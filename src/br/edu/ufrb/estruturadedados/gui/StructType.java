package br.edu.ufrb.estruturadedados.gui;

public enum StructType {
	
	PILHA("Pilha"),
	FILA("Fila"),
	LISTA_S("Lista Simplesmente Encadeada"),
	LISTA_D("Lista Duplamente Encadeada"),
	ARVORE_BIN("Arvore Binaria"),
	ARVORE_B("Arvore B"),
	ARVORE_AVL("Arvore AVL"),
	ORDENACAO("Ordenação");
	
	public String getText() {
		return text;
	}

	String text;

	private StructType(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}

}
