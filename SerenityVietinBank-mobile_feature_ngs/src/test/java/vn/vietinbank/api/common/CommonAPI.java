package vn.vietinbank.api.common;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import vn.vietinbank.api.utils.ExcelActions;

import java.util.Map;

import static vn.vietinbank.api.configs.APIConstants.*;
import static vn.vietinbank.api.configs.GetDataConstants.*;
import static vn.vietinbank.api.utils.ConvertData.responseToJSONObject;

public class CommonAPI {

    private static final Logger logger = LogManager.getLogger(CommonAPI.class);

    public static void callApiWithMethod(String url, @NotNull String method) {
        Map<String, String> headers = Serenity.sessionVariableCalled(HEADERS);
        String body = Serenity.sessionVariableCalled(BODY_REQUEST);
        Map<String, String> params = Serenity.sessionVariableCalled(PARAMS);
        Response response;
        RequestSpecification requestSpec = SerenityRest.given()
                .baseUri(url)
                .relaxedHTTPSValidation()
                .headers(headers);
        switch (method) {
            case METHOD_POST:
                response = requestSpec.body(body).post();
                break;
            case METHOD_GET:
                response = requestSpec.get();
                break;
            case METHOD_GET_PARAMS:
                response = requestSpec.params(params).get();
                break;
            default:
                response = null;
                break;
        }
        assert response != null;
        logger.info(response.asString());
        Serenity.setSessionVariable(RESPONSE).to(responseToJSONObject(response));
        Serenity.setSessionVariable(RESPONSE_STATUS).to(response.statusCode());
    }

    public static boolean callAPIFromExcelData() {
        String excelPath = Serenity.sessionVariableCalled(EXCEL_PATH);
        String sheetName = Serenity.sessionVariableCalled(SHEET_NAME);
        String row = Serenity.sessionVariableCalled(ROW);
        try {
            ExcelActions excelReader = new ExcelActions(excelPath);
            int numberOfRow;
            if (row.equals(RUN_FULL_FILE)) {
                numberOfRow = excelReader.getRowCount(sheetName) - 1;
            } else {
                numberOfRow = Integer.parseInt(row);
            }
            return callAPIAndWriteResultIntoExcel(excelPath, sheetName, numberOfRow);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean callAPIAndWriteResultIntoExcel(String pathFile, String sheetName, int row) {
        try {
            ExcelActions excelReader = new ExcelActions(pathFile);
            String url = excelReader.getCellData(sheetName, EXCEL_DATA.url.name(), row);
            String body = excelReader.getCellData(sheetName, EXCEL_DATA.body.name(), row);
            Serenity.setSessionVariable(BODY_REQUEST).to(body);
            String method = excelReader.getCellData(sheetName, EXCEL_DATA.method.name(), row);
            String responseExpected = excelReader.getCellData(sheetName,
                    EXCEL_DATA.responseExpected.name(), row);
            callApiWithMethod(url, method);
            JSONObject response = Serenity.sessionVariableCalled(RESPONSE);
            boolean result = false;
            String responseStr = response.toString(4);
            if (responseStr.contains(responseExpected)) {
                result = true;
                writeIntoResultColumn(pathFile, sheetName, row, RESULT_PASS);
            } else {
                writeIntoResultColumn(pathFile, sheetName, row, RESULT_FAIL);
            }
            return result;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void writeIntoResultColumn(String pathFile, String sheetName, int row,
                                             String statusRun) {
        ExcelActions excelReader = new ExcelActions(pathFile);
        excelReader.setCellData(sheetName, EXCEL_DATA.result.name(), row, statusRun);
    }

    public enum EXCEL_DATA {
        url,
        headerParam,
        method,
        body,
        responseExpected,
        result,
    }
}
