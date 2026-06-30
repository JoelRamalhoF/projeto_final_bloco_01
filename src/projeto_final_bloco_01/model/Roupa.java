package projeto_final_bloco_01.model;

public class Roupa extends Produto{

	private String tipoDeRoupa;

	public Roupa(int id, String nome, int categoria, float preco, String tipoDeRoupa) {
		super(id, nome, categoria, preco);
		this.tipoDeRoupa = tipoDeRoupa;
	}
	public String gettipoDeRoupa() {
		return tipoDeRoupa;
	}

	public void tipoDeRoupa(String tipoDeRoupa) {
		this.tipoDeRoupa = tipoDeRoupa;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.printf("Tipo de Roupa: %s\n", this.tipoDeRoupa);
	}
}