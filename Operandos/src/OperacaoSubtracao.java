
public class OperacaoSubtracao extends OperacaoBinaria{
	private float resultado;
	public float getResultado() {
		return resultado;
	}

	public void setResultado(float resultado) {
		this.resultado = resultado;
	}
	public OperacaoSubtracao(String nome, String simboloOperador) {
		super(nome, simboloOperador);
		// TODO Auto-generated constructor stub
	}
	
	public float calculoResultado(Operando ... valor) {
		if(valor.length == 2){
			this.resultado = valor[0].Avaliar() - valor[1].Avaliar();
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
		}
		return resultado;
	}
}
