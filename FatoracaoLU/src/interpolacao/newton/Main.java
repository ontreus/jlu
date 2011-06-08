package interpolacao.newton;

public class Main {

	public static void main(String[] args) {
		DataSetNewton dsn = new DataSetNewton();

		System.out.println(new Newton(dsn).valorPolinomioNoPonto(dsn, 2));
	}

}
