package br.univel.minhaarvore;

import br.univel.meustestes.Conta;

public class UniArvoreImpl<T> implements UniArvore<T> {

	private T raiz;

	public UniArvoreImpl(T noRaiz) {
		this.raiz = noRaiz;
	}

	@Override
	public void mostrarTodosConsole() {
		printRecursivo(0, raiz);
	}

	private void printRecursivo(int level, T node) {
		UniNode<Conta> nodeConta = (UniNode<Conta>) node;
		
		
		String space = "";
		for(int i = 0 ; i < level; i++){
			space += " ";
		}
		
		
		System.out.println( space + nodeConta.getConteudo().getNome() );

		
		if(!nodeConta.isLeaf()){
			for (UniNode<Conta> uniNodeFilho : nodeConta.getFilhos()) {
				printRecursivo(level + 1, (T) uniNodeFilho);
			}
		}
		
	}

	@Override
	public T getNoRaiz() {
		return raiz;
	}
	
}
