package lu;

import modelo.Vetor;
import saida.Saida;
import dataset.FatoracaoLUDataset;

public class Main {

	public static void main(String[] args) {
		FatoracaoLUDataset ds = new FatoracaoLUDataset();
		Saida saida = new Saida();
		
		saida.imprimirMatriz(ds.matrizA);
		saida.imprimirVetor(ds.vetorB);

		Vetor solucao = new FatoracaoLU(ds.matrizA, ds.vetorB, true).resolver();

		saida.imprimirVetor(solucao);
	}
}
