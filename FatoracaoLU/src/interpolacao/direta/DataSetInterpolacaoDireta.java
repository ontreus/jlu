package interpolacao.direta;

import modelo.Matriz;
import modelo.Tabela;
import modelo.Vetor;

public class DataSetInterpolacaoDireta {
	
	public Tabela tabela;
	public Matriz matriz;
	public Vetor vetor;
	
	public DataSetInterpolacaoDireta() {
		matriz = new Matriz();
		vetor = new Vetor();
		tabela = new Tabela();
		
		tabela.adicionar(-1.0, 4.0);
		tabela.adicionar(0.0, 1.0);
		tabela.adicionar(2.0, -1.0);
	}

	public int quantidadeDePontos() {
		return tabela.tamanho();
	}
	
	public double ponto(int k) {
		return tabela.pontos.get(k);
	}

	public Double valor(int k) {
		return tabela.valores.get(k);
	}

}
