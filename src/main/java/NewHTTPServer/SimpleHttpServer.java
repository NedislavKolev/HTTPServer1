package NewHTTPServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;


public class SimpleHttpServer {

    private static final String BASEDIR = "src/main/java/NewHTTPServer";

    private static final int PORT = 9000;

    private HttpServer server;

    public static void main(String[] args) throws Exception {
        SimpleHttpServer server = new SimpleHttpServer();
        server.start();
    }

    public void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress(PORT), 0);

        server.createContext("/static", new StaticFileHandler(BASEDIR));

        server.start();
    }

    public void stop() {
        server.stop(0);
    }
}
