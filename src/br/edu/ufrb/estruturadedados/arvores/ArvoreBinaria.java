package br.edu.ufrb.estruturadedados.arvores;

/**
 * <p>
 * Uma árvore é uma estrutura de dados em que cada elemento tem um ou mais
 * elementos associados, podendo definir-se uma árvore recursivamente como:
 * </p>
 * 
 * <ol>
 * <li>uma estrutura (uma árvore);</li>
 * <li>um nó (designado por raiz), que contém a informação a armazenar e um
 * conjunto finito de árvores (as sub-árvores).</li>
 * </ol>
 * 
 * <p>
 * A Árvore é composta por 1 (um) Elemento principal chamado Raiz, que possui
 * ligações para outros Elementos, que são denominados de Ramos ou filhos. Estes
 * ramos levam a outros elementos que também possuem outros ramos. O elemento
 * que não possui ramos é conhecido como Folha e/ou Nó-terminal.
 * </p>
 * 
 * <p>
 * O número máximo de ramos em um elemento é chamado Ordem da Árvore. Uma árvore
 * binária é aquela de ordem 2, i.e., em que cada elemento possui no máximo 2
 * ramos.
 * </p>
 * 
 * <p>
 * Uma das operações importantes consiste em percorrer cada elemento da árvore
 * uma única vez. Esse percurso, também chamado de travessia da árvore, pode ser
 * feito em pré-ordem (os filhos de um nó são processados após o nó) ou em
 * pós-ordem (os filhos são processados antes do nó). Em árvores binárias é
 * possível ainda fazer uma travessia em-Ordem, em que se processa o filho à
 * esquerda, o nó, e finalmente o filho à direita.
 * </p>
 * 
 * @author Caique
 *
 * @param <T>
 *            Tipo de Objeto armazenado na Árvore.
 * @since 1.0
 */
public class ArvoreBinaria<T extends Comparable<T>> {
	/**
	 * Nó inicial, chamado de raíz da <code>Árvore</p>.
	 */
	public Nodo root;
	private int size;

	public ArvoreBinaria() {
	}

	/**
	 * Adiciona um elemento na <code>Árvore</p>.
	 * 
	 * @param value
	 *            Objeto que será armazenado.
	 */
	public void add(T value) {
		Nodo novo = new Nodo(value);
		if (root == null)
			root = novo;
		else
			add(root, novo);
		size++;
	}

	private Nodo add(Nodo atual, Nodo novo) {
		if (atual != null) {
			if (novo.value.compareTo(atual.value) > 0
					|| novo.value.compareTo(atual.value) == 0) {
				atual.direita = add(atual.direita, novo);
			} else if (novo.value.compareTo(atual.value) < 0)
				atual.esquerda = add(atual.esquerda, novo);
			else
				return null;
		} else {
			atual = novo;
		}
		return atual;
	}

	/**
	 * Exibe os elementos da raíz até as folhas na saída padrão.
	 * 
	 * @param n
	 *            elemento da raíz da
	 *            <code>Árvore</p>, passe a varíavel publica root.
	 */
	public void preOrdem(Nodo n) {
		if (n == null)
			return;
		System.out.println(n.value);
		preOrdem(n.esquerda);
		preOrdem(n.direita);
	}

	/**
	 * Exibe os elementos em ordem crescente na saída padrão.
	 * 
	 * @param n
	 *            elemento da raíz da
	 *            <code>Árvore</p>, passe a varíavel publica root.
	 */
	public void emOrdem(Nodo n) {
		if (n == null)
			return;
		emOrdem(n.esquerda);
		System.out.println(n.value);
		emOrdem(n.direita);
	}

	/**
	 * Exibe os elementos das folhas até a raíz na saída padrão.
	 * 
	 * @param n
	 *            elemento da raíz da
	 *            <code>Árvore</p>, passe a varíavel publica root.
	 */
	public void posOrdem(Nodo n) {
		if (n == null)
			return;
		posOrdem(n.esquerda);
		posOrdem(n.direita);
		System.out.println(n.value);
	}

	/**
	 * Busca um elemento na <code>Árvore</p>.
	 * 
	 * @param atual
	 *            nó de início da pesquisa, normalmente usa-se o nó <code>root
	 *            </code>.
	 * @param value
	 *            o Objeto que se deseja encontrar
	 * @return o nó na qual o Objeto se encontra.
	 */
	public Nodo buscaTree(Nodo atual, T value) {
		Nodo a1;
		if (atual == null)
			return null;
		else {
			if (atual.value.compareTo(value) == 0)
				return atual;
			else {
				a1 = buscaTree(atual.esquerda, value);
				if (a1 == null)
					a1 = buscaTree(atual.direita, value);
			}
			return a1;
		}
	}

	/**
	 * Verifica o tamanho da <code>Árvore</p>.
	 * 
	 * @return o número de elementos da <code>Árvore</p>.
	 */
	public int size() {
		return size;
	}

	/**
	 * Verifica se a <code>Árvore</p> está vazia.
	 * 
	 * @return <code>true</code> se a <code>Árvore</p> estiver vazia.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Representa um nó da <code>Árvore</p>.
	 * 
	 * @author Caique
	 *
	 */
	public class Nodo {
		Nodo esquerda;
		Nodo direita;
		public T value;

		public Nodo(T vl) {
			value = vl;
		}
	}
}
