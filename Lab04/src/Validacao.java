
public class Validacao {
	
	private static String remove(String dado) { //Remove todos os caracteres não numéricos do CPF 
		dado = dado.replaceAll("[^0-9]+", "");
		return dado;
	}
	
	private static int firstDigitCheckPF(String dado) { 
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

	private static int secondDigitCheckPF(String dado) {
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



	public static boolean validarCPF(String dado){
			if(remove(dado).length() != 11 ) {
				System.out.println("número de dígitos incorreto");
				return false;
			}
			int d1 = Character.getNumericValue(dado.charAt(dado.length()- 2));
			int d2 = Character.getNumericValue(dado.charAt(dado.length()- 1));
			if(firstDigitCheckPF(dado) != d1 && secondDigitCheckPF(dado) != d2 ) {
				System.out.println("CPF inválido");
				return false;
			}
			System.out.println("CPF válido");
			return true;
		}
	
	
	private static int firstDigitCheckPJ(String dado) {
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
		
	private static int secondDigitCheckPJ(String dado) {
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
	
	public static boolean validarCPNJ(String dado){
		if(remove(dado).length() != 14 ) {
			System.out.println("número de dígitos incorreto");
			return false;
		}
		int d1 = Character.getNumericValue(dado.charAt(dado.length()- 2));
		int d2 = Character.getNumericValue(dado.charAt(dado.length()- 1));
		if(firstDigitCheckPJ(dado) != d1 && secondDigitCheckPJ(dado) != d2 ) {
			System.out.println("CNPJ inválido");
			return false;
		}
		System.out.println("CNPJ válido");
		return true;
	}
	
	public static boolean validarNome(String dado) {
		String test = dado.replaceAll("[^A-Z,^a-z,^\s]", dado);
		if(test.equals(dado)) {
			System.out.println("Nome válido");
			return true;
		}
		else {
			System.out.println("Nome inválido");
			return false;
		}	
	}

}
