package planetas;

public class C extends Planeta{

    public C() {
        super(8,15);
        this.nome = "C";
        this.translacao = 10;
        this.rotacao = 0.1;
        this.resumo = "C é uma linguagem de programação de alto desempenho que é amplamente usada em desenvolvimento de sistemas, sistemas operacionais e software de baixo nível.\n" +
                "É conhecida por sua eficiência e portabilidade, mas também requer um gerenciamento manual de memória.\n" +
                "Muitas outras linguagens, incluindo C++, foram influenciadas pelo C em sua sintaxe e design.";


    }
    public void mover(int momento) {
        posicaoX = 8;
        posicaoY = 15;
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
