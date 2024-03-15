public class RoboSimples implements Robo {
    private int x, y;
    private Area area;

    public RoboSimples(Area area) {
        this.area = area;
    }

    @Override
    public boolean andar(Direcao direcao, int deslocamento) {
        if (area.invalido(x, y, direcao, deslocamento)) {
            return false;
        }
        switch (direcao) {
            case NORTE:
                y -= deslocamento;
                break;
            case SUL:
                y += deslocamento;
                break;
            case OESTE:
                x -= deslocamento;
                break;
            case LESTE:
                x += deslocamento;
                break;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ " + x + ", " + y + " ]";
    }
}
