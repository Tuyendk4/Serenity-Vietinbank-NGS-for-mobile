package vn.vietinbank.api.utils;

import static vn.vietinbank.api.configs.GetDataConstants.*;

import net.serenitybdd.core.Serenity;
import org.junit.Assert;

public class ReadData {
    public static void readJsonFile(String sessionVariableName, String pathJsonFile) {
        JsonReader jsonReader = new JsonReader();
        String filePath = System.getProperty("user.dir") + "/" + pathJsonFile;
        jsonReader.readJsonFileAndSetToSession(filePath, sessionVariableName);
    }

    public static void getDataFromExcel(String row, String sheetName, String excelPath) {
        Serenity.setSessionVariable(ROW).to(row);
        Serenity.setSessionVariable(SHEET_NAME).to(sheetName);
        Serenity.setSessionVariable(EXCEL_PATH).to(excelPath);
        ExcelActions excelReader = new ExcelActions(excelPath);
        Assert.assertTrue(excelReader.isSheetExist(sheetName));
    }
}
