import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoFrota implements I_Arquivo{
	public String lerArquivo() throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/frotas.csv";
		String mensage = "\n";
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			br.readLine();
			String linha; 
			while( (linha = br.readLine()) != null){
				String[] campos = linha.split(",");
				String code = campos[0];
				String placa1 = campos[1];
				String placa2 = campos[2];
				String placa3 = campos[3];
				mensage += ("Id da Frota:" + code + "\n");
				mensage += ("Placa do Veiculo 1:" + placa1 + "\n");
				mensage += ("Placa do Veiculo 2:" + placa2 + "\n");
				mensage += ("Placa do Veiculo 3:" + placa3 + "\n");
				
			}
		}
		catch(IOException e){
			mensage = "Houve um erro" + e;
		}
		return mensage;
	}
	
	
	
	public List<Frota> infoArquivo() throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/frotas.csv";
		List<Frota> listaFrotas = new ArrayList<>();
		List<Veiculo> listaVeiculos = new ArrayList<>();
		ArquivoVeiculo teste = new ArquivoVeiculo();
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			br.readLine();
			String linha; 
			while( (linha = br.readLine()) != null){
				String[] campos = linha.split(",");
				String code = campos[0];
				String placa1 = campos[1];
				String placa2 = campos[2];
				String placa3 = campos[3];
				Frota frota = new Frota(code);
				listaVeiculos = teste.infoArquivo();
				for(int i = 0; i < listaVeiculos.size();i++) {
					if(listaVeiculos.get(i).getPlaca().equals(placa1)) {
						frota.addVeiculo(listaVeiculos.get(i));
					}
					else if(listaVeiculos.get(i).getPlaca().equals(placa2)) {
						frota.addVeiculo(listaVeiculos.get(i));
					}
					else if(listaVeiculos.get(i).getPlaca().equals(placa3)) {
						frota.addVeiculo(listaVeiculos.get(i));
					}
				}
				listaFrotas.add(frota);
			}
		}
		catch(IOException e){
			System.out.println("Houve um erro" + e);
		}
		return listaFrotas;
	}
	
	public boolean gravarArquivo(String dados) throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/frotas.csv";
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
