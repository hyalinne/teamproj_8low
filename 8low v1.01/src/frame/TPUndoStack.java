package frame;

import java.util.ArrayList;

import data.TPData;

public class TPUndoStack {
	public final int MAX_SIZE = 10;
	
	private ArrayList<ArrayList<TPData>> stack;
	
	public TPUndoStack() {
		this.stack = new ArrayList<ArrayList<TPData>>();
	}
	
	@SuppressWarnings("unchecked")
	public void push(ArrayList<TPData> list) {
		if(this.stack.size() > MAX_SIZE) {
			this.stack.remove(0);
		}
		this.stack.add((ArrayList<TPData>)list.clone());
	}
	
	public ArrayList<TPData> pop() {
		if(this.stack.size() > 0) {
			return this.stack.remove(stack.size()-1);
		} else {
			return null;
		}
	}
}
