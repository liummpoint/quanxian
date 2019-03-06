package com.manage.commom.cipher.rsa;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;

import org.springframework.util.Base64Utils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * RSAUtils
 * Description rsa 加解密
 * Copyrigth(C),2017,lx86468@126.com.com
 * Date 2017/6/14
 *
 * @author lixiao on 2017/6/14.
 * @version 1.0
 */
public class RSAUtils {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    private static final int KEY_SIZE = 1024;
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    /** */
    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /** */
    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * 使用getPublicKey得到公钥,返回类型为PublicKey
     *
     * @param pubKey String to PublicKey
     * @throws Exception
     */
    public static PublicKey getPublicKey(String pubKey) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(pubKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    /**
     * 转换私钥
     *
     * @param priKey String to PrivateKey
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String priKey) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(priKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    public static byte[] sign(byte[] data, String privateKey) throws Exception {
        PrivateKey priK = getPrivateKey(privateKey);
        Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
        sig.initSign(priK);
        sig.update(data);
        return sig.sign();
    }

    public static boolean verify(byte[] data, byte[] sign, String pubKey) throws Exception {
        PublicKey pubK = getPublicKey(pubKey);
        Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
        sig.initVerify(pubK);
        sig.update(data);
        return sig.verify(sign);
    }

    public static String encrypt(String bt_plaintext,String pubkey)throws Exception{
        PublicKey publicKey = getPublicKey(pubkey);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bt_encrypted = cipher.doFinal(bt_plaintext.getBytes());
        return Base64.encodeBase64String(bt_encrypted);
    }

    /** */
    /**
     * <p>
     * 公钥加密
     * </p>
     *
     * @param data      源数据
     * @param pubkey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data, String pubkey) throws Exception {

        byte[] dataBytes = data.getBytes();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PublicKey publicKey = getPublicKey(pubkey);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            int inputLen = dataBytes.length;

            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(dataBytes, offSet, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(dataBytes, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out.toByteArray();
            out.flush();
            out.close();
            return Base64.encodeBase64String(encryptedData);
        } catch (NoSuchAlgorithmException e) {
            throw e;
        } catch (BadPaddingException e) {
            throw e;
        } catch (IllegalBlockSizeException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } catch (NoSuchPaddingException e) {
            throw e;
        } catch (InvalidKeyException e) {
            throw e;
        } catch (InvalidKeySpecException e) {
            throw e;
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }

    /** */
    /**
     * <P>
     * 私钥解密
     * </p>
     *
     * @param data       已加密数据
     * @param priKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data, String priKey) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            byte[] dataBytes = Base64.decodeBase64(data);
            PrivateKey privateKey = getPrivateKey(priKey);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            int inputLen = dataBytes.length;
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(dataBytes, offSet, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(dataBytes, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.flush();
            out.close();
            return new String(decryptedData);
        } catch (NoSuchAlgorithmException e) {
            throw e;
        } catch (BadPaddingException e) {
            throw e;
        } catch (IllegalBlockSizeException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } catch (NoSuchPaddingException e) {
            throw e;
        } catch (InvalidKeyException e) {
            throw e;
        } catch (InvalidKeySpecException e) {
            throw e;
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }

    public static String decrypt(String bt_encrypted, String priKey) throws Exception {
        byte[] decodeBase64 = Base64.decodeBase64(bt_encrypted);
        PrivateKey privateKey = getPrivateKey(priKey);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bt_original = cipher.doFinal(decodeBase64);
        return new String(bt_original);
    }

    public static void main(String[] args) throws Exception {
        String str_plaintext = "这是一段用来测试密钥转换的明文12313121111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFrgC0sy4YCdKPtPW1fdR2va6uOr0HSLnIyBbQfSyyP/aDHcaVu6Xujx8vfF5VW8ONwsf1iZxugTa6aAL4ortAbbgk3TlxFSjIoT8l6b8okua2GVNYXWIdahJaPv0Ybh12g3qMUCpww1sOWsmXf3uMHT17z2FuhHaoft5ViO5RCwIDAQAB";
        String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBANOoWeIusWhmlkBjORl0XomgY/gRcMgLifDjniANIx5Ytfq6hxIophhLjEJlOm6Ln44cIsQyfWTk9qE3FtueGMyOTLO1ldGd0jQCA6TMp1A9ECsehKnfE+GXWFD7WvV4s7pgqmvkmBrRgaUWCa7ImDZGGUFskUXrrTHGSTkPAbOLAgMBAAECgYBbkLlR4GFfiQH3WPWazX0YjQqyhtkDsfo6/D2sIALRXg9cKNXGRU+Vsxk6oBBnQoAEOqfPuQgGXgdUN0DsQbj3/CzU3j9mKGFMyLFgRbydJ5SkRS1HULT/kxzgU41CHZziYFUmIJY/5zC9vb8IkNsa3NuO/DogxcZfkzoL2UIAAQJBAOta7Sq9JB+bTA3+uxHOj0oGGJLBkj8f4XLz/umB5k0yfDsXaP+/CT/53cMJajcRJKUScHUFtsQAPNy8KgQeigECQQDmOUdPJFcHrp/qyi1r/pQgPfl2zM2ssyGV+hq76QtQyXpFbx/hadKaVlNUL5jLkjtPDe7NRxuUioZOcsYOOsWLAkAlHWavSbqLnXLl9hjMGxXvp3xykEIe4EkuVpoJeum1nNOIgg2V3yt3QlEdc7ujSXnM6lZ/rdH/oMX4TVgW5DYBAkAaaOuzOnn5WaDisDqxrsyTPkjFxgy6CPqLV9uFPuCbbeFm4a6Ijzknl0uL1sHyaF4BXZnNVqDlU1bA3Q23SCqtAkA+qSMc4Xf2CFqcq3aCn9eLKjK6Eag2a5uPgATDyMm61RxzKzF8fCez6HTTArD4Va+JQX4HxyLiQ46huXmIMmQP";
        System.err.println("明文：" + str_plaintext);
        String bt_cipher = encryptByPublicKey(str_plaintext, publicKey);
        System.out.println("加密后：" + bt_cipher);
        bt_cipher="wAxRO/2RIgSSFIraN/UpzsXaQI/8QZgzYHNQA+H5rrQitwJi/EIXMAU7+FEAs3iwu1E8mxLqC81fLNErZFmHsb1Gd7g8nKAu7Ry/lqanefL4ihXfp7t9QztH226/yFUTF2hPALvt3H7HECaCNUVKMaYmEQtGzUtptAI1kEPMvlaDJnfm63rIoZ6Pbx6NZt9kUwoy0Mci4gRHfEOBE7shq3qp4X+/nt0SZHOk2l+1rn7EU6/x4bYDMcuxQ9JISypYJmpIvgOczzdUNQe9EcBsw1s3fP76OEwadCPxSxlnY8jeczsk/4NsdRdo6K4dVC5963RxfV/N58DgBDgPlJEFZA==";
        String bt_original = decryptByPrivateKey(bt_cipher, privateKey);
        String str_original = new String(bt_original);
        System.out.println("解密结果:" + str_original);
    }
}