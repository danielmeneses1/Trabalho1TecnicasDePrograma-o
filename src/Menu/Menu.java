package Menu;

import Plano.Plano;
import Relatorio.Relatorio;
import elementos.Bug;
import elementos.Dev;
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
    private List<Planeta> falecidos = new ArrayList<>();
    private List<Dev> devsColididos = new ArrayList<>();
    private List<Bug> bugsColididos = new ArrayList<>();
    public Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema Javalar");

        plano = new Plano();
        plano.preencherBugs();
        plano.preencherDevs();
        planetas = plano.getPlanetas();

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Transladar");
            System.out.println("2. Mostrar relatório");
            System.out.println("3. Adicionar desenvolvedores");
            System.out.println("4. Adicionar bugs");
            System.out.println("5. Sair");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o momento desejado");
                    momento += sc.nextInt();
                    Plano.moverEExibir(planetas, momento);
                    System.out.println();
                    plano.distanciaEntreOsPlanetas();
                    System.out.println();

                    plano.numeroDeBugs();
                    plano.numeroDeDevs();
                    plano.posicoesBugs();
                    plano.posicoesDevs();

                    plano.verificarColisaoDev(devsColididos);
                    plano.verificarColisaoBug(bugsColididos);
                    System.out.println();
                    plano.explodirPlaneta(falecidos);
                    plano.norteSulJava();
                    System.out.println();
                    plano.verificarAlinhamento();
                    System.out.println();
                    this.momento = momento;
                    this.bugs = plano.getBugs();
                    break;
                case 2:
                    Relatorio relatorio = new Relatorio(this.planetas, this.plano);
                    relatorio.ExibirRelatorio(this.momento,this.falecidos);
                    break;
                case 3:
                    System.out.println();
                    plano.preencherDevs();
                    break;

                case 4:
                    System.out.println();
                    plano.preencherBugs();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


}

