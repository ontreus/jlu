package quadmin.linear;

import java.util.ArrayList;

import modelo.Matriz;
import modelo.Vetor;

public class DataSetLinear {
	
	public Matriz matriz;
	public Vetor vetor;
	public Tabela tabela;
	public int quantidadeDeEquacoes;
	public boolean isLinear;
	
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
		
		isLinear = true;
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
	
	protected class Tabela {
		ArrayList<Double> pontos, valores;
		
		public Tabela() {
			pontos = new ArrayList<Double>();
			valores = new ArrayList<Double>();
		}
		
		public double valorDeX(double ponto) {
			for (int i = 0; i < pontos.size(); i++) {
				if (pontos.get(i) == ponto) {
					return valores.get(i);
				}
			}
			
			return 0;
		}
		
		public void adicionar(double ponto, double valor) {
			pontos.add(ponto);
			valores.add(valor);
		}

		public int tamanho() {
			return pontos.size();
		}
	}
	
}
