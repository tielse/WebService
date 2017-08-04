package com.chauthoiit.kali.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Decode {
	public static String DecodeMD5(String str) {
		byte[] defaultByte = str.getBytes();
		try {
			MessageDigest alogorithm = MessageDigest.getInstance("MD5");
			alogorithm.reset();
			alogorithm.update(defaultByte);
			byte Disgest[] = alogorithm.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < Disgest.length; i++) {
				String hex = Integer.toHexString(0xFF & Disgest[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			str = hexString + "";
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return str;
	}
}
