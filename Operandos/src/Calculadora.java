
public class Calculadora {

	public static void main(String[] args) {
		Operando a = new Operando(1);
		Operando b = new Operando(2);
		OperacaoSoma s = new OperacaoSoma("Soma", "+");
		OperacaoSubtracao r = new OperacaoSubtracao("Subtracao", "-");
		OperacaoMultiplicacao x = new OperacaoMultiplicacao("Multiplicao", "*");
		OperacaoDivisao y = new OperacaoDivisao("Subtracao", "/");
		s.calculoResultado(a, b);
		r.calculoResultado(a, b);
		x.calculoResultado(a, b);
		y.calculoResultado(a, b);
	}

}
