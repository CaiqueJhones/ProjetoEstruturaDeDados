package br.edu.ufrb.estruturadedados.lista;

import java.io.Serializable;
import java.util.Iterator;

public class ListaDuplaEncadeada<T> implements Lista<T>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6180689131065718746L;
	private Nodo primeiro;
	private Nodo ultimo;
	
	private int size;
	
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
				nodo = nodo.elo2;
				return temp.value;
			}
		};
	}

	@Override
	public void add(T object) {
		Nodo n = new Nodo(object);
		if(primeiro == null) {
			primeiro = n;
			ultimo = primeiro;
		}else {
			ultimo.elo2 = n;
			n.elo1 = ultimo;
			ultimo = n;
		}
		size++;
	}
	
	public void addInicio(T object) {
		add(0, object);
	}

	@Override
	public void add(int index, T object) {
		if(index < 0)
			throw new IllegalArgumentException("Valor tem que ser maior que zero");
		if(index >= size - 1 || primeiro == null)
			add(object);
		else {
			Nodo n = new Nodo(object);
			Nodo temp;
			Nodo aux;
			
			if(index == 0) {
				temp = primeiro;
				primeiro = n;
				primeiro.elo2 = temp;
				temp.elo1 = n;
			}else {
				aux = getNodo(index - 1);
				temp = aux.elo2;
				
				aux.elo2 = n;
				n.elo2 = temp;
				
				temp.elo1 = n;
				n.elo1 = aux;
				
			}
		}
	}

	@Override
	public T get(int index) {
		return getNodo(index).value;
	}

	@Override
	public void remove(int index) {
		if(index > size - 1 || index < 0)
			throw new ArrayIndexOutOfBoundsException(index + "não existe na lista");
		
		size--;
		if(index == 0){
			primeiro = primeiro.elo2;
			return;
		}
		Nodo anterior = getNodo(index - 1);
		if(index == size){
			anterior.elo2 = null;
		} else {
			Nodo atual = getNodo(index);
			anterior.elo2 = atual.elo2;
		}
	}

	@Override
	public void remove(T object) {
		Nodo atual = primeiro;
		Nodo ant = null;
		while (atual != null) {
			if(atual.value.equals(object)){
				if(ant == null) {
					primeiro = primeiro.elo2;
				}else if(atual.elo2 == null) {
					ant.elo2 = null;
				}else {
					ant.elo2 = atual.elo2;
				}
				size--;
				break;
			}
			ant = atual;
			atual = atual.elo2;
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
	
	public void exibeListaContrario() {
		Nodo atual = ultimo;
		while(atual != null) {
			System.out.println(atual.value);
			atual = atual.elo1;
		}
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
	public T[] toArray(T[] array) {
		try{
			int i = 0;
			for(T e : this) {
				array[i] = e;
				i++;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return array;
		}
		return array;
	}
	
	private Nodo getNodo(int index) {
		if(index > size - 1 || index < 0)
			throw new ArrayIndexOutOfBoundsException(index + " não existe na lista");
		Nodo atual = primeiro;
		for (int i = 0; i < index; i++) {
			atual = atual.elo2;
		}
		return atual;
	}
	
	private class Nodo {
		T value;
		Nodo elo1;
		Nodo elo2;
		
		public Nodo(T value) {
			this.value = value;
		}
	}

}
