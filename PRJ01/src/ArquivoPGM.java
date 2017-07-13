import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.Scanner;

public class ArquivoPGM {

  private int altura;
  private int largura;
  private int max;
  private int[][] imagem;
  
  
  //Getters and Setters
  
    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int[][] getImagem() {
        return imagem;
    }

    public void setImagem(int[][] imagem) {
        this.imagem = imagem;
    }
  
// Métodos da Classe
    public void carregaPGM(String caminho) throws Exception {
        Scanner s = new Scanner(Paths.get(caminho));
        s.nextLine();// P2
            setLargura(s.nextInt());
            setAltura(s.nextInt());
            setImagem(new int[this.getLargura()][this.getLargura()]);
            setMax(s.nextInt()); // 255
        for (int i = 0; i < getLargura(); i++) {
          for (int j = 0; j < getAltura(); j++) {
                    getImagem()[i][j] = s.nextInt();
          }
        }
      }

    public void escrevePGM(String caminho) throws IOException {
        PrintStream ps = new PrintStream(caminho);
        ps.println("P2 ");
        ps.printf("%d %d\n%d\n", 70, ((getAltura()*getAltura())/70)+70, getMax());
        int count = 0;
        for (int i = 0; i < getLargura(); i++) {
          for (int j = 0; j < getAltura(); j++) {
            count++;
            ps.printf("%d ", getImagem()[i][j]);
            if (count == 70) {
              ps.println();
              count = 0;
            }
          }
        }
    }
  
  public void filtrar (int [][] mascara){
	  int k = mascara.length;
    
	if(mascara.length%2 !=0 && mascara.length >0){
      int t= imagem.length+mascara.length/2;
      int[][] imagemTemporaria = new int[t][t];
      
      int j;
	int i;
	for(int p =0; p<mascara.length/2;p++){
        for(j=0;j<t;j++){
          imagemTemporaria[p][j]=0;
          imagemTemporaria[t-p][j]=0;
        }
        for(i=1;i<t-1;i++){
          imagemTemporaria[i][p]=0;
          imagemTemporaria[j][t-p]=0;
        }
      }
            
      for(i=1;i<k-1;i++){
        for(j=1;j<k-1;j++){
          imagemTemporaria[i][j]=imagem[i][j];
        }
      }
      
      for(i=0;i<k;i++){
        for(j=0;j<k;j++){
          imagem[i][j] = (imagemTemporaria[i][j] * mascara[i][j])/(1/(k*k));
        }
      }
    }
  }
    
    public void infoImagem (){
        System.out.println("Largura da Imagem = " + this.getLargura());
        System.out.println("Altura da Imagem = " + this.getAltura());
    }

}
