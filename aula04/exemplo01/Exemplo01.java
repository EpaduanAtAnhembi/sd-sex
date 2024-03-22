package exemplo01;

public class Exemplo01 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread 1");
        MyThread t2 = new MyThread("Thread 2");
        MyThread t3 = new MyThread("Thread 3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join(); // main só continua depois da t1 terminar
        } catch (Exception e) {
            System.out.println("Erro no join");
        }

        System.out.println("Final do main");
    }

}