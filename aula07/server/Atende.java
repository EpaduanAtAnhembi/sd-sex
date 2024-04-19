package server;

import java.net.Socket;

import util.Comunicacao;
import util.Mensagem;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.dev.br>
 */

public class Atende extends Thread {
    Socket cliente;
    Comunicacao comunicacao;

    public Atende(Socket cliente) {
        this.cliente = cliente;
        comunicacao = new Comunicacao(cliente);
    }

    @Override
    public void run() {
        boolean online = true;

        while (online) {
            Mensagem msg = (Mensagem) comunicacao.receive();
            if(msg == null) {
                online = false;
            } else {
                System.out.println(msg.getTexto());
            }
        }
        System.out.println("Final da thread");
    }
}
