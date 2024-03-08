package exercicio1a;

import java.util.Scanner;

/**
 * Aristoteles POO
 */
public class Aristoteles {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numLampadas;
        
        System.out.println("Quantas lampadas?");
        numLampadas = entrada.nextInt();

        Corredor corredor = new Corredor(numLampadas);

        for (int vez = 1; vez <= numLampadas; vez++) {
            for (int interruptor = 1; interruptor <= numLampadas; interruptor++) {
                if (interruptor % vez == 0) {
                    corredor.algerarLampada(interruptor); 
                }
            }
        }

        System.out.print(corredor);
        
        entrada.close();
    }

}