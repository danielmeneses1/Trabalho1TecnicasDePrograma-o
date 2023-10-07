package planetas;

public class PHP extends Planeta{
    public PHP() {
        super(8,12);
        this.nome = "PHP";
        this.translacao = 2;
        this.rotacao = 60;
    }

    public void mover(int momento) {
        if (momento != (int) momento) {
            throw new IllegalArgumentException("O valor de momento deve ser um número inteiro.");
        }
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
