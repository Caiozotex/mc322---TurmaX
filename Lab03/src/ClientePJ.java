import java.util.Date;
import java.text.SimpleDateFormat;

public class ClientePJ extends Cliente {
	private final String cnpj; 
	private Date dataFundacao;
	
	public ClientePJ(String Nome,String Educacao,String Endereco,String Genero, 
			String ClasseEconomica,Date Data,String CNPJ,Date DataFundacao) {
				super(Nome,Educacao,Endereco,Genero,ClasseEconomica,Data);
				this.cnpj = CNPJ;
				this.dataFundacao = DataFundacao;
			}

	public String getCnpj() {
		return cnpj;
	}
	
	public String remove(String dado) { //Remove todos os caracteres não numéricos do CNPJ 
		dado = dado.replaceAll("[^0-9]+", "");
		return dado;
	}
	
	public int firstDigitCheck(String dado) {
		dado = remove(dado);
		int soma = 0;
		int digitoVerificador1;
		for(int i =0 , j = 5 ; i < 4 && j > 1 ; i++ , j--) {
			soma += Character.getNumericValue(dado.charAt(i))* j;
		}
		for(int i = 4 , j = 9 ; i < 12 && j > 1; i++, j--) {
			soma += Character.getNumericValue(dado.charAt(i))* j;
		}
		int resto = soma % 11;
		if(resto < 2) {
			digitoVerificador1 = 0;
		} else {
			digitoVerificador1 = 11 - resto;
		}
		return digitoVerificador1;
	}
	
	public int secondDigitCheck(String dado) {
		dado = remove(dado);
		int soma = 0;
		int digitoVerficador2;
		for(int i =0 , j = 6 ; i < 5 && j > 1 ; i++ , j--) {
			soma += Character.getNumericValue(dado.charAt(i))* j;
		}
		for(int i = 5 , j = 9 ; i < 13 && j > 1; i++, j--) {
			soma += Character.getNumericValue(dado.charAt(i))* j;
		}
		int resto = soma % 11;
		if(resto < 2) {
			digitoVerficador2 = 0;
		} else {
			digitoVerficador2 = 11 - resto;
		}
		return digitoVerficador2;
	}
	
	public boolean validarCPNJ(String dado){
		if(remove(dado).length() != 14 ) {
			System.out.println("número de dígitos incorreto");
			return false;
		}
		int d1 = Character.getNumericValue(dado.charAt(dado.length()- 2));
		int d2 = Character.getNumericValue(dado.charAt(dado.length()- 1));
		if(firstDigitCheck(dado) != d1 && secondDigitCheck(dado) != d2 ) {
			System.out.println("CNPJ inválido");
			return false;
		}
		System.out.println("CNPJ válido");
		return true;
	}
	
	public void setDataFundacao(Date data) {
		this.dataFundacao = data; 
	}
	
	public Date getDataFundacao() {
		return dataFundacao;
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String informacoes = ClientePJ.super.toString() + "\n" + "CNPJ:" + getCnpj() + "\n"
		+ "Data de Fundação: " + formato.format(getDataFundacao());
		return informacoes;
	}
	
	
	//Fazer o método toString
	

}
