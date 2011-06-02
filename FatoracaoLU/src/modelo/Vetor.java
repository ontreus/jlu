package modelo;

import java.util.ArrayList;

public class Vetor {

	private ArrayList<Double> elementos;
	
	public Vetor() {
		elementos = new ArrayList<Double>();
	}
	
	public Vetor(int quantidadeDeElementos) {
		elementos = new ArrayList<Double>();
		for (int i = 0; i < quantidadeDeElementos; i++) {
			elementos.add((double) 0);
		}
	}

	public void adicionarElemento(Double i) {
		elementos.add(i);
	}

	public void adicionarElemento(int i) {
		elementos.add((double) i);
	}

	public int tamanho() {
		return elementos.size();
	}

	public void permutarElementos(int posX, int posY) {
		double x = elementos.get(posX);
		double y = elementos.get(posY);
		
		elementos.set(posX, y);
		elementos.set(posY, x);
	}

	public double getElemento(int i) {
		return elementos.get(i);
	}
	
	public void setElemento(int posicao, double elemento) {
		elementos.set(posicao, elemento);
	}

}
