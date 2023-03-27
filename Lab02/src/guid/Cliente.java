package guid;
	public class Cliente {
		private String nome;
		private String cpf;
		private String dataNascimento;
		private String endereco;
		private int idade;
		
		public Cliente(String Nome, String CPF , String DataNascimento , String Endereco , int Idade) {
			setNomeCliente(Nome);
			setCpf(CPF);
			setDataNascimento(DataNascimento);
			setEnderecoCliente(Endereco);
			setIdade(Idade);
		}
		
		
		public void setNomeCliente(String umNome) {
			 this.nome = umNome;
		 }
		
		public void setCpf(String CPF) {
			 this.cpf = CPF;
		 }
		
		public void setDataNascimento(String DataNascimento) {
			 this.dataNascimento = DataNascimento;
		 }
		
		public void setEnderecoCliente(String Endereco) {
			 this.endereco = Endereco;
		 }
		
		public void setIdade(int Idade) {
			 this.idade = Idade;
		 }
		
		public String getNomeCliente() {
			return nome;
		}
		
		public String getCpf() {
			return cpf;
		}
		
		public String getDataNascimento() {
			return dataNascimento;
		}
		
		public String getEnderecoCliente() {
			return endereco;
		}
		
		public int getIdade() {
			return idade;
		}
		
		public String toString() {
			String informacoes = "Nome:" + getNomeCliente() + "\n" + "Cpf:" + getCpf() + "\n"
			+ "Data de Nascimento:" + getDataNascimento() + "\n" + "Endereço:" + getEnderecoCliente();
			return informacoes;
		}
		
		public String remove(String dado) { //Remove todos os caracteres não numéricos do CPF 
			dado = dado.replaceAll("[^0-9]+", "");
			return dado;
		}
		
		public int firstDigitCheck(String dado) { 
			dado = remove(dado);
			int soma = 0;
			int digitoVerificador1;
			for(int i = 0 ,  j = 10 ; i < 10 && j > 1 ; i++ , j--) {
				soma += Character.getNumericValue(dado.charAt(i))* j;
			}
			int resto = soma % 11;
			if(resto == 0 || resto == 1) {
				digitoVerificador1 = 0;
			 } else {
					digitoVerificador1 = 11 - resto;
				}
			return digitoVerificador1;
		}
		
		public int secondDigitCheck(String dado) {
			dado = remove(dado);
			int soma = 0;
			int digitoVerificador2;
			for(int i = 1 ,  j = 10 ; i < 10 && j > 1 ; i++ , j--) {
				soma += Character.getNumericValue(dado.charAt(i))* j;
			}
			int resto = soma % 11;
			if(resto == 0 || resto == 1) {
				digitoVerificador2 = 0;
			 } else {
					digitoVerificador2 = 11 - resto;
				}
			return digitoVerificador2;
		}
		
		public boolean validarCPF(String dado){
			if(remove(dado).length() != 11 ) {
				System.out.println("número de dígitos incorreto");
				return false;
			}
			if(getCpf().equals(dado) == false) {
				System.out.println("CPF diferentes");
				return false;
			}
			int d1 = Character.getNumericValue(dado.charAt(dado.length()- 2));
			int d2 = Character.getNumericValue(dado.charAt(dado.length()- 1));
			if(firstDigitCheck(dado) != d1 && secondDigitCheck(dado) != d2 ) {
				return false;
			}
			return true;
		}
	
	
	
	
	
	
	

}
