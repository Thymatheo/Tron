package model.element.interactionMap;

import contract.IElement;
import contract.IInteractionPlayerMap;
import contract.IModel;
import contract.IPosition;

public class InteractionPlayerMap implements IInteractionPlayerMap{

	private IModel model;

	public InteractionPlayerMap(IModel model) {
		this.model = model;
	}

	public void playerMove(int x, int y, int player) {
		if ( analyse(model.getPlayer(player).getPosition().getX()+x, model.getPlayer(player).getPosition().getY()+y, player) == true) {
			IPosition playerPosition = model.getPlayer(player).getPosition();
			playerPosition.setX(playerPosition.getX()+x);
			playerPosition.setY(playerPosition.getY()+y);
			model.getMap().setOnThMapXY(model.getPlayer(player), playerPosition.getX(), playerPosition.getY());
		}
		
	}
	
	private boolean analyse(int x , int y,int player) {
			if (model.getMap().getOnTheMapXY(x, y).isUnPenetrable() == true) {
				model.getPlayer(player).setALive();
			}
		return true;
	}
}
