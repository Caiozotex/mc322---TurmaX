import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ArquivoVeiculo implements I_Arquivo {
	
	public String lerArquivo() throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/veiculos.csv";
		String mensage = "\n";
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			br.readLine();
			String linha; 
			while( (linha = br.readLine()) != null){
				String[] campos = linha.split(",");
				String placa = campos[0];
				String marca = campos[1];
				String modelo = campos[2];
				String ano = campos[3];
				mensage += ("Placa:" + placa + "\n");
				mensage += ("Marca:" + marca + "\n");
				mensage += ("Modelo:" + modelo + "\n");
				mensage += ("Ano:" + ano + "\n");
			}
		}
		catch(IOException e){
			mensage = "Houve um erro" + e; //ver depois
		}
		return mensage;
	}
	
	public List<Veiculo> infoArquivo() throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/veiculos.csv";
		List<Veiculo> listaVeiculos = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			br.readLine();
			String linha; 
			while( (linha = br.readLine()) != null){
				String[] campos = linha.split(",");
				String placa = campos[0];
				String marca = campos[1];
				String modelo = campos[2];
				String ano = campos[3];
				Veiculo carro = new Veiculo(placa,marca,modelo,Integer.parseInt(ano));
				listaVeiculos.add(carro);
			}
		}
		catch(IOException e){
			System.out.println("Houve um erro" + e);
		}
		return listaVeiculos;
	}
	
	
	public boolean gravarArquivo(String dados) throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/veiculos.csv";
		try(BufferedWriter br = new BufferedWriter(new FileWriter(caminho))){
			br.write(dados);
			br.write("\n");
			return true;
		}
		catch(IOException e){
			System.out.println("Houve um erro" + e);
			return false;
		}
	}
}
