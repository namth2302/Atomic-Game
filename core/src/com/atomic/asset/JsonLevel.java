package com.atomic.asset;

import java.util.ArrayList;

public class JsonLevel {
	private String id;
	private	String name;
	private ArrayList<JsonAtoms> atoms;
	private ArrayList<String> arena;
	private ArrayList<String> molecule;
	
	public String getID () {
		return id;
	}
	
	public String getName () {
		return name;
	}
	
	public ArrayList<JsonAtoms> getListAtoms() {
		return atoms;
	}
	
	public ArrayList<String> getListMolecule() {
		return molecule;
	}
	
	public ArrayList<String> getListArena() {
		return arena;
	}
}

