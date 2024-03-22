package exemplo01;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name); // construtor de Thread
    }

    @Override
    public void run() {
        System.out.println("Início da thread " + getName());
        
        try {
            sleep(3000); // suspende por 2 segundos
        } catch (Exception e) {
            System.out.println("Erro no sleep");
        }

        System.out.println("Final da thread " + getName());
    }
}
