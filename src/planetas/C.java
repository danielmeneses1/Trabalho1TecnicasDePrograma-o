package planetas;

public class C extends Planeta{

    public C() {
        super(8,10);
        this.nome = "C";
        this.translacao = 10;
        this.posicaoY = 15;
        this.rotacao = 0.1;

    }

    @Override
    public void mover(int momento) {
        if (momento != (int) momento) {
            throw new IllegalArgumentException("O valor de momento deve ser um número inteiro.");
        }
        int unidades = momento * translacao;
        int direcao = 0;
        for (int i = 0; i < unidades; i++) {
            if (direcao == 0) {
                posicaoX--;
                if (posicaoX == 0 && posicaoY == 15) {
                    direcao = 1;
                }
            } else if (direcao == 1) {
                posicaoY--;
                if (posicaoX == 0 && posicaoY == 0) {
                    direcao = 2;
                }
            } else if (direcao == 2) {
                posicaoX++;
                if (posicaoX == 16 && posicaoY == 0) {
                    direcao = 3;
            }
            }
            else if (direcao == 3) {
                posicaoY++;
                if (posicaoX == 16 && posicaoY == 15) {
                    direcao = 0;
                }
            }
            if(posicaoX==8 && posicaoY==15){
                anoJavalar++;
            }
        }
    }
}
