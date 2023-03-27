package guid;
public class Principal {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("Cleiton Alves Feitosa","123.456.078-80","30/9/1987","Rua Rolinha",35);
		Veiculo carro1 = new Veiculo("BMW","NAL-9377","Série 1 M");
		Seguradora seguro1 = new Seguradora("SEGURADORA SECON","0800 704 8383 ","seguradoraSecon@gmail.com","Monte Alto");
		Sinistro acidente1 = new Sinistro("23/04/2019","Rua João Evangelista Magalhães");
		System.out.println(cliente1.validarCPF(cliente1.getCpf()) == true ? "CPF válido" : "CPF inválido");
		cliente1.setCpf("A7b.7#3.6-4-C8");
		System.out.println(cliente1.validarCPF(cliente1.getCpf()) == true ? "CPF válido" : "CPF inválido");
		cliente1.setCpf("076.713.684-58");
		System.out.println(cliente1.validarCPF("280.012.389-38") == true ? "CPF válido" : "CPF inválido");
		System.out.println(cliente1.validarCPF(cliente1.getCpf()) == true ? "CPF válido" : "CPF inválido");
		System.out.println("");
		System.out.println(cliente1.toString());
		System.out.println("");
		System.out.println(carro1.toString());
		System.out.println(seguro1.toString());
		System.out.println("");
		System.out.println(acidente1.toString());
	}

}
