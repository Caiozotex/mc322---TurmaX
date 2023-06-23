import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ArquivoCondutor implements I_Arquivo {
	
	public String lerArquivo() throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/condutores.csv";
		String mensage = "\n";
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			br.readLine();
			String linha; 
			while( (linha = br.readLine()) != null){
				String[] campos = linha.split(",");
				String cpf = campos[0];
				String nome = campos[1];
				String telefone = campos[2];
				String endereco = campos[3];
				String email = campos[4];
				String dataN = campos[5];
				mensage += ("CPF:" + cpf + "\n");
				mensage += ("Name:" + nome + "\n");
				mensage += ("Telefone:" + telefone + "\n");
				mensage += ("Endereço:" + endereco + "\n");
				mensage += ("Email:" + email + "\n");
				mensage += ("Data de Nascimento:" + dataN + "\n");
			}
		}
		catch(IOException e){
			mensage = "Houve um erro" + e;
		}
		return mensage;
	}
	
	public List<Condutor> infoArquivo() throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/condutores.csv";
		List<Condutor> listaCondutor = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			br.readLine();
			String linha; 
			while( (linha = br.readLine()) != null){
				String[] campos = linha.split(",");
				String cpf = campos[0];
				String nome = campos[1];
				String telefone = campos[2];
				String endereco = campos[3];
				String email = campos[4];
				String dataN = campos[5];
				Condutor condutor = new Condutor(cpf,nome,telefone,endereco,email,formato.parse(dataN));
				listaCondutor.add(condutor);
			}
		}
		catch(IOException e){
			System.out.println("Houve um erro" + e);
		}
		return listaCondutor;
	}
	
	public boolean gravarArquivo(String dados) throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/condutores.csv";
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
