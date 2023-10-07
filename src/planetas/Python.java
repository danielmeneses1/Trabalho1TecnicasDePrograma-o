package planetas;

public class Python extends Planeta{

    public Python() {
        super(8,9);
        this.nome ="Python";
        this.translacao = 4;
        this.rotacao = 24;
        this.anoJavalar = 0;
    }

    public void mover(int momento){
        if (momento != (int) momento) {
            throw new IllegalArgumentException("O valor de momento deve ser um número inteiro.");
        }

        posicaoX = 8;
        posicaoY = 9;
        int unidades = momento * translacao;
        int direcao = 0;

        for (int i = 0; i<unidades; i++){

            if(direcao == 0){
                posicaoX--;
                if(posicaoX ==6 && posicaoY ==9){
                    direcao = 1;}
            }else if (direcao ==1){
                posicaoY--;
                if (posicaoX ==6&&posicaoY==6){
                    direcao =2;}
            } else if (direcao ==2) {
                posicaoX++;
                if(posicaoX ==10 && posicaoY ==6){
                    direcao =3;}}
                else if (direcao==3) {
                posicaoY++;
                if(posicaoX ==10 && posicaoY ==9){
                    direcao =0;
                }
            }
                if(posicaoX==8 && posicaoY==9){
                anoJavalar++;
                }
        }
    }


   }











