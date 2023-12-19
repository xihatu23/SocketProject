import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class DayTimeClient {

    public static final int DAYTIME_PORT = 13;

    public static void main(String[] args) {
        String hostname = args.length > 0 ? args[0] : "time.nist.gov";

        try (Socket socket = new Socket(hostname, DAYTIME_PORT)) {
            System.out.println("Connected to DayTime Server on host " + hostname);
            socket.setSoTimeout(15000);
            InputStream input = socket.getInputStream();
            byte[] inputBytes = input.readAllBytes();
            String time = new String(inputBytes, StandardCharsets.US_ASCII);
            System.out.println(time);
        } catch (UnknownHostException e) {
            System.out.println("Can't connect to host!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}