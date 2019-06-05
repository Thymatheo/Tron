package model.element.mobileelement;

import contract.IElement;
import contract.IMap;
import contract.IMobileElementFactory;
import contract.IPosition;
import model.element.Position;
import model.element.dpdecorator.IsAlive;
import model.element.dpdecorator.IsUnPenetrable;

public class MobileElementFactory implements IMobileElementFactory{

	public IElement createPlayer(IPosition position) {
		return new IsUnPenetrable(new IsAlive( new Player(position))) ;
	}

	public IElement createEnemy(IPosition position) {
		return new IsUnPenetrable(new IsAlive( new Enemy(position))) ;
	}
	@Override
	public IElement createMobile(int nbMobile) {
		if ( nbMobile == 0 ) {
			return createPlayer(new Position(IMap.StartXPlayer1, IMap.StartYPlayer1));
		} else if ( nbMobile == 1){
			return createPlayer(new Position(IMap.StartXPlayer2, IMap.StartYPlayer2));
		}
		return null;
	}
}
