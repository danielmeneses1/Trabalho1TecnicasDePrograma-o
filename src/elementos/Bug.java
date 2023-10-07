package elementos;

import java.util.List;
import java.util.Random;

public class Bug extends Elemento{
    public String name;

    public Bug(int posicaoX, int posicaoY) {
        super(posicaoX, posicaoY);
    }


    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }
}
