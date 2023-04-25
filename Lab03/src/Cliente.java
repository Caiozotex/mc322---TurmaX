import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class Cliente {
	private String nome;
	private String endereco;
	private String educacao;
	private String genero;
	private String classeEconomica;
	private Date dataLicenca;
	private List<Veiculo> listaVeiculos;
	
	public Cliente(String Nome,String Educacao,String Endereco,String Genero, 
	String ClasseEconomica, Date Data) {
		this.nome = Nome;
		this.endereco = Endereco;
		this.educacao = Educacao;
		this.genero = Genero;
		this.classeEconomica = ClasseEconomica;
		this.dataLicenca = Data;
		listaVeiculos = new ArrayList<>();
	}
	
	public Veiculo getVeiculo(int indice){
		return listaVeiculos.get(indice);
	}
	
	public void setVeiculo(Veiculo veiculo) {
		listaVeiculos.add(veiculo);
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

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	
	public void setData(Date Data) {
		this.dataLicenca = Data;
	}
	
	public Date getData() {
		return dataLicenca;
	}
	
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String informacoes = "Nome:" + getNome() + "\n" + "Endereço:" 
	+ getEndereco() + "\n" + "Educacao:" + getEducacao() + "\n" + "Gênero:" +
	getGenero() + "\n" + "Classe Econômica:" + getClasseEconomica()+ "\n" + "Data da Licença:"
	+ formato.format(getData())+ "\n" + "Lista de veiculos:" + listaVeiculos.toString();
		return informacoes;
	}
	
	
	
	//Resolver data licença
	

}
