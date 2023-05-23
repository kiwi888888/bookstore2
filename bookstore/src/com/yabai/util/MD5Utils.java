package com.yabai.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    /**
     * 针对输入的明文字符串执行 MD5 加密操作
     * @param source 输入的明文
     * @return 经过 MD5 加密的密文
     */
    public static String encode(String source) {

        // 1、判空保护
        // 字符串认定为空情况一：null 值 String s1 = null;
        // 字符串认定为空情况二：长度为零的空字符串 String s2 = "";
        if (source == null || source.length() == 0) {
            throw new RuntimeException("明文不能为空！");
        }

        // 集合判空
        // List<String> list = null;
        // if (list == null || list.size() == 0) {
        //
        // }

        try {
            // 2、指定加密算法的名称
            String algorithm = "md5";

            // 3、获取 MessageDigest 对象实例
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            // 4、获取明文字符串的字节数组
            byte[] input = source.getBytes();

            // 5、执行加密操作
            byte[] output = messageDigest.digest(input);

            // 6、创建 BigInteger 对象
            // signum 设置为 1，表示强制让 BigInteger 把字节数组视为正数
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum, output);

            // 7、调用 BigInteger 对象的 toString() 方法得到十六进制形式的字符串
            return bigInteger.toString(16).toUpperCase();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String source = "123456";
        String encode = encode(source);

        // E10ADC3949BA59ABBE56E057F20F883E
        System.out.println("encode = " + encode);
    }

}
