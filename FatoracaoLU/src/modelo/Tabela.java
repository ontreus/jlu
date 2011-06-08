package modelo;

import java.util.ArrayList;

public class Tabela {

	public ArrayList<Double> pontos, valores;

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
