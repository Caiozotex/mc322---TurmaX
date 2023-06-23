
public enum Cadastrar {
	CADASTRAR_CLIENTE_PF(1),
	CADASTRAR_CLIENTE_PJ(2),
	CADASTRAR_VEICULO(3),
	CADASTRAR_SEGURADORA(4),
	CADASTRAR_SEGURO_PF(5),
	CADASTAR_SEGURO_PJ(6),
	CADASTRAR_CONDUTOR(7),
	CADASTRAR_FROTA(8),
	VOLTAR(0);
	
	
	public final int operacao;
	
	Cadastrar(int Operacao){
		this.operacao = Operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}
	

}
