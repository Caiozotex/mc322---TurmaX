import java.util.Date;
import java.text.SimpleDateFormat;

public class ClientePF extends Cliente {
	private final String cpf ; 
	private Date dataNascimento;
	
	public ClientePF(String Nome,String Educacao,String Endereco,String Genero, 
	String ClasseEconomica,Date Data,String CPF,Date DataNascimento) {
		super(Nome,Educacao,Endereco,Genero,ClasseEconomica,Data);
		this.cpf = CPF;
		this.dataNascimento = DataNascimento;
	}

	public String getCpf() {
		return cpf;
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
		int d1 = Character.getNumericValue(dado.charAt(dado.length()- 2));
		int d2 = Character.getNumericValue(dado.charAt(dado.length()- 1));
		if(firstDigitCheck(dado) != d1 && secondDigitCheck(dado) != d2 ) {
			System.out.println("CPF inválido");
			return false;
		}
		System.out.println("CPF válido");
		return true;
	}
	
	public void setDataNascimento(Date data) {
		this.dataNascimento = data;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String informacoes = ClientePF.super.toString() + "\n" + "CPF:" + getCpf() + "\n"
		+ "Data de Nascimento: " + formato.format(getDataNascimento());
		return informacoes;
	}
	
	
	//Fazer  o metodo to string
	
	
}
