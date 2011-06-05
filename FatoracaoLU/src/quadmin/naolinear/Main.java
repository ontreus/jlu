package quadmin.naolinear;

import saida.Saida;
import lu.FatoracaoLU;
import modelo.Vetor;

public class Main {

	public static void main(String[] args) {
		DataSetNaoLinear ds = new DataSetNaoLinear();
		QuadradosMinimosNaoLinear qmnl = new QuadradosMinimosNaoLinear();
		
		qmnl.montarMatriz(ds);
		Vetor a = new FatoracaoLU(ds.matriz, ds.vetor, true).resolver();
		
		new Saida().imprimirVetor(qmnl.obterAlphas(a));
	}

}
