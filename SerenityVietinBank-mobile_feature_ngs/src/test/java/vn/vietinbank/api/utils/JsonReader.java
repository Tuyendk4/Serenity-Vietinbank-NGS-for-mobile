package vn.vietinbank.api.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import net.serenitybdd.core.Serenity;
import org.json.JSONObject;

public class JsonReader {
    public void readJsonFileAndSetToSession(String filePath, String sessionVariableName) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);
            Serenity.setSessionVariable(sessionVariableName).to(jsonObject);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
