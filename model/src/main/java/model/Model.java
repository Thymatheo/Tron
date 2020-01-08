package model;

import java.util.ArrayList;

import contract.IElement;
import contract.IInteractionPlayerMap;
import contract.IMap;
import contract.IModel;
import map.Map;
import model.element.interactionMap.InteractionPlayerMap;

public final class Model implements IModel {

	private Map map;

	private ArrayList<IElement> playerList;

	private InteractionPlayerMap interactionPlayerMap;

	public Model() {
		this.setMap(new Map(IMap.heightMap, IMap.widthMap));
		this.setPlayerList(new ArrayList<IElement>());
		this.findMobile();
		this.setInteractionPlayerMap(new InteractionPlayerMap(this));

	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public void findMobile() {
		int nb = 1;
		for( int x = 0 ; x < IMap.heightMap ; x++) {
			for ( int y = 0 ; y < IMap.widthMap ; y++) {
				if (this.getMap().getOnTheMapXY(x, y) != null) {
					if (this.getMap().getOnTheMapXY(x, y).isALive() == true) {
						if (this.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == "p1" || this.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == "p2") {
							System.out.println("player " + nb +" found !!!");
							nb++;
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

	public IInteractionPlayerMap getInteractionPlayerMap() {
		return interactionPlayerMap;
	}

	public void setInteractionPlayerMap(InteractionPlayerMap interactionPlayerMap) {
		this.interactionPlayerMap = interactionPlayerMap;
	}
}
