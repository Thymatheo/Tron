package map;

import contract.IMap;

public class Map implements IMap {

	private String[][] onTheMap;
	
	public Map(int heightMap, int widthMap) {
		this.setOnTheMap(new String[heightMap][widthMap]);
	}

	public String[][] getOnTheMap() {
		return onTheMap;
	}

	public void setOnTheMap(String[][] onTheMap) {
		this.onTheMap = onTheMap;
	}
	
}
