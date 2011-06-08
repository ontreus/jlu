package quadmin.linear;

import modelo.Matriz;
import modelo.Tabela;
import modelo.Vetor;

public class DataSetLinear {
	
	public Matriz matriz;
	public Vetor vetor;
	public Tabela tabela;
	public int quantidadeDeEquacoes;
	
	public DataSetLinear() {
		matriz = new Matriz();
		vetor = new Vetor();
		tabela = new Tabela();
		
		tabela.adicionar(-1.0, 2.05);
		tabela.adicionar(-0.75, 1.153);
		tabela.adicionar(-0.6, 0.45);
		tabela.adicionar(-0.5, 0.4);
		tabela.adicionar(-0.3, 0.5);
		tabela.adicionar(0.0, 0.0);
		tabela.adicionar(0.2, 0.2);
		tabela.adicionar(0.4, 0.6);
		tabela.adicionar(0.5, 0.512);
		tabela.adicionar(0.7, 1.2);
		tabela.adicionar(1.0, 2.05);
		
		quantidadeDeEquacoes = 1;
	}
	
	public double g(double x, int f) {
		return x * x;
	}
	
	public double f(double ponto) {
		return tabela.valorDeX(ponto);
	}
	
	public double ponto(int k) {
		return tabela.pontos.get(k);
	}

	public int quantidadeDePontos() {
		return tabela.tamanho();
	}
	
}
