package com.atomic.option;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ASSET {
	
	// Avantar mặc định
	public static TextureRegion imgDefaultAvantarMan;
	public static TextureRegion imgDefaultAvatarWoman;
		
	// Các phân tử hóa học
	public static TextureRegion imgAtomBr;
	public static TextureRegion imgAtomC;
	public static TextureRegion imgAtomCl;
	public static TextureRegion imgAtomF;
	public static TextureRegion imgAtomH;
	public static TextureRegion imgAtomN;
	public static TextureRegion imgAtomO;
	public static TextureRegion imgAtomP;
	public static TextureRegion imgAtomS;
	
	// Các phân tử hóa học chỉ hiện màu
	public static TextureRegion imgAtomCrystal;
	public static TextureRegion imgCrystalE;
	public static TextureRegion imgCrystalF;
	public static TextureRegion imgCrystalG;
	public static TextureRegion imgCrystalH;
	public static TextureRegion imgCrystalI;
	public static TextureRegion imgCrystalJ;
	public static TextureRegion imgCrystalK;
	public static TextureRegion imgCrystalL;
	public static TextureRegion imgCrystalM;
	
	// Hình ảnh tường viền
	public static TextureRegion imgWall;
	
	// Hình ảnh các button chỉ hướng đi
	public static TextureRegion imgBtnLeft;
	public static TextureRegion imgBtnRight;
	public static TextureRegion imgBtnUp;
	public static TextureRegion imgBtnDown;
	
	// Hình ảnh các kết nối đơn
	public static TextureRegion imgBondBottom;
	public static TextureRegion imgBondBottomLeft;
	public static TextureRegion imgBondBottomRight;
	
	public static TextureRegion imgBondUp;
	public static TextureRegion imgBondUpLeft;
	public static TextureRegion imgBondUpRight;
	
	public static TextureRegion imgBondLeft;
	public static TextureRegion imgBondRight;
	
	// Hình ảnh các kết nối đôi
	public static TextureRegion imgBondBottomDouble;
	public static TextureRegion imgBondBottomLeftDouble;
	public static TextureRegion imgBondBottomRightDouble;
	
	public static TextureRegion imgBondUpDouble;
	public static TextureRegion imgBondUpLeftDouble;
	public static TextureRegion imgBondUpRightDouble;
	
	public static TextureRegion imgBondLeftDouble;
	public static TextureRegion imgBondRightDouble;
	
	// Hình ảnh các kết nối ba
	public static TextureRegion imgBondBottomTriple;
	public static TextureRegion imgBondUpTriple;
	public static TextureRegion imgBondLeftTriple;
	public static TextureRegion imgBondRightTriple;
	
	// Hình ảnh các kết nối cách xa
	public static TextureRegion imgConnectorBackslash;
	public static TextureRegion imgConnectorHorizontal;
	public static TextureRegion imgConnectorSlash;
	public static TextureRegion imgConnectorVertical;
	
	// Hình ảnh các nút chức năng
	public static TextureRegion btnUndo;
	public static TextureRegion btnRecno;
	public static TextureRegion btnReset;
	
	// Tải tập tin ảnh Texture
	public static Texture loadTexture(String pathImage) {
		return new Texture(Gdx.files.internal(pathImage));
	}
	
	// Tải toàn bộ tập tin chung mặc định
	public static void loadAllFile() {
		loadImageAvantar();
		loadImageItemGame();
		loadButtonGame();
		loadFont();
	}
	
	private static void loadImageAvantar() {
		imgDefaultAvantarMan = new TextureRegion(loadTexture("avantar/avatar_nam.png"));
		imgDefaultAvatarWoman = new TextureRegion(loadTexture("avantar/avatar_nu.png"));
	}
	
	private static void loadImageItemGame() {
		// Load các tập tin atom
		connectAtom();
		
		// Load các tập tin Crystal
		connectCrystal();
		
		// Load các tập tin tường viền
		imgWall = new TextureRegion(loadTexture("katomic/wall.png"));
		
		// Load các kết nối đơn
		connectBondSimple();
		
		// Load các kết nói đôi
		connectBondDouble();
		
		// Load các kết nối ba
		connectBondTriple();
		
		// Load kết nối cách xa
		connectLine();
	}
	
	private static void loadButtonGame() {
		// Load các nút chỉ hướng
		imgBtnLeft = new TextureRegion(loadTexture("katomic/arrow-left.png"));
		imgBtnRight = new TextureRegion(loadTexture("katomic/arrow-right.png"));
		imgBtnUp = new TextureRegion(loadTexture("katomic/arrow-up.png"));
		imgBtnDown = new TextureRegion(loadTexture("katomic/arrow-down.png"));
		
		// Load các nút chức năng
		btnRecno = new TextureRegion(loadTexture("_redo.png"));
		btnUndo = new TextureRegion(loadTexture("_undo.png"));
		btnReset = new TextureRegion(loadTexture("refresh.png"));
	}
	
	// Cấu hình tải font
	private static void loadFont() {
		
	}
	
	private static void connectAtom() {
		imgAtomBr = new TextureRegion(loadTexture("katomic/atom-br.png"));
		imgAtomC = new TextureRegion(loadTexture("katomic/atom-c.png"));
		imgAtomCl = new TextureRegion(loadTexture("katomic/atom-cl.png"));
		imgAtomF = new TextureRegion(loadTexture("katomic/atom-f.png"));
		imgAtomH = new TextureRegion(loadTexture("katomic/atom-h.png"));
		imgAtomN = new TextureRegion(loadTexture("katomic/atom-n.png"));
		imgAtomO = new TextureRegion(loadTexture("katomic/atom-o.png"));
		imgAtomP = new TextureRegion(loadTexture("katomic/atom-p.png"));
		imgAtomS = new TextureRegion(loadTexture("katomic/atom-s.png"));
	}
	
	private static void connectCrystal() {
		imgAtomCrystal = new TextureRegion(loadTexture("katomic/atom-crystal.png"));
		imgCrystalE = new TextureRegion(loadTexture("katomic/crystal-E.png"));
		imgCrystalF = new TextureRegion(loadTexture("katomic/crystal-F.png"));
		imgCrystalG = new TextureRegion(loadTexture("katomic/crystal-G.png"));
		imgCrystalH = new TextureRegion(loadTexture("katomic/crystal-H.png"));
		imgCrystalI = new TextureRegion(loadTexture("katomic/crystal-I.png"));
		imgCrystalJ = new TextureRegion(loadTexture("katomic/crystal-J.png"));
		imgCrystalK = new TextureRegion(loadTexture("katomic/crystal-K.png"));
		imgCrystalL = new TextureRegion(loadTexture("katomic/crystal-L.png"));
		imgCrystalM = new TextureRegion(loadTexture("katomic/crystal-M.png"));
	}
	
	private static void connectBondSimple() {
		imgBondBottom = new TextureRegion(loadTexture("katomic/bond-bottom.png"));
		imgBondBottomLeft = new TextureRegion(loadTexture("katomic/bond-bottom-left.png"));
		imgBondBottomRight = new TextureRegion(loadTexture("katomic/bond-bottom-right.png"));
		imgBondUp = new TextureRegion(loadTexture("katomic/bond-top.png"));
		imgBondUpLeft = new TextureRegion(loadTexture("katomic/bond-top-left.png"));
		imgBondUpRight = new TextureRegion(loadTexture("katomic/bond-top-right.png"));
		imgBondLeft = new TextureRegion(loadTexture("katomic/bond-left.png"));
		imgBondRight = new TextureRegion(loadTexture("katomic/bond-right.png"));
	}
	
	// Kết nối đôi
	private static void connectBondDouble() {
		imgBondBottomDouble = new TextureRegion(loadTexture("katomic/bond-bottom-double.png"));
		imgBondBottomLeftDouble = new TextureRegion(loadTexture("katomic/bond-bottom-left-double.png"));
		imgBondBottomRightDouble = new TextureRegion(loadTexture("katomic/bond-bottom-right-double.png"));		
		imgBondUpDouble = new TextureRegion(loadTexture("katomic/bond-top-double.png"));
		imgBondUpLeftDouble = new TextureRegion(loadTexture("katomic/bond-top-left-double.png"));
		imgBondUpRightDouble = new TextureRegion(loadTexture("katomic/bond-top-right-double.png"));
		imgBondLeftDouble = new TextureRegion(loadTexture("katomic/bond-left-double.png"));
		imgBondRightDouble = new TextureRegion(loadTexture("katomic/bond-right-double.png"));
	}
	
	// Kết nói 3
	private static void connectBondTriple() {
		imgBondBottomTriple = new TextureRegion(loadTexture("katomic/bond-bottom-triple.png"));
		imgBondUpTriple = new TextureRegion(loadTexture("katomic/bond-top-triple.png"));
		imgBondLeftTriple = new TextureRegion(loadTexture("katomic/bond-left-triple.png"));
		imgBondRightTriple = new TextureRegion(loadTexture("katomic/bond-right-triple.png"));
	}
	
	// Kết nối ở xa
	private static void connectLine() {
		imgConnectorBackslash = new TextureRegion(loadTexture("katomic/connector-backslash.png"));
		imgConnectorHorizontal = new TextureRegion(loadTexture("katomic/connector-horizontal.png"));
		imgConnectorSlash = new TextureRegion(loadTexture("katomic/connector-slash.png"));
		imgConnectorVertical = new TextureRegion(loadTexture("katomic/connector-vertical.png"));
	}
}
