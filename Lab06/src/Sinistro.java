
import java.util.UUID;

public class Sinistro {
	private final int id;
	private String data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	
	
	
	private int Identificador() {
		UUID uuid = UUID.randomUUID();
		String strUUID = Long.toString(uuid.getMostSignificantBits())
		                   + Long.toString(uuid.getLeastSignificantBits());
		strUUID = strUUID.replaceAll("-", "");
		strUUID = strUUID.substring(0 , 6);
		int  numericUUID = Integer.parseInt(strUUID);
		return numericUUID;
	}
	
	
	public Sinistro(String Data, String Endereco,Condutor Condutor, Seguro Seguro){
		this.id = Identificador();
		this.data = Data;
		this.endereco = Endereco;
		this.condutor = Condutor;
		this.seguro = Seguro;
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

	
	public int getId() {
		return id;
	}
	
	
	
	public Condutor getCondutor() {
		return condutor;
	}


	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}


	public Seguro getSeguro() {
		return seguro;
	}


	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}


	public String toString() {
		String informacoes = "ID :" + getId() + "\n" + "Data:" + getData()
		+ "\n" + "Endereço:" + getEndereco() + "\n" + "Condutor:" + getCondutor().getNome() + "-" + getCondutor().getCpf()
		+ "\n" + "Seguro:" + getSeguro().getId();
		return informacoes;
	}
	
}
