package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final int PORT = 1234;
        DatagramSocket socket;
        DatagramPacket pacote;
        byte[] dados;
        InetAddress address;

        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("127.0.0.1");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        String message = "Oba, funcionou!";
        Scanner scanner = new Scanner(System.in);
        while (true) {

            try {
                System.out.println("Digite a mensagem:");
                message = scanner.nextLine();
                dados = message.getBytes();
                pacote = new DatagramPacket(dados, dados.length, address, PORT);
                socket.send(pacote);
                System.out.println("Dados enviados.");
            } catch (Exception e) {
                System.out.println("Erro ao enviar");
            }
        }
    }
}
