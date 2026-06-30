package projeto_final_bloco_01.model;

public class Eletronicos extends Produto {
	private String game;
	public Eletronicos(int id, String nome, int categoria, float preco) {
		super(id, nome, categoria, preco);
		this.game = game;
	}
	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public void visualizar() {
		super.visualizar();
		System.out.printf("Nome do game: %s\n", this.game);
	}

}
