package com.atomic.option;

public class OPTION_GAME {
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 800;
	
	public static final int START_X = 18;
	public static final int START_Y = 2;
	public static final int END_X = 766;
	public static final int END_Y = 753;
	
	public static final String[][] ITEM_KIND = {
		{"1", "atom-h"}, // hydrogen
		{"2", "atom-c"}, // carbon
		{"3", "atom-o"}, // oxygen
		{"4", "atom-n"}, // nitrogen
		{"5", "atom-s"}, // sulphur
		{"6", "atom-f"}, // fluorine
		{"7", "atom-cl"}, // chlorine
        {"8", "atom-br"}, // bromine
        {"9", "atom-p"}, // phosphorus
        {"o", "atom-crystal"},
        {"A", "connector-horizontal"},
        {"B", "connector-slash"},
        {"C", "connector-vertical"},
        {"D", "connector-backslash"},

        {"E", "crystal-E"},
        {"F", "crystal-F"},
        {"G", "crystal-G"},
        {"H", "crystal-H"},
        {"I", "crystal-I"},
        {"J", "crystal-J"},
        {"K", "crystal-K"},
        {"L", "crystal-L"},
        {"M", "crystal-M"}
	};
	
	public static final String[][] BOND_KIND = {
		{"a", "bond-top"},
		{"b", "bond-top-right"},
        {"c", "bond-right"},
        {"d", "bond-bottom-right"},
        {"e", "bond-bottom"},
        {"f", "bond-bottom-left"},
        {"g", "bond-left"},
        {"h", "bond-top-left"},
        {"A", "bond-top-double"},
        {"B", "bond-right-double"},
        {"C", "bond-bottom-double"},
        {"D", "bond-left-double"},
        {"E", "bond-top-triple"},
        {"F", "bond-right-triple"},
        {"G", "bond-bottom-triple"},
        {"H", "bond-left-triple"},
        {"1", "bond-top-left-double"},
        {"2", "bond-top-right-double"},
        {"3", "bond-bottom-right-double"},
        {"4", "bond-bottom-left-double"}
	};
}