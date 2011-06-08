package interpolacao.direta;

import saida.Saida;
import lu.FatoracaoLU;

public class Main {

	public static void main(String[] args) {
		DataSetInterpolacaoDireta dsid = new DataSetInterpolacaoDireta();
		new InterpolacaoDireta().montarSistema(dsid);
		new Saida().imprimirVetor(new FatoracaoLU(dsid.matriz, dsid.vetor, true).resolver());
	}

}
