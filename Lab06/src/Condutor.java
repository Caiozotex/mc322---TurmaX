
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Condutor {
	private final String Cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private Date dataNascimento;
	private List<Sinistro> listaSinistros;
	
	public Condutor(String CPF,String Nome,String Telefone,String Endereco,String Email,Date DataN) {
		this.Cpf = CPF;
		this.nome = Nome;
		this.telefone = Telefone;
		this.endereco = Endereco;
		this.email = Email;
		this.dataNascimento = DataN;
		listaSinistros = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getCpf() {
		return Cpf;
	}
	
	
	public void adicionarSinistros(Sinistro sinistrao) {
		listaSinistros.add(sinistrao);
	}
	
	public int quantidadeSinistro() {
		return listaSinistros.size();
	}
	
	public String infoSinistro() {
		String info = "";
		for(int i = 0 ; i < listaSinistros.size();i++) {
			info += listaSinistros.get(i).getId() + "-";
		}
		return info;
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String informacoes = "CPF" + getCpf() + "\n" + "Nome:" + getNome() + "\n" + "Telefone:" + getTelefone() + "\n" +
	    "Endereço:" + getEndereco() + "\n" + "Email:" + getEmail() + "Data de Nascimento:" 
		+ formato.format(getDataNascimento()) + "\n" + "lista de sinistros:" + infoSinistro();
		return informacoes;
	
	}
	
}
