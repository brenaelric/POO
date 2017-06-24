
abstract class OperacaoUnaria extends Operacao{
		
	public OperacaoUnaria(String nome, String simboloOperador) {
		super(nome, simboloOperador);
	}

	public abstract float calculoResultado(Operando ... valor);
}
