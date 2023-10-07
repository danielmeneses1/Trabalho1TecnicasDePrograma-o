package Relatorio;

import Plano.Plano;
import planetas.Planeta;

import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    private List<Planeta> planetas = new ArrayList<>();
    private Plano plano;

    public Relatorio(List<Planeta> planetas, Plano plano) {
        this.planetas = planetas;
        this.plano = plano;
    }

    public void ExibirRelatorio(int momento){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("RELATORIO");
        mostrarTranslacao();
        mostrarColisoesDev();
        mostrarColisoesBugs();
        momentosTotais(momento);
        totalDeDias(momento);
        verificarSeExplodiu();

    }

    public void mostrarTranslacao() {
        System.out.println();
        for(Planeta planeta : planetas){
            System.out.println("A translação de "+ planeta.getNome() + " é =" + planeta.getTranslacao());
        }
        System.out.println();
    }

    public void mostrarColisoesDev(){
        System.out.println();
        for(Planeta planeta : planetas){
            System.out.println("O planeta "+ planeta.getNome()+ " colidiu com "+ planeta.getColisoesDevs() + " Devs");
        }
    }
    public void mostrarColisoesBugs(){
        System.out.println();
        for(Planeta planeta : planetas){
            System.out.println("O planeta "+ planeta.getNome()+" colidiu com "+ planeta.getColisoesBugs() + " bugs");
        }
    }

    public void VMedRotacao(){

    }

    public void momentosTotais(int momento){
        System.out.println();
        System.out.println(" Os instantes solicitados pelo usuário foram = " + momento);
    }

    public void totalDeDias(int momento){
        System.out.println("Total de dias passados: ");
        for (Planeta planeta : planetas){
            double dias = (planeta.getRotacao() * momento) / 24;
            System.out.println("NO planeta "+ planeta.getNome() + " Passaram-se "+ dias + " Dias");
        }
    }

    public void verificarSeExplodiu(){
        for (Planeta planeta : planetas){
            if(planeta.getTranslacao() == 0){
                System.out.println("O planeta" + planeta.getNome() + "Explodiu");
            }
        }
    }





}

