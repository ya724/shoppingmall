package com.micro.utils;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.utils
 * @CreateTime: 2020-11-20 10:56
 * @Description: TODO
 */
import java.security.MessageDigest;

public class MD5Util {
    public static String str;
    public static final String EMPTY_STRING = "";

    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 转换字节数组为16进制字串
     * @param b 字节数组
     * @return 16进制字串
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString
                    .getBytes()));
        } catch (Exception ex) {
        }
        return resultString;
    }

    public static void main(String[] args) {
        String salt="tom";
        String admin111 = MD5Util.MD5Encode("admin111"+salt);  // admin111tom
        System.out.println(MD5Encode(admin111.toLowerCase())); // bbad8d72c1fac1d081727158807a8798  BBAD8D72C1FAC1D081727158807A8798
    }


}
