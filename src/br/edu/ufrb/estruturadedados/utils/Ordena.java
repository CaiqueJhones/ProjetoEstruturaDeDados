package br.edu.ufrb.estruturadedados.utils;

/**
 * <p>
 * Possui m�todos est�ticos para ordena��o de vetores que implementam a
 * interface java.lang.Comparable. 
 * </p>
 * @author Caique
 * @since API-1.0
 * @see {@link java.lang.Comparable}.
 */
public final class Ordena {

	private Ordena() {

	}

	/**
	 * <p>
	 * <strong>Bubble sort</strong> � o algoritmo mais simples, mas o menos
	 * eficientes. Neste algoritmo cada elemento da posi��o i ser� comparado com
	 * o elemento da posi��o i + 1, ou seja, um elemento da posi��o 2 ser�
	 * comparado com o elemento da posi��o 3. Caso o elemento da posi��o 2 for
	 * maior que o da posi��o 3, eles trocam de lugar e assim sucessivamente.
	 * Por causa dessa forma de execu��o, o vetor ter� que ser percorrido
	 * quantas vezes que for necess�ria, tornando o algoritmo ineficiente para
	 * listas muito grandes.
	 * </p>
	 * 
	 * @param vector
	 *            Vetor que ser� ordenado.
	 */
	public static <T extends Comparable<T>> void bubbleSort(T[] vector) {
		T aux;
		for (int i = 0; i < vector.length; i++) {
			for (int j = 0; j < vector.length - 1; j++) {
				if (vector[j].compareTo(vector[j + 1]) > 0) {
					aux = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = aux;
				}
			}
		}
	}

	/**
	 * <p>
	 * Este algoritmo � baseado em se passar sempre o menor valor do vetor para
	 * a primeira posi��o (ou o maior dependendo da ordem requerida), depois o
	 * segundo menor valor para a segunda posi��o e assim sucessivamente, at� os
	 * �ltimos dois elementos.
	 * </p>
	 * 
	 * <p>
	 * Neste algoritmo de ordena��o � escolhido um n�mero a partir do primeiro,
	 * este n�mero escolhido � comparado com os n�meros a partir da sua direita,
	 * quando encontrado um n�mero menor, o n�mero escolhido ocupa a posi��o do
	 * menor n�mero encontrado. Este n�mero encontrado ser� o pr�ximo n�mero
	 * escolhido, caso n�o for encontrado nenhum n�mero menor que este
	 * escolhido, ele � colocado na posi��o do primeiro n�mero escolhido, e o
	 * pr�ximo n�mero � sua direita vai ser o escolhido para fazer as
	 * compara��es. � repetido esse processo at� que a lista esteja ordenada.
	 * </p>
	 * 
	 * @param vector
	 *            Vetor que ser� ordenado.
	 */
	public static <T extends Comparable<T>> void selectionSort(T[] vector) {
		for (int i = 0; i < vector.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < vector.length; j++)
				if (vector[j].compareTo(vector[index]) < 0)
					index = j;

			T smallerNumber = vector[index];
			vector[index] = vector[i];
			vector[i] = smallerNumber;
		}
	}

	/**
	 * <p>
	 * O Insertion sort � um algoritmo simples e eficiente quando aplicado em
	 * pequenas listas. Neste algoritmo a lista � percorrida da esquerda para a
	 * direita, � medida que avan�a vai deixando os elementos mais � esquerda
	 * ordenados.
	 * </p>
	 * 
	 * <p>
	 * O algoritmo funciona da mesma forma que as pessoas usam para ordenar
	 * cartas em um jogo de baralho como o p�quer.
	 * </p>
	 * 
	 * @param vector
	 *            Vetor que ser� ordenado.
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] vector) {
		for (int i = 1; i < vector.length; i++) {
			T temp = vector[i];
			int j;
			for (j = i - 1; j >= 0 && temp.compareTo(vector[j]) < 0; j--)
				vector[j + 1] = vector[j];
			vector[j + 1] = temp;
		}
	}

}
