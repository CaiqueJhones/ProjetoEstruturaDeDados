package br.edu.ufrb.estruturadedados.lista;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * A pilha é uma estrutura de dados baseada no princípio LIFO (LAST in, FIRST
 * out), na qual os dados que foram inseridos primeiros na pilha serão os
 * últimos a serem removidos. Existem duas funções que se aplicam a todas as
 * pilhas: PUSH, que insere um dado no topo da pilha, e POP, que remove o item
 * no topo da pilha.
 * </p>
 * 
 * @author Caique
 *
 * @param <T> Tipo de Objeto da Pilha.
 * @since 1.0
 * @see {@link Lista}
 */
public class Pilha<T> implements Iterable<T>, Serializable {

	private static final long serialVersionUID = -461118081168641022L;
	private Lista<T> data;
	
	/**
	 * Inicializa uma lista interna.
	 */
	public Pilha() {
		data = new ListaSimplesEncadeada<T>();
	}
	
	/**
	 * Adiciona um objeto a <code>Pilha</code>.
	 * @param value o Objeto a ser adiconado na <code>Pilha</code>
	 * @see {@link Lista#add(Object)}
	 */
	public void push(T value) {
		data.add(value);
	}
	
	/**
	 * Recupera um elemento da pilha
	 * @param index posição do elemento na <code>Pilha</code>.
	 * @return o Obejto da determinada posição.
	 * @see {@link List#get(int)}
	 */
	public T get(int index) {
		return data.get(index);
	}
	
	/**
	 * Remove um elemento da <code>Pilha</code>.
	 * @return o Objeto removido.
	 * @see {@link Lista#remove(int)}
	 */
	public T pop() {
		if (isEmpty())
			return null;
		T e = data.get(size() - 1);
		data.remove(size() - 1);
		return e;
	}
	
	/**
	 * Retorna o tamanho da <code>Pilha</code>.
	 * @return o tamanho da <code>Pilha</code>.
	 * @see {@link Lista#size()}
	 */
	public int size() {
		return data.size();
	}
	
	/**
	 * Verifica se a pilha se encontra vazia.
	 * @return <code>true<</code> se <code>Pilha</code> estiver vazia.
	 * @see {@link Lista#isEmpty()}
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/**
	 * Exibe todos os itens da <code>Pilha</code> na saída padrão.
	 * @see {@link Lista#exibeLista()}
	 */
	public void exibeFila() {
		data.exibeLista();
	}

	@Override
	public Iterator<T> iterator() {
		return data.iterator();
	}

}
