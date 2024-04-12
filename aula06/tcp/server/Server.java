package tcp.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        final int PORT = 9999;
        ServerSocket serverSocket;
        Socket clientSocket;
        Scanner in;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor disponível na porta: " + PORT);
            while (true) {
                System.out.println("Aguardando novo cliente...");
                clientSocket = serverSocket.accept();
                in = new Scanner(clientSocket.getInputStream());

                String msg = "";
                while (!msg.equalsIgnoreCase("exit")) {
                    System.out.println("Aguardando mensagem...");
                    msg = in.nextLine();
                    System.out.println("Recebido: " + msg);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

/*         try {
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            // TODO: handle exception
        } */
    }

}