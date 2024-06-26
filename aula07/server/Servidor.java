package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.dev.br>
 */
public class Servidor {
    protected static ArrayList<Atende> atendentes = new ArrayList<>();

    public static void main(String[] args) {
        final int PORT = 9876;
        ServerSocket serverSocket;
        Socket cliente;

        try {
            serverSocket = new ServerSocket(PORT);

            while (true) {
                System.out.println("Aguardando o cliente...");
                cliente = serverSocket.accept();
                Atende atende = new Atende(cliente);
                atendentes.add(atende);
                atende.start();
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
