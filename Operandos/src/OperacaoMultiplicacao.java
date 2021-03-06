
public class OperacaoMultiplicacao extends OperacaoBinaria{
	private float resultado;
	public float getResultado() {
		return resultado;
	}

	public void setResultado(float resultado) {
		this.resultado = resultado;
	}

	public OperacaoMultiplicacao(String nome, String simboloOperador) {
		super(nome, simboloOperador);
	}
	
	public float calculoResultado(Operando ... valor) throws NumeroOperandosException{
		if(valor.length == 2){
			this.resultado = valor[0].Avaliar() * valor[1].Avaliar();
			System.out.println("Operandos: " + valor[0].Avaliar() + " e " + valor[1].Avaliar() +"\n"
					+ "Simbolo: " + simboloOperador + "\n" + "Resultado: " + this.resultado);
		}
		else{
			throw new NumeroOperandosException("Numero de operandos não suportado");
		}
		return resultado;
	}
}
