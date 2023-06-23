
import java.util.Date;

public class SeguroPJ extends Seguro {
	private Frota frota;
	private ClientePJ cliente;
	
	public SeguroPJ(Date dataI , Date dataF, Seguradora Seguradora,Frota Frota,ClientePJ Cliente) {
		super(dataI,dataF,Seguradora);
		this.frota = Frota;
		this.cliente = Cliente;
	}
	
	public ClientePJ getCliente() {
		return cliente;
	}

	public Frota getFrota() {
		return frota;
	}

	public void setFrota(Frota frota) {
		this.frota = frota;
	}

	public void setCliente(ClientePJ cliente) {
		this.cliente = cliente;
	}
	
	public double CalcularValor() {
		return CalcSeguro.VALOR_BASE.valorSeguro * (10 + (cliente.getQtdefuncionarios())/10.0) * (1 + 1.0/(cliente.qtdeVeiculos()+2)) * 
		(1 + 1.0/(cliente.anosFundacao(cliente.getDataFundacao())+2)) * (2 + (super.qtdSinistros())/10.0) * (5 + super.qtdSinistrosCondutor()/10.0);
	}
	
	public String toString() {
		String informacoes = super.toString() + "\n" + "Frota" + frota.toString() + "\n" + "Cliente:" + cliente.toString();
		return informacoes;
	}
	

}
