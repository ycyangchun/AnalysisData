package com.zhcw.analysisdata.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DesUtil {


	public static String encryptDES(String encryptString, String encryptKey) {
		try {
			SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptedData = cipher.doFinal(encryptString.getBytes("UTF-8"));

			String encodeForUrl = new String(Base64Util.encode(encryptedData));
			//转成针对url的base64编码
			encodeForUrl = encodeForUrl.replaceAll("\\=", "!");
			encodeForUrl = encodeForUrl.replaceAll("\\+", "*");
			encodeForUrl = encodeForUrl.replaceAll("\\/", "-");
			//去除换行
			encodeForUrl = encodeForUrl.replaceAll("\\n", "");
			encodeForUrl = encodeForUrl.replaceAll("\\r", "");
			//转换*号为 -x-
			//防止有违反协议的字符
			encodeForUrl = encodeSpecialLetter(encodeForUrl);
			return encodeForUrl;
		} catch (Exception e) {
		}
		return "";
	}

	public static String decryptDES(String decryptString, String decryptKey) {
		try {
			decryptString = decodeSpecialLetter(decryptString);
			decryptString = decryptString.replaceAll("\\!", "=");
			decryptString = decryptString.replaceAll("\\*", "+");
			decryptString = decryptString.replaceAll("\\-", "/");



			SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptedData = cipher.doFinal(Base64Util.decode(decryptString));
			return new String(decryptedData,"UTF-8");
		} catch (Exception e) {
		}
		return "";
	}
	
	
	/**
     * 转换*号为 -x-，
                 为了防止有违反协议的字符，-x 转换为-xx
     * @param str
     * @return
     */
    private static String encodeSpecialLetter(String str){
     str = str.replaceAll("\\-x", "-xx");
     str = str.replaceAll("\\*", "-x-");
     return str;
    }
    
    /**
     * 转换 -x-号为*，-xx转换为-x
     * @param str
     * @return
     */
    private static String decodeSpecialLetter(String str){
     str = str.replaceAll("\\-x-", "*");
     str = str.replaceAll("\\-xx", "-x");
     return str;
    }
    
}