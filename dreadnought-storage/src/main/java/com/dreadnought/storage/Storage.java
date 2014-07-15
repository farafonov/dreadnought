package com.dreadnought.storage;

import org.apache.cassandra.service.CassandraDaemon;

/**
 * Description.
 * <p/>
 * Date: 7/14/14
 *
 * @author <a href="mailto:farafonov@gmail..com">Dmitri Farafonov</a>
 * @version 1.0
 */
public class Storage {
    CassandraDaemon daemon;

    public Storage() {
        this.daemon = new CassandraDaemon();
        daemon.activate();
    }
}
