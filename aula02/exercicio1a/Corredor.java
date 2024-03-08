package exercicio1a;

public class Corredor {
    Lampada lampadas[];

    Corredor(int tamanho) {
        lampadas = new Lampada[tamanho];
        for (int i = 0; i < lampadas.length; i++) {
            lampadas[i] = new Lampada();
        }
    }

    public void algerarLampada(int lampada) {
        lampadas[lampada-1].alteraEstado();
    }

    @Override
    public String toString() {
        String saida = "[ ";
        for (Lampada lampada : lampadas) {
            saida += lampada + " ";
        }
        saida += "]";
        return saida;
    }
}
