package br.edu.ufrb.estruturadedados.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.edu.ufrb.estruturadedados.lista.Lista;
import br.edu.ufrb.estruturadedados.lista.ListaSimplesEncadeada;
import br.edu.ufrb.estruturadedados.utils.Busca;
import br.edu.ufrb.estruturadedados.utils.Ordena;

public class OrdenaTest {

	@Test
	public void bubble() {
		String[] vet1 = {"Carlos", "Rafael", "Antonio", "José"};
		Float[] vet2 = {1.2f, 1.0f, 0.3f, 4.0f};
		
		Ordena.bubbleSort(vet1);
		Ordena.bubbleSort(vet2);
		
		assertArrayEquals(new String[]{"Antonio", "Carlos", "José", "Rafael"}, vet1);
		
		System.out.println("Bubble sort:");
		for (String s : vet1) {
			System.out.println(s);
		}
		for (float f : vet2) {
			System.out.println(f);
		}
	}
	
	@Test
	public void selection() {
		String[] vet1 = {"Carlos", "Rafael", "Antonio", "José"};
		Float[] vet2 = {1.2f, 1.0f, 0.3f, 4.0f};
		
		Ordena.selectionSort(vet1);
		Ordena.selectionSort(vet2);
		
		System.out.println("Selection sort");
		for (String s : vet1) {
			System.out.println(s);
		}
		for (float f : vet2) {
			System.out.println(f);
		}
	}
	
	@Test
	public void insertion() {
		String[] vet1 = {"Carlos", "Rafael", "Antonio", "José"};
		Float[] vet2 = {1.2f, 1.0f, 0.3f, 4.0f};
		
		Ordena.insertionSort(vet1);
		Ordena.insertionSort(vet2);
		
		System.out.println("Insertion sort");
		for (String s : vet1) {
			System.out.println(s);
		}
		for (float f : vet2) {
			System.out.println(f);
		}
	}
	
}
