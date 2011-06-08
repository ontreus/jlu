package interpolacao.lagrange;

import interpolacao.direta.DataSetInterpolacaoDireta;

public class Main {

	public static void main(String[] args) {
		DataSetInterpolacaoDireta dsid = new DataSetInterpolacaoDireta();
		
		System.out.println(new Lagrange().valorPolinomioNoPonto(dsid, 1));
	}

}
