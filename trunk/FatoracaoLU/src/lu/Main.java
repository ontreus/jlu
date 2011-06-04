package lu;

import modelo.Vetor;
import saida.Saida;

public class Main {

	public static void main(String[] args) {
		DataSet ds = new DataSet();
		Saida saida = new Saida();
		
		saida.imprimirMatriz(ds.matrizA);
		saida.imprimirVetor(ds.vetorB);

		Vetor solucao = new FatoracaoLU(ds.matrizA, ds.vetorB, true).resolver();

		saida.imprimirVetor(solucao);
	}
}
