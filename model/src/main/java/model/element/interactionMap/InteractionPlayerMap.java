package model.element.interactionMap;

import contract.IElement;
import contract.IInteractionPlayerMap;
import contract.IModel;
import contract.IPosition;
import model.element.Position;
import model.element.dpdecorator.IsUnPenetrable;
import model.element.staticelement.TrailPlayer1;
import model.element.staticelement.TrailPlayer2;

public class InteractionPlayerMap implements IInteractionPlayerMap{

	private IModel model;

	public InteractionPlayerMap(IModel model) {
		this.model = model;
	}

	public void playerMove(int x, int y, int p) {
		IElement player = this.model.getPlayer(p);
		if ( analyse(player.getPosition().getX()+x, player.getPosition().getY()+y, player) == true ) {
			IPosition playerPosition = player.getPosition();
			playerPosition.setX(playerPosition.getX()+x);
			playerPosition.setY(playerPosition.getY()+y);
			model.getMap().setOnThMapXY(player, playerPosition.getX(), playerPosition.getY());
			if ( p == 0 ) {
				model.getMap().setOnThMapXY(new IsUnPenetrable(new TrailPlayer1(new Position(playerPosition.getX()-x,playerPosition.getY()-y))), playerPosition.getX()-x, playerPosition.getY()-y);
			} else if ( p == 1 ) {
				model.getMap().setOnThMapXY(new IsUnPenetrable(new TrailPlayer2(new Position(playerPosition.getX()-x,playerPosition.getY()-y))), playerPosition.getX()-x, playerPosition.getY()-y);
			}
		}

	}

	private boolean analyse(int x , int y,IElement player) {
		if (model.getMap().getOnTheMapXY(x, y) != null ) {
			if (model.getMap().getOnTheMapXY(x, y).isUnPenetrable() == true) {
				player.setALive(false);
				return false;
			}
		}
		return true;
	}
}
