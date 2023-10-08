package planetas;

public class RubyOnRails extends Planeta{

    public RubyOnRails() {
        super(8,11);
        this.nome = "Ruby";
        this.translacao = 2;
        this.rotacao = 48;
        this.resumo = "Ruby on Rails, muitas vezes chamado apenas de \"Rails\", é um framework de desenvolvimento web baseado na linguagem Ruby.\n" +
                "Ele segue o paradigma MVC (Model-View-Controller) e enfatiza a convenção sobre configuração, tornando o desenvolvimento web mais rápido e mais organizado.\n" +
                "É conhecido por promover a produtividade do desenvolvedor e é amplamente utilizado para criar aplicativos da web.";

    }
    public void mover(int momento) {

        posicaoX = 8;
        posicaoY = 11;
        int unidades = momento * translacao;
        int direcao = 0;

        for (int i = 0; i < unidades; i++) {


            if (direcao == 0) {
                posicaoX--;
                if (posicaoX == 4 && posicaoY == 11) {
                    direcao = 1;
                }
            } else if (direcao == 1) {
                posicaoY--;
                if (posicaoX == 4 && posicaoY == 4) {
                    direcao = 2;
                }
            } else if (direcao == 2) {
                posicaoX++;
                if (posicaoX == 12 && posicaoY == 4) {
                    direcao = 3;
                }
            }
             else if (direcao == 3) {
                posicaoY++;
                if (posicaoX == 12 && posicaoY == 11) {
                    direcao = 0;
                }
            }if (passouInicio(8,11)){
                anoJavalar ++;
            }

    }

    }


}