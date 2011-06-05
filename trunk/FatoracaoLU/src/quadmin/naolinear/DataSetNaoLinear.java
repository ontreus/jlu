package quadmin.naolinear;

import modelo.Matriz;
import modelo.Vetor;
import quadmin.linear.DataSetLinear;

public class DataSetNaoLinear extends DataSetLinear {
	
	public DataSetNaoLinear () {
		matriz = new Matriz();
		vetor = new Vetor();
		tabela = new Tabela();
		
		tabela.adicionar(-1.0, 36.547);
		tabela.adicionar(-0.7, 17.264);
		tabela.adicionar(-0.4, 8.155);
		tabela.adicionar(-0.1, 3.852);
		tabela.adicionar(0.2, 1.820);
		tabela.adicionar(0.5, 0.860);
		tabela.adicionar(0.8, 0.406);
		tabela.adicionar(1.0, 0.246);
		
		quantidadeDeEquacoes = 2;
		
		isLinear = false;
	}
	
	public double g(double x, int f) {
		if (f == 0) {
			return 1;
		}
		
		if (f == 1) {
			return x;
		}
		
		return 0;
	}
	
	public double z(double x) {
		return Math.log(f(x));
	}

}
