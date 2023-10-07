package Menu;

import Plano.Plano;
import Relatorio.Relatorio;
import elementos.Bug;
import planetas.Planeta;
import java.util.List;
import java.util.Scanner;



public class Menu {
    private int momento;
    private Plano plano;
    private List<Planeta> planetas;
    private int momentosTotais;

    public Menu() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema Javalar");
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Começar");
            System.out.println("2. Mostrar relatorio");
            System.out.println("3. Sair");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:

            Plano plano = new Plano();
            plano.preencherBugs();
            plano.preencherDevs();

            System.out.println("Digite o momento desejado");
            momento += sc.nextInt();
            List<Planeta> planetas = plano.getPlanetas();
            List<Bug> bugs = plano.getBugs();
            Plano.moverEExibir(planetas, momento);
            System.out.println();

            plano.verificarColisaoDev();
            plano.verificarColisaoBug();
            System.out.println();
            plano.explodirPlaneta();
                    //plano.mostrarPosicaoBugs();
                    //plano.mostrarPosicoesDevs();


            this.plano = plano;
            this.planetas = planetas;
            this.momentosTotais = momento;

                    break;
                case 2:
                    Relatorio relatorio = new Relatorio(this.planetas,this.plano);
                    relatorio.ExibirRelatorio(this.momento);

                default:
                case 3:

            }

    }

}}