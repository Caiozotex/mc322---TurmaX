package guid;
import java.util.UUID;

	public class Sinistro {
		public int id;
		public String data;
		public String endereco;
		
		public int Identificador() {
			UUID uuid = UUID.randomUUID();
			String strUUID = Long.toString(uuid.getMostSignificantBits())
			                   + Long.toString(uuid.getLeastSignificantBits());
			strUUID = strUUID.replaceAll("-", "");
			strUUID = strUUID.substring(0 , 6);
			int  numericUUID = Integer.parseInt(strUUID);
			return numericUUID;
		}
		
		public Sinistro(String Data, String Endereco) {
			setEnderecoSinistro(Endereco);
			setData(Data);
			this.id = Identificador();
		}
		
		public void setData(String Data) {
			this.data = Data;
		}
		
		public void setEnderecoSinistro(String Endereco) {
			this.endereco = Endereco;
		}
		
		public String getData() {
			return data;
		}
		
		public String getEnderecoSinistro() {
			return endereco;
		}
		
		public int getID() {
			return id;
		}
		
		public String toString() {
			String informacoes = "id:" + getID() + "\n" + "Data:" + getData() + "\n"
			+ "Endereco:" + getEnderecoSinistro();
			return informacoes;
		}
		
	}
