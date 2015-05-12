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
	 * Verifica se est� vazio
	 * 
	 * @return <code>true</code> se v�zio.
	 */
	boolean isEmpty();
	/**
	 * 
	 * @return O n�mero de elementos da estrutura.
	 */
	int size();

}
