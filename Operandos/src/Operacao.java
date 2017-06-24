
abstract class Operacao{
	protected String nome;
	protected String simboloOperador;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSimboloOperador() {
		return simboloOperador;
	}
	public void setSimboloOperador(String simboloOperador) {
		this.simboloOperador = simboloOperador;
	}
	
	Operacao(String nome, String simboloOperador){
		this.nome = nome;
		this.simboloOperador = simboloOperador;
	}
	
	public abstract float calculoResultado(Operando ... valor);
}
