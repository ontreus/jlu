package lu;

import saida.Saida;
import modelo.Matriz;
import modelo.Vetor;

public class FatoracaoLU {

	Matriz matriz;
	Vetor constante;
	boolean fazPivoteamentoParcial;

	public FatoracaoLU(Matriz paramMatriz, Vetor paramConstante, boolean paramFazPivoteamentoParcial) {
		matriz = paramMatriz;
		constante = paramConstante;
		fazPivoteamentoParcial = paramFazPivoteamentoParcial;
	}

	public Vetor resolver() {
		// Obtenção do fatores L e U.
		for (int etapa = 0; etapa < matriz.quantidadeDeColunas() - 1; etapa++) {
			// Cálculo do pivô
			double pivo = fazPivoteamentoParcial ? 
					pivoteamentoParcial(etapa) : pivoteamento(etapa);

			// Cálculo do multiplicador
			for (int linha = etapa + 1; linha < matriz.quantidadeDeLinhas(); linha++) {
				double multiplicador = matriz.getElemento(linha, etapa) / pivo;

				// Eliminação dos coeficientes
				for (int coluna = etapa; coluna < matriz.quantidadeDeColunas(); coluna++) {
					if (coluna == etapa) {
						matriz.setElemento(linha, coluna, multiplicador);
					} else {
						double resultado = matriz.getElemento(linha, coluna)
								- multiplicador
								* matriz.getElemento(etapa, coluna);
						matriz.setElemento(linha, coluna, resultado);
					}
				}
			}
		}

		Matriz matrizL = obterMatrizL();
		Matriz matrizU = obterMatrizU();

		Vetor vetorY = resolverSistemaTriangularInferior(matrizL, constante);
		Vetor vetorX = resolverSistemaTriangularSuperior(matrizU, vetorY);

		return vetorX;
	}

	private Matriz obterMatrizU() {
		Matriz matrizU = new Matriz();

		for (int linha = 0; linha < matriz.quantidadeDeLinhas(); linha++) {
			Vetor vetor = new Vetor();
			for (int coluna = 0; coluna < matriz.quantidadeDeColunas(); coluna++) {
				if (linha > coluna) {
					vetor.adicionarElemento(0);
				} else {
					vetor.adicionarElemento(matriz.getElemento(linha, coluna));
				}
			}

			matrizU.adicionarLinha(vetor);
		}

		return matrizU;
	}

	private Matriz obterMatrizL() {
		Matriz matrizL = new Matriz();

		for (int linha = 0; linha < matriz.quantidadeDeLinhas(); linha++) {
			Vetor vetor = new Vetor();
			for (int coluna = 0; coluna < matriz.quantidadeDeColunas(); coluna++) {
				if (linha == coluna) {
					vetor.adicionarElemento(1);
				} else {
					if (linha < coluna) {
						vetor.adicionarElemento(0);
					} else {
						vetor.adicionarElemento(matriz.getElemento(linha, coluna));
					}
				}
			}

			matrizL.adicionarLinha(vetor);
		}

		return matrizL;
	}

	private double pivoteamento(int etapa) {
		return matriz.getElemento(etapa, etapa);
	}

	private double pivoteamentoParcial(int etapa) {
		double pivo = 0;
		int linhaDoElemento = etapa;
		// Escolhendo o elemento das linhas a partir de k com o maior valor
		// absoluto na coluna k
		for (int linha = etapa; linha < matriz.quantidadeDeLinhas(); linha++) {
			if (Math.abs(matriz.getElemento(linha, etapa)) > Math.abs(pivo)) {
				pivo = matriz.getElemento(linha, etapa);
				linhaDoElemento = linha;
			}
		}

		// Se a linha do elemento for diferente de k, � necess�rio permutar
		// essas linhas
		if (linhaDoElemento != etapa) {
			matriz.permutarLinhas(linhaDoElemento, etapa);
			constante.permutarElementos(linhaDoElemento, etapa);
		}

		return pivo;
	}

	private Vetor resolverSistemaTriangularSuperior(Matriz matriz, Vetor vetor) {
		Vetor solucao = new Vetor(vetor.tamanho());

		for (int k = vetor.tamanho() - 1; k >= 0; k--) {
			double soma = 0;
			for (int j = k + 1; j < vetor.tamanho(); j++) {
				soma += matriz.getElemento(k, j) * solucao.getElemento(j);
			}
			solucao.setElemento(k, (vetor.getElemento(k) - soma) / matriz.getElemento(k, k));
		}

		return solucao;
	}

	private static Vetor resolverSistemaTriangularInferior(Matriz matriz, Vetor vetor) {
		Vetor solucao = new Vetor(vetor.tamanho());

		for (int i = 0; i < vetor.tamanho(); i++) {
			double soma = 0;
			for (int j = 0; j < i; j++) {
				soma += matriz.getElemento(i, j) * solucao.getElemento(j);
			}
			solucao.setElemento(i, (vetor.getElemento(i) - soma) / matriz.getElemento(i, i));
		}

		return solucao;
	}

}
