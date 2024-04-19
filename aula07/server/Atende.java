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

    public void sendMsg(Mensagem msg) {
        comunicacao.send(msg);
    }

    @Override
    public void run() {
        boolean online = true;

        while (online) {
            Mensagem msg = (Mensagem) comunicacao.receive();
            if(msg == null) {
                online = false;
            } else {
                // for (int i = 0; i < Servidor.atendentes.size(); i++) {
                //     Servidor.atendentes.get(i).sendMsg(msg);
                // }
                for (Atende atende : Servidor.atendentes) {
                    atende.sendMsg(msg);
                }
            }
        }
        System.out.println("Final da thread");
        Servidor.atendentes.remove(this);
    }
}
