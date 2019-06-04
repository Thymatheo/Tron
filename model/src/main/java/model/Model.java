package model;

import contract.IMap;
import contract.IModel;
import map.Map;

public final class Model implements IModel {

	private Map map;
	
	public Model() {
		this.setMap(new Map(IMap.heightMap, IMap.widthMap));
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

}
