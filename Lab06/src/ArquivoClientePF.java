import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class ArquivoClientePF implements I_Arquivo {

	public String lerArquivo() throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/clientesPF.csv";
		String mensage = "\n";
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			String linha; 
			br.readLine();
			while( (linha = br.readLine()) != null){
				String[] campos = linha.split(",");
				String cpf = campos[0];
				String nome = campos[1];
				String telefone = campos[2];
				String endereco = campos[3];
				String email = campos[4];
				String sexo = campos[5];
				String ensino = campos[6];
				String dataN = campos[7];
				mensage += ("CPF:" + cpf + "\n");
				mensage += ("Nome:" + nome + "\n");
				mensage += ("Telefone:" + telefone + "\n");
				mensage += ("Endereço:" + endereco + "\n");
				mensage += ("Email:" + email + "\n");
				mensage += ("Sexo:" + sexo + "\n");
				mensage += ("Ensino:" + ensino + "\n");
				mensage += ("Data de Nascimento:" + dataN + "\n");
			}
		}
		catch(IOException e){
			mensage = "Houve um erro" + e;
		}
		return mensage;
	}
	
	
	public List<Cliente> infoArquivo() throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/clientesPF.csv";
		List<Cliente> listaClientes = new ArrayList<>();
		List<Veiculo> listaVeiculos = new ArrayList<>();
		ArquivoVeiculo teste = new ArquivoVeiculo();
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
				String sexo = campos[5];
				String ensino = campos[6];
				String dataN = campos[7];
				String placa = campos[8];
				ClientePF cliente = new ClientePF(nome,telefone,endereco,
				email,ensino,sexo,cpf,formato.parse(dataN));
				listaVeiculos = teste.infoArquivo();
				for(int i = 0; i < listaVeiculos.size();i++) {
					if(listaVeiculos.get(i).getPlaca().equals(placa)) {
						cliente.cadastrarVeiculo(listaVeiculos.get(i));
					}
				}
				listaClientes.add(cliente);
			}
		}
		catch(IOException e){
			System.out.println("Houve um erro" + e);
		}
		return listaClientes;
	}
	
	
	public boolean gravarArquivo(String dados) throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/clientesPF.csv";
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
