package Relatorio;

import Plano.Plano;
import planetas.Planeta;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    private List<Planeta> planetas = new ArrayList<>();
    private Plano plano;

    public Relatorio(List<Planeta> planetas, Plano plano) {
        this.planetas = planetas;
        this.plano = plano;
    }

    public void ExibirRelatorio(int momento,List<Planeta>falecidos){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("RELATORIO");
        mostrarTranslacao();
        System.out.println();
        mostrarColisoesDev();
        System.out.println();
        mostrarColisoesBugs();
        System.out.println();
        momentosTotais(momento);
        System.out.println();
        totalDeDias(momento);
        System.out.println();
        verificarSeExplodiu(falecidos);
        System.out.println();

    }

    public void mostrarTranslacao() {
        System.out.println();
        for(Planeta planeta : planetas){
            System.out.println("A translação de "+ planeta.getNome() + " é =" + planeta.getTranslacao());
        }
        System.out.println();
    }

    public void mostrarColisoesDev(){
        System.out.println("Planetas ainda vivos que encontraram Desenvolvedores: ");
        for(Planeta planeta : planetas){
            System.out.println("O planeta "+ planeta.getNome()+ " colidiu com "+ planeta.getColisoesDevs() + " Devs");
        }
    }
    public void mostrarColisoesBugs(){
        System.out.println("Planetas ainda vivos que colidiram com Bugs");
        for(Planeta planeta : planetas){
            System.out.println("O planeta "+ planeta.getNome()+" colidiu com "+ planeta.getColisoesBugs() + " bugs");
        }
    }

    public void momentosTotais(int momento){
        System.out.println();
        System.out.println(" Os instantes solicitados pelo usuário foram = " + momento);
    }

    public void totalDeDias(int momento){
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Total de dias passados: ");
        for (Planeta planeta : planetas){
            double dias = (planeta.getRotacao() * momento) / 24;
            String diasFormatados = df.format(dias);
            System.out.println("No planeta "+ planeta.getNome() + " Passaram-se "+ diasFormatados + " Dias");
        }
    }
    public void verificarSeExplodiu(List<Planeta> falecidos){
        System.out.println("Planetas que explodiram durante a execução do programa: ");
        for (Planeta planeta : falecidos){
            if(planeta.getTranslacao() == 0){
                System.out.println("O planeta " + planeta.getNome() + " Explodiu");
            }
        }
    }





}

