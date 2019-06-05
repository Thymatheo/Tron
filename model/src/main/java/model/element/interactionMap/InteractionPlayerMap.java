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

	public void playerMove(int x, int y, IElement player) {
		if ( analyse(player.getPosition().getX()+x, player.getPosition().getY()+y, player) == true) {
			IPosition playerPosition = player.getPosition();
			playerPosition.setX(playerPosition.getX()+x);
			playerPosition.setY(playerPosition.getY()+y);
			model.getMap().setOnThMapXY(player, playerPosition.getX(), playerPosition.getY());
			model.getMap().setOnThMapXY(null, playerPosition.getX()-x, playerPosition.getY()-y);

		}

	}

	private boolean analyse(int x , int y,IElement player) {
		if (model.getMap().getOnTheMapXY(x, y) != null ) {
			if (model.getMap().getOnTheMapXY(x, y).isUnPenetrable() == true) {
				player.setALive(false);
			}
		}
		return true;
	}
}
