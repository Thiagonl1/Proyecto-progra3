import java.util.ArrayList;

public interface Juego {
    public void juego(int desicion, Usuario ia);
    public ArrayList<Carta> inicializarCartas();
}
