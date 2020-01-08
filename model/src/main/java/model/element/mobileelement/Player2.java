package model.element.mobileelement;

import contract.IElement;
import contract.IPosition;
import model.element.Sprite;

public class Player2 extends mobileElement implements IElement {
	private static Sprite SPRITE = new Sprite("p2","Player2.png");
	public Player2(IPosition position) {
		super(SPRITE, position);
	}
}
