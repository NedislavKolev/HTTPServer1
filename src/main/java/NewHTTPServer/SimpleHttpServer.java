package NewHTTPServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import Config.Config;
import com.sun.net.httpserver.HttpServer;


public class SimpleHttpServer{

    /**
     *
     */
    //Server base directory
    private static String BASEDIR;
    //Server port
    private static int PORT;
    private static String IPADDRS;
    private HttpServer server;

    static {
        try {
            BASEDIR = (Config.getInstance().getBase_dir());
            PORT = (Config.getInstance().getPort());
            IPADDRS = (Config.getInstance().getIp_address());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







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
