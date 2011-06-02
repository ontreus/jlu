package p;

public class Main {

	public static void main(String[] args) {
		// Criando a matriz a e o vetor b
		Matriz matrizA = new Matriz();

		Linha linha1, linha2, linha3;

		linha1 = new Linha();
		linha2 = new Linha();
		linha3 = new Linha();

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

		Linha vetorB = new Linha();

		vetorB.adicionarElemento(9);
		vetorB.adicionarElemento(3);
		vetorB.adicionarElemento(-2);

		// Obtenção do fatores L e U pelo método de Gauss
		for (int etapa = 0; etapa < matrizA.quantidadeDeColunas() - 1; etapa++) {
			double pivo = pivoteamentoParcial(matrizA, etapa, vetorB);
			//double pivo = pivoteamento(matrizA, etapa);

			for (int linha = etapa + 1; linha < matrizA.quantidadeDeLinhas(); linha++) {
				double multiplicador = matrizA.getElemento(linha, etapa) / pivo;

				for (int coluna = etapa; coluna < matrizA.quantidadeDeColunas(); coluna++) {
					if (coluna == etapa) {
						matrizA.setElemento(linha, coluna, multiplicador);
					} else {
						double resultado = matrizA.getElemento(linha, coluna) - multiplicador * matrizA.getElemento(etapa, coluna);
						matrizA.setElemento(linha, coluna, resultado);
					}
				}
			}
		}

		Matriz matrizL = obterMatrizLDeA(matrizA);
		Matriz matrizU = obterMatrizUDeA(matrizA);
		
		Linha vetorY = resolverSistemaTriangularInferior(matrizL, vetorB);
		Linha vetorX = resolverSistemaTriangularSuperior(matrizU, vetorY);
		
		imprimirMatriz(matrizA);
		imprimirLinha(vetorX);
	}

	private static double pivoteamento(Matriz matriz, int etapa) {
		return matriz.getElemento(etapa, etapa);
	}
	
	private static double pivoteamentoParcial(Matriz a, int etapa, Linha b) {
		double pivo = 0;
		int linhaDoElemento = etapa;
		// Escolhendo o elemento das linhas a partir de k com o maior valor
		// absoluto na coluna k
		for (int linha = etapa; linha < a.quantidadeDeLinhas(); linha++) {
			if (Math.abs(a.getElemento(linha, etapa)) > Math.abs(pivo)) {
				pivo = a.getElemento(linha, etapa);
				linhaDoElemento = linha;
			}
		}

		// Se a linha do elemento for diferente de k, � necess�rio permutar
		// essas linhas
		if (linhaDoElemento != etapa) {
			a.permutarLinhas(linhaDoElemento, etapa);
			b.permutarElementos(linhaDoElemento, etapa);
		}

		return pivo;
	}

	private static Linha resolverSistemaTriangularSuperior(Matriz a, Linha b) {
		Linha x = new Linha(b.tamanho());
		
		double ann = a.getElemento(a.quantidadeDeLinhas() - 1, a.quantidadeDeColunas() - 1);
		double bn = b.getElemento(b.tamanho() - 1);
		x.setElemento(bn / ann, x.tamanho() - 1);

		for (int k = b.tamanho() - 2; k >= 0; k--) {
			double s = 0;
			for (int j = k + 1; j < b.tamanho(); j++) {
				s += a.getElemento(k, j) * x.getElemento(j);
			}
			x.setElemento((b.getElemento(k) - s) / a.getElemento(k, k), k);
		}

		return x;
	}

	private static Linha resolverSistemaTriangularInferior(Matriz a, Linha b) {
		Linha x = new Linha(b.tamanho());
		
		x.setElemento(b.getElemento(0) / a.getElemento(0, 0), 0);

		for (int k = 1; k < b.tamanho(); k++) {
			double s = 0;
			for (int j = 0; j < k; j++) {
				s += a.getElemento(k, j) * x.getElemento(j);
			}
			x.setElemento((b.getElemento(k) - s) / a.getElemento(k, k), k);
		}

		return x;
	}

	private static Matriz obterMatrizUDeA(Matriz matriz) {
		Matriz matrizU = new Matriz();

		for (int linha = 0; linha < matriz.quantidadeDeLinhas(); linha++) {
			Linha linhaL = new Linha();
			for (int coluna = 0; coluna < matriz.quantidadeDeColunas(); coluna++) {
				if (linha > coluna) {
					linhaL.adicionarElemento(0);
				} else {
					linhaL.adicionarElemento(matriz.getElemento(linha, coluna));
				}
			}

			matrizU.adicionarLinha(linhaL);
		}

		return matrizU;
	}

	private static Matriz obterMatrizLDeA(Matriz matriz) {
		Matriz matrizL = new Matriz();

		for (int linha = 0; linha < matriz.quantidadeDeLinhas(); linha++) {
			Linha linhaL = new Linha();
			for (int coluna = 0; coluna < matriz.quantidadeDeColunas(); coluna++) {
				if (linha == coluna) {
					linhaL.adicionarElemento(1);
				} else {
					if (linha < coluna) {
						linhaL.adicionarElemento(0);
					} else {
						linhaL.adicionarElemento(matriz.getElemento(linha,
								coluna));
					}
				}
			}

			matrizL.adicionarLinha(linhaL);
		}

		return matrizL;
	}

	private static void imprimirLinha(Linha vetorB) {
		for (int i = 0; i < vetorB.tamanho(); i++) {
			System.out.println(vetorB.getElemento(i));
		}
		System.out.println();
	}

	private static void imprimirMatriz(Matriz matriz) {
		for (int i = 0; i < matriz.quantidadeDeLinhas(); i++) {
			for (int j = 0; j < matriz.quantidadeDeColunas(); j++) {
				System.out.print(matriz.getElemento(i, j) + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
