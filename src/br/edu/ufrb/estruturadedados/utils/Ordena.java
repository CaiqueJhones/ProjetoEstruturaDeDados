package br.edu.ufrb.estruturadedados.utils;

/**
 * <p>
 * Possui métodos estáticos para ordenação de vetores que implementam a
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
	 * <strong>Bubble sort</strong> é o algoritmo mais simples, mas o menos
	 * eficientes. Neste algoritmo cada elemento da posição i será comparado com
	 * o elemento da posição i + 1, ou seja, um elemento da posição 2 será
	 * comparado com o elemento da posição 3. Caso o elemento da posição 2 for
	 * maior que o da posição 3, eles trocam de lugar e assim sucessivamente.
	 * Por causa dessa forma de execução, o vetor terá que ser percorrido
	 * quantas vezes que for necessária, tornando o algoritmo ineficiente para
	 * listas muito grandes.
	 * </p>
	 * 
	 * @param vector
	 *            Vetor que será ordenado.
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
	 * Este algoritmo é baseado em se passar sempre o menor valor do vetor para
	 * a primeira posição (ou o maior dependendo da ordem requerida), depois o
	 * segundo menor valor para a segunda posição e assim sucessivamente, até os
	 * últimos dois elementos.
	 * </p>
	 * 
	 * <p>
	 * Neste algoritmo de ordenação é escolhido um número a partir do primeiro,
	 * este número escolhido é comparado com os números a partir da sua direita,
	 * quando encontrado um número menor, o número escolhido ocupa a posição do
	 * menor número encontrado. Este número encontrado será o próximo número
	 * escolhido, caso não for encontrado nenhum número menor que este
	 * escolhido, ele é colocado na posição do primeiro número escolhido, e o
	 * próximo número à sua direita vai ser o escolhido para fazer as
	 * comparações. É repetido esse processo até que a lista esteja ordenada.
	 * </p>
	 * 
	 * @param vector
	 *            Vetor que será ordenado.
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
	 * O Insertion sort é um algoritmo simples e eficiente quando aplicado em
	 * pequenas listas. Neste algoritmo a lista é percorrida da esquerda para a
	 * direita, à medida que avança vai deixando os elementos mais à esquerda
	 * ordenados.
	 * </p>
	 * 
	 * <p>
	 * O algoritmo funciona da mesma forma que as pessoas usam para ordenar
	 * cartas em um jogo de baralho como o pôquer.
	 * </p>
	 * 
	 * @param vector
	 *            Vetor que será ordenado.
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
