package planetas;

public class RubyOnRails extends Planeta{

    public RubyOnRails() {
        super(8,11);
        this.nome = "Ruby";
        this.translacao = 2;
        this.rotacao = 48;
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