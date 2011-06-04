package lu;

import modelo.Matriz;
import modelo.Vetor;

public class DataSet {
	
	public Matriz matrizA;
	public Vetor vetorB;
	
	public DataSet() {
		matrizA = new Matriz();
		
		Vetor linha1, linha2, linha3;

		linha1 = new Vetor();
		linha2 = new Vetor();
		linha3 = new Vetor();

		linha1.adicionarElemento(3);
		linha1.adicionarElemento(-4);
		linha1.adicionarElemento(1);

		linha2.adicionarElemento(1);
		linha2.adicionarElemento(2);
		linha2.adicionarElemento(2);

		linha3.adicionarElemento(4);
		linha3.adicionarElemento(0);
		linha3.adicionarElemento(-3);

		matrizA.adicionarLinha(linha1);
		matrizA.adicionarLinha(linha2);
		matrizA.adicionarLinha(linha3);

		vetorB = new Vetor();

		vetorB.adicionarElemento(9);
		vetorB.adicionarElemento(3);
		vetorB.adicionarElemento(-2);
	}

}
