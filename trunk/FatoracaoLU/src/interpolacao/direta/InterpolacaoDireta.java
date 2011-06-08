package interpolacao.direta;

import modelo.Vetor;

public class InterpolacaoDireta {

	public void montarSistema(DataSetInterpolacaoDireta dsid) {
		for (int i = 0; i < dsid.quantidadeDePontos(); i++) {

			Vetor linha = new Vetor();

			for (int j = 0; j <= dsid.quantidadeDePontos(); j++) {
				linha.adicionarElemento(Math.pow(dsid.ponto(i), j));
			}

			dsid.matriz.adicionarLinha(linha);
			dsid.vetor.adicionarElemento(dsid.valor(i));
		}
	}

}
