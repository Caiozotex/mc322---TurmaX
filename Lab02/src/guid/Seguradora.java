package guid;
 public class Seguradora {
	 private String nome;
	 private String telefone;
	 private String email;
	 private String endereco;
	 
	 
	 public Seguradora(String Nome,String Telefone, String Email , String Endereco ) {
		 setNomeSeguradora(Nome);
		 setTelefone(Telefone);
		 setEmail(Email);
		 setEnderecoSeguradora(Endereco);
	 }
	 
	 public void setNomeSeguradora(String umNome) {
		 this.nome = umNome;
	 }
	 
	 public void setTelefone(String Telefone) {
		 this.telefone = Telefone;
	 }
	 
	 public void setEmail(String Email) {
		 this.email = Email;
	 }
	 
	 public void setEnderecoSeguradora(String Endereco) {
		 this.endereco = Endereco;
	 }
	 
	 public String getNomeSeguradora() {
		 return nome;
	 }
	 
	 public String getTelefone() {
		 return telefone;
	 }
	 
	 public String getEmail() {
		 return email;
	 }
	 
	 public String getEnderecoSeguradora() {
		 return endereco;
	 }
	 
	 public String toString() {
			String informacoes = "Nome:" + getNomeSeguradora() + "\n" + "Telefone:" + getTelefone() + "\n"
			+ "Email:" + getEmail() + "\n" + "Endereço:" + getEnderecoSeguradora();
			return informacoes;
		}
	 
	
}
