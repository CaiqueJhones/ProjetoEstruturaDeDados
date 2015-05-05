package br.edu.ufrb.estruturadedados.lista;

import java.io.Serializable;
import java.util.Iterator;

/**
 * <p>
 * Uma <b>lista ligada</b> ou <b>lista encadeada</b> é uma estrutura de dados linear e
 * dinâmica. Ela é composta por células que apontam para o próximo elemento da
 * lista. Para "ter" uma lista ligada/encadeada, basta guardar seu primeiro
 * elemento, e seu último elemento aponta para uma célula nula. O esquema a
 * seguir representa uma lista ligada/encadeada com 5 elementos:
 * </p>
 * 
 * <p>
 * Célula 1 ----> Célula 2 ---> Célula 3 ---> Célula 4 ---> Célula 5 ---> (Nulo)
 * </p>
 * 
 * <p>
 * Para inserir dados ou remover dados é necessário ter um ponteiro que aponte
 * para o 1º elemento e outro que aponte para o fim, porque se queremos inserir
 * ou apagar dados que estão nessas posições, a operação é rapidamente
 * executada. Caso seja necessário editar um nó que esteja no meio da lista
 * haverá uma busca pela posição desejada.
 * </p>
 * 
 * @author Caique
 *
 * @param <T>
 *            Tipo de Objetos da lista.
 * @since 1.0
 * @see {@link Lista}.
 */
public class ListaSimplesEncadeada<T> implements Lista<T>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7034883238989292842L;
	private int size;
	private Nodo primeiro = null, ultimo = null;

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private Nodo nodo = primeiro;

			@Override
			public boolean hasNext() {
				return nodo != null;
			}

			@Override
			public T next() {
				Nodo temp = nodo;
				nodo = nodo.elo;
				return temp.value;
			}
		};
	}

	@Override
	public void add(T object) {
		Nodo n = new Nodo(object);
		if (primeiro == null) {
			primeiro = n;
			ultimo = primeiro;
		} else {
			ultimo.elo = n;
			ultimo = ultimo.elo;
		}
		size++;
	}

	@Override
	public void add(int index, T object) {
		if (index < 0)
			throw new IllegalArgumentException(
					"Valor tem que ser maior que zero");
		if (index >= size - 1 || primeiro == null)
			add(object);
		else {
			Nodo n = new Nodo(object);
			Nodo temp;
			Nodo aux;

			if (index == 0) {
				temp = primeiro;
				primeiro = n;
				primeiro.elo = temp;
			} else {
				aux = getNodo(index - 1);
				temp = aux.elo;

				aux.elo = n;
				n.elo = temp;

			}
		}
	}

	@Override
	public T get(int index) {
		return getNodo(index).value;
	}

	@Override
	public void remove(int index) {
		if (index > size - 1 || index < 0)
			throw new ArrayIndexOutOfBoundsException(index
					+ "não existe na lista");

		size--;
		if (index == 0) {
			primeiro = primeiro.elo;
			return;
		}
		Nodo anterior = getNodo(index - 1);
		if (index == size) {
			anterior.elo = null;
		} else {
			Nodo atual = getNodo(index);
			anterior.elo = atual.elo;
		}

	}

	@Override
	public void remove(T object) {
		Nodo atual = primeiro;
		Nodo ant = null;
		while (atual != null) {
			if (atual.value.equals(object)) {
				if (ant == null) {
					primeiro = primeiro.elo;
				} else if (atual.elo == null) {
					ant.elo = null;
				} else {
					ant.elo = atual.elo;
				}
				size--;
				break;
			}
			ant = atual;
			atual = atual.elo;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void exibeLista() {
		for (T t : this) {
			System.out.println(t);
		}
	}

	private Nodo getNodo(int index) {
		if (index > size - 1 || index < 0)
			throw new ArrayIndexOutOfBoundsException(index
					+ " não existe na lista");
		Nodo atual = primeiro;
		for (int i = 0; i < index; i++) {
			atual = atual.elo;
		}
		return atual;
	}

	@Override
	public void fill(Lista<T> list) {
		for (T element : list) {
			add(element);
		}
	}

	@Override
	public void clear() {
		size = 0;
		primeiro = ultimo = null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public T[] toArray(T[] array) {
		try {
			int i = 0;
			for (T e : this) {
				array[i] = e;
				i++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return array;
		}
		return array;
	}

	private class Nodo {
		public T value;
		public Nodo elo;

		public Nodo(T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value.toString();
		}
	}

}
