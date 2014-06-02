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


}
