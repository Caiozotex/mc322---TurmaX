
public enum Excluir {
	EXCLUIR_CLIENTE(1),
	EXCLUIR_VEICULO_PF(2),
	EXCLUIR_VEICULO_PJ(3),
	EXCLUIR_SEGURO(4),
	EXCLUIR_FROTA(5),
	EXCLUIR_CONDUTOR(6),
	VOLTAR(0);
	
	
	public final int operacao;
	
	Excluir(int Operacao){
		this.operacao = Operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}
	
}
