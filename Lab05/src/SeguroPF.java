
import java.util.Date;

public class SeguroPF extends Seguro {
	private Veiculo veiculo;
	private ClientePF cliente;
	
	public SeguroPF(Date dataI , Date dataF, Seguradora Seguradora,Veiculo Veiculo,ClientePF Cliente) {
		super(dataI,dataF,Seguradora);
		this.veiculo = Veiculo;
		this.cliente = Cliente;
	}
	
	public ClientePF getCliente() {
		return cliente;
	}
	
	public void setCliente(ClientePF cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public double CalcularValor() {
		if(cliente.diferencaAnos(cliente.getDataNascimento())< 30) {
			return CalcSeguro.FATOR_18_30.valorSeguro * CalcSeguro.VALOR_BASE.valorSeguro * (1 + 1.0/(cliente.qtdeVeiuclos()+ 2))*
			(2 + (super.qtdSinistros())/10.0) * (5 + super.qtdSinistrosCondutor()/10.0);
		}
		if(cliente.diferencaAnos(cliente.getDataNascimento()) >= 30) {
			return CalcSeguro.FATOR_30_60.valorSeguro * CalcSeguro.VALOR_BASE.valorSeguro * (1 + 1.0/(cliente.qtdeVeiuclos()+2))*
			(2 + (super.qtdSinistros())/10.0) * (5 + super.qtdSinistrosCondutor()/10.0);
		}
		else {
			return CalcSeguro.FATOR_60_90.valorSeguro * CalcSeguro.VALOR_BASE.valorSeguro * (1 + 1.0/(cliente.qtdeVeiuclos()+2))*
			(2 + (super.qtdSinistros())/10.0) * (5 + super.qtdSinistrosCondutor()/10.0);
		}
	}
	
	public String toString() {
		String informacoes = super.toString() + "\n" + "Veiculo" + veiculo.toString() + "\n" + "Cliente:" + cliente.toString();
		return informacoes;
	}

}
