package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) {
        final int PORT = 1234;
        DatagramSocket socket;

        try {
            socket = new DatagramSocket(PORT);
            System.out.println("Servidor disponível");
        } catch (Exception e) {
            System.out.println("Erro de binding");
            return;
        }

        while (true) {
            try {
                byte[] data = new byte[1024];
                DatagramPacket pacote = new DatagramPacket(data, data.length);

                System.out.println("Aguardando dados...");
                socket.receive(pacote);
                String message = new String(pacote.getData());
                System.out.println("Recebido:" + message);
            } catch (Exception e) {
                System.out.println("Erro na troca de dados");
            }
        }

        // try {
        // socket.close();
        // System.out.println("Servidor encerrado");
        // } catch (Exception e) {
        // System.out.println("Erro ao fechar o socket");
        // }

    }
}