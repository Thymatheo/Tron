package model;

import java.util.ArrayList;

import contract.IElement;
import contract.IMap;
import contract.IModel;
import map.Map;

public final class Model implements IModel {

	private Map map;
	
	private ArrayList<IElement> playerList;
	
	public Model() {
		this.setMap(new Map(IMap.heightMap, IMap.widthMap));
		this.setPlayerList(new ArrayList<IElement>());
		this.findMobile();
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
	public void findMobile() {
		for( int x = 0 ; x < IMap.heightMap ; x++) {
			for ( int y = 0 ; y < IMap.widthMap ; y++) {
				if (this.getMap().getOnTheMapXY(x, y) != null) {
					if (this.getMap().getOnTheMapXY(x, y).isALive() == true) {
						if (this.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == "p") {
							this.playerList.add(this.getMap().getOnTheMapXY(x, y));
						}
					}	
				}	
			}
		}
	}


	public ArrayList<IElement> getPlayerList(){
		return this.playerList;
	}
	
	public IElement getPlayer(int x) {
		return this.getPlayerList().get(x);
	}
	
	public void setPlayerList(ArrayList<IElement> playerList) {
		this.playerList = playerList;
	}
}
