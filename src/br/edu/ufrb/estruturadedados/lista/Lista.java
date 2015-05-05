package br.edu.ufrb.estruturadedados.lista;

/**
 * <p>
 * uma lista ou sequ�ncia � uma estrutura de dados abstrata que implementa uma
 * cole��o ordenada de valores, onde o mesmo valor pode ocorrer mais de uma vez.
 * Uma inst�ncia de uma lista � uma representa��o computacional do conceito
 * matem�tico de uma sequ�ncia finita, que �, uma tupla. Cada inst�ncia de um
 * valor na lista normalmente � chamado de um item, entrada ou elemento da
 * lista. Se o mesmo valor ocorrer v�rias vezes, cada ocorr�ncia � considerada
 * um item distinto.
 * </p>
 * 
 * @author Caique
 *
 * @param <T> Tipo de objetos da lista.
 * @since 1.0
 */
public interface Lista<T> extends Iterable<T> {

	/**
	 * Adicona novo elemento no final da lista.
	 * 
	 * @param object
	 */
	void add(T object);

	/**
	 * Adicona novo elemento em uma determinada posi��o.
	 * 
	 * @param object
	 */
	void add(int index, T object);

	/**
	 * Recupera um elemento pelo index.
	 * 
	 * @param index
	 * @return
	 */
	T get(int index);

	/**
	 * Remove pelo index espec�fico;
	 * 
	 * @param index
	 */
	void remove(int index);

	/**
	 * Remove um elemento espec�fico.
	 * 
	 * @param object
	 *            elemento a ser eliminado.
	 */
	void remove(T object);

	/**
	 * 
	 * @return O tamanho da lista.
	 */
	int size();
	
	/**
	 * Exibe na sa�da padr�o todos os itens da lista.
	 */
	void exibeLista();

	/**
	 * Preenche com elementos de outra lista.
	 * 
	 * @param list
	 */
	void fill(Lista<T> list);

	/**
	 * Remove todos os elementos da <code>Lista</code>.
	 */
	void clear();

	/**
	 * Verifica se est� vazio
	 * 
	 * @return <code>true</code> se v�zio.
	 */
	boolean isEmpty();

	/**
	 * Devolve os elementos em forma de vetor
	 * 
	 * @param array
	 * @return
	 */
	T[] toArray(T[] array);

}
