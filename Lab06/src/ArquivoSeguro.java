import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoSeguro implements I_Arquivo{
	
	public String lerArquivo() throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/Seguros.csv";
		String mensage = "\n";
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			br.readLine();
			String linha; 
			while( (linha = br.readLine()) != null) {
				String[] campos = linha.split(",");
				String code = campos[0];
				String dataInicio = campos[1];
				String dataFim = campos[2];
				String name = campos[3];
				String Id = campos[4];
				String cpfs = campos[5];
				String valor = campos[6];
				mensage += ("Id do Seguro:" + code + "\n");
				mensage += ("Data de Inicio:" + dataInicio + "\n");
				mensage += ("Data de Término:" + dataFim + "\n");
				mensage += ("Nome da Seguradora:" + name + "\n");
				mensage += ("Id's dos Sinistrros:" + Id + "\n");
				mensage += ("Cpf's dos Condutores :" + cpfs + "\n");
				mensage += ("Valor Mensal:" + valor + "\n");
			}
		}
		catch(IOException e){
			mensage = "Houve um erro" + e;
		}
		return mensage;
	}
	
	public boolean gravarArquivo(String dados) throws Exception {
		String caminho = "lab06-seguradora_arquivos_v2/Seguros.csv";;
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
