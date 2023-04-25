import java.util.UUID;

public class Sinistro {
	private final int id;
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	
	public int Identificador() {
		UUID uuid = UUID.randomUUID();
		String strUUID = Long.toString(uuid.getMostSignificantBits())
		                   + Long.toString(uuid.getLeastSignificantBits());
		strUUID = strUUID.replaceAll("-", "");
		strUUID = strUUID.substring(0 , 6);
		int  numericUUID = Integer.parseInt(strUUID);
		return numericUUID;
	}
	
	
	public Sinistro(String Data, String Endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		this.id = Identificador();
		this.data = Data;
		this.endereco = Endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		String informacoes = "ID :" + getId() + "\n" + "Data:" + getData()
		+ "\n" + "Endereço:" + getEndereco() + "\n" + "Veiculo:" + "\n" +
		getVeiculo() + "\n" + "Cliente:" + "\n" + getCliente();
		return informacoes;
	}
	
	
	
}
