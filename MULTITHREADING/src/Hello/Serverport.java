package Hello;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Serverport {
 public static void main(String[] args) {
 ServerSocket serversocket = null;
 try {
 serversocket = new ServerSocket(12345);
 System.out.println("Server is listening on port " + serversocket.getLocalPort());
 while (true) {
 Socket socket = serversocket.accept();
 System.out.println("New client connected from port: " + socket.getPort());
 System.out.println("Client address: " + socket.getInetAddress());
 socket.close();
 }
 } catch (IOException e) {
 e.printStackTrace();
 } finally {
 if (serversocket != null) {
 try {
 serversocket.close();
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
 }
 }
}
