import java.net.*;
import java.io.*;

 public class LowPortScanner {
    public static final int MAX_PORT = 1024;

    public static void main(String[] args) {
        String hostname = args.length > 0 ? args[0] : "localhost";
        System.out.println("\nScanning ports on host " + hostname);

        for (int port = 1; port < MAX_PORT; port++) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(hostname, port), 10);
                System.out.println("There is a server on port " + port + " of " + hostname);
            } catch (UnknownHostException ex) {
                System.err.println(ex);
                break;
            } catch (IOException ex) {
            }
        }
        System.out.println("Finished scan");
    }
}