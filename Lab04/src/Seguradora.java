import java.util.ArrayList;
import java.util.List;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private List<Sinistro> listaSinistros;
	private List<Cliente> listaClientes;
	
	public Seguradora(String Nome,String Telefone,String Email,String Endereco) {
		this.nome = Nome;
		this.telefone = Telefone;
		this.email = Email;
		this.endereco = Endereco;
		listaSinistros = new ArrayList<>();
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
	
	public boolean acharCliente(String cliente) {
		if(listaClientes.size() > 0) {
			for(int i = 0;i < listaClientes.size();i++) {
				if(listaClientes.get(i).getNome().equals(cliente)){
					return true;
				}
			}
		}
		return false;
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
	
	public void listarVeiculos() {
		for(int i = 0; i < listaClientes.size();i++) {
			for(int j = 0; j < listaClientes.get(i).qtdeVeiculos();j++) {
				System.out.println(listaClientes.get(i).getVeiculo(j));
			}
		}
	}
	
	public boolean visualizarSinistro(String cliente) {
		if(listaSinistros.size()==0) {
			return false;
		}
		else {
			for(int i = 0; i < listaSinistros.size(); i++) {
				if(listaSinistros.get(i).getCliente().getNome().equals(cliente) == true) {
					System.out.println(listaSinistros.get(i));
				}
			}
			return true;
		}
	}
	
	public String listarSinistro() {
		return listaSinistros.toString(); //Ver
	}
	
	public boolean gerarSinistro(String Data,String Endereco,Cliente cliente,Seguradora seguradora,Veiculo veiculo){
		if(listaClientes.contains(cliente)== false) {
			return false;
		}
		else {
			Sinistro sinistro = new Sinistro(Data,Endereco,seguradora,veiculo,cliente);
			listaSinistros.add(sinistro);
		}
		return true;
	}
	
	public void removerSinistro(int ID) {
		for(int i = 0; i < listaSinistros.size();i++) {
			if(listaSinistros.get(i).getId() == ID) {
				listaSinistros.remove(i);
			}
		}
	}
	
	private int contSinistro(String cliente) {
		int soma = 0;
		for(int i = 0; i < listaSinistros.size(); i++) {
			if(listaSinistros.get(i).getCliente().getNome().equals(cliente) == true) {
				soma++;
			}
		}
		return soma;
	}
	
	public double calcularPrecoSeguroCliente(Cliente cliente) {
		return cliente.CalculaScore() * (1 + contSinistro(cliente.getNome()));
	}
	
	public double calcularReceita() {
		double soma = 0.0;
		for(int i= 0;i < listaClientes.size();i++) {
			listaClientes.get(i).setValorSeguro(calcularPrecoSeguroCliente(listaClientes.get(i)));
			soma += calcularPrecoSeguroCliente(listaClientes.get(i));
		}
		return soma;
	}
	

}
