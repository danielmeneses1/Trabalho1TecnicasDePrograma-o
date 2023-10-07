package planetas;

import elementos.Elemento;

public abstract class Planeta extends Elemento implements IPlaneta {
    protected String nome;
    protected int translacao;
    protected int tempo;
    protected double rotacao;
    protected int anoJavalar = 0;
    protected int colisoesBugs = 0;
    protected int colisoesDevs = 0;

    public Planeta(int posicaoX, int posicaoY) {
        super(posicaoX, posicaoY);
    }

    public void exibirPosicao(){
        System.out.println("Posicao de "+ this.getClass().getSimpleName()+": x: "+ posicaoX + " y: "+ posicaoY);
    }

    public void totalRotacao(int momento){
        System.out.println("no planeta "+ this.getClass().getSimpleName() +" passaram-se: "+(momento*rotacao) + " horas");
    };
    public void totalAnos(){
        System.out.println("no planeta "+ this.getClass().getSimpleName() +" passaram-se: "+ anoJavalar + " anos");
    }

    public void AumentarTranslação(){
        translacao++;
    }

    public void DiminuirTranslação(){
        translacao--;
    }

    public void incrementarColisoesDevs(){
        colisoesDevs +=1;
    }
    public void incrementarColisoesBugs(){
        colisoesBugs +=1;
    }
    protected boolean passouInicio(int pX, int pY){
        return posicaoX == pX && posicaoY ==pY;
    }



    public String getNome() {
        return nome;
    }

    public int getTranslacao() {
        return translacao;
    }

    public void setTranslacao(int translacao) {
        this.translacao = translacao;
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

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getColisoesBugs() {
        return colisoesBugs;
    }

    public void setColisoesBugs(int colisoesBugs) {
        this.colisoesBugs = colisoesBugs;
    }

    public int getColisoesDevs() {
        return colisoesDevs;
    }

    public void setColisoesDevs(int colisoesDevs) {
        this.colisoesDevs = colisoesDevs;
    }

    public double getRotacao() {
        return rotacao;
    }
}
