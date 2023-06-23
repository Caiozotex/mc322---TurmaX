
public enum MenuOperacoes {
	LER_DADOS_INICIAIS(1),
	CADASTROS(2),
	LISTAR(3),
	EXCLUIR(4),
	GERAR_SINISTRO(5),
	CALCULAR_RECEITA_SEGURADORA(6),
	GRAVAR_DADOS(7),
	SAIR(0);
	
	public final int operacao;
	
	MenuOperacoes(int Operacao){
		this.operacao = Operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}
}
