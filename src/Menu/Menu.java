package Menu;

import Plano.Plano;
import Relatorio.Relatorio;
import elementos.Bug;
import planetas.Planeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Menu {
    private Plano plano;
    private List<Planeta> planetas;
    private int momento;
    private List<Bug> bugs;
    private boolean continuar = true;

    public Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema Javalar");

        plano = new Plano();
        plano.preencherBugs();
        plano.preencherDevs();
        planetas = plano.getPlanetas();

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Começar");
            System.out.println("2. Mostrar relatório");
            System.out.println("3. Sair");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o momento desejado");
                    momento += sc.nextInt();
                    Plano.moverEExibir(planetas, momento);
                    System.out.println();

                    plano.verificarColisaoDev();
                    plano.verificarColisaoBug();
                    System.out.println();
                    plano.explodirPlaneta();
                    plano.norteSulJava();
                    plano.verificarAlinhamento();
                    this.momento = momento;
                    this.bugs = plano.getBugs();
                    break;
                case 2:
                    Relatorio relatorio = new Relatorio(this.planetas, this.plano);
                    relatorio.ExibirRelatorio(this.momento);
                    break;
                case 3:
                    continuar = false; // Define continuar como false para sair do loop
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


}

