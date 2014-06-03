package com.dreadnought.encryption;

import org.jasypt.encryption.pbe.PooledPBEByteEncryptor;

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
}
