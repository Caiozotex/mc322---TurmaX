import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AppMain {

	public static void teste() throws Exception{	
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		ArquivoVeiculo arqVec = new ArquivoVeiculo();
		ArquivoFrota arqFrota = new ArquivoFrota();
		ArquivoCondutor arqCondutor = new ArquivoCondutor();
		ArquivoClientePF arqClientPF = new ArquivoClientePF();
		ArquivoClientePJ arqClientPJ = new ArquivoClientePJ();
		System.out.println("******************");
		System.out.println("Teste dos métodos:");
		Seguradora seg1 = new Seguradora("11.959.337/0001-47","SEGURADORA TESTE","0800 704 8383","seguradoraTeste@gmail.com","Monte Alto");
		seg1.setVeiculos(arqVec.infoArquivo());
		seg1.setCondutores(arqCondutor.infoArquivo());
		seg1.setFrotas(arqFrota.infoArquivo());
		seg1.setClientes(arqClientPF.infoArquivo());
		seg1.setClientes(arqClientPJ.infoArquivo());
		ClientePF cliente1 = new ClientePF("Cleiton Alves Feitosa","(19) 2171-2468","Rua Rolinha","Cleiton@hotmail.com","Ensino Médio Completo",
		"Masculino","280.012.389-38",formato.parse("1987-09-03"));
		ClientePJ cliente2 = new ClientePJ("Empresa Benedita","(17) 3360-7291","Rua Tucumã","Benedita@gmail.com","46.540.836/0001-80",
		formato.parse("2020-02-21"),100);
		Veiculo carro1 = new Veiculo("BVA-6491","VW - VolksWagen","Fox Sportline/Sports 1.6/1.6 Tot.Flex 4p",2004);
		Veiculo carro2 = new Veiculo("CVG-9760","Suzuki","Grand Vitara 2.0 16V 5p/ Gold Aut( Arg.)",2000);
		Veiculo carro3 = new Veiculo("MVJ-2017","Miura","Picape BG-Truck CD Turbo Diesel",1993);
		Veiculo carro4 = new Veiculo("KNK-3085","Jaguar","F-Type R AWD Supercharged Coupe 5.0 V8",2016);
		Frota frota1 = new Frota("006");
		Condutor condutor1 = new Condutor("135.572.488-01","Glauco Farias","(13) 97574-7381", "Beco Brasília",
		"Glauco@outlook.com",formato.parse("1933-07-15"));
		Condutor condutor2 = new Condutor("512.522.413-80","Marco Lopes Carvalho","(99) 2422-1535", "Rua Candido Mendes",
		"MarcosL@outlook.com",formato.parse("1966-06-25"));
		seg1.gerarSeguroPF(formato.parse("2020-09-09"),formato.parse("2021-09-09"),seg1,carro1,cliente1); //Seguro1
		seg1.gerarSeguroPJ(formato.parse("2024-07-10"),formato.parse("2025-07-10"),seg1,frota1,cliente2); //Seguro2
		seg1.getSeguro(0).gerarSinistro("2019-04-23","Rua João Evangelista Magalhães", condutor1,seg1.getSeguro(0)); //Sinistro1
		seg1.getSeguro(1).gerarSinistro("2018-06-25","Rua Miguel dos Santos", condutor1, seg1.getSeguro(1)); //Sinistro2
		frota1.addVeiculo(carro1);
		frota1.addVeiculo(carro2);
		frota1.addVeiculo(carro3);
		cliente1.cadastrarVeiculo(carro4);
		seg1.getSeguro(0).autorizarcondutor(condutor1);
		seg1.getSeguro(1).autorizarcondutor(condutor2);
		cliente2.cadastrarFrota(frota1);
		seg1.cadastrarCliente(cliente1);
		seg1.cadastrarCliente(cliente2);
		seg1.cadastrarCondutores(condutor1);
		seg1.cadastrarCondutores(condutor2);
		seg1.cadastrarFrota(frota1);
		seg1.cadastrarSinistro(seg1.getSeguro(0).getSinistro().get(0));
		seg1.cadastrarSinistro(seg1.getSeguro(1).getSinistro().get(0));
		seg1.cadastrarVeiculos(carro1);
		seg1.cadastrarVeiculos(carro2);
		seg1.cadastrarVeiculos(carro3);
		seg1.cadastrarVeiculos(carro4);
		seg1.calculaReceita();
		System.out.println("---------------");
		System.out.println("Teste dos métodos dos arquivos:");
		System.out.println("Clientes:");
		seg1.lerDados("ClientePF");
		System.out.println("---------------");
		seg1.lerDados("ClientePJ");
		System.out.println("---------------");
		System.out.println("Veiculos:");
		seg1.lerDados("Veiculo");
		System.out.println("---------------");
		System.out.println("Frotas:");
		seg1.lerDados("Frota");
		System.out.println("---------------");
		System.out.println("Condutores:");
		seg1.lerDados("Condutor");
		System.out.println("---------------");
		System.out.println("Fim dos teste");
		System.out.println("******************");
	}
	
	public static void Cadastros(Scanner teclado,List<Seguradora> listaSeguradoras)throws ParseException{
		String informacao = "Para Cadastar Cliente_PF aperte 1\npara Cadastar Cliente_PJ aperte 2 \n"
				+ "para Cadastar Veiculo aperte 3\npara Cadastar Seguradora aperte 4 \n"
				+ "para Cadastar Seguro_PF aperte 5\npara Cadastar Seguro_PJ aperte 6 \n"
				+ "para Cadastrar Condutor aperte 7\npara Cadastrar Frota aperte 8 \n"
				+ "e para Voltar aperte 0";
		System.out.println(informacao);
		int operador1 = teclado.nextInt();
		while(operador1 != Cadastrar.VOLTAR.operacao) {
			if(operador1 == Cadastrar.CADASTRAR_CLIENTE_PF.operacao) {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Scanner teclado8 = new Scanner(System.in);
				System.out.println("Digite os dados do cliente:");
				System.out.println("Nome,Telefone,Endereço,Email,Educação,Gênero,CPF,data de nascimento");
				String name = teclado8.nextLine();
				while(validacao.validarNome(name) == false) {
					System.out.println("digite outro nome , com apenas letras");
					name = teclado8.nextLine();
				}
				String telefone = teclado8.nextLine();
				String adress = teclado8.nextLine();
				String email = teclado8.nextLine();
				String education = teclado8.nextLine();
				String gender = teclado8.nextLine();
				String CPF = teclado8.nextLine();
				while(validacao.validarCPF(CPF) == false) {
					System.out.println("Digite outro CPF");
					CPF = teclado8.nextLine();
				}
				String Birth_Date = teclado8.nextLine();
				Date DataN = formato.parse(Birth_Date);
				ClientePF cliente1 = new ClientePF(name,telefone,adress,email,education,gender,CPF,DataN);
				System.out.println("Cliente Adicionado");
				System.out.println("Registre o cliente a seguradora que deseja");
				Scanner teclado1 = new Scanner(System.in);
				Scanner teclado3 = new Scanner(System.in);
				System.out.println("Digite o nome da Seguradora");
				String placa = teclado3.nextLine();
				Seguradora seguradora1 = new Seguradora(null,null,null,null,null);
				for(int j = 0 ; j < listaSeguradoras.size();j++) {
					if(listaSeguradoras.get(j).getNome().equals(placa)) {
						seguradora1 = listaSeguradoras.get(j);
						seguradora1.cadastrarCliente(cliente1);
						System.out.println("Operação realizada");
					}
				}
			}
			
			
			else if(operador1 == Cadastrar.CADASTRAR_CLIENTE_PJ.operacao) {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Scanner teclado7 = new Scanner(System.in);
				Scanner teclado6 = new Scanner(System.in);
				System.out.println("Digite os dados do cliente:");
				System.out.println("Nome,Telefone,Endereço,Email,CNPJ,data de fundação,quantidade de funcionários");
				String name = teclado7.nextLine();
				String telefone = teclado7.nextLine();
				String adress = teclado7.nextLine();
				String email = teclado7.nextLine();
				String CNPJ = teclado7.nextLine();
				while(validacao.validarCPNJ(CNPJ) == false) {
					System.out.println("Digite outro CNPJ");
					CNPJ = teclado7.nextLine();
				}
				String Fundation = teclado7.nextLine();
				Date DataF = formato.parse(Fundation);
				int qntdeF = teclado6.nextInt();
				ClientePJ cliente2 = new ClientePJ(name,telefone,adress,email,CNPJ,DataF,qntdeF);
				System.out.println("Cliente Adicionado");
				System.out.println("crie um código para a frota de seu cliente:");
				String Code = teclado7.nextLine();
				Frota frota = new Frota(Code);
				cliente2.cadastrarFrota(frota);
				System.out.println("Frota adicionada");
				System.out.println("Registre o cliente a seguradora que deseja");
				Scanner teclado3 = new Scanner(System.in);
				System.out.println("Digite o nome da Seguradora");
				String placa = teclado3.nextLine();
					Seguradora seguradora1 = new Seguradora(null,null,null,null,null);
					for(int j = 0 ; j < listaSeguradoras.size();j++) {
						if(listaSeguradoras.get(j).getNome().equals(placa)) {
							seguradora1 = listaSeguradoras.get(j);
							seguradora1.cadastrarCliente(cliente2);
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
				System.out.println("Veiculo registrado");
				System.out.println("Registre o(s) veículo(s) a um cliente que deseja");
				System.out.println("Digite  PF para cliente físico e PJ pra cliente juridico");
				String type = teclado6.nextLine();
				switch(type) {
				case "PF":
					System.out.println("Digite o CPF do cliente:");
					String CPF = teclado6.nextLine();
					for(int i = 0;i < listaSeguradoras.size();i++) {
						if(((ClientePF)listaSeguradoras.get(i).getCliente(CPF)).getCpf().equals(CPF)) {
							((ClientePF)listaSeguradoras.get(i).getCliente(CPF)).cadastrarVeiculo(carro1);
							System.out.println("Veiculo adicionado");
						}
					}
					break;
				case "PJ":
					System.out.println("Digite o Cnpj do cliente:");
					String Cnpj = teclado6.nextLine();
					System.out.println("Digite o código da frota:");
					String Code = teclado6.nextLine();
					for(int i = 0;i < listaSeguradoras.size();i++) {
						if(((ClientePJ)listaSeguradoras.get(i).getCliente(Cnpj)).getCnpj().equals(Cnpj)) {
							((ClientePJ)listaSeguradoras.get(i).getCliente(Cnpj)).atualizarFrota("adicionar veiculo", Code, carro1);
							System.out.println("Veiculo adicionado");
						}
					}
					break;
				}
			}
			
			else if(operador1 == Cadastrar.CADASTRAR_SEGURADORA.operacao) {
				Scanner teclado3 = new Scanner(System.in);
				System.out.println("Bem vindo ao programa de seguradora");
				System.out.println("Digite os dados com enter entre eles");
				System.out.println("Para começar ,digite os dados da 1ª seguradora :");
				System.out.println("CNPJ,Nome,Telefone,email,endereço");
				String CNPJ = teclado3.nextLine();
				while(validacao.validarCPNJ(CNPJ) == false) {
					System.out.println("Digite outro CNPJ");
					CNPJ = teclado3.nextLine();
				}
				String name = teclado.nextLine();
				String Telephone = teclado.nextLine();
				String EMAIL = teclado.nextLine();
				String adress = teclado.nextLine();
				Seguradora SEGURADORA = new Seguradora(CNPJ,name,Telephone,EMAIL,adress);
				listaSeguradoras.add(SEGURADORA);
				System.out.println("Seguradora registrada");
			}
			
			else if(operador1 == Cadastrar.CADASTRAR_SEGURO_PF.operacao) {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Scanner teclado1 = new Scanner(System.in);
				System.out.println("Digite os dados do seguro:");
				System.out.println("Data de inicio, Data de fim , Nome da seguradora, Cpf do cliente, e placa do veiculo do cliente");
				String DataI = teclado1.nextLine();
				Date DateI = formato.parse(DataI);
				String DataF  = teclado1.nextLine();
				Date DateF = formato.parse(DataF);
				String seg = teclado1.nextLine();
				String Cpf = teclado1.nextLine();
				String placa = teclado1.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(seg)) {
						listaSeguradoras.get(i).gerarSeguroPF(DateI, DateF, listaSeguradoras.get(i), 
						((ClientePF)listaSeguradoras.get(i).getCliente(Cpf)).getVeiculo(placa), 
						(ClientePF)listaSeguradoras.get(i).getCliente(Cpf));
						System.out.println("Seguro adicionado");
					}
				}
			}
			
			
			
			else if(operador1 == Cadastrar.CADASTAR_SEGURO_PJ.operacao) {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Scanner teclado1 = new Scanner(System.in);
				operador1 = teclado.nextInt();
				System.out.println("Digite os dados do seguro:");
				System.out.println("Data de inicio, Data de fim , Nome da seguradora, Cnpj do cliente, e codigo da frota");
				String DataI = teclado1.nextLine();
				Date DateI = formato.parse(DataI);
				String DataF  = teclado1.nextLine();
				Date DateF = formato.parse(DataF);
				String seg = teclado1.nextLine();
				String Cnpj = teclado1.nextLine();
				String code = teclado1.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(seg)) {
						listaSeguradoras.get(i).gerarSeguroPJ(DateI, DateF, listaSeguradoras.get(i), 
						((ClientePJ) listaSeguradoras.get(i).getCliente(Cnpj)).getFrota(code), 
						(ClientePJ)listaSeguradoras.get(i).getCliente(Cnpj));
						System.out.println("Seguro adicionado");
					}
				}
			}
			
			else if(operador1 == Cadastrar.CADASTRAR_CONDUTOR.operacao) {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Scanner teclado2 = new Scanner(System.in);
				Scanner teclado3 = new Scanner(System.in);
				System.out.println("Digite os dados do Condutor:");
				System.out.println("CPF,Nome,Telefone,Endereço,Email,data de nascimento");
				String CPF = teclado2.nextLine();
				while(validacao.validarCPF(CPF) == false) {
					System.out.println("Digite outro CPF");
					CPF = teclado2.nextLine();
				}
				String name = teclado2.nextLine();
				while(validacao.validarNome(name) == false) {
					System.out.println("digite outro nome , com apenas letras");
					name = teclado2.nextLine();
				}
				String telephone = teclado2.nextLine();
				String adress = teclado2.nextLine();
				String email = teclado2.nextLine();
				String Birth_Date = teclado2.nextLine();
				Date DataN = formato.parse(Birth_Date);
				Condutor condutor = new Condutor(CPF, name, telephone, adress, email, DataN);
				System.out.println("Condutor criado");
				System.out.println("Digite o Id do seguro que deseja registrar o condutor:");
				int ID = teclado3.nextInt();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).pegarSeguro(ID).getId() == ID) {
						listaSeguradoras.get(i).pegarSeguro(ID).autorizarcondutor(condutor);
						System.out.println("Condutor registrado no seguro");
					}
				}
			}
			
			else if(operador1 == Cadastrar.CADASTRAR_FROTA.operacao) {
				Scanner teclado2 = new Scanner(System.in);
				Seguradora seguradora = new Seguradora(null,null,null,null,null);
				System.out.println("Digite um código para a frota");
				String code = teclado2.nextLine();
				Frota frota = new Frota(code);
				System.out.println("Digite o nome da seguradora que contém o cliente");
				String seg = teclado2.nextLine();
				System.out.println("Digite o cnpj do cliente que deseja associar a frota");
				String type = teclado2.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(seg)) {
						seguradora = listaSeguradoras.get(i);
					}
				}
				((ClientePJ) seguradora.getCliente(type)).cadastrarFrota(frota);
				System.out.println("Frota adicionada");
			}
			System.out.println("---------------");
			System.out.println(informacao);
			operador1 = teclado.nextInt();
		}
	}
	
	
	public static void Listar(Scanner teclado,List<Seguradora> listaSeguradoras)throws ParseException{
		String informacao = "Para Listar Cliente_PF por seguradora aperte 1\npara Listar Cliente_PJ por seguradora aperte 2 \n"
				+ "para Listar Seguro por Cliente aperte 3\npara Listar Sinistro por Cliente aperte 4 \n"
				+ "para Listar Veiculo por Cliente Físico aperte 5 \n"
				+ "para Listar Veiculo por Cliente Juridico aperte 6\ne para Voltar aperte 0";
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
			
			else if(operador1 == Listar.LISTAR_SEGURO_CLIENTE.operacao) {
				Scanner teclado1 = new Scanner(System.in);
				Seguradora seguradora = new Seguradora(null,null,null,null,null);
				System.out.println("Digite o nome da seguradora");
				String Name = teclado1.nextLine();
				System.out.println("Digite o Cpf ou Cnpj do cliente:");
				String type = teclado1.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(Name)) {
						seguradora = listaSeguradoras.get(i);
					}
				}
				System.out.println(seguradora.getSeguroCliente(seguradora.getCliente(type)).toString());
			}
			
			else if(operador1 == Listar.LISTAR_SINISTRO_CLIENTE.operacao) {
				Scanner teclado1 = new Scanner(System.in);
				Seguradora seguradora = new Seguradora(null,null,null,null,null);
				System.out.println("Digite o nome da seguradora");
				String Name = teclado1.nextLine();
				System.out.println("Digite o Cnpj ou Cpf do cliente:");
				String type = teclado1.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(Name)) {
						seguradora = listaSeguradoras.get(i);
					}
				}
				System.out.println(seguradora.getSinistroCliente(seguradora.getCliente(type)).toString());
			}
			
			
			else if(operador1 == Listar.LISTAR_VEICULO_FROTA.operacao) {
				Scanner teclado1 = new Scanner(System.in);
				Seguradora seguradora = new Seguradora(null,null,null,null,null);
				System.out.println("Digite o nome da seguradora");
				String Name = teclado1.nextLine();
				System.out.println("Digite o Cnpj do cliente:");
				String type = teclado1.nextLine();
				System.out.println("Digite o código da frota");
				String ident = teclado1.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(Name)) {
						seguradora = listaSeguradoras.get(i);
					}
				}
				((ClientePJ) seguradora.getCliente(type)).getVeiculosPorFrota(ident);	
			}
			
			else if(operador1 == Listar.LISTAR_VEICULO_CLIENTE.operacao) {
				Scanner teclado1 = new Scanner(System.in);
				Seguradora seguradora = new Seguradora(null,null,null,null,null);
				System.out.println("Digite o nome da seguradora");
				String Name = teclado1.nextLine();
				System.out.println("Digite o Cpf do cliente:");
				String type = teclado1.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(Name)) {
						seguradora = listaSeguradoras.get(i);
					}
				}
				((ClientePF) seguradora.getCliente(type)).ListarVeiculo();
			}
			System.out.println("---------------");
			System.out.println(informacao);
			operador1 = teclado.nextInt();
		}
	}
	
	
	public static void Excluir(Scanner teclado,List<Seguradora> listaSeguradoras)throws ParseException{
		String informacao = "Para Excluir cliente aperte 1\npara Excluir veiculo aperte 2 \n"
				+ "para Excluir sinistro aperte 3\npara Excluir Seguro digite 4 \n"
				+ "para Excluir Condutor digite 5\ne para Voltar aperte 0";
		System.out.println(informacao);
		int operador1 = teclado.nextInt();
		while(operador1 != Excluir.VOLTAR.operacao) {
			if(operador1 == Excluir.EXCLUIR_CLIENTE.operacao) {
				Seguradora seguradora = new Seguradora(null,null,null,null,null);
				Scanner teclado1 = new Scanner(System.in);
				Scanner teclado3 = new Scanner(System.in);
				System.out.println("Informe o nome da Seguradora");
				String seg = teclado3.nextLine();
				System.out.println("Digite o Cnpj ou Cpf do cliente:");
				String type = teclado1.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(seg)) {
						seguradora = listaSeguradoras.get(i);
					}
				}
				seguradora.removerCliente(seguradora.getCliente(type).getNome());
				System.out.println("Cliente removido");
			}
			
			
			else if(operador1 == Excluir.EXCLUIR_VEICULO_PF.operacao) {
				Seguradora seguradora = new Seguradora(null,null,null,null,null);
				Scanner teclado3 = new Scanner(System.in);
				System.out.println("Informe o nome da Seguradora");
				String seg = teclado3.nextLine();
				System.out.println("Digite o cpf");
				String type = teclado3.nextLine();
				System.out.println("Digite a placa do veiculo");
				String plate = teclado3.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(seg)) {
						seguradora = listaSeguradoras.get(i);
					}
				}
				((ClientePF) seguradora.getCliente(type)).removerVeiculo(plate);
				System.out.println("Veiculo removido");
			}
			
			else if(operador1 == Excluir.EXCLUIR_VEICULO_PJ.operacao) {
				Seguradora seguradora = new Seguradora(null,null,null,null,null);
				Scanner teclado3 = new Scanner(System.in);
				System.out.println("Informe o nome da Seguradora");
				String seg = teclado3.nextLine();
				System.out.println("Digite o Cnpj do cliente");
				String type = teclado3.nextLine();
				System.out.println("Digite o código da frota");
				String code = teclado3.nextLine();
				System.out.println("Digite a placa do veiculo");
				String plate = teclado3.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(seg)) {
						seguradora = listaSeguradoras.get(i);
					}
				}
				((ClientePJ)seguradora.getCliente(type)).atualizarFrota
				("remover veiculo",code,((ClientePJ) seguradora.getCliente(type)).getFrota(code).getCarro(plate));
				System.out.println("Veiculo removido");
			}
			
			
			else if(operador1 == Excluir.EXCLUIR_SEGURO.operacao) {
				Seguradora seguradora = new Seguradora(null,null,null,null,null);
				Scanner teclado3 = new Scanner(System.in);
				Scanner teclado1 = new Scanner(System.in);
				System.out.println("Informe o nome da Seguradora");
				String seg = teclado3.nextLine();
				System.out.println("Digite o Id do seguro");
				int code = teclado3.nextInt();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(seg)) {
						seguradora = listaSeguradoras.get(i);
					}
				}
				seguradora.cancelarSeguro(seguradora.pegarSeguro(code));
				System.out.println("Seguro cancelado");
			}
			
			else if(operador1 == Excluir.EXCLUIR_FROTA.operacao) {
				Seguradora seguradora = new Seguradora(null,null,null,null,null);
				Scanner teclado3 = new Scanner(System.in);
				System.out.println("Informe o nome da Seguradora");
				String seg = teclado3.nextLine();
				System.out.println("Digite o Cnpj do cliente");
				String type = teclado3.nextLine();
				System.out.println("Digite o código da frota");
				String code = teclado3.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(seg)) {
						seguradora = listaSeguradoras.get(i);
					}
				}
				((ClientePJ) seguradora.getCliente(type)).atualizarFrota("remover frota",code,null);
				System.out.println("Frota removida");
			}
			
			else if(operador1 == Excluir.EXCLUIR_CONDUTOR.operacao) {
				Seguradora seguradora = new Seguradora(null,null,null,null,null);
				Scanner teclado3 = new Scanner(System.in);
				Scanner teclado4 = new Scanner(System.in);
				System.out.println("Informe o nome da Seguradora");
				String seg = teclado3.nextLine();
				System.out.println("Digite o Id do seguro");
				int ident = teclado4.nextInt();
				System.out.println("Digite o cpf do condutor");
				String type = teclado3.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(seg)) {
						seguradora = listaSeguradoras.get(i);
					}
				}
				seguradora.getSeguro(ident).desautorizar_condutor(seguradora.pegarSeguro(ident).getCondutor(type));
				System.out.println("Condutor removido");
			}
			System.out.println("---------------");
			System.out.println(informacao);
			operador1 = teclado.nextInt();
		}
	}
	
	public static void gerarSinistro(Scanner teclado,List<Seguradora> listaSeguradoras)throws ParseException {
		Seguradora seguradora = new Seguradora(null,null,null,null,null);
		Scanner teclado0 = new Scanner(System.in);
		Scanner teclado1 = new Scanner(System.in);
		System.out.println("Digite a data:");
		String Crash_Date = teclado0.nextLine();
		System.out.println("Digite o endereço:");
		String adress = teclado0.nextLine();
		System.out.println("Informe o nome da Seguradora");
		String seg = teclado0.nextLine();
		System.out.println("Digite o Id do seguro");
		int code = teclado1.nextInt();
		System.out.println("Digite o Cpf do condutor");
		String CPF = teclado0.nextLine();
		for(int i = 0; i < listaSeguradoras.size();i++) {
			if(listaSeguradoras.get(i).getNome().equals(seg)) {
				seguradora = listaSeguradoras.get(i);
			}
		}
		seguradora.pegarSeguro(code).gerarSinistro(Crash_Date, adress, 
		seguradora.pegarSeguro(code).getCondutor(CPF), seguradora.pegarSeguro(code));
		seguradora.setSinistros(seguradora.pegarSeguro(code).getSinistro());
		System.out.println("Sinistro Criado");
	}
	
	
	
	public static void calcularReceita(Scanner teclado,List<Seguradora> listaSeguradoras) throws ParseException {
		DecimalFormat df = new DecimalFormat("#,###.00");
		Seguradora seguradora = new Seguradora(null,null,null,null,null);
		Scanner teclado0 = new Scanner(System.in);
		System.out.println("Informe o nome da Seguradora");
		String seg = teclado0.nextLine();
		for(int i = 0; i < listaSeguradoras.size();i++) {
			if(listaSeguradoras.get(i).getNome().equals(seg)) {
				seguradora = listaSeguradoras.get(i);
			}
		}
		System.out.println("Recita da" + seguradora.getNome() + " é:" + " R$ " + df.format(seguradora.calculaReceita()));
	}
	
	
	
	public static void main(String[] args) throws Exception{
		teste();
		Scanner teclado = new Scanner(System.in);
		List<Seguradora> listaSeguradoras = new ArrayList<>();
		Seguradora segTest = new Seguradora("00.000.000/0000-00","SEGURADORA TESTE","0000 000 0000","seguradoraTeste@email.com","Endereco");
		ArquivoVeiculo arqVec = new ArquivoVeiculo();
		ArquivoFrota arqFrota = new ArquivoFrota();
		ArquivoCondutor arqCondutor = new ArquivoCondutor();
		ArquivoClientePF arqClientPF = new ArquivoClientePF();
		ArquivoClientePJ arqClientPJ = new ArquivoClientePJ();
		segTest.setVeiculos(arqVec.infoArquivo());
		segTest.setCondutores(arqCondutor.infoArquivo());
		segTest.setFrotas(arqFrota.infoArquivo());
		segTest.setClientes(arqClientPF.infoArquivo());
		segTest.setClientes(arqClientPJ.infoArquivo());
		System.out.println("Bem vindo ao programa de seguradora");
		System.out.println("Digite os dados com enter entre eles");
		System.out.println("Para começar ,digite os dados da 1ª seguradora :");
		System.out.println("Cnpj,Nome,Telefone,email,endereço");
		String CNPJ = teclado.nextLine();
		while(validacao.validarCPNJ(CNPJ) == false) {
			System.out.println("Digite outro CNPJ");
			CNPJ = teclado.nextLine();
		}
		String name = teclado.nextLine();
		String Telephone = teclado.nextLine();
		String EMAIL = teclado.nextLine();
		String adress = teclado.nextLine();
		Seguradora SEGURADORA = new Seguradora(CNPJ,name,Telephone,EMAIL,adress);
		listaSeguradoras.add(SEGURADORA);
		System.out.println("Seguradora registrada");
		System.out.println("---------------");
		String informacao = "Para ler os dados iniciais aperte 1\nPara Cadastros aperte 2\npara Listar aperte 3\n"
				+ "Para Excluir aperte 4\nPara Gerar Sinistro aperte 5\n"
				+ "Para Calcular Receita de uma seguradora aperte 6\n"
				+ "Para gravar os dados dos seguros e dos sinistros de alguma seguradora criadas nessa sesão aperte7\n"
				+ "e para Sair aperte 0";
		System.out.println(informacao);
		int operador = teclado.nextInt();
		while(operador != MenuOperacoes.SAIR.operacao) {
			if(operador == MenuOperacoes.CADASTROS.operacao) {
				Cadastros(teclado,listaSeguradoras);
			}
			else if(operador == MenuOperacoes.LISTAR.operacao) {
				Listar(teclado,listaSeguradoras);
			}
			else if(operador == MenuOperacoes.EXCLUIR.operacao) {
				Excluir(teclado,listaSeguradoras);
			}
			else if(operador == MenuOperacoes.GERAR_SINISTRO.operacao) {
				gerarSinistro(teclado,listaSeguradoras);
			}
			else if(operador == MenuOperacoes.CALCULAR_RECEITA_SEGURADORA.operacao){
				calcularReceita(teclado,listaSeguradoras);
			}
			else if(operador == MenuOperacoes.LER_DADOS_INICIAIS.operacao) {
				segTest.lerDados("ClientePF");
				System.out.println("---------------");
				segTest.lerDados("ClientePJ");
				System.out.println("---------------");
				segTest.lerDados("Condutor");
				System.out.println("---------------");
				segTest.lerDados("Frota");
				System.out.println("---------------");
				segTest.lerDados("Veiculo");
				System.out.println("---------------");
			}
			else if(operador == MenuOperacoes.GRAVAR_DADOS.operacao) {
				Seguradora seguradora = new Seguradora(null,null,null,null,null);
				Scanner teclado0 = new Scanner(System.in);
				System.out.println("Informe o nome da Seguradora");
				String seg = teclado0.nextLine();
				for(int i = 0; i < listaSeguradoras.size();i++) {
					if(listaSeguradoras.get(i).getNome().equals(seg)) {
						seguradora = listaSeguradoras.get(i);
					}
				}
				seguradora.gravarDados("Seguro");
				seguradora.gravarDados("Sinistro");
				System.out.println("Deseja ver os dados gravados ? Aperte Y  se sim OU N se não");
				String decision = teclado0.nextLine();
				if(decision.equals("Y")) {
					seguradora.lerDados("Seguro");
					System.out.println("---------------");
					seguradora.lerDados("Sinistro");
				}
			}
			System.out.println("---------------");
			System.out.println(informacao);
			operador = teclado.nextInt();
		}
		System.out.println("******************");
		System.out.println("Obrigado por ter usado o programa");
	}
	

}
