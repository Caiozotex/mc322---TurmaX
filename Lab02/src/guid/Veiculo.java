package guid;
	public class Veiculo {
		private String marca;
		private String placa;
		private String modelo;
		
		public Veiculo(String Marca, String Placa , String Modelo) {
			setMarca(Marca);
			setPlaca(Placa);
			setModelo(Modelo);
		}
		
		public void setMarca(String Marca) {
			this.marca = Marca;
		}
		
		public void setPlaca(String Placa) {
			this.placa = Placa;
		}
		
		public void setModelo(String Modelo) {
			this.modelo = Modelo;
		}
		
		public String getMarca() {
			return marca;
		}
		
		public String getPlaca(){
			return placa;
		}
		
		public String getModelo() {
			return modelo;
		}
		
		public String toString() {
			String informacoes = "Marca:" + getMarca() + "\n" + "Placa:" + getPlaca() + "\n"
			+ "Modelo:" + getModelo() + "\n";
			return informacoes;
		}
	
	}
