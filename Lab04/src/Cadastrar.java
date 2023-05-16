
public enum Cadastrar {
	CADASTRAR_CLIENTE_PF(1),
	CADASTRAR_CLIENTE_PJ(2),
	CADASTRAR_VEICULO(3),
	CADASTRAR_SEGURADORA(4),
	VOLTAR(5);
	
	
	public final int operacao;
	
	Cadastrar(int Operacao){
		this.operacao = Operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}
	

}
