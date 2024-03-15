import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Area area = new Area(50, 50);
        RoboSimples r2d2 = new RoboSimples(area);
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;

        while (opcao!= 5) {
            System.out.println("1 - Andar para o Norte:");
            System.out.println("2 - Andar para o Sul:");
            System.out.println("3 - Andar para o Leste:");
            System.out.println("4 - Andar para o Oeste:");
            System.out.println("5 - Terminar:");
            opcao = teclado.nextInt();
            switch (opcao) {
                case 1:
                    if(r2d2.andar(Direcao.NORTE, 10)){
                        System.out.println(r2d2);
                    } else {
                        System.out.println("Não dá.");
                    }
                    break;
                case 2:
                    if(r2d2.andar(Direcao.SUL, 10)){
                        System.out.println(r2d2);
                    } else {
                        System.out.println("Não dá.");
                    }
                    break;
            
                default:
                    break;
            }
        }
        teclado.close();
    }
}
