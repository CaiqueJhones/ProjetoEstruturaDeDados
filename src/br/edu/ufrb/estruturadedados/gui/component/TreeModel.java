package br.edu.ufrb.estruturadedados.gui.component;

import java.util.List;

import br.edu.ufrb.estruturadedados.gui.StructType;

public class TreeModel extends AbstractTreeModel{
	
	private final String root = "Estruturas";
	private List<StructType> data;
	
	public TreeModel(List<StructType> data) {
		this.data = data;
	}

	@Override
	public Object getRoot() {
		return root;
	}

	@Override
	public Object getChild(Object parent, int index) {
		return data.get(index);
	}

	@Override
	public int getChildCount(Object parent) {
		return data.size();
	}

	@Override
	public boolean isLeaf(Object node) {
		return node instanceof StructType;
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if (data.contains(child)){
			for (int i = 0; i < data.size(); i++) {
				if(data.get(i).equals(child))
					return i;
			}
		}
		return -1;
	}

}
