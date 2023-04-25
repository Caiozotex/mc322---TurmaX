import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class Mein {
	
	public static void main(String[] args) throws ParseException {
		Scanner teclado = new Scanner(System.in);
		List<Cliente> listaClientes = new ArrayList<>();
		List<Veiculo> listaVeiculos = new ArrayList<>();
		List<Seguradora> listaSeguradoras = new ArrayList<>();
		System.out.println("Bem vindo, digite primeiramente o número de clientes:");
		int indice1 = teclado.nextInt();
		while(indice1> 0) {
			Scanner teclado1 = new Scanner(System.in);
			System.out.println("Digite se o cliente é pessoa física ou jurídica");
			String tipoCliente = teclado1.nextLine();
			if(tipoCliente.equals("pessoa física")) {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Scanner teclado8 = new Scanner(System.in);
				System.out.println("Digite os dados do cliente:");
				System.out.println("Nome,educação,endereço,gênero,classe econômica,data da licença,CPF,data de nascimento");
				String name = teclado8.nextLine();
				String education = teclado8.nextLine();
				String adress = teclado8.nextLine();
				String gender = teclado8.nextLine();
				String economic_class = teclado8.nextLine();
				String Data_licensa = teclado8.nextLine();
				Date DataL = formato.parse(Data_licensa);
				String CPF = teclado8.nextLine();
				String Birth_Date = teclado8.nextLine();
				Date DataN = formato.parse(Birth_Date);
				ClientePF cliente1 = new ClientePF(name,education,adress,gender,
				economic_class,DataL,CPF,DataN);
				listaClientes.add(cliente1);
				System.out.println("Cliente Adicionado");
			}
			else if(tipoCliente.equals("pessoa jurídica")) {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Scanner teclado7 = new Scanner(System.in);
				System.out.println("Digite os dados do cliente:");
				System.out.println("Nome,educação,endereço,gênero,classe econômica,data da licença,CNPJ,data de fundação");
				String name = teclado7.nextLine();
				String education = teclado7.nextLine();
				String adress = teclado7.nextLine();
				String gender = teclado7.nextLine();
				String economic_class = teclado7.nextLine();
				String Data_licensa = teclado7.nextLine();
				Date DataL = formato.parse(Data_licensa);
				String CNPJ = teclado7.nextLine();
				String Fundation = teclado7.nextLine();
				Date DataF = formato.parse(Fundation);
				ClientePJ cliente2 = new ClientePJ(name,education,adress,gender,
				economic_class,DataL,CNPJ,DataF);
				listaClientes.add(cliente2);
				System.out.println("Cliente Adicionado");
			}
			indice1--;
		}
		System.out.println("---------------");
		System.out.println("Deseja verificar o CPF ou CNPJ de algum cliente");
		System.out.println("Digite o número de operações");
		int indice = teclado.nextInt();
		while(indice > 0) {
			Scanner teclado2 = new Scanner(System.in);
			System.out.println("Digite o nome do cliente");
			String Name = teclado2.nextLine();
				for(int i = 0; i < listaClientes.size(); i++) {
					if(listaClientes.get(i).getNome().equals(Name) && listaClientes.get(i).getClass() == ClientePF.class) {
						((ClientePF) listaClientes.get(i)).validarCPF(((ClientePF) listaClientes.get(i)).getCpf());
					}
				}
				for(int i = 0; i < listaClientes.size(); i++) {
					if(listaClientes.get(i).getNome().equals(Name) && listaClientes.get(i).getClass() == ClientePJ.class) {
						((ClientePJ) listaClientes.get(i)).validarCPNJ(((ClientePJ) listaClientes.get(i)).getCnpj());
					}
				}
			
			indice--;
		}
		System.out.println("---------------");
		System.out.println("Digite o número de veículos que deseja registrar:");
		indice = teclado.nextInt();
		while(indice > 0) {
			Scanner teclado6 = new Scanner(System.in);
			Scanner teclado0 = new Scanner(System.in);
			System.out.println("Digite os dados dos veiculos:");
			System.out.println("Placa,Marca,Modelo");
			String Placa = teclado6.nextLine();
			String Marca = teclado6.nextLine();
			String Modelo = teclado6.nextLine();
			int Year = teclado0.nextInt();
			Veiculo carro1 = new Veiculo(Placa,Marca,Modelo,Year);
			listaVeiculos.add(carro1);
			System.out.println("Veiculo registrado");
			indice--;
		}
		System.out.println("---------------");
		System.out.println("Registre o(s) veículo(s) a um cliente que deseja");
		System.out.println("Digite o número de operações:");
		indice = teclado.nextInt();
		while(indice > 0) {
			Scanner teclado1 = new Scanner(System.in);
			Scanner teclado3 = new Scanner(System.in);
			System.out.println("Digite o nome do cliente");
			String Name = teclado1.nextLine();
			System.out.println("Digite a placa do veiculo");
			String placa = teclado3.nextLine();
				Veiculo carro = new Veiculo(null,null,null,0);
				for(int j = 0 ; j < listaVeiculos.size();j++) {
					if(listaVeiculos.get(j).getPlaca().equals(placa)) {
						carro = listaVeiculos.get(j);
					}
				}
				for(int i = 0; i < listaClientes.size(); i++) {
					if(listaClientes.get(i).getNome().equals(Name)) {
						listaClientes.get(i).setVeiculo(carro);
						System.out.println("Veículo adicionado");
					}
				}
				
			indice--;
		}
		System.out.println("---------------");
		System.out.println("Digite o número de seguradoras");
		indice = teclado.nextInt();
		while(indice > 0) {
			Scanner teclado5 = new Scanner(System.in);
			System.out.println("Digite os dados da seguradora :");
			System.out.println("Nome,Telefone,email,endereço");
			String name = teclado5.nextLine();
			String Telephone = teclado5.nextLine();
			String EMAIL = teclado5.nextLine();
			String adress = teclado5.nextLine();
			Seguradora SEGURADORA = new Seguradora(name,Telephone,EMAIL,adress);
			listaSeguradoras.add(SEGURADORA);
			System.out.println("Seguradora registrada");
			indice--;
		}
		System.out.println("---------------");
		System.out.println("Registre as seguradoras ao(s) cliente(s) que deseja");
		System.out.println("Digite o número de operações:");
		indice = teclado.nextInt();
		while(indice > 0) {
			Scanner teclado1 = new Scanner(System.in);
			Scanner teclado3 = new Scanner(System.in);
			System.out.println("Digite o nome do cliente");
			String Name = teclado1.nextLine();
			System.out.println("Digite o nome da Seguradora");
			String placa = teclado3.nextLine();
			
				Seguradora seguradora1 = new Seguradora(null,null,null,null);
				for(int j = 0 ; j < listaSeguradoras.size();j++) {
					if(listaSeguradoras.get(j).getNome().equals(placa)) {
						seguradora1 = listaSeguradoras.get(j);
					}
				}
				for(int i = 0; i < listaClientes.size(); i++) {
					if(listaClientes.get(i).getNome().equals(Name)==true) {
						seguradora1.cadastrarCliente(listaClientes.get(i));
						System.out.println("Operação realizada");
					}
				}
				indice--;
			}	
		System.out.println("---------------");
		System.out.println("Gere Sinistros:");
		System.out.println("Digite o número de operações:");
		indice = teclado.nextInt();
		while(indice > 0) {
			Scanner teclado1 = new Scanner(System.in);
			Scanner teclado2 = new Scanner(System.in);
			Scanner teclado3 = new Scanner(System.in);
			Scanner teclado4 = new Scanner(System.in);
			System.out.println("Digite o nome do cliente");
			String Name = teclado1.nextLine();
			System.out.println("Digite a placa do veiculo do cliente");
			String placa = teclado2.nextLine();
			System.out.println("Informe os dados para gerar o Sinistro");
			System.out.println("Data e endereço");
			String Data = teclado3.nextLine();
			String adress = teclado4.nextLine();
			System.out.println("Informe o nome da Seguradora");
			String seg = teclado4.nextLine();
				Seguradora seguradora1 = new Seguradora(null,null,null,null);
				Veiculo carro = new Veiculo(null,null,null,0);
				for(int j = 0 ; j < listaSeguradoras.size();j++) {
					if(listaSeguradoras.get(j).getNome().equals(seg)) {
						seguradora1 = listaSeguradoras.get(j);
					}
				}
				for(int j = 0 ; j < listaVeiculos.size();j++) {
					if(listaVeiculos.get(j).getPlaca().equals(placa)) {
						carro = listaVeiculos.get(j);
					}
				}
				
				
				for(int i = 0; i < listaClientes.size(); i++) {
					if(listaClientes.get(i).getNome().equals(Name)) {
						seguradora1.gerarSinistro(Data, adress,listaClientes.get(i),seguradora1,carro);
						System.out.println("Sinistro criado");
					}
				}
			indice--;
		}
		System.out.println("---------------");
		System.out.println("Deseja Excluir algum cliente de alguma seguradora");
		System.out.println("Digite o numero de operações");
		indice = teclado.nextInt();
		while(indice > 0) {
			Scanner teclado1 = new Scanner(System.in);
			Scanner teclado3 = new Scanner(System.in);
			System.out.println("Digite o nome do cliente");
			String Name = teclado1.nextLine();
			System.out.println("Informe o nome da Seguradora");
			String seg = teclado3.nextLine();
				Seguradora seguradora1 = new Seguradora(null,null,null,null);
				for(int j = 0 ; j < listaSeguradoras.size();j++) {
					if(listaSeguradoras.get(j).getNome().equals(seg)) {
						seguradora1 = listaSeguradoras.get(j);
					}
				}
				for(int i = 0; i < listaClientes.size(); i++) {
					if(listaClientes.get(i).getNome().equals(Name)) {
						seguradora1.removerCliente(listaClientes.get(i).getNome());
						System.out.println("Cliente removido");
					}
				}
			
			indice--;
			
		}
		System.out.println("---------------");
		System.out.println("Esses são os dados informados:");
		System.out.println("Clientes:");
		for(int i = 0; i < listaClientes.size();i++) {
			if(listaClientes.get(i).getClass() == ClientePF.class) {
				System.out.println(((ClientePF) listaClientes.get(i)).toString());
			}
			else if(listaClientes.get(i).getClass() == ClientePJ.class) {
				System.out.println(((ClientePJ) listaClientes.get(i)).toString());
			}
		}
		System.out.println("---------------");
		System.out.println("Veiculos:");
		for(int i = 0; i < listaVeiculos.size();i++) {
			System.out.println(listaVeiculos.get(i).toString());
		}
		System.out.println("---------------");
		System.out.println("Sinistros:");
		for(int i = 0; i < listaSeguradoras.size();i++) {
			System.out.println(listaSeguradoras.get(i).listarSinistro());
		}
		System.out.println("---------------");
		System.out.println("Sinistros por Cliente:");
		for(int i = 0; i < listaSeguradoras.size();i++) {
			for(int j = 0; j < listaClientes.size();j++) {
				System.out.println(listaSeguradoras.get(i).visualizarSinistro(listaClientes.get(j).getNome()));
			}
		}
		System.out.println("---------------");
		System.out.println("Pessoas físicas e jurídicas por seguradora");
		for(int i = 0; i < listaSeguradoras.size();i++) {
			System.out.println(listaSeguradoras.get(i).listarClientes("PF"));;
			System.out.println(listaSeguradoras.get(i).listarClientes("PJ"));;
		}
		System.out.println("---------------");
		System.out.println("Fim do programa");
		teclado.close();
	}

}
