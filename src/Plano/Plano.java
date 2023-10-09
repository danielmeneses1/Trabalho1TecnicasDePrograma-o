package Plano;

import elementos.Bug;
import elementos.Dev;
import planetas.*;

import java.text.DecimalFormat;
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

    public static List<Planeta> preencherPlanetas() {
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

    public void preencherBugs() {
        int limiteBugs = 100;
        int quantidade = 0;

        Scanner sc = new Scanner(System.in);
        while (quantidade <= 0 || quantidade > limiteBugs) {
            System.out.println("Informe a quantidade de Bugs desejada (até " + limiteBugs + "): ");
            quantidade = sc.nextInt();
            if (quantidade <= 0 || quantidade > limiteBugs) {
                System.out.println("Quantidade inválida. Por favor, insira um valor entre 1 e " + limiteBugs + ".");
            }
        }
        for (int i = 0; i < quantidade; i++) {
            Random random = new Random();
            int posicaoX = random.nextInt(17);
            int posicaoY = random.nextInt(16);

            while (this.celulas[posicaoX][posicaoY].verificarPreenchimento()) {
                posicaoX = random.nextInt(17);
                posicaoY = random.nextInt(16);
            }
            Bug bug = new Bug(posicaoX, posicaoY);
            bugs.add(bug);
            celulas[posicaoX][posicaoY].setElemento(bug);
        }
    }

    public void preencherDevs() {
        int limiteDevs = 100;
        int quantidade = 0;
        Scanner sc = new Scanner(System.in);
        while (quantidade <= 0 || quantidade > limiteDevs) {
            System.out.println("Informe a quantidade de Devs desejada (até " + limiteDevs + "): ");
            quantidade = sc.nextInt();
            if (quantidade <= 0 || quantidade > limiteDevs) {
                System.out.println("Quantidade inválida. Por favor, insira um valor entre 1 e " + limiteDevs + ".");
            }
        }for (int i = 0; i < quantidade; i++) {
            Random random = new Random();
            int posicaoX = random.nextInt(17);
            int posicaoY = random.nextInt(16);

            while (celulas[posicaoX][posicaoY].verificarPreenchimento()) {
                posicaoX = random.nextInt(17);
                posicaoY = random.nextInt(16);
            }
            Dev dev = new Dev(posicaoX, posicaoY);
            devs.add(dev);
            celulas[posicaoX][posicaoY].setElemento(dev);
        }
    }

    public void PovoarCelulasVazias() {
        for (int i = 0; i < celulas.length; i++) {

            for (int j = 0; j < celulas[i].length; j++) {

                celulas[i][j] = new Celula(i, j);
            }
        }
    }

    public static void moverEExibir(List<Planeta> plano, int momento) {
        for (Planeta planeta : plano) {
            planeta.mover(momento);
        }
        for (Planeta planeta : plano) {
            planeta.exibirPosicao();
        }
        System.out.println();
        for (Planeta planeta : plano) {
            planeta.totalRotacao(momento);
        }
        System.out.println();
        for (Planeta planeta : plano) {
            planeta.totalAnos();
        }
    }

    public void verificarColisaoDev(List<Dev> devsColididos) {
        for (Planeta planeta : planetas) {
            for (Dev dev : devs) {
                if (planeta.getPosicaoX() == dev.getPosicaoX() && planeta.getPosicaoY() == dev.getPosicaoY()) {
                    planeta.AumentarTranslação();
                    planeta.incrementarColisoesDevs();
                    System.out.println("O planeta, " + planeta.getNome() + " encontrou um desenvolvedor na posição, X=" + planeta.getPosicaoX() + " y= " + planeta.getPosicaoY());
                    devsColididos.add(dev);
                }
            }
            devs.removeAll(devsColididos);
        }
    }

    public void verificarColisaoBug(List<Bug> bugsApagados) {
        for (Planeta planeta : planetas) {
            for (Bug bug : bugs) {
                if (planeta.getPosicaoX() == bug.getPosicaoX() && planeta.getPosicaoY() == bug.getPosicaoY()) {
                    planeta.DiminuirTranslação();
                    planeta.incrementarColisoesBugs();
                    System.out.println("O planeta, " + planeta.getNome() + " encontrou um bug na posição, X=" + planeta.getPosicaoX() + " y= " + planeta.getPosicaoY());
                    bugsApagados.add(bug);
                }
            }
            bugs.removeAll(bugsApagados);
        }
    }

    public void norteSulJava() {
        int ContadorNorte = 0;
        int ContadorSul = 0;
        for (Planeta planeta : planetas) {
            if (planeta.getPosicaoY() >= 8) {
                ContadorNorte++;
            } else if (planeta.getPosicaoY() <= 6) {
                ContadorSul++;
            }
        }
        System.out.println("Numero de planetas ao norte de java =" + ContadorNorte);
        System.out.println("Numero de planetas ao sul de java = " + ContadorSul);
    }

    public void verificarAlinhamento() {
        for (Planeta planeta : planetas) {
            for (Planeta planeta1 : planetas) {
                if (planeta1.getPosicaoY() == planeta.getPosicaoY() + 1 && planeta1.getPosicaoX() == planeta.getPosicaoX()) {
                    System.out.println("O planeta " + planeta.getNome() + " está alinhado com " + planeta1.getNome());
                } else if (planeta1.getPosicaoY() == planeta.getPosicaoY() + 1 && planeta1.getPosicaoX() == planeta.getPosicaoX() - 1) {
                    System.out.println("O planeta " + planeta.getNome() + " está alinhado com " + planeta1.getNome());
                } else if (planeta1.getPosicaoY() == planeta.getPosicaoY() - 1 && planeta1.getPosicaoX() == planeta.getPosicaoX()) {
                    System.out.println("O planeta " + planeta.getNome() + " está alinhado com " + planeta1.getNome());
                } else if (planeta1.getPosicaoY() == planeta.getPosicaoY() - 1 && planeta1.getPosicaoX() == planeta.getPosicaoX() - 1) {
                    System.out.println("O planeta " + planeta.getNome() + " está alinhado com " + planeta1.getNome());
                } else if (planeta1.getPosicaoY() == planeta.getPosicaoY() - 1 && planeta1.getPosicaoX() == planeta.getPosicaoX() + 1) {
                    System.out.println("O planeta " + planeta.getNome() + " está alinhado com " + planeta1.getNome());
                } else if (planeta1.getPosicaoY() == planeta.getPosicaoY() + 1 && planeta1.getPosicaoX() == planeta.getPosicaoX() + 1) {
                    System.out.println("O planeta " + planeta.getNome() + " está alinhado com " + planeta1.getNome());
                }
            }
        }
    }

    public void explodirPlaneta(List<Planeta> falecidos) {
        for (Planeta planeta : planetas) {
            if (planeta.getTranslacao() == 0) {
                System.out.println("O planeta " + planeta.getNome() + " explodiu");
                falecidos.add(planeta);
            }
        }
        planetas.removeAll(falecidos);

    }

    public void posicoesBugs(){
        for (Bug bug : bugs){
            System.out.println("Bug criado na posição x= "+ bug.getPosicaoX() + " y= "+ bug.getPosicaoY());
        }
    }
    public void posicoesDevs(){
        for (Dev dev : devs){
            System.out.println("Dev criado na posição x= "+ dev.getPosicaoX() + " y= "+ dev.getPosicaoY());
        }
    }

    public void numeroDeBugs(){
        int total = 0;
        for (Bug bug:bugs){
            total ++;
        }
        System.out.println("Foram criados "+ total + " bugs");
    }
    public void numeroDeDevs(){
        int total = 0;
        for (Dev dev : devs){
            total ++;
        }
        System.out.println("Foram criados "+ total + " desenvolvedores");
    }
    public void distanciaEntreOsPlanetas(){
        DecimalFormat formato = new DecimalFormat("#.##");
        int deltaX= 0;
        int deltaY = 0;
        for(Planeta planeta : planetas){
            for (Planeta planeta1 : planetas){
                deltaX = Math.abs(planeta.getPosicaoX() - planeta1 .getPosicaoX());
                deltaY = Math.abs(planeta.getPosicaoY() - planeta1.getPosicaoY());
                if(planeta.getNome() != planeta1.getNome()){
                System.out.println("A distancia entre " + planeta.getNome() + " e " + planeta1.getNome() +" é " + formato.format((Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY,2)))));
            }}
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
}

