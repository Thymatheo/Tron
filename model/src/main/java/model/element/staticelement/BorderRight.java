package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class BorderRight extends StaticElement{
	private static Sprite SPRITE = new Sprite("]");
	public BorderRight(IPosition position) {
		super(SPRITE, position);
	}
}
