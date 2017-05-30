import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ArquivoPGM {
	/**Declaração de atributos*/
	private int altura;
	private int largura;
	private int max;
	private int[][] imagem = new int [altura][largura];
	
	/**Gets e Sets*/
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
	
	
	/**Recebe uma string com o caminha para um arquivo PGM, verifica a existência do arquivo
	 *e caso o arquivo exista, carrega as informações do objeto*/
	public void carregaPGM(String caminho){		
		try{
			FileInputStream cArquivo = new FileInputStream(caminho);
			BufferedReader br = new BufferedReader(new InputStreamReader(cArquivo));
			String linhaUm = br.readLine(); //Linha que contem o P2
			String linhaDois = br.readLine(); //Linha que contem a largura e a altura
			String linhaTres = br.readLine(); //Linha que contem o valor máximo
			
			//Lendo altura e largura
			Scanner s = new Scanner(linhaDois);
			String[] separada = linhaDois.split(" ");
			this.largura = Integer.parseInt(separada[0]);
			this.altura = Integer.parseInt(separada[1]);
			s.close();
			
			//Lendo o valor máximo
			s = new Scanner(linhaTres);
			this.max = s.nextInt();
			s.close();
			cArquivo.close();
			br.close();
			
			//Montando a matriz
			int b =0, count =0;
			cArquivo = new FileInputStream(caminho);
			DataInputStream arquivo = new DataInputStream(cArquivo);
			arquivo.readLine();
			arquivo.readLine();
			arquivo.readLine();
			while(count < altura*largura){
				b = arquivo.read();
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
					imagem[count/largura][count%largura] = (int)b;
					count++;
				}
				
			}
			
		}catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	
	/**Recebe o caminho do arquivo e o cria a partir dos dados contidos na classe
	 * @throws IOException */
	public void escrevePGM(String caminho) throws IOException{
		DataOutputStream escreveArquivo = new DataOutputStream(new FileOutputStream(caminho));
		escreveArquivo.writeUTF("P2 \n");
		escreveArquivo.writeUTF(largura + " " + altura + "\n");
		escreveArquivo.writeUTF(max + "\n");
		for(int i=0; i<altura; i++){
			for(int j=0; j<largura;j++){
				escreveArquivo.writeByte(imagem[i][j]);
				escreveArquivo.writeUTF(" ");
			}
			escreveArquivo.writeUTF(" \n");
		}
		escreveArquivo.close();		
	}
}