
abstract class OperacaoBinaria extends Operacao {

	public OperacaoBinaria(String nome, String simboloOperador) {
		super(nome, simboloOperador);
	}
	
	public abstract float calculoResultado(Operando ... valor);
}
