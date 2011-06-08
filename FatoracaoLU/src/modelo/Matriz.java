package modelo;

import java.util.ArrayList;

public class Matriz {
	private ArrayList<Vetor> linhas;
	
	public Matriz() {
		linhas = new ArrayList<Vetor>();
	}
	
	public Matriz(Double[][] pd) {
		for (int i = 0; i < pd.length; i++) {
			Vetor linha = new Vetor();
			for (int j = 0; j < pd[0].length; j++) {
				linha.adicionarElemento(pd[i][j]);
			}
			linhas.add(linha);
		}
	}

	public void adicionarLinha(Vetor linha)
	{
		linhas.add(linha);
	}

	public void permutarLinhas(int posX, int posY) {
		Vetor x = linhas.get(posX);
		Vetor y = linhas.get(posY);
		
		linhas.set(posX, y);
		linhas.set(posY, x);
	}

	public int quantidadeDeLinhas() {
		return linhas.size();
	}
	
	public int quantidadeDeColunas() {
		return linhas.get(0).tamanho();
	}

	public double getElemento(int i, int j) {
		return linhas.get(i).getElemento(j);
	}

	public void setElemento(int i, int j, double elemento) {
		linhas.get(i).setElemento(j, elemento);
	}

	public void adicionarLinha() {
		// TODO Auto-generated method stub
		
	}
}
