package interpolacao.newton;


public class Newton {

	DataSetNewton dsn;
	private Double[][] pd;

	public Newton(DataSetNewton paramDsn) {
		dsn = paramDsn;
		pd = new Double[dsn.quantidadeDePontos() + 4][dsn.quantidadeDePontos() + 4];
	}

	public double valorPolinomioNoPonto(DataSetNewton dsn, int x) {
		double resultado = 0, mult = 1;
		for (int i = 0; i < dsn.quantidadeDePontos(); i++) {
			if (i != 0) {
				mult *= (x - dsn.ponto(i - 1));
			}

			resultado += d(i) * mult;
		}

		return resultado;
	}

	private double d(int i) {
		return f(0, i);
	}

	private double f(int a, int b) {
		if (a == b) {
			pd[a][b] = dsn.valor(a);
		}

		if (pd[a][b] == null) {
			pd[a][b] = (f(a + 1, b) - f(a, b - 1))
					/ (dsn.ponto(b) - dsn.ponto(a));
		}

		return pd[a][b];
	}

}
