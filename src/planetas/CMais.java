package planetas;

public class CMais extends Planeta{

    public CMais() {
        super(8,14);
        this.nome = "C++";
        this.translacao = 2;
        this.posicaoX = 8;
        this.posicaoY = 14;
        this.rotacao = 0.5;
    }

    public void mover(int momento) {

        posicaoX = 8;
        posicaoY = 14;
        int unidades = momento * translacao;
        int direcao = 0;
        for (int i = 0; i < unidades; i++) {

            if (direcao == 0) {
                posicaoX--;
                if (posicaoX == 1 && posicaoY == 14) {
                    direcao = 1;
                }
            } else if (direcao == 1) {
                posicaoY--;
                if (posicaoX == 1 && posicaoY == 1) {
                    direcao = 2;
                }
            } else if (direcao == 2) {
                posicaoX++;
                if (posicaoX == 15 && posicaoY == 1) {
                    direcao = 3;
                }
            }
             else if (direcao == 3) {
                posicaoY++;
                if (posicaoX ==8 && posicaoY ==14){
                    anoJavalar++;
                }
                if (posicaoX == 15 && posicaoY == 14) {
                    direcao = 0;
                }
            }if(posicaoX==8 && posicaoY==14){
                anoJavalar++;
            }
        }

    }
    }

