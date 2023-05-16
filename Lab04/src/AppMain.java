import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AppMain {
	
	public static void Cadastros(Scanner teclado,List<Cliente> listaClientes,List<Veiculo> listaVeiculos,List<Seguradora> listaSeguradoras)throws ParseException {
		String informacao = "Para Cadastar Cliente_PF aperte 1, para Cadastar Cliente_PJ  aperte 2,"
				+ "para Cadastar Veiculo aperte 3 , para Cadastar Seguradora aperte 4,"
				+ " e para Voltar aperte 5";
		System.out.println(informacao);
		int operador1 = teclado.nextInt();
		while(operador1 != Cadastrar.VOLTAR.operacao) {
			if(operador1 == Cadastrar.CADASTRAR_CLIENTE_PF.operacao) {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Scanner teclado8 = new Scanner(System.in);
				System.out.println("Digite os dados do cliente:");
				System.out.println("Nome,educação,endereço,gênero,classe econômica,data da licença,CPF,data de nascimento");
				String name = teclado8.nextLine();
				while(Validacao.validarNome(name) == false) {
					System.out.println("digite outro nome , com apenas letras");
					name = teclado8.nextLine();
				}
				String education = teclado8.nextLine();
				String adress = teclado8.nextLine();
				String gender = teclado8.nextLine();
				String economic_class = teclado8.nextLine();
				String Data_licensa = teclado8.nextLine();
				Date DataL = formato.parse(Data_licensa);
				String CPF = teclado8.nextLine();
				while(Validacao.validarCPF(CPF) == false) {
					System.out.println("Digite outro CPF");
					CPF = teclado8.nextLine();
				}
				String Birth_Date = teclado8.nextLine();
				Date DataN = formato.parse(Birth_Date);
				ClientePF cliente1 = new ClientePF(name,education,adress,gender,
				economic_class,DataL,CPF,DataN); 
				listaClientes.add(cliente1);
				System.out.println("Cliente Adicionado");
				System.out.println("Registre o cliente a seguradora que deseja");
				Scanner teclado1 = new Scanner(System.in);
				Scanner teclado3 = new Scanner(System.in);
				System.out.println("Digite o nome da Seguradora");
				String placa = teclado3.nextLine();
					Seguradora seguradora1 = new Seguradora(null,null,null,null);
					for(int j = 0 ; j < listaSeguradoras.size();j++) {
						if(listaSeguradoras.get(j).getNome().equals(placa)) {
							seguradora1 = listaSeguradoras.get(j);
						}
					}
					for(int i = 0; i < listaClientes.size(); i++) {
						if(listaClientes.get(i).getNome().equals(name)==true) {
							seguradora1.cadastrarCliente(listaClientes.get(i));
							System.out.println("Operação realizada");
						}
					}
			}
			else if(operador1 == Cadastrar.CADASTRAR_CLIENTE_PJ.operacao){
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Scanner teclado7 = new Scanner(System.in);
				Scanner teclado6 = new Scanner(System.in);
				System.out.println("Digite os dados do cliente:");
				System.out.println("Nome,endereço,CNPJ,data de fundação,quantidade de funcionários");
				String name = teclado7.nextLine();
				while(Validacao.validarNome(name) == false) {
					System.out.println("digite outro nome , com apenas letras");
					name = teclado7.nextLine();
				}
				String adress = teclado7.nextLine();
				String CNPJ = teclado7.nextLine();
				while(Validacao.validarCPNJ(CNPJ) == false) {
					System.out.println("Digite outro CNPJ");
					CNPJ = teclado7.nextLine();
				}
				String Fundation = teclado7.nextLine();
				Date DataF = formato.parse(Fundation);
				int qntdeF = teclado6.nextInt();
				ClientePJ cliente2 = new ClientePJ(name,adress,CNPJ,DataF,qntdeF);
				listaClientes.add(cliente2);
				System.out.println("Cliente Adicionado");
				System.out.println("Registre o cliente a seguradora que deseja");
				Scanner teclado3 = new Scanner(System.in);
				System.out.println("Digite o nome da Seguradora");
				String placa = teclado3.nextLine();
					Seguradora seguradora1 = new Seguradora(null,null,null,null);
					for(int j = 0 ; j < listaSeguradoras.size();j++) {
						if(listaSeguradoras.get(j).getNome().equals(placa)) {
							seguradora1 = listaSeguradoras.get(j);
						}
					}
					for(int i = 0; i < listaClientes.size(); i++) {
						if(listaClientes.get(i).getNome().equals(name)==true) {
							seguradora1.cadastrarCliente(listaClientes.get(i));
							System.out.println("Operação realizada");
						}
					}
			}
			else if(operador1 == Cadastrar.CADASTRAR_VEICULO.operacao) {
				Scanner teclado6 = new Scanner(System.in);
				Scanner teclado0 = new Scanner(System.in);
				System.out.println("Digite os dados dos veiculos:");
				System.out.println("Placa,Marca,Modelo,Ano de Fabricação");
				String Placa = teclado6.nextLine();
				String Marca = teclado6.nextLine();
				String Modelo = teclado6.nextLine();
				int Year = teclado0.nextInt();
				Veiculo carro1 = new Veiculo(Placa,Marca,Modelo,Year);
				listaVeiculos.add(carro1);
				System.out.println("Veiculo registrado");
				System.out.println("Registre o(s) veículo(s) a um cliente que deseja");
				Scanner teclado1 = new Scanner(System.in);
				Scanner teclado3 = new Scanner(System.in);
				System.out.println("Digite o nome do cliente");
				String Name = teclado1.nextLine();
					Veiculo carro = new Veiculo(null,null,null,0);
					for(int j = 0 ; j < listaVeiculos.size();j++) {
						if(listaVeiculos.get(j).getPlaca().equals(Placa)) {
							carro = listaVeiculos.get(j);
						}
					}
					for(int i = 0; i < listaClientes.size(); i++) {
						if(listaClientes.get(i).getNome().equals(Name)) {
							listaClientes.get(i).setVeiculo(carro);
							System.out.println("Veículo adicionado");
						}
					}
			}
			else if(operador1 == Cadastrar.CADASTRAR_SEGURADORA.operacao) {
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
			}
			System.out.println(informacao);
			operador1 = teclado.nextInt();
		}
	}
	
	public static void Listar(Scanner teclado,List<Cliente> listaClientes,List<Veiculo> listaVeiculos,List<Seguradora> listaSeguradoras) {
		String informacao = "Para Listar Cliente_PF por seguradora aperte 1, para Listar Cliente_PJ por seguradora  aperte 2,"
				+ "para Listar Sinistro por seguradora aperte 3 , para Listar Sinistro por Cliente aperte 4,"
				+ " para Listar Veiculo por cliente aperte 5," + "para Listar Veiculo por Seguradora aperte 6,"
				+ "e para Voltar aperte 7";
		System.out.println(informacao);
		int operador1 = teclado.nextInt();
		while(operador1 != Listar.VOLTAR.operacao) {
			if(operador1 == Listar.LISTAR_CLIENTE_PF_SEG.operacao) {
				Scanner teclado1 = new Scanner(System.in);
				System.out.println("Digite o nome da seguradora");
				String Name = teclado1.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(Name)) {
						System.out.println(listaSeguradoras.get(i).listarClientes("PF"));
					}
				}
			}
			else if(operador1 == Listar.LISTAR_CLIENTE_PJ_SEG.operacao) {
				Scanner teclado1 = new Scanner(System.in);
				System.out.println("Digite o nome da seguradora");
				String Name = teclado1.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(Name)) {
						System.out.println(listaSeguradoras.get(i).listarClientes("PJ"));
					}
				}
			}
			else if(operador1 == Listar.LISTAR_SINISTRO_SEGURADORA.operacao) {
				Scanner teclado1 = new Scanner(System.in);
				System.out.println("Digite o nome da seguradora");
				String Name = teclado1.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(Name)) {
						System.out.println(listaSeguradoras.get(i).listarSinistro());
					}
				}
			}
			else if(operador1 == Listar.LISTAR_SINISTRO_CLIENTE.operacao) {
				Scanner teclado1 = new Scanner(System.in);
				Scanner teclado2 = new Scanner(System.in);
				System.out.println("Digite o nome da seguradora");
				String NameSeg = teclado1.nextLine();
				System.out.println("Digite o nome do cliente");
				String NameCl = teclado2.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(NameSeg)) {
						for(int j = 0; j < listaClientes.size();j++) {
							if(listaClientes.get(j).getNome().equals(NameCl)) {
								System.out.println(listaSeguradoras.get(i).visualizarSinistro(listaClientes.get(j).getNome()));
							}
						}
					}
				}
			}
			else if(operador1 == Listar.LISTAR_VEICULO_CLIENTE.operacao) {
				Scanner teclado2 = new Scanner(System.in);
				System.out.println("Digite o nome do cliente");
				String NameCl = teclado2.nextLine();
				for(int i = 0; i < listaClientes.size();i++) {
					if(listaClientes.get(i).getNome().equals(NameCl)) {
						for(int j = 0; j < listaClientes.get(i).qtdeVeiculos();j++) {
							System.out.println(listaClientes.get(i).getVeiculo(j));
						}
					}
				}
			}
			else if(operador1 == Listar.LISTAR_VEICULO_SEGURADORA.operacao) {
				Scanner teclado1 = new Scanner(System.in);
				System.out.println("Digite o nome da seguradora");
				String Name = teclado1.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(Name)) {
						listaSeguradoras.get(i).listarVeiculos();
					}
				}
			}
			System.out.println(informacao);
			operador1 = teclado.nextInt();
		}
	}
	
	public static void Excluir(Scanner teclado,List<Cliente> listaClientes,List<Veiculo> listaVeiculos,List<Seguradora> listaSeguradoras) {
		String informacao = "Para Excluir cliente aperte 1, para Excluir veiculo aperte 2,"
				+ "para Excluir sinistro aperte 3 , e para Voltar aperte 4";
		System.out.println(informacao);
		int operador1 = teclado.nextInt();
		while(operador1 != Excluir.VOLTAR.operacao) {
			if(operador1 == Excluir.EXCLUIR_CLIENTE.operacao) {
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
							listaClientes.remove(listaClientes.get(i));
							System.out.println("Cliente removido");
						}
					}			
			}
			else if(operador1 == Excluir.EXCLUIR_VEICULO.operacao) {
				Scanner teclado2 = new Scanner(System.in);
				System.out.println("Digite a placa do veículo");
				String Placa = teclado2.nextLine();
				for(int i = 0; i < listaClientes.size(); i++) {
					for(int j = 0; j < listaClientes.get(i).qtdeVeiculos();j++) {
						if(listaClientes.get(i).getVeiculo(j).getPlaca().equals(Placa)) {
							listaClientes.get(i).removeVeiculo(Placa);
							System.out.println("Veiculo removido");
						}
					}
				}
			}
			else if(operador1 == Excluir.EXCLUIR_SINISTRO.operacao) {
				Scanner teclado4 = new Scanner(System.in);
				Scanner teclado3 = new Scanner(System.in);
				System.out.println("Digite o nome da seguradora");
				String name = teclado4.nextLine();
				System.out.println("Digite a Id do sinistro");
				int ident = teclado3.nextInt();
				for(int i = 0;i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(name)) {
						listaSeguradoras.get(i).removerSinistro(ident);
						System.out.println("Sinistro removido");
					}
				}
			}
			System.out.println(informacao);
			operador1 = teclado.nextInt();
		}
	}
	
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Veiculo carro1 = new Veiculo("BVA-6491","VW - VolksWagen","Fox Sportline/Sports 1.6/1.6 Tot.Flex 4p",2004);
		Veiculo carro2 = new Veiculo("CVG-9760","Suzuki","Grand Vitara 2.0 16V 5p/ Gold Aut( Arg.)",2000);
		ClientePF cl1 = new ClientePF("Cleiton Alves Feitosa","Ensino Médio Completo","Rua Rolinha","Masculino","Classe Média",
		formato.parse("23/04/2019"),"280.012.389-38",formato.parse("30/09/1987"));
		ClientePJ cl2 = new ClientePJ("Empresa Benedita","Rua Tucumã","46.540.836/0001-80",formato.parse("21/04/2020"),100);
		Seguradora seg1 = new Seguradora("SEGURADORA SECON","0800 704 8383","seguradoraSecon@gmail.com","Monte Alto");
		cl1.setVeiculo(carro1);
		cl2.setVeiculo(carro2);
		seg1.cadastrarCliente(cl1);
		seg1.cadastrarCliente(cl2);
		seg1.gerarSinistro("23/04/2019", "Rua João Evangelista Magalhães", cl1, seg1, carro1);
		seg1.gerarSinistro("25/06/2018", "Rua Miguel dos Santos", cl2, seg1, carro2);
		System.out.println("Teste do métodos:");
		seg1.listarClientes("PF");
		System.out.println("----------------");
		seg1.listarClientes("PJ");
		System.out.println("----------------");
		seg1.visualizarSinistro("Cleiton Alves Feitosa");
		System.out.println("----------------");
		seg1.visualizarSinistro("Empresa Benedita");
		System.out.println("----------------");
		System.out.println(seg1.listarSinistro());
		System.out.println("----------------");
		System.out.println("Seguro Cliente1:" + seg1.calcularPrecoSeguroCliente(cl1));
		System.out.println("----------------");
		System.out.println("Seguro Cliente2:" + seg1.calcularPrecoSeguroCliente(cl2));
		System.out.println("----------------");
		System.out.println(seg1.calcularReceita());
		System.out.println("Fim dos teste");
		System.out.println("----------------");
		Scanner teclado = new Scanner(System.in);
		List<Cliente> listaClientes = new ArrayList<>();
		List<Veiculo> listaVeiculos = new ArrayList<>();
		List<Seguradora> listaSeguradoras = new ArrayList<>();
		System.out.println("Bem vindo ao programa de seguradora");
		System.out.println("Para começar ,digite os dados da 1ª seguradora :");
		System.out.println("Nome,Telefone,email,endereço");
		String name = teclado.nextLine();
		String Telephone = teclado.nextLine();
		String EMAIL = teclado.nextLine();
		String adress = teclado.nextLine();
		Seguradora SEGURADORA = new Seguradora(name,Telephone,EMAIL,adress);
		listaSeguradoras.add(SEGURADORA);
		System.out.println("Seguradora registrada");
		String informacao = "Para Cadastros aperte 1, para Listar aperte 2,"
				+ "para Excluir aperte 3 , para Gerar Sinistro aperte 4,"
				+ "para Transferir Seguro aperte 5, para Calcular Receita "
				+ "de uma seguradora aperte 6 , e para Sair aperte 0";
		System.out.println(informacao);
		int operador = teclado.nextInt();
		while(operador != MenuOperacoes.SAIR.operacao) {
			if(operador == MenuOperacoes.CADASTROS.operacao){
				Cadastros(teclado,listaClientes,listaVeiculos,listaSeguradoras);
			}
			else if(operador == MenuOperacoes.LISTAR.operacao) {
				Listar(teclado,listaClientes,listaVeiculos,listaSeguradoras);
			}
			else if(operador == MenuOperacoes.EXCLUIR.operacao) {
				Excluir(teclado,listaClientes,listaVeiculos,listaSeguradoras);
			}
			
			else if(operador == MenuOperacoes.GERAR_SINISTRO.operacao) {
				System.out.println("Gere o Sinistro:");
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
				String Adress = teclado4.nextLine();
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
							seguradora1.gerarSinistro(Data, Adress,listaClientes.get(i),seguradora1,carro);
							System.out.println("Sinistro criado");
						}
					}
			}
			
			else if(operador == MenuOperacoes.TRANSFERIR_SEGURO.operacao) {
				Scanner teclado1 = new Scanner(System.in);
				Scanner teclado2 = new Scanner(System.in);
				Scanner teclado3 = new Scanner(System.in);
				Scanner teclado4 = new Scanner(System.in);
				System.out.println("Digite o nome do cliente no qual deseja receber o seguro");
				String cliente1 = teclado1.nextLine();
				System.out.println("Digite o nome do cliente no qual deseja transferir o seguro");
				String cliente2 = teclado1.nextLine();
				for(int i = 0; i < listaClientes.size(); i++) {
					if(listaClientes.get(i).getNome().equals(cliente1)) {
						for(int j = 0; j < listaClientes.size(); j++) {
							if(listaClientes.get(j).getNome().equals(cliente2)) {
								for(int k = 0; k < listaSeguradoras.size();k++) {
									if(listaSeguradoras.get(k).acharCliente(cliente2)==true && listaSeguradoras.get(k).acharCliente(cliente1)==true){
										for(int a = 0;a < listaClientes.get(j).qtdeVeiculos();a++) {
											listaClientes.get(i).setVeiculo(listaClientes.get(j).getVeiculo(a));
											System.out.println("Seguro transferido com sucesso");
										}
										listaSeguradoras.get(k).calcularReceita();
									}
								}
							}
						}
					}
				}
			}
			
			else if(operador == MenuOperacoes.CALCULAR_RECEITA_SEGURADORA.operacao) {
				Scanner teclado1 = new Scanner(System.in);
				System.out.println("Digite o nome da seguradora");
				String Name = teclado1.nextLine();
				for(int j = 0 ; j < listaSeguradoras.size();j++) {
					if(listaSeguradoras.get(j).getNome().equals(Name)) {
						System.out.println("O preço da receita é :");
						System.out.println("R$:" + listaSeguradoras.get(j).calcularReceita());
					}
				}
			}
			
			System.out.println(informacao);
			operador = teclado.nextInt();
		}
		System.out.println("Obrigado por ter usado o programa");
	}
}
