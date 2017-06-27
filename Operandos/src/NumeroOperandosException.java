
public class NumeroOperandosException extends RuntimeException {

	public NumeroOperandosException(String string) {
		super(string);
	}
	public String toString(){
		return super.getMessage();
	}
}
