package NewHTTPServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;


public class SimpleHttpServer {

    /**
     *
     */
    //Server base directory
    private static final String BASEDIR = "src/main/java/NewHTTPServer";
    //Server port
    private static final int PORT = 9000;

    private static final String IPADDRS = "127.0.0.1";

    private HttpServer server;

    public static void main(String[] args) throws Exception {
        SimpleHttpServer server = new SimpleHttpServer();
        server.start();
    }

    public void start() throws IOException {
        //Getting the ip address and port
        server = HttpServer.create(new InetSocketAddress(IPADDRS,PORT), 0);
        //Server context path
        server.createContext("/static", new StaticFileHandler(BASEDIR));
        //Starting the server
        server.start();
    }

    public void stop() {
        //Stopping the server
        server.stop(0);
    }
}
