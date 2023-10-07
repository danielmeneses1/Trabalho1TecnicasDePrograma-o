package Plano;

import elementos.Bug;
import elementos.Dev;
import planetas.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Plano {


    public List<Planeta> planetas;
    private List<Bug> bugs = new ArrayList<>();
    private List<Dev> devs = new ArrayList<>();
    protected Celula[][] celulas = new Celula[17][16];


    public Plano() {
        PovoarCelulasVazias();
        this.planetas = preencherPlanetas();
    }

    public static List<Planeta> preencherPlanetas(){
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(new Python());
        planetas.add(new JavaScript());
        planetas.add(new RubyOnRails());
        planetas.add(new PHP());
        planetas.add(new CSharp());
        planetas.add(new CMais());
        planetas.add(new C());
        return planetas;
    }
    public void preencherBugs(){
        System.out.println("Informe a quantidade de Bugs desejada");
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        for(int i = 0; i< quantidade; i++){
            Random random = new Random();
            int posicaoX = random.nextInt(17);
            int posicaoY = random.nextInt(16);

            while (this.celulas[posicaoX][posicaoY].verificarPreenchimento()){
                posicaoX = random.nextInt(17);
                posicaoY = random.nextInt(16);
            }
            Bug bug = new Bug(posicaoX,posicaoY);
            bugs.add(bug);
            celulas[posicaoX][posicaoY].setElemento(bug);
        }
    }
    public void preencherDevs(){
        System.out.println("Informe a quantidade de Devs desejada");
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        for(int i = 0; i< quantidade; i++){
            Random random = new Random();
            int posicaoX = random.nextInt(17);
            int posicaoY = random.nextInt(16);

            while (celulas[posicaoX][posicaoY].verificarPreenchimento()){
                posicaoX = random.nextInt(17);
                posicaoY = random.nextInt(16);
            }
            Dev dev = new Dev(posicaoX,posicaoY);
            devs.add(dev);
            celulas[posicaoX][posicaoY].setElemento(dev);
        }
    }

    public void PovoarCelulasVazias(){
        for(int i = 0 ; i<celulas.length; i++){

            for (int j = 0; j < celulas[i].length; j++){

                celulas[i][j] = new Celula(i,j);
            }
        }
    }

    public static void moverEExibir(List<Planeta> plano, int momento){
        for(Planeta planeta : plano){
            planeta.mover(momento);}
        for(Planeta planeta : plano){
            planeta.exibirPosicao();}
        System.out.println();
        for(Planeta planeta : plano){
            planeta.totalRotacao(momento);
        }System.out.println();
        for (Planeta planeta : plano){
            planeta.totalAnos();}
        }

        public void verificarColisaoDev() {
            for (Planeta planeta : planetas) {
                for (Dev dev : devs) {
                    if (planeta.getPosicaoX() == dev.getPosicaoX() && planeta.getPosicaoY() == dev.getPosicaoY()) {
                        planeta.AumentarTranslação();
                        planeta.colisoesDevs++;
                        System.out.println("O planeta, "+ planeta.getNome() + " encontrou um desenvolvedor na posição, X="+ planeta.getPosicaoX() +" y= "+ planeta.getPosicaoY());
                    }
                }
            }
    }

        public void verificarColisaoBug() {
            for (Planeta planeta : planetas) {
                for (Bug bug : bugs) {
                    if (planeta.getPosicaoX() == bug.getPosicaoX() && planeta.getPosicaoY() == bug.getPosicaoY()) {
                        planeta.DiminuirTranslação();
                        planeta.colisoesBugs++;
                        System.out.println("O planeta, " + planeta.getNome() + " encontrou um bug na posição, X=" + planeta.getPosicaoX() + " y= " + planeta.getPosicaoY());

                    }

                }
            }
        }

        public void norteSulJava(){
            int ContadorNorte = 0;
            int ContadorSul = 0;
        for(Planeta planeta : planetas){
            if(planeta.getPosicaoY() >= 8){
                ContadorNorte++;
            } else if (planeta.getPosicaoY() <= 6) {
                ContadorSul ++;
            }
        }
            System.out.println("Numero de planetas ao norte de java =" + ContadorNorte);
            System.out.println("Numero de planetas ao sul de java = " + ContadorSul);
        }


        public void explodirPlaneta(){
        for (Planeta planeta : planetas){
            if(planeta.getTranslacao()==0){
                System.out.println("O planeta "+ planeta.getNome() +" explodiu");
            }
        }

        }


        public void mostrarPosicaoBugs(){
        for(Bug bug: bugs){
            System.out.println("bug na posição x = "+ bug.getPosicaoX() + " Y = "+ bug.getPosicaoY());
        }
        }
        public void mostrarPosicoesDevs(){
        for(Dev dev : devs){
            System.out.println("dev na posição x = "+ dev.getPosicaoX() + " Y = "+ dev.getPosicaoY());
        }
        }



    public List<Planeta> getPlanetas() {
        return planetas;
    }
    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }
    public List<Bug> getBugs() {
        return bugs;
    }
    public void setBugs(List<Bug> bugs) {
        this.bugs = bugs;
    }
    public List<Dev> getDevs() {
        return devs;
    }
    public void setDevs(List<Dev> devs) {
        this.devs = devs;
    }
}

