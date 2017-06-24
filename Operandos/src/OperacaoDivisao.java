
public class OperacaoDivisao extends OperacaoBinaria{
	private float resultado;
	public float getResultado() {
		return resultado;
	}
	public void setResultado(float resultado) {
		this.resultado = resultado;
	}
	public OperacaoDivisao(String nome, String simboloOperador) {
		super(nome, simboloOperador);
	}
	
	public float calculoResultado(Operando ... valor) {
		if(valor.length == 2 && valor[1].Avaliar() != 0){
			this.resultado = valor[0].Avaliar() / valor[1].Avaliar();
			System.out.println("Operandos: " + valor[0].Avaliar() + " e " + valor[1].Avaliar() +"\n"
					+ "Simbolo: " + simboloOperador + "\n" + "Resultado: " + this.resultado);
		}
		else{
			try{
				throw new NumeroOperandosException("Numero de operandos não suportado");
			} catch(Exception e){
				System.out.println("Capturada: " + e);
				e.printStackTrace();
			}
			try{
				throw new DivisaoPorZeroException("Impossível dividir por zero");
			} catch(Exception b){
				System.out.println("Capturada: " + b);
				b.printStackTrace();
			}
		}
		return resultado;
	}
}
