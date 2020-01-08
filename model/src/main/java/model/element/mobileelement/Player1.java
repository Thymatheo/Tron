package model.element.mobileelement;

import contract.IElement;
import contract.IPosition;
import model.element.Sprite;

public class Player1 extends mobileElement implements IElement {
	private static Sprite SPRITE = new Sprite("p1","Player1.png");
	public Player1(IPosition position) {
		super(SPRITE, position);
	}
}
