package com.dreadnought.encryption;

import org.jasypt.encryption.pbe.PooledPBEByteEncryptor;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import java.io.UnsupportedEncodingException;

/**
 * Created by boss on 6/2/14.
 */
public class EncryptionUtil {
    private static final String ALGORITHM = "PBEWithMD5AndTripleDES";
    public static byte[] encrypt(String pass, byte[] unEncrypted ) {
        PooledPBEByteEncryptor encryptor = new PooledPBEByteEncryptor();
        encryptor.setPoolSize(4);          // This would be a good value for a 4-core system
        encryptor.setPassword(pass);
        encryptor.setAlgorithm(ALGORITHM);
        return encryptor.encrypt(unEncrypted);
    }

    public static byte[] decrypt(String pass, byte[] encrypted) {
        PooledPBEByteEncryptor encryptor = new PooledPBEByteEncryptor();
        encryptor.setPoolSize(4);          // This would be a good value for a 4-core system
        encryptor.setPassword(pass);
        encryptor.setAlgorithm(ALGORITHM);
        return encryptor.decrypt(encrypted);
    }

    public static byte[] hash(String password) {
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm("SHA-1");
        passwordEncryptor.setPlainDigest(true);
        String encryptedPassword = passwordEncryptor.encryptPassword(password);
        try {
            return encryptedPassword.getBytes("UTF-8");
        } catch (UnsupportedEncodingException exception) {
            throw new RuntimeException(exception);
        }
    }
}
