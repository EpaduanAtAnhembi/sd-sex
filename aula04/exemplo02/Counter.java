package exemplo02;

public class Counter {
    private int i;

    synchronized public void count(int number) {
        for (i = 1; i <= number; i++) {
            System.out.println( i * number );
        }
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Erro no sleep");
        }
    }
}
