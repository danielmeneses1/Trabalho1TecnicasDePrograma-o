package Plano;

import elementos.Elemento;


public class Celula {

    private int posicaoX;
    private int posicaoY;
    private Elemento elemento;

    public Celula(int posicaoX, int posicaoY) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
    }

    public boolean verificarPreenchimento(){
        return elemento != null;
    }

    public void setElemento(Elemento elemento){
        this.elemento = elemento;
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
