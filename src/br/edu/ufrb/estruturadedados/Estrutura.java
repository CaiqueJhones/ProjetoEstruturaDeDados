/**
 * 
 */
package br.edu.ufrb.estruturadedados;

/**
 * @author Caique
 *
 */
public interface Estrutura<T> extends Iterable<T>{
	
	/**
	 * Verifica se está vazio
	 * 
	 * @return <code>true</code> se vázio.
	 */
	boolean isEmpty();
	/**
	 * 
	 * @return O número de elementos da estrutura.
	 */
	int size();

}
