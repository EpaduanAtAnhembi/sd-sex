package tcp.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

public static void main(String[] args) {
    final int PORT = 9999;
    ServerSocket serverSocket;
    Socket clientSocket;

    
    try {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor disponível na porta: " + PORT);
        System.out.println("Aguardando novo cliente...");
        clientSocket = serverSocket.accept();
        // ....

    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
    }
}
    
}