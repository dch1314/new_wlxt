package org.thcic.xapx.example;

import java.security.*;

/**
 *
 * <p>Title: 生成消息摘要</p>
 * <p>Description: 实现MD5和SHA</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Tsinghua University</p>
 * @author LiuQixin
 * @version 1.0
 */
public class HashUtils {
  static char charmap[] = {
      '4','Q','A','P',
      '2','W','S','X',
      '3','E','D','C',
      '9','R','F','V',
      '5','T','G','B',
      '6','Y','H','N',
      '7','U','J','M',
      '8','L','K','Z'
  };

  /**
   * 缺省的构造函数
   */
  public HashUtils() {
  }

  /**
   * 计算byte数组的MD5值，输出计算结果（byte数组）
   * @param src 输入的byte数组
   * @return 输出MD5结果
   */
  static public byte[] MD5(byte[] src) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(src);
      byte[] dst = md.digest();
      return dst;
    }
    catch (Exception ex) {
      return null;
    }
  }

  /**
   * 计算byte数组的MD5值，输出计算结果（byte数组）
   * @param src 输入的byte数组
   * @param len 输入数据的有效长度
   * @return 输出MD5结果
   */
  static public byte[] MD5(byte[] src, int len) {
    try {
      byte[] tmp = new byte[len];
      for(int j=0; j<len; j++)
        tmp[j] = src[j];
      return MD5(tmp);
    }
    catch (Exception ex) {
      return null;
    }
  }

  /**
   * 计算字符串的MD5值，输出计算结果的表示字符串
   * @param msg 输入的字符串
   * @return 输出MD5值
   */
  static public String MD5(String msg) {
      return Byte2Hex(MD5(msg.getBytes()));
  }

  /**
   * 计算byte数组的SHA值，输出计算结果（byte数组）
   * @param src 输入的byte数组
   * @return 输出SHA结果
   */
  static public byte[] SHA(byte[] src) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA");
      md.update(src);
      byte[] dst = md.digest();
      return dst;
    }
    catch (Exception ex) {
      return null;
    }
  }

  /**
   * 计算byte数组的SHA值，输出计算结果（byte数组）
   * @param src 输入的byte数组
   * @param len 输入数据的有效长度
   * @return 输出SHA结果
   */
  static public byte[] SHA(byte[] src, int len) {
    try {
      byte[] tmp = new byte[len];
      for(int j=0; j<len; j++)
        tmp[j] = src[j];
      return SHA(tmp);
    }
    catch (Exception ex) {
      return null;
    }
  }

  /**
   * 计算字符串的SHA值，输出计算结果的表示字符串
   * @param msg 输入的字符串
   * @return 输出SHA值
   */
  static public String SHA(String msg) {
    return Byte2Hex(SHA(msg.getBytes()));
  }

  /**
   * 把byte[]数组转换为16进制显示的字符串
   * @param ba byte[]数组
   * @return String
   */
  static public String Byte2Hex(byte[] ba) {
    try {
      int len = ba.length;
      char[] res = new char[len * 2];
      int tmp, i, j, k;
      for (i = 0; i < len; i++) {
        tmp = (int) ba[i];
        if (tmp < 0) {
          tmp += 256;
        }
        j = tmp / 16;
        k = tmp % 16;
        for (j = 0, k = tmp / 16; j < 2; j++, k = tmp % 16) {
          if (k < 10) {
            res[i * 2 + j] = (char) (k + 48);
          }
          else {
            res[i * 2 + j] = (char) (k + 87);
          }
        }
      }
      return new String(res);
    }
    catch (Exception ex) {
      return null;
    }
  }

  /**
   * 把16进制字符串转换为byte[]数组
   * @param hex String 16进制字符串
   * @return byte[] 数组
   */
  static public byte[] Hex2Byte(String hex) {
    try {
      int length = hex.length() / 2;
      byte[] ba = new byte[length];
      for (int i=0; i<length; i++) {
        int s = 0;
        for (int j=0; j<2; j++) {
          s *= 16;
          char c = hex.charAt(i*2+j);
          if (c >= '0' && c <= '9') {
            s += (c - '0');
          } else if (c >= 'a' && c <= 'f') {
            s += (c - 'a' + 10);
          } else if (c >= 'A' && c <= 'F') {
            s += (c - 'A' + 10);
          } else {
            return null;
          }
        }
        ba[i] = (s > 127) ? (byte)(s-256) : (byte)(s);
      }
      return ba;
    }
    catch (Exception ex) {
      return null;
    }
  }

}
