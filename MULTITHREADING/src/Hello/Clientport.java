package Hello;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Clientport {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Clientport <server_address> <port_number>");
            return;
        }
        
        String serverAddress = args[0];
        int port = 0;
        
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("The port number must be an integer.");
            return;
        }
        
        try (
            Socket socket = new Socket(serverAddress, port);
            OutputStream outToServer = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            InputStream inFromServer = socket.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer)
        ) {
            System.out.println("Connected to server at " + serverAddress + " on port " + port);
            String message = "Hello from client at port " + socket.getLocalPort();
            out.writeUTF(message);
            System.out.println("Sent to server: " + message);
            String response = in.readUTF();
            System.out.println("Server response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

