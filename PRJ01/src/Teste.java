import java.util.Scanner;

public class Teste {
	public static void main(String []args) throws Exception{
		ArquivoPGM arquivo = new ArquivoPGM();
        Scanner teclado = new Scanner (System.in);
        System.out.println("Digite o caminho/diretório do arquivo: ");
        String caminho = teclado.nextLine();
		arquivo.carregaPGM(caminho);
        arquivo.infoImagem();
		arquivo.escrevePGM("baboon2.ascii.pgm");
	}
}