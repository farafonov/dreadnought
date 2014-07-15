package com.dreadnought.storage;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Description.
 * <p/>
 * Date: 7/14/14
 *
 * @author <a href="mailto:farafonov@gmail..com">Dmitri Farafonov</a>
 * @version 1.0
 */
public class TestStorage {
    Storage storage;

    /**
     * Set up
     *
     * @throws Exception thrown on any test set up failure
     */
    @BeforeSuite
    public void setUp() throws Exception {
        storage = new Storage();
    }

    @Test
    public void testSimpleQuery() throws Exception {
        System.out.println("Started...");

    }
}
