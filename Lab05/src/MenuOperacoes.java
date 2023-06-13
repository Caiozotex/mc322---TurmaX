
public enum MenuOperacoes {
	CADASTROS(1),
	LISTAR(2),
	EXCLUIR(3),
	GERAR_SINISTRO(4),
	CALCULAR_RECEITA_SEGURADORA(5),
	SAIR(0),;
	
	public final int operacao;
	
	MenuOperacoes(int Operacao){
		this.operacao = Operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}
}
