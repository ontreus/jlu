package interpolacao.newton;

import modelo.Matriz;
import modelo.Tabela;
import modelo.Vetor;
import interpolacao.direta.DataSetInterpolacaoDireta;

public class DataSetNewton extends DataSetInterpolacaoDireta {
	
	public DataSetNewton() {
		matriz = new Matriz();
		vetor = new Vetor();
		tabela = new Tabela();
		
		tabela.adicionar(-1.0, 4.0);
		tabela.adicionar(0.0, 1.0);
		tabela.adicionar(2.0,-1.0);
	}

}
