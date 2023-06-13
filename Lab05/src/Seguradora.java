
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
	
	public Seguradora(String Cnpj,String Nome,String Telefone,String Email,String Endereco) {
		this.cnpj = Cnpj;
		this.nome = Nome;
		this.telefone = Telefone;
		this.email = Email;
		this.endereco = Endereco;
		listaSeguros = new ArrayList<>();
		listaClientes = new ArrayList<> ();
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
	
	public String toString() {
		String informacoes =  "Cnpj:" + getCnpj() + "\n" + "Nome:" + getNome() + "\n" + "Telefone:" + getTelefone() + "\n" + "Email:" + getEmail()
		+ "\n" + "Endereço:" + getEndereco() + "\n" + "Lista de seguros:" + infoSeguros() + "\n" +
		"Lista Clientes:" + listaClientes.toString();
		return informacoes;
	}
		
}
