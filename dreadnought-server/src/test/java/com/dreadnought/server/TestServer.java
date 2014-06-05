package com.dreadnought.server;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TestServer {

    private static Server server;

    @BeforeSuite
    public static void setUp() throws Exception {
        server = new Server();
        new Thread(server).start();
    }

    @AfterSuite
    public static void stopServer() {
        server.shutdown();
    }

    @Test
    public void client() throws Exception {
        SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("localhost", 9999);
        OutputStream outputstream = sslsocket.getOutputStream();
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
        BufferedWriter bufferedwriter = new BufferedWriter(outputstreamwriter);
        bufferedwriter.write("I am Rex!\n");
        bufferedwriter.flush();
        bufferedwriter.write("How are you?\n");
        bufferedwriter.flush();
        outputstream.close();
        sslsocket.close();
    }
}