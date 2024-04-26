package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        Registry registry;

        try {
            // cria um novo Registry na porta padrão: 1099
            registry = LocateRegistry.createRegistry(1099);

            // Criando o objeto que ficará disponível para o cliente
            ClassMath objMath = new ClassMath();

            // registra o objeto para consulta pelo cliente
            registry.rebind("calculadora", objMath);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
