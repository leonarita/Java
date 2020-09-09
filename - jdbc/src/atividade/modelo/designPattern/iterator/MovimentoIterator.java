package atividade.modelo.designPattern.iterator;

import java.util.ArrayList;

import atividade.modelo.Movimento;

public class MovimentoIterator implements Iterator {

	ArrayList<Movimento> itens;
	int posicao = 0;

	public MovimentoIterator(ArrayList<Movimento> itens) {
		this.itens = itens;
	}

	public Object next() {
		Movimento menuItem = itens.get(posicao);
		posicao++;
		return menuItem;
	}

	public boolean hasNext() {
		if (posicao >= itens.size() || itens.get(posicao) == null) {
			return false;
		} else {
			return true;
		}
	}

}