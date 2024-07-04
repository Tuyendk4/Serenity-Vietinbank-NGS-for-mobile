package vn.vietinbank.utils.generate;

import java.security.SecureRandom;
import java.util.Random;

public class GenerateRandom {

    /**
     * trả về string ngẫu nhiên số với độ dài trong khoản begin - end
     *
     * @param begin là số bắt đầu
     * @param end   là số kết thúc
     */
    public String generateRandomNumberFromTo(int begin, int end) {
        Random random = new Random();
        int length = random.nextInt(end - begin + 1) + begin;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * trả về string ngẫu nhiên số với độ dài length
     *
     * @param length là độ dài
     */
    public String generateRandomNumberWithLength(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * trả ra danh sách số từ string ngăn cách bởi _
     *
     * @param value là string chứa số
     */
    public int[] extractNumbers(String value) {
        String[] parts = value.split("_");
        int[] numbers = new int[1];
        if (parts.length == 3) {
            numbers[0] = Integer.parseInt(parts[2]);
        }
        if (parts.length == 4) {
            numbers[0] = Integer.parseInt(parts[2]);
            numbers[1] = Integer.parseInt(parts[3]);
        }
        return numbers;
    }

    /**
     * trả về string ngẫu nhiên chữ và số với độ dài length
     *
     * @param length là độ dài
     */
    public String generateRandomString(int length) {
        String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    /**
     * trả về string ngẫu nhiên chữ và số với độ dài trong khoản begin - end
     *
     * @param begin là số bắt đầu
     * @param end   là số kết thúc
     */
    public String generateRandomStringFromTo(int begin, int end) {
        String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();
        int length = random.nextInt(end - begin + 1) + begin;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
