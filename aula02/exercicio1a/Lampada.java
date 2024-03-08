package exercicio1a;

public class Lampada {
    private boolean estado;

    public void alteraEstado() {
        estado  = !estado;
    }

    @Override
    public String toString() {
        return (estado)? "On":"Off";
    }
}
