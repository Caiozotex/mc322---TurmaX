
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClientePF extends Cliente{
	private String educacao;
	private String genero;
	private Date dataLicenca;
	private final String cpf ; 
	private Date dataNascimento;
	private List<Veiculo> listaVeiculos;
	
	public ClientePF(String Nome,String Telefone,String Endereco,String Email,String Educacao,String Genero,String CPF,Date DataNascimento) {
		super(Nome,Telefone,Endereco,Email);
		this.educacao = Educacao;
		this.genero = Genero;
		this.cpf = CPF;
		this.dataNascimento = DataNascimento;
		listaVeiculos = new ArrayList<>();
	}
	
	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Date getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public String getCpf() {
		return cpf;
	}

	public void setDataNascimento(Date data) {
		this.dataNascimento = data;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public Veiculo getVeiculo(String plate) {
		Veiculo carro = new Veiculo(null, null, null, 0);
		for(int i  = 0 ; i < listaVeiculos.size();i++) {
			if(listaVeiculos.get(i).getPlaca().equals(plate)) {
				carro = listaVeiculos.get(i);
			}
		}
		return carro;
	}
	
	public void ListarVeiculo() {
		for(int i = 0;i < listaVeiculos.size();i++) {
			System.out.println(listaVeiculos.get(i).toString());
		}
	}
	
	public boolean cadastrarVeiculo(Veiculo veiculo) {
		if(listaVeiculos.contains(veiculo) == false) {
			listaVeiculos.add(veiculo);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean removerVeiculo(String placa) {
		for(int i = 0; i < listaVeiculos.size();i++) {
			if(listaVeiculos.get(i).getPlaca().equals(placa)) {
				listaVeiculos.remove(i);
			}
		}
		return true;
	}
	
	public int diferencaAnos(Date DataNascimento) {
		 Date data_atual = new Date();
		 int dia = DataNascimento.getDate();
		 int mes = (DataNascimento.getMonth()) * 30;
		 int ano = (DataNascimento.getYear() + 1900) * 365;
		 int dia1 = data_atual.getDate();
		 int mes1 = data_atual.getMonth() * 30;
		 int ano1 = (data_atual.getYear() + 1900) * 365;
		 int comp = (dia1 + mes1 + ano1) - (dia + mes + ano);
		 if(comp % 365 == 0) {
			 return comp /= 365;
		 }
		 else {
			 return (comp /= 365) + 1;
		 }
	}
	
	public int qtdeVeiuclos() {
		return listaVeiculos.size();
	}
	
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String informacoes = super.toString() + "Educação:" + getEducacao() + "\n" + "Gênero:"+ getGenero()+ "\n" 
		+ "\n" + "CPF:" + getCpf() + "\n"  + "Data de Nascimento: " + formato.format(getDataNascimento()) + "\n" + "Lista de Veiculos: " + listaVeiculos.toString();
		return informacoes; 
	}
	

}
