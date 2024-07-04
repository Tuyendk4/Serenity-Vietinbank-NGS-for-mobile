package vn.vietinbank.utils.generate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class GenerateDateTime {

    /**
     * trả về thời gian định dạng yyyyMMddHHmmss
     */
    public String timeStampLocalNow() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }

    /**
     * trả về thời gian định dạng yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
     */
    public String getLocalTime1() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date now = new Date(System.currentTimeMillis());
        return dateFormat.format(now);
    }

    /**
     * trả về thời gian định dạng dd/MM/yyyy
     */
    public String getLocalDate1() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return currentDate.format(formatter);
    }

    /**
     * trả về thời gian định dạng dd-MM-yyyy
     */
    public String getLocalDate2() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return currentDate.format(formatter);
    }

    /**
     * trả về thời gian định dạng yyyy-MM-dd
     */
    public String getLocalDate3() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(formatter);
    }
}
