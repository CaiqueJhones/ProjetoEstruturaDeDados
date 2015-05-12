package br.edu.ufrb.estruturadedados.arvores;

/**
 * <p>
 * Árvore AVL (ou árvore balanceada pela altura), é
 * uma árvore de busca binária auto-balanceada. Em tal árvore, as alturas das
 * duas sub-árvores a partir de cada nó diferem no máximo em uma unidade. As
 * operações de busca, inserção e remoção de elementos possuem complexidade O(
 * log n ) (no qual n é o número de elementos da árvore)1 . Inserções e
 * remoções podem também requerer o rebalanceamento da árvore, exigindo uma ou
 * mais rotações.
 * </p>
 * 
 * <p>
 * O nome AVL vem de seus criadores soviéticos Adelson Velsky e Landis, e sua
 * primeira referência encontra-se no documento
 * "Algoritmos para organização da informação" de 1962.
 * </p>
 * 
 * <p>
 * Nessa estrutura de dados cada elemento é chamado de nó. Um nó contém um valor
 * próprio, um valor de altura, e dois filhos que são outros nós. A partir desta
 * estrutura é possível montar um algoritmo eficiente para armazenar, buscar e
 * deletar informações.
 * </p>
 * 
 * @author TiagoPagano
 */
public class ArvoreAVL {

	Nodo raiz = null;

	public static Nodo inserir(Nodo aux, int num) {
		// o objeto novo é um objeto auxiliar
		Nodo novo;
		if (aux == null) {
			novo = new Nodo();
			novo.num = num;
			novo.altd = 0;
			novo.alte = 0;
			novo.esq = null;
			novo.dir = null;
			aux = novo;
		} else if (num < aux.num) {
			aux.esq = inserir(aux.esq, num);
			if (aux.esq.altd > aux.esq.alte) {
				aux.alte = aux.esq.altd + 1;
			} else {
				aux.alte = aux.esq.alte + 1;
			}
		} else {
			aux.dir = inserir(aux.dir, num);
			if (aux.dir.altd > aux.dir.alte) {
				aux.altd = aux.dir.altd + 1;
			} else {
				aux.altd = aux.dir.alte + 1;
			}
		}

		aux = balanceamento(aux);

		return aux;
	}

	public static Nodo balanceamento(Nodo aux) {
		int d, df;
		d = aux.altd - aux.alte;
		if (d == 2) {
			df = aux.dir.altd - aux.dir.alte;
			if (df >= 0) {
				aux = rotacao_esquerda(aux);
			} else {
				aux.dir = rotacao_direita(aux.dir);
				aux = rotacao_esquerda(aux);
			}
		} else if (d == -2) {
			df = aux.esq.altd - aux.esq.alte;
			if (df <= 0) {
				aux = rotacao_direita(aux);
			} else {
				aux.esq = rotacao_esquerda(aux.esq);
				aux = rotacao_direita(aux);
			}
		}
		return aux;
	}

	public static Nodo rotacao_esquerda(Nodo aux) {
		Nodo aux1, aux2;
		aux1 = aux.dir;
		aux2 = aux1.esq;
		aux.dir = aux2;
		aux1.esq = aux;
		if (aux.dir == null) {
			aux.altd = 0;
		} else if (aux.dir.alte > aux.dir.altd) {
			aux.altd = aux.dir.alte + 1;
		} else {
			aux.altd = aux.dir.altd + 1;
		}

		if (aux1.esq.alte > aux1.esq.altd) {
			aux1.alte = aux1.esq.alte + 1;
		} else {
			aux1.alte = aux1.esq.altd + 1;
		}
		return aux1;
	}

	public static Nodo rotacao_direita(Nodo aux) {
		Nodo aux1, aux2;
		aux1 = aux.esq;
		aux2 = aux1.dir;
		aux.esq = aux2;
		aux1.dir = aux;
		if (aux.esq == null) {
			aux.alte = 0;
		} else if (aux.esq.alte > aux.esq.altd) {
			aux.alte = aux.esq.alte + 1;
		} else {
			aux.alte = aux.esq.altd + 1;
		}

		if (aux1.dir.alte > aux1.dir.altd) {
			aux1.altd = aux1.dir.alte + 1;
		} else {
			aux1.altd = aux1.dir.altd + 1;
		}
		return aux1;
	}

	public static void exibiremordem(Nodo aux) {
		if (aux != null) {
			exibiremordem(aux.esq);
			System.out.print(aux.num + "  ");
			exibiremordem(aux.dir);
		}
	}

	public static void exibirpreordem(Nodo aux) {
		if (aux != null) {
			System.out.print(aux.num + ", ");
			exibirpreordem(aux.esq);
			exibirpreordem(aux.dir);
		}
	}

	public static void exibirposordem(Nodo aux) {
		if (aux != null) {
			exibirposordem(aux.esq);
			exibirposordem(aux.dir);
			System.out.print(aux.num + ", ");
		}
	}

	/**
	 *
	 * @author TiagoPagano
	 */
	public static class Nodo {
		public Nodo() {
		}

		public int num, altd, alte;
		public Nodo dir, esq;
	}

}
