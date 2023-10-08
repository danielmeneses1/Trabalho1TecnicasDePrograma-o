package planetas;

public class PHP extends Planeta{
    public PHP() {
        super(8,12);
        this.nome = "PHP";
        this.translacao = 2;
        this.rotacao = 60;
        this.resumo = "PHP é uma linguagem de script amplamente usada para desenvolvimento web.\n" +
                "É executado no servidor e é usado para criar páginas dinâmicas, interagir com bancos de dados e gerar conteúdo web.\n" +
                "Embora tenha perdido popularidade para algumas outras linguagens, ainda é usado em muitos sites e aplicativos.";

    }
        public void mover(int momento) {

        posicaoX = 8;
        posicaoY = 12;
        int unidades = momento * translacao;
        int direcao = 0;

        for (int i = 0; i < unidades; i++) {

            if (direcao == 0) {
                posicaoX--;
                if (posicaoX == 3 && posicaoY == 12) {
                    direcao = 1;
                }
            } else if (direcao == 1) {
                posicaoY--;
                if (posicaoX == 3 && posicaoY == 3) {
                    direcao = 2;
                }
            } else if (direcao == 2) {
                posicaoX++;
                if (posicaoX == 13 && posicaoY == 3) {
                    direcao = 3;
                }
            }
             else if (direcao == 3) {
                posicaoY++;
                if (posicaoX == 13 && posicaoY == 12) {
                    direcao = 0;
                }

                }
            if (passouInicio(8,12)){
                anoJavalar ++;
            }if(posicaoX==8 && posicaoY==12){
                anoJavalar++;
            }
}}


}
