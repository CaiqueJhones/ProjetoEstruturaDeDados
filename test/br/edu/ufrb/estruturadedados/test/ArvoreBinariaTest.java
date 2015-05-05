package br.edu.ufrb.estruturadedados.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.edu.ufrb.estruturadedados.arvores.ArvoreBinaria;

public class ArvoreBinariaTest {

	@Test
	public void test() {
		ArvoreBinaria<String> arvore = new ArvoreBinaria<>();
		arvore.add("Caique");
		arvore.add("Cláudio");
		arvore.add("Emannuel");
		arvore.add("Adson");
		arvore.emOrdem(arvore.root);
	}

}
