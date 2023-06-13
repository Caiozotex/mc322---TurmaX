
public  class Cliente {
	private String nome;
	private String telefone;
	private String endereco;
	private String email;

	public Cliente(String Nome,String Telefone,String Endereco,String Email) {
		this.nome = Nome;
		this.telefone = Telefone;
		this.endereco = Endereco;
		this.email = Email;
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
	
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String toString() {
		String informacoes = "Nome:" + getNome() + "\n"  + "Telefone:" + getTelefone() + "\n"+ "Endereço:" 
	+ getEndereco() + "\n" + "Email:" + getEmail()+ "\n";
		return informacoes;
	}
	

}
