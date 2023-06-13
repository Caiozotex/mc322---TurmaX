
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Seguro {
	private final int id;
	private Date dataInicio;
	private Date dataFim;
	private Seguradora seguradora;
	private List<Sinistro> listaSinistros;
	private List<Condutor> listaCondutores;
	private double valorMensal;
	
	private int Identificador() {
		UUID uuid = UUID.randomUUID();
		String strUUID = Long.toString(uuid.getMostSignificantBits())
		                   + Long.toString(uuid.getLeastSignificantBits());
		strUUID = strUUID.replaceAll("-", "");
		strUUID = strUUID.substring(0 , 6);
		int  numericUUID = Integer.parseInt(strUUID);
		return numericUUID;
	}
	
	public Seguro(Date dataI , Date dataF, Seguradora Seguradora) {
		this.id = Identificador();
		this.dataInicio = dataI;
		this.dataFim = dataF;
		this.seguradora = Seguradora;
		listaSinistros = new ArrayList<>();
		listaCondutores = new ArrayList<>();
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}

	public int getId() {
		return id;
	}
	
	public List<Sinistro> getSinistro(){
		List <Sinistro> listSinistros = new ArrayList<>();
		for(int i = 0; i< listaSinistros.size();i++) {
			listSinistros.add(listaSinistros.get(i));
		}
		return listSinistros;
	}
	
	public void gerarSinistro(String Data, String Endereco,Condutor Condutor, Seguro Seguro){
			Sinistro sinistro = new Sinistro(Data,Endereco,Condutor,Seguro);
			Condutor.adicionarSinistros(sinistro);
			listaSinistros.add(sinistro);
	}
	
	public Condutor getCondutor(String CPF) {
		Condutor cond = new Condutor(null, null, null, null, null, null);
		for(int i = 0; i < listaCondutores.size();i++) {
			if(listaCondutores.get(i).getCpf().equals(CPF)) {
				cond = listaCondutores.get(i);
			}
		}
		return cond;
	}
	
	public boolean autorizarcondutor(Condutor condutor) {
		if(listaCondutores.contains(condutor)) {
			return false;
		}
		else {
			listaCondutores.add(condutor);
			return true;
		}
	}
	
	public boolean desautorizar_condutor(Condutor condutor) {
		if(listaCondutores.contains(condutor)) {
			listaCondutores.remove(condutor);
			return true;
		}
		else {
			return false;
		}
	}
	
	public int qtdSinistros() {
		return listaSinistros.size();
	}
	
	public int qtdSinistrosCondutor() {
		int soma = 0;
		for(int i = 0; i < listaCondutores.size();i++) {
			soma += listaCondutores.get(i).quantidadeSinistro();
		}
		return soma;
	}
	
	public String infoCondutores() {
		String info = "";
		for(int i = 0 ; i < listaCondutores.size();i++) {
			info += listaCondutores.get(i).getNome() + "-" +listaCondutores.get(i).getCpf();
		}
		return info;
	}
	
	public String infoSinistro() {
		String info = "";
		for(int i = 0 ; i < listaSinistros.size();i++) {
			info += listaSinistros.get(i).getId() + "-";
		}
		return info;
	}
	
	
	public double CalcularValor() {
		return 0.0;
	}
	
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,###.00");
		String informacoes = "ID:" + getId() + "\n" + "Data Inicio:" + formato.format(getDataInicio()) + "\n" 
		+ "Data Fim:" + formato.format(getDataFim()) + "\n" + "Seguradora:"+ getSeguradora().getNome() +
		 "\n" + "Lista de condutores:" + infoCondutores() + "\n" + "Lista de Sinistros:" + infoSinistro() +
		"\n" + "Valor mensal:" + df.format(getValorMensal());
		return informacoes;
		
	}
	

}
