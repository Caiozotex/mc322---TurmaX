
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Seguradora {
	private final String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private List<Seguro> listaSeguros;
	private List<Cliente> listaClientes;
	private List<Veiculo> listaVeiculos;
	private List<Condutor> listaCondutores;
	private List<Frota> listaFrotas;
	private List<Sinistro> listaSinistros;
	private ArquivoClientePF fileClientPF;
	private ArquivoClientePJ fileClientPJ;
	private ArquivoCondutor fileCondutor;
	private ArquivoFrota fileFrota;
	private ArquivoSeguro fileSeguro;
	private ArquivoSinistro fileSinistro;
	private ArquivoVeiculo fileVeiculo;
	
	
	public Seguradora(String Cnpj,String Nome,String Telefone,String Email,String Endereco) {
		this.cnpj = Cnpj;
		this.nome = Nome;
		this.telefone = Telefone;
		this.email = Email;
		this.endereco = Endereco;
		this.fileClientPF = new ArquivoClientePF();
		this.fileClientPJ = new ArquivoClientePJ();
		this.fileCondutor = new ArquivoCondutor();
		this.fileFrota = new ArquivoFrota();
		this.fileSeguro = new ArquivoSeguro();
		this.fileSinistro = new ArquivoSinistro();
		this.fileVeiculo = new ArquivoVeiculo();
		listaSeguros = new ArrayList<>();
		listaClientes = new ArrayList<> ();
		listaCondutores = new ArrayList<> ();
		listaFrotas = new ArrayList<> ();
		listaSinistros = new ArrayList<> ();
		listaVeiculos = new ArrayList<> ();
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Seguro getSeguro(int indice) {
		return listaSeguros.get(indice);
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public Seguro pegarSeguro(int identificador) {
		Seguro seguro = new Seguro(null,null,null);
		if(listaSeguros.size()>0) {
			for(int i = 0; i < listaSeguros.size();i++) {
				if(listaSeguros.get(i).getId() == identificador) {
					seguro =  listaSeguros.get(i);
				}
			}
		}
		return seguro;
	}
	
	
	public boolean cadastrarCliente(Cliente cliente) {
		if(listaClientes.contains(cliente)==true) {
			return false;
		}
		else if(listaClientes.contains(cliente)==false){
			listaClientes.add(cliente);
		}
		return true;
	}
	
	public void cadastrarVeiculos(Veiculo carro) {
		listaVeiculos.add(carro);
	}
	
	public void cadastrarCondutores(Condutor condutor) {
		listaCondutores.add(condutor);
	}
	
	public void cadastrarFrota(Frota frota) {
		listaFrotas.add(frota);
	}
	
	public void cadastrarSinistro(Sinistro sinistro) {
		listaSinistros.add(sinistro);
	}
	
	public boolean removerCliente(String cliente) { //cliente é igual ao nome dele
		for(int i = 0; i < listaClientes.size(); i++) {
			if(listaClientes.get(i).getNome().equals(cliente)) {
				listaClientes.remove(i);
				return true;
			}
		}
		
		return false;
	
	}
	
	public Cliente getCliente(String cliente) {
		Cliente client = new Cliente(null,null,null,null);
		if(listaClientes.size()>0) {
			for(int i = 0; i < listaClientes.size();i++) {
				if(listaClientes.get(i).getClass() == ClientePF.class) {
					if(((ClientePF) listaClientes.get(i)).getCpf().equals(cliente)){
						return listaClientes.get(i);
					}
				}
				else if(listaClientes.get(i).getClass() == ClientePJ.class) {
					if(((ClientePJ) listaClientes.get(i)).getCnpj().equals(cliente)) {
						return listaClientes.get(i);
					}
			      }
		        }
		      }
		return client;
	}
	
	
	
	public boolean listarClientes(String tipoCliente) {
		if(tipoCliente.equals("PF")) {
			for(int i = 0; i < listaClientes.size();i++) {
				if(listaClientes.get(i).getClass() == ClientePF.class) {
					System.out.println(listaClientes.get(i));
				}
			}
			return true;
		}
		else if(tipoCliente.equals("PJ")) {
			for(int i = 0; i < listaClientes.size();i++) {
				if(listaClientes.get(i).getClass() == ClientePJ.class) {
					System.out.println(listaClientes.get(i));
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean gerarSeguroPF(Date dataI , Date dataF, Seguradora Seguradora,Veiculo veiculo,ClientePF cliente) {
		SeguroPF seguro = new SeguroPF(dataI,dataF,Seguradora,veiculo,cliente); 
		if(listaSeguros.contains(seguro)) {
			return false;
		}
		else {
			listaSeguros.add(seguro);
			return true;
		}
	}
	
	public boolean gerarSeguroPJ(Date dataI , Date dataF, Seguradora Seguradora,Frota frota,ClientePJ cliente) {
		SeguroPJ seguro = new SeguroPJ(dataI,dataF,Seguradora,frota,cliente); //INCOMPLETO
		if(listaSeguros.contains(seguro)) {
			return false;
		}
		else {
			listaSeguros.add(seguro);
			return true;
		}
	}
	
	public boolean cancelarSeguro(Seguro seguro) {
		if(listaSeguros.contains(seguro)) {
			listaSeguros.remove(seguro);
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Seguro> getSeguroCliente(Cliente cliente){
		List <Seguro> listSeguros = new ArrayList<>();
		for(int i = 0;i< listaSeguros.size();i++) {
			if(listaSeguros.get(i).getClass() == SeguroPF.class) {
				if(((SeguroPF) listaSeguros.get(i)).getCliente().equals(cliente)) {
					listSeguros.add(listaSeguros.get(i));
				}
			}
			else if(listaSeguros.get(i).getClass() == SeguroPJ.class) {
				if(((SeguroPJ)listaSeguros.get(i)).getCliente().equals(cliente)){
					listSeguros.add(listaSeguros.get(i));
				}
			}
		}
		return listSeguros;
	}
	
	public List<Sinistro> getSinistroCliente(Cliente cliente){
		List <Sinistro> listSinistros = new ArrayList<>();
		for(int i = 0;i< listaSeguros.size();i++) {
			if(listaSeguros.get(i).getClass() == SeguroPF.class) {
				if(((SeguroPF) listaSeguros.get(i)).getCliente().equals(cliente)) {
					listSinistros = listaSeguros.get(i).getSinistro();
				}
			}
			else if(listaSeguros.get(i).getClass() == SeguroPJ.class) {
				if(((SeguroPJ)listaSeguros.get(i)).getCliente().equals(cliente)){
					listSinistros =  listaSeguros.get(i).getSinistro();
				}
			}
			
	      }
		return listSinistros;
	}
	
	
	public double calculaReceita() {
		double soma = 0.0;
		for(int i =0 ; i < listaSeguros.size();i++) {
			listaSeguros.get(i).setValorMensal(listaSeguros.get(i).CalcularValor());
			soma += listaSeguros.get(i).CalcularValor();
		}
		return soma;
	}
	
	public String infoSeguros() {
		String info = "";
		for(int i = 0; i < listaSeguros.size();i++) {
			info += listaSeguros.get(i).getId() + "-";
		}
		return info;
	}
	
	public void setVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public void setClientes(List<Cliente> listaClientes) {
		if(this.listaClientes.size()> 0) {
			List<Cliente> listaTemp = new ArrayList<>();
			listaTemp = listaClientes;
			for(int i = 0;i < listaTemp.size();i++) {
				this.listaClientes.add(listaTemp.get(i));
			}
		}
		else {
			this.listaClientes = listaClientes;
		}
	}
	
	public void setFrotas(List<Frota> listaFrotas) {
		this.listaFrotas = listaFrotas;
	}
	
	public void setCondutores(List<Condutor> listaCondutores) {
		this.listaCondutores = listaCondutores;
	}
	
	public void setSinistros(List<Sinistro> listaSinistro) {
		this.listaSinistros = listaSinistro;
	}
	
	

	public void gravarDados(String operacao) throws Exception {
		switch(operacao) {
		case "ClientePF":
			String arquivo1 = "CPF_CLIENTE,NOME_CLIENTE,"
			+ "TELEFONE_CLIENTE,ENDERECO_CLIENTE,EMAIL_CLIENTE,SEXO,"
			+ "ENSINO,DATA_NASCIMENTO,PLACA_VEICULO_CLIENTE1" + "\n";
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			for(int i = 0; i< listaClientes.size();i++) {
				if(listaClientes.get(i).getClass() == ClientePF.class) {
					arquivo1 += ((ClientePF) listaClientes.get(i)).getCpf() + ",";
					arquivo1 += listaClientes.get(i).getNome() + ",";
					arquivo1 += listaClientes.get(i).getTelefone() + ",";
					arquivo1 += listaClientes.get(i).getEndereco() + ",";
					arquivo1 += listaClientes.get(i).getEmail() + ",";
					arquivo1 += ((ClientePF) listaClientes.get(i)).getGenero() + ",";
					arquivo1 += ((ClientePF) listaClientes.get(i)).getEducacao() + ",";
					arquivo1 += formato.format(((ClientePF) listaClientes.get(i)).getDataNascimento()) + ",";
					arquivo1 += ((ClientePF) listaClientes.get(i)).primeiraPlaca() + "\n"; //Duvida,apenas 1 placa?
				}
			}
			arquivo1 = arquivo1.substring(0, arquivo1.length() - 2);
			fileClientPF.gravarArquivo(arquivo1);
			break;
		case "ClintePJ":
			String arquivo2 = "CNPJ_CLIENTE,NOME_CLIENTE,TELEFONE,ENDERECO,"
			+ "EMAIL_CLIENTE,DATA_FUND,CODE_FROTA" + "\n";
			SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd");
			for(int i = 0; i< listaClientes.size();i++) {
				if(listaClientes.get(i).getClass() == ClientePJ.class) {
					arquivo2 += ((ClientePJ) listaClientes.get(i)).getCnpj() + ",";
				    arquivo2 += listaClientes.get(i).getNome() + ",";
					arquivo2 += listaClientes.get(i).getTelefone() + ",";
					arquivo2 += listaClientes.get(i).getEndereco() + ",";
					arquivo2 += listaClientes.get(i).getEmail() + ",";
					arquivo2 += formato1.format(((ClientePJ) listaClientes.get(i)).getDataFundacao()) + ",";
					arquivo2 += ((ClientePJ) listaClientes.get(i)).primeiroCode() + "\n"; //Duvida,apenas 1 code?
				}
			}
			arquivo2 = arquivo2.substring(0, arquivo2.length() - 2);
			fileClientPJ.gravarArquivo(arquivo2);
			break;
		case "Condutor":
			SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
			String arquivo3 = "CPF_CONDUTOR,NOME_CONDUTOR,TELEFONE,ENDERECO,EMAIL,DATA_NASCIMENTO" + "\n";
			for(int i = 0 ; i < listaCondutores.size();i++) {
				arquivo3 += listaCondutores.get(i).getCpf() + ",";
				arquivo3 += listaCondutores.get(i).getNome() + ",";
				arquivo3 += listaCondutores.get(i).getTelefone() + ",";
				arquivo3 += listaCondutores.get(i).getEndereco() + ",";
				arquivo3 += listaCondutores.get(i).getEmail() + ",";
				arquivo3 += formato2.format(listaCondutores.get(i).getDataNascimento()) + "\n";
			}
			arquivo3 = arquivo3.substring(0, arquivo3.length() - 2);
			fileCondutor.gravarArquivo(arquivo3);
			break;
		case "Frota":
			String arquivo4 = "ID_FROTA,PLACA_VEICULO1,PLACA_VEICULO2,PLACA_VEICULO3" + "\n";
			for(int i = 0; i < listaFrotas.size();i++) {
				List<Veiculo> listaVeiculos = new ArrayList<>();
				listaVeiculos = listaFrotas.get(i).listaVeiculos();
				arquivo4 += listaFrotas.get(i).getCode() + ",";
				arquivo4 += listaVeiculos.get(0).getPlaca() + ",";
				arquivo4 += listaVeiculos.get(1).getPlaca() + ",";
				arquivo4 += listaVeiculos.get(2).getPlaca() + "\n";
			}
			arquivo4 = arquivo4.substring(0, arquivo4.length() - 2);
			fileFrota.gravarArquivo(arquivo4);
			break;
		case "Seguro":
			String arquivo5 = "Id do seguro,Data de Inicio,Data de Fim,Nome da Seguradora,"
			+ "ID's dos Sinistros,Cpfs dos Condutores,Valor mensal" + "\n";
			SimpleDateFormat formato3 = new SimpleDateFormat("dd/MM/yyyy");
			DecimalFormat df = new DecimalFormat("#,###.00");
			for(int i = 0;i < listaSeguros.size();i++) {
				arquivo5 += listaSeguros.get(i).getId() + ",";
				arquivo5 += formato3.format(listaSeguros.get(i).getDataInicio()) +  ",";
				arquivo5 += formato3.format(listaSeguros.get(i).getDataFim()) + ",";
				arquivo5 += listaSeguros.get(i).getSeguradora().getNome() + ",";
				arquivo5 += listaSeguros.get(i).Sinistros() + ",";
				arquivo5 += listaSeguros.get(i).Condutores() + ","; 
				arquivo5 += df.format(listaSeguros.get(i).getValorMensal()) + "\n";
			}
			arquivo5 = arquivo5.substring(0, arquivo5.length() - 2);
			fileSeguro.gravarArquivo(arquivo5); 
			break;
		case "Sinistro":
			String arquivo6 = "Id do Sinistro,Data do Acidente,"
			+ "Endereço do Acidente,Cpf do Condutor,Id do Seguro" + "\n";
			for(int i = 0; i < listaSinistros.size();i++) {
				arquivo6 += listaSinistros.get(i).getId() + ",";
				arquivo6 += listaSinistros.get(i).getData() + ",";
				arquivo6 += listaSinistros.get(i).getEndereco() + ",";
				arquivo6 += listaSinistros.get(i).getCondutor().getCpf() + ",";
				arquivo6 += listaSinistros.get(i).getSeguro().getId() + "\n";
			}
			arquivo6 = arquivo6.substring(0, arquivo6.length() - 2);
			fileSinistro.gravarArquivo(arquivo6); 
			break;
		case "Veiculo":
			String arquivo = "PLACA,MARCA,MODELO,ANO_FAB" + "\n";
			for(int i = 0; i< listaVeiculos.size();i++) {
				arquivo += listaVeiculos.get(i).getPlaca() + ",";
				arquivo += listaVeiculos.get(i).getMarca() + ",";
				arquivo += listaVeiculos.get(i).getModelo() + ",";
				arquivo += listaVeiculos.get(i).getAnoFabricacao() + "\n";
			}
			arquivo = arquivo.substring(0, arquivo.length() - 2);
			fileVeiculo.gravarArquivo(arquivo);
			break;
		}
	}
	
	public void lerDados(String operacao) throws Exception {
		switch(operacao) {
		case "ClientePF":
			System.out.println(fileClientPF.lerArquivo());
			break;
		case "ClientePJ":
			System.out.println(fileClientPJ.lerArquivo());
			break;
		case "Condutor":
			System.out.println(fileCondutor.lerArquivo());
			break;
		case "Frota":
			System.out.println(fileFrota.lerArquivo());
			break;
		case "Seguro":
			System.out.println(fileSeguro.lerArquivo());
			break;
		case "Sinistro":
			System.out.println(fileSinistro.lerArquivo()); 
			break;
		case "Veiculo":
			System.out.println(fileVeiculo.lerArquivo());
			break;
		}
	}
	
	
	public String toString() {
		String informacoes =  "Cnpj:" + getCnpj() + "\n" + "Nome:" + getNome() + "\n" + "Telefone:" + getTelefone() + "\n" + "Email:" + getEmail()
		+ "\n" + "Endereço:" + getEndereco() + "\n" + "Lista de seguros:" + infoSeguros() + "\n" +
		"Lista Clientes:" + listaClientes.toString();
		return informacoes;
	}
		
}
