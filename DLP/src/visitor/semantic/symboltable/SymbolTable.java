package visitor.semantic.symboltable;

import java.util.*;
import ast.Definition;

public class SymbolTable {
	
	private int scope=0;
	private final List<Map<String,Definition>> table;
	public SymbolTable()  {
		table = new ArrayList<>();
		table.add(new HashMap<>());
	}

	public void set() {
		table.add(new HashMap<>());
		scope++;
	}
	
	public void reset() {
		table.remove(scope--);
	}
	
	public boolean insert(Definition definition) {
		if (findInCurrentScope(definition.getName()) == null){
			table.get(scope).put(definition.getName(), definition);
			definition.setScope(scope);
			return true;
		}
		return false;
	}
	
	public Definition find(String id) {
		for (int i = scope; i >= 0; i--) {
			Definition res = table.get(i).get(id);
			if (res != null) {
				return res;
			}
		}
		return null;
	}

	public Definition findInCurrentScope(String id) {
		return table.get(scope).get(id);
	}
}
