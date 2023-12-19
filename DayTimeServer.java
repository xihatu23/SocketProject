import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DayTimeServer {

    public final static int PORT = 13;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Listening for connection on port " + PORT);
                try (Socket connection = server.accept()) {
                    System.out.println("Client connected from host " + connection.getInetAddress()
                    + ", port " + connection.getPort());
                    Thread.sleep(500);
                    Writer output = new OutputStreamWriter(connection.getOutputStream());
                    Date now = new Date();
                    output.write(now + "\r\n");
                    output.flush();
                } catch (IOException ex) {
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
} 