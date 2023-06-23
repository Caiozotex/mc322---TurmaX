import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoSinistro implements I_Arquivo {
	
	public String lerArquivo() throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/Sinistros.csv";
		String mensage = "\n";
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			br.readLine();
			String linha; 
			while( (linha = br.readLine()) != null) {
				String[] campos = linha.split(",");
				String Id = campos[0];
				String data = campos[1];
				String endereco = campos[2];
				String cpf = campos[3];
				String code = campos[4];
				mensage += ("ID do Sinistro:" + Id + "\n");
				mensage += ("Data do Acidente:" + data + "\n");
				mensage += ("Enderço do Acidente" + endereco + "\n");
				mensage += ("CPF do Condutor:" + cpf + "\n");
				mensage += ("Código do Seguro:" + code + "\n");
			}
		}
		catch(IOException e){
			mensage = "Houve um erro" + e;
		}
		return mensage;
	}
	
	
	public boolean gravarArquivo(String dados) throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/Sinistros.csv";;
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
