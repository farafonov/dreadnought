package com.dreadnought.encryption;

import org.jasypt.digest.StandardStringDigester;
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
        StandardStringDigester digester = new StandardStringDigester();
        digester.setAlgorithm("SHA-256");   // optionally set the algorithm
        digester.setIterations(50000);  // increase security by performing 50000 hashing iterations
        String encryptedPassword = digester.digest(password);
        try {
            return encryptedPassword.getBytes("UTF-8");
        } catch (UnsupportedEncodingException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void verify(String password, String password2) throws InvalidPasswordException {
        StandardStringDigester digester = new StandardStringDigester();
        digester.setAlgorithm("SHA-256");   // optionally set the algorithm
        digester.setIterations(50000);  // increase security by performing 50000 hashing iterations
        String encryptedPassword = digester.digest(password);

        if (!digester.matches(password2, encryptedPassword)){
            throw new InvalidPasswordException();
        }
    }
}
