package p;

import java.util.ArrayList;

public class Linha {

	private ArrayList<Double> elementos;
	
	public Linha() {
		elementos = new ArrayList<Double>();
	}
	
	public void adicionarElemento(Double i) {
		elementos.add(i);
	}

	public void adicionarElemento(int i) {
		elementos.add((double) i);
	}

	public void setElementos(ArrayList<Double> elementos) {
		this.elementos = elementos;
	}

	public ArrayList<Double> getElementos() {
		return elementos;
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

}
