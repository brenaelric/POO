
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
	
	public float calculoResultado(Operando ... valor) throws NumeroOperandosException, DivisaoPorZeroException{
		if(valor.length == 2 && valor[1].Avaliar() != 0){
			this.resultado = valor[0].Avaliar() / valor[1].Avaliar();
			System.out.println("Operandos: " + valor[0].Avaliar() + " e " + valor[1].Avaliar() +"\n"
					+ "Simbolo: " + simboloOperador + "\n" + "Resultado: " + this.resultado);
		}
		else{			
			if(valor.length == 2){
				throw new NumeroOperandosException("Numero de operandos não suportado");
			}
			else{
				throw new DivisaoPorZeroException("Impossível dividir por zero");
			}
		}
		return resultado;
	}
}
