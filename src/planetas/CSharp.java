package planetas;

public class CSharp extends Planeta{

    public CSharp() {
        super(8,13);
        this.nome = "C#";
        this.translacao = 1;
        this.rotacao = 4;
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
                if(posicaoX ==8&&posicaoY==13){
                    anoJavalar++;
                }
                if (posicaoX == 2 && posicaoY == 13) {
                    direcao = 1;
                }
            } else if (direcao == 1) {
                posicaoY--;
                if (posicaoX == 2 && posicaoY == 2) {
                    direcao = 2;
                }
            } else if (direcao == 2) {
                posicaoX++;
                if (posicaoX == 14 && posicaoY == 2) {
                    direcao = 3;
                }
            }
             else if (direcao == 3) {
                posicaoY++;
                if (posicaoX == 14 && posicaoY == 13) {
                    direcao = 0;
                }

            }if(posicaoX==8 && posicaoY==13){
                anoJavalar++;
            }
        }
    }
}