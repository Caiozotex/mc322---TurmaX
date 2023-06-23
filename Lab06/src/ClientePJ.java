
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class ClientePJ extends Cliente{
	private final String cnpj; 
	private Date dataFundacao;
	private int Qtdefuncionarios;
	private List<Frota> listaFrota;
	
	
	public ClientePJ(String Nome,String Telefone,String Endereco,String Email,String CNPJ,Date DataFundacao,int QTDEfuncionarios) {
				super(Nome,Telefone,Endereco,Email);
				this.cnpj = CNPJ;
				this.dataFundacao = DataFundacao;
				this.Qtdefuncionarios = QTDEfuncionarios;
				listaFrota = new ArrayList<>();
			}

	public String getCnpj() {
		return cnpj;
	}
	
	public void setDataFundacao(Date data) {
		this.dataFundacao = data; 
	}
	
	public Date getDataFundacao() {
		return dataFundacao;
	}
	
	public boolean cadastrarFrota(Frota frota) {
		if(listaFrota.contains(frota) == false) {
			listaFrota.add(frota);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Frota getFrota(String ident) {
		Frota frota = new Frota(null);
		for(int i = 0; i < listaFrota.size();i++) {
			if(listaFrota.get(i).getCode().equals(ident)) {
				frota = listaFrota.get(i);
			}
		}
		return frota;
	}
	
	
	public int getQtdefuncionarios() {
		return Qtdefuncionarios;
	}

	public void setQtdefuncionarios(int qtdefuncionarios) {
		Qtdefuncionarios = qtdefuncionarios;
	}

	public boolean atualizarFrota(String operacao,String identificador,Veiculo carro) {
		for(int i = 0 ; i < listaFrota.size();i++) {
			if(listaFrota.get(i).getCode().equals(identificador)) {
				switch(operacao) {
				case "adicionar veiculo":
					listaFrota.get(i).addVeiculo(carro);
					break;
				case "remover veiculo":
					listaFrota.get(i).removeVeiculo(carro.getPlaca());
					break;
				case "remover frota":
					listaFrota.remove(i);
				}	
			}
		}
		return true;
	}
	
	public void getVeiculosPorFrota(String identificador) {
		for(int i = 0 ; i < listaFrota.size();i++) {
			if(listaFrota.get(i).getCode().equals(identificador)) {
				listaFrota.get(i).getVeiculos();
			}
		}
	}
	
	public String primeiroCode() {
		return listaFrota.get(0).getCode();
	}
	
	
	public int anosFundacao(Date dataFund) {
		 Date data_atual = new Date();
		 int dia = dataFund.getDate();
		 int mes = (dataFund.getMonth()) * 30;
		 int ano = (dataFund.getYear() + 1900) * 365;
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
	
	public int qtdeVeiculos() {
		int soma = 0;
		for(int i = 0 ; i < listaFrota.size();i++) {
			soma += listaFrota.get(i).qtdeVeiculos();
		}
		return soma;
	}
	
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String informacoes = super.toString() + "\n" + "CNPJ:" + getCnpj() + "\n"
		+ "Data de Fundação: " + formato.format(getDataFundacao());
		return informacoes;
	}
	
	
	
	
}
