package com.dreadnought.encryption;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Dmitri Farafonov on 6/2/14.
 */
public class SimpleEncryptDecryptTest {
    @Test
    public void testEncryptBlah() throws Exception {
        byte[] blah = "blah".getBytes("UTF-8");
        byte[] encrypted = EncryptionUtil.encrypt("test", blah);
        byte[] decrypted = EncryptionUtil.decrypt("test", encrypted);
        Assert.assertEquals("blah", new String(decrypted, "UTF-8"));
    }

    @Test
    public void testHashEncryption() throws Exception {
        String password= "rex";
        byte[] hash = EncryptionUtil.hash(password);
        String password2 = "dmitri";
        byte[] hash2 = EncryptionUtil.hash(password2);
        Assert.assertNotEquals(hash,hash2,"Expected Different Hash but got same");
    }
}
