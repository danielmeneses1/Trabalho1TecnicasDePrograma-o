package planetas;

public class Python extends Planeta{

    public Python() {
        super(8,9);
        this.nome ="Python";
        this.translacao = 4;
        this.rotacao = 24;
        this.anoJavalar = 0;
        this.resumo = "Python é uma linguagem de programação de alto nível conhecida por sua simplicidade e legibilidade.\n" +
                "É amplamente utilizado em desenvolvimento web, análise de dados, automação, inteligência artificial e muitas outras áreas.\n" +
                "Sua sintaxe limpa e fácil de aprender a torna uma escolha popular para iniciantes em programação.";

    }

    public void mover(int momento){

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











