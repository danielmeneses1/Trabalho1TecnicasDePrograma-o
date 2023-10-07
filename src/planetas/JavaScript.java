package planetas;

public class JavaScript extends Planeta {
    public JavaScript() {
        super(8,10);
        this.nome = "JavaScript";
        this.translacao = 3;
        this.rotacao = 10;

    }

    public void mover(int momento){
        if (momento != (int) momento) {
            throw new IllegalArgumentException("O valor de momento deve ser um número inteiro.");
        }
        int unidades = momento * translacao;
        int direcao = 0;

        for (int i = 0; i<unidades; i++){

            if(direcao == 0){
                posicaoX--;
                if(posicaoX ==5 && posicaoY ==10){
                    direcao = 1;}
            }else if (direcao ==1){
                posicaoY--;
                if (posicaoX ==5&&posicaoY==5){
                    direcao =2;}
            } else if (direcao ==2) {
                posicaoX++;
                if(posicaoX ==11 && posicaoY ==5){
                    direcao =3;}}
            else if (direcao==3) {
                posicaoY++;
                if(posicaoX ==11 && posicaoY ==10){
                    direcao =0;
                }
            }if(posicaoX==8 && posicaoY==10){
                anoJavalar++;
            }
        }
    }


}
