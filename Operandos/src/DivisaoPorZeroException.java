
public class DivisaoPorZeroException extends RuntimeException {

	public DivisaoPorZeroException(String string) {
		super(string);
	}
	
	public String toString(){
		return super.getMessage();
	}

}
