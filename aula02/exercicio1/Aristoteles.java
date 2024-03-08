package exercicio1;
import java.util.Scanner;

/**
 * Aristoteles
 */
public class Aristoteles {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numLampadas;
        boolean lampadas[];

        System.out.println("Quantas lampadas?");
        numLampadas = entrada.nextInt();

        lampadas = new boolean[numLampadas];

        for (int vez = 1; vez <= lampadas.length; vez++) {
            for (int interruptor = 1; interruptor <= lampadas.length; interruptor++) {
                if (interruptor % vez == 0) {
                    lampadas[interruptor - 1] = !lampadas[interruptor - 1];
                }
            }
        }

        for (boolean lampada : lampadas) {
            System.out.print((lampada) ? "On " : "Off ");
        }
        entrada.close();
    }

}