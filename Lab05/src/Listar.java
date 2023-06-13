
public enum Listar {
	LISTAR_CLIENTE_PF_SEG(1),
	LISTAR_CLIENTE_PJ_SEG(2),
	LISTAR_SEGURO_CLIENTE(3),
	LISTAR_SINISTRO_CLIENTE(4),
	LISTAR_VEICULO_CLIENTE(5),
	LISTAR_VEICULO_FROTA(6),
	VOLTAR(0);
	
	
	public final int operacao;
	
	Listar(int Operacao){
		this.operacao = Operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}
	


}
