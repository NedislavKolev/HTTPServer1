package NewHTTPServerTest;

import Config.Config;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class newHTTPServerConfigTest {

    /**
     * This Junit test is testing the port which the HTTP Server is using
     * @int actual_port //Gets the port from config.properties file
     * @asserEquals //Checks if the port is as expected
     */

    @Test

    public void testConfigPortPositive() throws IOException {
        Config config = new Config();
        //Getting the port form config.properties
        int actual_port = config.getPort();
        //Expected HTTP port
        int expected_port = 9000;
        //Compares whether the ports are equal or not
        assertEquals(expected_port, actual_port);
        System.out.println("Test passed!\nPorts are equal");
    }


    @Test

    public void testConfigPortNegative() throws IOException {
        Config config = new Config();
        //Getting the port form config.properties
        int actual_port = config.getPort();
        //Expected wrong HTTP port
        int expected_port = 9009;
        //Compares whether the ports are equal or not
        assertEquals(expected_port, actual_port);
        System.out.println("Test passed!\nPorts are equal");
    }

    /**
     * This Junit test is testing the IP Address which the HTTP Server is using
     * @int actual_ipaddress //Gets the IP Address from config.properties file
     * @asserEquals //Checks if the IP Address is as expected
     */

    @Test

    public void testConfigIPAddressPositive() throws IOException {
        Config config = new Config();
        //Getting the IP Address form config.properties
        String actual_ipaddress = config.getIp_address();
        //Expected HTTP IP Address
        String expected_ipaddress = "127.0.0.1";
        //Compares whether the ip address are equal or not
        assertEquals(expected_ipaddress, actual_ipaddress);
        System.out.println("Test passed!\nPorts are equal");
    }

    @Test

    public void testConfigIPAddressNegative() throws IOException {
        Config config = new Config();
        //Getting the IP Address form config.properties
        String actual_ipaddress = config.getIp_address();
        //Expected HTTP IP Address
        String expected_ipaddress = "127.0.0.0";
        //Compares whether the ip address are equal or not
        assertEquals(expected_ipaddress, actual_ipaddress);
        System.out.println("Test passed!\nIP Addresses are equal");
    }


    /**
     * This Junit test is testing the IP Address which the HTTP Server is using
     * @int actual_ipaddress //Gets the IP Address from config.properties file
     * @asserEquals //Checks if the IP Address is as expected
     */

    @Test

    public void testConfigBaseDirPositive() throws IOException {
        Config config = new Config();
        //Getting the path form config.properties
        String actual_dir = config.getBase_dir();
        //Expected HTTP IP Address
        String expected_dir = "src/main/java/NewHTTPServer";
        //Compares whether the paths are equal or not
        assertEquals(expected_dir, actual_dir);
        System.out.println("Test passed!\nPaths are equal");
    }


    @Test

    public void testConfigBaseDirNegative() throws IOException {
        Config config = new Config();
        //Getting the Base Directory form config.properties
        String actual_dir = config.getBase_dir();
        //Expected Base Directory for HTTP
        String expected_dir = "src/main/java/newHTTPServer";
        //Compares whether the paths are equal or not
        assertEquals(expected_dir, actual_dir);
        System.out.println("Test passed!\nPaths are equal");
    }

    /**
     * This UNIT Test is testing if there is a file ready to be uploaded to HTTP Server
     * @throws IOException
     */

    @Test
    public void testFilePath() throws IOException {
        /**
         * @param
         * @filepath_actual Path to file from config.properties
         * @filepath_expected Expected path to file
         */
        Config config = new Config();

        String filepath_actual = config.getFile_path();

        String filepath_expected = "D:/Java/HTTPServer1/src/main/java/NewHTTPServer/testfile.xml" ;

        Path path = Paths.get(filepath_actual);
        //Method to test if file exists
        boolean exists = Files.exists(path);
        //Method to check if file does not exist
        boolean notExists = Files.notExists(path);
        //Method to check if file is directory
        boolean isDir = Files.isDirectory(path);

        if (isDir) {
            System.out.println("File is a Directory");
        }
        else if (exists) {
            System.out.println("File exists!!");
        }
        else if (notExists) {
            System.out.println("File doesn't exist!!");
        }
        else {
            System.out.println("Program doesn't have access to the file!!");
        }
        //Compares the two names
        assertEquals(filepath_expected, filepath_actual);
        System.out.println("There is a file with that name, ready for upload");
    }
}
