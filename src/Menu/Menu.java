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
    private List<Bug> bugs = new ArrayList<>();
    private List<Dev> devs = new ArrayList<>();
    private boolean continuar = true;
    private List<Planeta> falecidos = new ArrayList<>();
    private List<Dev> devsColididos = new ArrayList<>();
    private List<Bug> bugsColididos = new ArrayList<>();
    private static final int LimiteMaximo = 272;
    public Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema Javalar");
        System.out.println("Para começar informe a quantidade de bugs e devs que o sistema vai ter:");

        plano = new Plano();
        System.out.println("Informe a quantidade de bugs que deseja adicionar");
        int quantidadeBugs = sc.nextInt();

        plano.preencherBugs(quantidadeBugs);
        System.out.println("Informe a quantidade de devs que deseja adicionar");
        int quantidadeDevs = sc.nextInt();
        plano.preencherDevs(quantidadeDevs);
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
                    this.bugs = plano.getBugs();
                    this.devs = plano.getDevs();
                    break;
                case 2:
                    Relatorio relatorio = new Relatorio(this.planetas, this.plano);
                    relatorio.ExibirRelatorio(this.momento,this.falecidos);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Informe a quantidade de desenvolvedores desejada:");
                    quantidadeDevs = sc.nextInt();
                    plano.preencherDevs(quantidadeDevs);
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Informe a quantidade de Bugs desejada:");
                    quantidadeBugs = sc.nextInt();
                    plano.preencherBugs(quantidadeBugs);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    public void validarQuantidade(int quantidadeBugs,int quantidadeDevs) throws LimiteException{

        if((quantidadeBugs + bugs.size() + quantidadeDevs + devs.size())>LimiteMaximo){
            throw new LimiteException("Quantidade de bugs ou Devs excedidas, tente novamente");
        }
    }

}

