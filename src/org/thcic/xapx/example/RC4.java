package org.thcic.xapx.example;

/**
 * RC4流加/解密算法实现
 */
public class RC4 {
  // 密钥
  private boolean hasKey = false;
  private int[] cipherBox = null;
  private int[] cipherKeyArray = null;

  /**
   * 缺省的构造函数
   */
  public RC4() {
  }

  /**
   * 由于byte是signed类型的，我们需要unsigned的值是必须作此转换
   * @param b 被转换的数值
   * @return int 转换的结果
   */
  private int getUnsignedByte(byte b) {
    if (b<0)
      return (b+256);
    else
      return b;
  }

  /**
   * 将unsigned的byte数据转成signed的
   * @param b 输入
   * @return byte 输出
   */
  private byte getSignedByte(int b) {
    if (b>127)
      return (byte)(b-256);
    else
      return (byte)b;
  }

  /**
   * 生成RC4密钥
   * @param thisKey String
   */
  public void setKey(String thisKey) {
    setKey(thisKey.getBytes());
    return;
  }

  /**
   * 生成RC4密钥
   * @param thisKey byte[]
   */
  public void setKey(byte[] thisKey) {
    //Initialize cipherBox and cipherKey Array's
    int keyLength = 0;
    int dataSwap;
    int b;
    cipherBox = new int[256];
    cipherKeyArray = new int[256];
    keyLength = thisKey.length;
    for (int a = 0; a < 256; a++) {
      //take the key character at the selected position
      cipherKeyArray[a] = getUnsignedByte(thisKey[a % keyLength]);
      cipherBox[a] = a;
    }
    b = 0;
    for (int a = 0; a < 256; a++) {
      b = (b + cipherBox[a] + cipherKeyArray[a]) % 256;
      dataSwap = cipherBox[a];
      cipherBox[a] = cipherBox[b];
      cipherBox[b] = dataSwap;
    }
    this.hasKey = true;
  }

  /**
   * 加密/解密
   * @param unencodedData byte[]
   * @return byte[]
   */
  public byte[] doCipher(byte[] unencodedData) {
    return doCipher(null, unencodedData);
  }

  /**
   * 加密/解密
   * @param unencodedData String
   * @return byte[]
   */
  public byte[] doCipher(String unencodedData) {
    return doCipher(null, unencodedData.getBytes());
  }

  /**
   * 加密/解密
   * @param cipherKey byte[]
   * @param unencodedData byte[]
   * @return byte[]
   */
  public byte[] doCipher(byte[] cipherKey, byte[] unencodedData) {
    // doCipher will encrypt unencrypted data or decrypt encrypted data
    int z = 0;
    int t = 0;
    int i = 0;
    int cipherBy = 0;
    int tempInt = 0;
    char cipherText;
    byte[] cipher = new byte[unencodedData.length];

    //Initialize cipherBox and cipherKeyArray
    if (hasKey == false) {
      if (cipherKey == null)
        return null;
      setKey(cipherKey);
    }
    for (int a = 0; a < unencodedData.length; a++) {
      i = (i + 1) % 256;
      t = (t + cipherBox[i]) % 256;
      tempInt = cipherBox[i];
      cipherBox[i] = cipherBox[t];
      cipherBox[t] = tempInt;
      z = cipherBox[ (cipherBox[i] + cipherBox[t]) % 256];
      //get character at position a
      cipherText = (char)(getUnsignedByte(unencodedData[a]));
      //convert to ascii value XOR'd by z
      cipherBy = (int) cipherText ^ z;
      cipher[a] = this.getSignedByte(cipherBy);
    }
    return cipher;
  }

}
