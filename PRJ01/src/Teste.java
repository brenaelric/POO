
public class Teste {
	public static void main(String []args) throws Exception{
		ArquivoPGM A = new ArquivoPGM();
		A.carregaPGM("mona_lisa.ascii.pgm");
		A.escrevePGM("mona_lisa2.ascii.pgm");
	}
}
