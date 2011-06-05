package quadmin.linear;

import lu.FatoracaoLU;
import saida.Saida;

public class Main {

	public static void main(String[] args) {
		DataSetLinear ds = new DataSetLinear();
		
		new QuadradosMinimosLinear().montarMatriz(ds);
		
		new Saida().imprimirVetor(new FatoracaoLU(ds.matriz, ds.vetor, true).resolver());
	}

}
