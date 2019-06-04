package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class CornerRightUp extends StaticElement{
	private static Sprite SPRITE = new Sprite("#");
	public CornerRightUp( IPosition position) {
		super(SPRITE, position);
	}
}
