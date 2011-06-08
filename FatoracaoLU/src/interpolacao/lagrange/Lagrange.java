package interpolacao.lagrange;

import interpolacao.direta.DataSetInterpolacaoDireta;

public class Lagrange {

	public double valorPolinomioNoPonto(DataSetInterpolacaoDireta dsid, int x) {
		double soma = 0;
		
		for (int i = 0; i < dsid.quantidadeDePontos(); i++) {
			soma += dsid.valor(i) * l(i, x, dsid);
		}
		
		return soma;
	}

	private Double l(int k, int x, DataSetInterpolacaoDireta ds) {
		double numerador = 1, denominador = 1;
		
		for (int i = 0; i < ds.quantidadeDePontos(); i++) {
			if (i != k) {
				numerador *= (x - ds.ponto(i));
				denominador *= (ds.ponto(k) - ds.ponto(i));
			}
		}
		
		return numerador / denominador;
	}

}
