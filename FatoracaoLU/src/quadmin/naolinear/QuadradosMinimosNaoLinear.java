package quadmin.naolinear;

import modelo.Vetor;

public class QuadradosMinimosNaoLinear {

	public void montarSistema(DataSetNaoLinear ds) {
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
				soma += ds.z(ds.ponto(k)) * ds.g(ds.ponto(k), i);
			}
			ds.vetor.adicionarElemento(soma);
		}
	}

	public Vetor obterAlphas(Vetor a) {
		Vetor alphas = new Vetor();
		
		alphas.adicionarElemento(Math.pow(Math.E, a.getElemento(0)));
		alphas.adicionarElemento(-a.getElemento(1));
		
		return alphas;
	}

}
