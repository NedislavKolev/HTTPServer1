package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class uses Singleton method and has a connection to config.properties file
 */
public class Config {

    private final int port;
    private final String base_dir;
    private final String ip_address;
    private final String file_path;
    private final String file_name;
    private static Config instance = null;

    //Define the config.properties file path
    FileInputStream FIS;
    {
        try {
            FIS = new FileInputStream("D:\\Java\\HTTPServer1\\src\\main\\java\\ConfigFiles\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Properties prop = new Properties();

    //Loading the config.properties file
    public Config() throws IOException {
        prop = new Properties();
        prop.load(FIS);
        FIS.close();
//---------------------------------------------------------------------------------------------------//
        port = Integer.parseInt(prop.getProperty("port"));
        base_dir = new String(prop.getProperty("base_dir"));
        ip_address = new String(prop.getProperty("ip_address"));
        file_path = new String(prop.getProperty("file_path"));
        file_name = new String(prop.getProperty("file_name"));
    }
    //Using Singleton method
    public static Config getInstance() throws IOException {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
    //-------------------------------------------------------------------------------------------//
    //Getters for strings
    public int getPort(){return this.port;}
    public String getBase_dir(){return this.base_dir;}
    public String getIp_address(){return this.ip_address;}
    public String getFile_path(){return this.file_path;}
    public String getFile_name(){return this.file_name;}

}

