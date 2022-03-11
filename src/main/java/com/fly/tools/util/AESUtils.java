package com.fly.tools.util;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtils {

    private static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";

    private static final String AES = "AES";

    /**
     * 解密
     *
     * @param data 待解密内容
     * @param key  解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] data, String key) {
        try {
            Cipher cipher = builderCipher(key, Cipher.DECRYPT_MODE);
            // 解密
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException("decrypt fail!", e);
        }
    }

    /**
     * 加密
     *
     * @param data 需要加密的内容
     * @param key  加密密码
     * @return 加密后
     */
    public static byte[] encrypt(byte[] data, String key) {
        try {
            Cipher cipher = builderCipher(key, Cipher.ENCRYPT_MODE);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException("encrypt fail!", e);
        }
    }

    /**
     * @param key  密钥
     * @param mode 加密或解密
     * @return 密码器
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     */
    public static Cipher builderCipher(String key, Integer mode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        KeyGenerator keyGen = KeyGenerator.getInstance(AES);
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(key.getBytes(StandardCharsets.UTF_8));
        keyGen.init(128, secureRandom);
        SecretKey secretKey = keyGen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, AES);
        // 创建密码器
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(mode, keySpec);
        return cipher;
    }
}
