
public enum Listar {
	LISTAR_CLIENTE_PF_SEG(1),
	LISTAR_CLIENTE_PJ_SEG(2),
	LISTAR_SINISTRO_SEGURADORA(3),
	LISTAR_SINISTRO_CLIENTE(4),
	LISTAR_VEICULO_CLIENTE(5),
	LISTAR_VEICULO_SEGURADORA(6),
	VOLTAR(7);
	
	
	public final int operacao;
	
	Listar(int Operacao){
		this.operacao = Operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}
	


}
