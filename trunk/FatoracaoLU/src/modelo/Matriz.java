package modelo;

import java.util.ArrayList;

public class Matriz {
	private ArrayList<Vetor> linhas;
	
	public Matriz() {
		linhas = new ArrayList<Vetor>();
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
}
