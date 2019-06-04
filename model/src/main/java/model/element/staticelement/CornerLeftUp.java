package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class CornerLeftUp extends StaticElement{
	private static Sprite SPRITE = new Sprite("#");
	public CornerLeftUp( IPosition position) {
		super(SPRITE, position);
	}

}
