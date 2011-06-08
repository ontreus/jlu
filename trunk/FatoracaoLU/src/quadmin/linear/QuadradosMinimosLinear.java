package quadmin.linear;

import modelo.Vetor;

public class QuadradosMinimosLinear {

	public void montarSistema(DataSetLinear ds) {
		for (int i = 0; i < ds.quantidadeDeEquacoes; i++) {
			Vetor linha = new Vetor();
			for (int j = 0; j < ds.quantidadeDeEquacoes; j++) {
				// Calculo a[i][j]
				double soma = 0;
				for (int k = 0; k < ds.quantidadeDePontos(); k++) {
					soma += ds.g(ds.ponto(k), j) * ds.g(ds.ponto(k), i);
				}
				linha.adicionarElemento(soma);
			}

			ds.matriz.adicionarLinha(linha);

			// Calculo b[i]
			double soma = 0;
			for (int k = 0; k < ds.quantidadeDePontos(); k++) {
				soma += ds.f(ds.ponto(k)) * ds.g(ds.ponto(k), i);				
			}
			ds.vetor.adicionarElemento(soma);
		}
	}

}
