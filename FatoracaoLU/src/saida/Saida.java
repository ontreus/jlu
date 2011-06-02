package saida;

import modelo.Matriz;
import modelo.Vetor;

public class Saida {
	
	public void imprimirMatriz(Matriz matriz) {
		for (int i = 0; i < matriz.quantidadeDeLinhas(); i++) {
			for (int j = 0; j < matriz.quantidadeDeColunas(); j++) {
				System.out.print(matriz.getElemento(i, j) + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void imprimirVetor(Vetor vetor) {
		for (int i = 0; i < vetor.tamanho(); i++) {
			System.out.println(vetor.getElemento(i));
		}
		System.out.println();
	}

}
