package client;

import java.rmi.Naming;

import util.InterfaceMath;

public class Client {
    public static void main(String[] args) {
        InterfaceMath refMath;

        try {
            // refMath é uma referência para o objeto que está no server
            refMath = (InterfaceMath) 
                Naming.lookup("rmi://127.0.0.1:1099/calculadora");

            System.out.println(refMath);
            double resp = refMath.somar(15, 20);
            System.out.println("Resposta = " + resp);

            Thread.sleep(5000);

            refMath = (InterfaceMath) 
            Naming.lookup("rmi://127.0.0.1:1099/calculadora");

            System.out.println(refMath);
            resp = refMath.multiplicar(15, 20);
            System.out.println("Resposta = " + resp);

        } catch (Exception e) {
            System.out.println("Erro: "  + e.getMessage());
        }
    }
}
