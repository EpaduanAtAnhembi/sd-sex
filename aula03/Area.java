public class Area {
    private int maxX, maxY;

    public Area(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public boolean invalido(
            int x, int y, Direcao direcao, int deslocamento) {
        switch (direcao) {
            case NORTE:
                return (y - deslocamento < 0);
            case SUL:
                return (y + deslocamento > maxY);
            case OESTE:
                return (x - deslocamento < 0);
            case LESTE:
                return (x + deslocamento > maxX);
        }
        return true;
    }

}
