import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.Scanner;

public class ArquivoPGM {

  private int altura;
  private int largura;
  private int max;
  private int[][] imagem;// = new int [altura][largura];
  

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

public void carregaPGM(String caminho) throws Exception {
    Scanner s = new Scanner(Paths.get(caminho));
    FileInputStream cArquivo = new FileInputStream(caminho);
    DataInputStream arquivo = new DataInputStream(cArquivo);
    
    s.nextLine();// P2
    
    int b = arquivo.read();
    int count = 0;
	while(count<altura*largura){
    	if(b=='#'){
    		arquivo.readLine();
    		count++;
    	}
    	else{
    		largura = s.nextInt();
    		altura = s.nextInt(); 
    		break;
    	}    	
    }
	
    imagem = new int[this.largura][this.largura];
    while(count<altura*largura){
    	if(b=='#'){
    		arquivo.readLine();
    		count++;
    	}
    	else{
    		max = s.nextInt(); // 255
    		break;
    	}    	
    }
    
    for (int i = 0; i < largura; i++) {
      for (int j = 0; j < altura; j++) {
    	  if(b<0)
    		  break;
    	  if(b== '\n'){
    		  //Não faz nada
    		  }
    	  else if(b == '#'){
    		  arquivo.readLine();
    		  }
    	  else if(Character.isWhitespace(b)){
    		  //Não faz nada
    		  }
    	  else{
    		  imagem[i][j] = s.nextInt();  
    	  }
      }
    }
  }

  public void escrevePGM(String caminho) throws IOException {
    PrintStream ps = new PrintStream(caminho);
    ps.println("P2 ");
    ps.printf("%d %d\n%d\n", 70, ((altura*altura)/70)+70, max);
    int count = 0;
    for (int i = 0; i < largura; i++) {
      for (int j = 0; j < altura; j++) {
        count++;
        ps.printf("%d ", imagem[i][j]);
        if (count == 70) {
          ps.println();
          count = 0;
        }
      }
    }
  }
}