import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class ArquivoClientePJ implements I_Arquivo{
	
	public String lerArquivo() throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/clientesPJ.csv";
		String mensage = "\n";
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			br.readLine();
			String linha; 
			while( (linha = br.readLine()) != null){
				String[] campos = linha.split(",");
				String cnpj = campos[0];
				String nome = campos[1];
				String telefone = campos[2];
				String endereco = campos[3];
				String email = campos[4];
				String dataF = campos[5];
				String code = campos[6];
				mensage += ("CNPJ:" + cnpj + "\n");
				mensage += ("Nome:" + nome + "\n");
				mensage += ("Telefone:" + telefone + "\n");
				mensage += ("Endereço:" + endereco + "\n");
				mensage += ("Email:" + email + "\n");
				mensage += ("Data de Fundação:" + dataF + "\n");
				mensage += ("Código da Frota:" + code + "\n");
			}
		}
		catch(IOException e){
			mensage = "Houve um erro" + e;
		}
		return mensage;
	}
	
	
	public List<Cliente> infoArquivo() throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/clientesPJ.csv";
		List<Frota> listaFrotas = new ArrayList<>();
		List<Cliente> listaClientes = new ArrayList<>();
		ArquivoFrota teste = new ArquivoFrota();
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			br.readLine();
			String linha; 
			while( (linha = br.readLine()) != null){
				String[] campos = linha.split(",");
				String cnpj = campos[0];
				String nome = campos[1];
				String telefone = campos[2];
				String endereco = campos[3];
				String email = campos[4];
				String dataF = campos[5];
				String code = campos[6];
				ClientePJ cliente = new ClientePJ(nome,telefone,endereco,
				email,cnpj,formato.parse(dataF),0); 
				listaFrotas = teste.infoArquivo();
				for(int i = 0; i < listaFrotas.size();i++) {
					if(listaFrotas.get(i).getCode().equals(code)) {
						cliente.cadastrarFrota(listaFrotas.get(i));
						cliente.setQtdefuncionarios(listaFrotas.get(i).qtdeVeiculos());
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
		String caminho = "lab06-seguradora_arquivos_v2/clientesPJ.csv";
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
