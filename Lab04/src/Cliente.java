
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private String endereco;
	private double valorSeguro;
	private List<Veiculo> listaVeiculos;

	public Cliente(String Nome,String Endereco) {
		this.nome = Nome;
		this.endereco = Endereco;
		listaVeiculos = new ArrayList<>();
	}
	
	public Veiculo getVeiculo(int indice){
		return listaVeiculos.get(indice);
	}
	
	public void setVeiculo(Veiculo veiculo) {
		listaVeiculos.add(veiculo);
	}
	
	public int qtdeVeiculos() {
		return listaVeiculos.size();
	}
	
	public void removeVeiculo(String placa) {
		for(int i = 0; i < listaVeiculos.size();i++) {
			if(listaVeiculos.get(i).getPlaca().equals(placa)) {
				listaVeiculos.remove(i);
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	
	public double CalculaScore() {
		return 0.0;
	}

	public String toString() {
		String informacoes = "Nome:" + getNome() + "\n" + "Endereço:" 
	+ getEndereco() + "\n"  + "Lista de veiculos:" + listaVeiculos.toString()
	+ "\n" + "Valor do seguro:" + getValorSeguro();
		return informacoes;
	}
	

}
