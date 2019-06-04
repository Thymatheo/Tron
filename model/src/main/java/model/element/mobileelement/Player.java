package model.element.mobileelement;

import contract.IElement;
import contract.IPosition;
import model.element.Sprite;

public class Player extends mobileElement implements IElement {
	private static Sprite SPRITE = new Sprite("p");
	public Player(IPosition position) {
		super(SPRITE, position);
	}
}
