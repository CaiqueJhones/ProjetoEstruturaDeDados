package br.edu.ufrb.estruturadedados.lista;

public interface Lista<T> extends Iterable<T> {
	
	/**
	 * Adicona novo elemento no final da lista.
	 * @param object
	 */
	void add(T object);
	
	/**
	 * Adicona novo elemento em uma determinada posi��o.
	 * @param object
	 */
	void add(int index, T object);
	
	/**
	 * Recupera um elemento pelo index.
	 * @param index
	 * @return
	 */
	T get(int index);
	
	/**
	 * Remove pelo index espec�fico;
	 * @param index
	 */
	void remove(int index);
	
	/**
	 * Remove um elemento espec�fico.
	 * @param object elemento a ser eliminado.
	 */
	void remove(T object);
	
	/**
	 * 
	 * @return O tamanho da lista.
	 */
	int size();
	
	void exibeLista();
	
	/**
	 * Preenche com elementos de outra lista.
	 * @param list
	 */
	void fill(Lista<T> list);
	
	/**
	 * Apaga todas as informa��es.
	 */
	void clear();
	
	/**
	 * Devolve os dados em forma de vetor
	 * @param array
	 * @return
	 */
	T[] toArray(T[] array);
	
}
