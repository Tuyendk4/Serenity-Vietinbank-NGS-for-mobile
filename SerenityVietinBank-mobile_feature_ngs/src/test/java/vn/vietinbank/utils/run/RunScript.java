package vn.vietinbank.utils.run;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunScript {

    /**
     * chạy file sh
     *
     * @param scriptPath là path của file sh
     */
    public void runShellScript(String scriptPath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(scriptPath);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
