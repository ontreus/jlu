package quadmin;

import lu.FatoracaoLU;
import saida.Saida;

public class Main {

	public static void main(String[] args) {
		DataSet ds = new DataSet();
		
		new QuadradosMinimos().montarMatriz(ds);
		
		new Saida().imprimirVetor(new FatoracaoLU(ds.matriz, ds.vetor, true).resolver());
	}

}
