package NewHTTPServer;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import Config.Config;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public class StaticFileHandler implements HttpHandler {

    private final String baseDir;

    public StaticFileHandler(String baseDir) {

        this.baseDir = baseDir;
    }

    @Override
    public void handle(HttpExchange ex) throws IOException {

        //File send via the HTTP Server
        File path = new File(Config.getInstance().getFile_path()+Config.getInstance().getFile_name());

        Headers h = ex.getResponseHeaders();
        // Could be more clever about the content type based on the filename here.
        h.add("Content-Type",Config.getInstance().getContent_type());

        OutputStream out = ex.getResponseBody();

        if (path.exists()) {
            ex.sendResponseHeaders(200, path.length());
            out.write(Files.readAllBytes(path.toPath()));
        } else {
            System.err.println("File not found: " + path.getAbsolutePath());

            ex.sendResponseHeaders(404, 0);
            out.write("404 File not found.".getBytes());
        }

        out.close();
    }

}