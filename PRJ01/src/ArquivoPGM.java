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
    
    public void infoImagem (){
        System.out.println("Largura da Imagem = " + this.getLargura());
        System.out.println("Altura da Imagem = " + this.getAltura());
    }

}