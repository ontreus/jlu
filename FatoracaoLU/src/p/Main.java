package p;

public class Main {

	public static void main(String[] args) {
		// Criando a matriz a e o vetor b
		Matriz a = new Matriz();

		Linha linha1, linha2, linha3;

		linha1 = new Linha();
		linha2 = new Linha();
		linha3 = new Linha();

		linha1.adicionarElemento(3);
		linha1.adicionarElemento(2);
		linha1.adicionarElemento(4);

		linha2.adicionarElemento(1);
		linha2.adicionarElemento(1);
		linha2.adicionarElemento(2);

		linha3.adicionarElemento(4);
		linha3.adicionarElemento(3);
		linha3.adicionarElemento(2);

		a.adicionarLinha(linha1);
		a.adicionarLinha(linha2);
		a.adicionarLinha(linha3);

		Linha b = new Linha();

		b.adicionarElemento(1);
		b.adicionarElemento(2);
		b.adicionarElemento(3);
		
		// Etapa k, de "0" á "variáveis - 1";
		for (int k = 0; k < b.tamanho() - 1; k++) {
			double pivo = escolherPivo(a, k, b);			
		}

	}

	private static double escolherPivo(Matriz a, int k, Linha b) {
		double pivo = 0;
		//Escolhendo o elemento das linhas a partir de k com o maior valor absoluto na coluna k
		int linhaDoElemento = k;
		for (int i = k; i < a.getLinhas().size(); i++) {
			double elemento = Math.abs(a.getLinhas().get(i).getElementos().get(k));
			
			if (elemento > pivo) {
				pivo = elemento;
				linhaDoElemento = i;
			}				
		}
		
		//Se a linha do elemento for diferente de k, é necessário permutar essas linhas
		if (linhaDoElemento != k) {
			a.permutarLinhas(linhaDoElemento, k);
			b.permutarElementos(linhaDoElemento, k);
		}
		
		return pivo;
	}

}
