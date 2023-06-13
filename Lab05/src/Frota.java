
import java.util.ArrayList;
import java.util.List;

public class Frota {
	private String code;
	private List<Veiculo> listaVeiculos;
	
	public Frota(String Code) {
		this.code = Code;
		listaVeiculos = new ArrayList<>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public boolean addVeiculo(Veiculo veiculo) {
		if(listaVeiculos.contains(veiculo) == false) {
			listaVeiculos.add(veiculo);
		}
		return true;
	}
	
	public boolean removeVeiculo(String placa) {
		for(int i = 0; i < listaVeiculos.size();i++) {
			if(listaVeiculos.get(i).getPlaca().equals(placa)) {
				listaVeiculos.remove(i);
			}
		}
		return true;
	}
	
	public Veiculo getCarro(String placa) {
		Veiculo carro = new Veiculo(null,null,null,0);
		for(int i = 0; i < listaVeiculos.size();i++) {
			if(listaVeiculos.get(i).getPlaca().equals(placa)) {
				carro = listaVeiculos.get(i);
			}
		}
		return carro;
	}
	
	public void getVeiculos() {
		System.out.println(listaVeiculos.toString());
	}
	
	public int qtdeVeiculos() {
		return listaVeiculos.size();
	}
	
	public String toString() {
		String informacoes = "Código:" + getCode()+ "\n" + "Lista de veiculos:" + listaVeiculos.toString();
		return informacoes;
		
	}

}
