package tcp.client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String HOST = "127.0.0.1"; // localhost
        final int PORT = 9999;
        Socket socket;
        PrintStream out;
        Scanner teclado;

        try {
            socket = new Socket(HOST, PORT);
            System.out.println("Conectado com o servidor...");

            out = new PrintStream(socket.getOutputStream());

            teclado = new Scanner(System.in);

            String msg = "";
            while (!msg.equalsIgnoreCase("exit")) {
                System.out.println("Digite a mensagem");
                msg = teclado.nextLine();
                out.println(msg);
            }
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        try {
            teclado.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
