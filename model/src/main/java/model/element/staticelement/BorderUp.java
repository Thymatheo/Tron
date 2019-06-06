package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class BorderUp extends StaticElement {
	private static Sprite SPRITE = new Sprite("-", "BorderUp.png");
	public BorderUp( IPosition position) {
		super(SPRITE, position);
	}
}
