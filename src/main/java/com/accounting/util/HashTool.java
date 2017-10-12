package com.accounting.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.accounting.util.exception.UtilException;

public class HashTool {

  public static String hashLine(String line) throws UtilException {
    StringBuilder hexString = null;

    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hash = digest.digest(line.getBytes("UTF-8"));

      hexString = new StringBuilder();
      for (byte x : hash) {
        String hex = Integer.toHexString(0xff & x);

        if (hex.length() == 1) {
          hexString.append('0');
        }

        hexString.append(hex);
      }

    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
      throw new UtilException(e);
    }
    return hexString.toString();
  }
}

