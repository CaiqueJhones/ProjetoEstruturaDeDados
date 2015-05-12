package br.edu.ufrb.estruturadedados.lista;

import br.edu.ufrb.estruturadedados.Estrutura;

/**
 * <p>
 * uma lista ou sequência é uma estrutura de dados abstrata que implementa uma
 * coleção ordenada de valores, onde o mesmo valor pode ocorrer mais de uma vez.
 * Uma instância de uma lista é uma representação computacional do conceito
 * matemático de uma sequência finita, que é, uma tupla. Cada instância de um
 * valor na lista normalmente é chamado de um item, entrada ou elemento da
 * lista. Se o mesmo valor ocorrer várias vezes, cada ocorrência é considerada
 * um item distinto.
 * </p>
 * 
 * @author Caique
 *
 * @param <T> Tipo de objetos da lista.
 * @since 1.0
 */
public interface Lista<T> extends Estrutura<T> {

	/**
	 * Adicona novo elemento no final da lista.
	 * 
	 * @param object
	 */
	void add(T object);

	/**
	 * Adicona novo elemento em uma determinada posição.
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
	 * Remove pelo index específico;
	 * 
	 * @param index
	 */
	void remove(int index);

	/**
	 * Remove um elemento específico.
	 * 
	 * @param object
	 *            elemento a ser eliminado.
	 */
	void remove(T object);
	
	/**
	 * Exibe na saída padrão todos os itens da lista.
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
	 * Devolve os elementos em forma de vetor
	 * 
	 * @param array
	 * @return
	 */
	T[] toArray(T[] array);

}
