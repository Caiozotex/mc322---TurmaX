import java.util.Date;
import java.text.SimpleDateFormat;

public class ClientePJ extends Cliente{
	private final String cnpj; 
	private Date dataFundacao;
	private int qtdeFuncionarios;
	
	public ClientePJ(String Nome,String Endereco,String CNPJ,Date DataFundacao,int QTDEfuncionarios) {
				super(Nome,Endereco);
				this.cnpj = CNPJ;
				this.dataFundacao = DataFundacao;
				this.qtdeFuncionarios = QTDEfuncionarios;
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
	
	
	public int getQtdeFuncionarios() {
		return qtdeFuncionarios;
	}

	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}
	

	public double CalculaScore() {
		return CalcSeguro.VALOR_BASE.valorSeguro * (1 + ((getQtdeFuncionarios())/100)) * qtdeVeiculos();
	}

	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String informacoes = ClientePJ.super.toString() + "\n" + "CNPJ:" + getCnpj() + "\n"
		+ "Data de Fundação: " + formato.format(getDataFundacao());
		return informacoes;
	}
	
}
