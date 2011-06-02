package p;

import java.util.ArrayList;

public class Matriz {
	private ArrayList<Linha> linhas;
	
	public Matriz() {
		linhas = new ArrayList<Linha>();
	}
	
	public void adicionarLinha(Linha linha)
	{
		linhas.add(linha);
	}

	public void setLinhas(ArrayList<Linha> linhas) {
		this.linhas = linhas;
	}

	public ArrayList<Linha> getLinhas() {
		return linhas;
	}

	public void permutarLinhas(int posX, int posY) {
		Linha x = linhas.get(posX);
		Linha y = linhas.get(posY);
		
		linhas.set(posX, y);
		linhas.set(posY, x);
	}
}