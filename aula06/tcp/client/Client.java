package tcp.client;

import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final String HOST = "127.0.0.1"; // localhost
        final int PORT = 9999;
        Socket socket;

        try {
            socket = new Socket(HOST, PORT);
            System.out.println("Conectado com o servidor...");
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
