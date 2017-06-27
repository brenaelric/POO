
public class MenosUnario extends OperacaoUnaria{

	public MenosUnario() {
		super("Menos Unário", "-");		
	}
	public float calculoResultado(Operando ... valor){
		if(valor.lenght != 1){
			Syste,out.println("Erro");
		}
		else{
			return -valor[o].avaliar;
		}
	}
}
