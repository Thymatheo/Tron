package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class BorderRight extends StaticElement{
	private static Sprite SPRITE = new Sprite("]","BorderLeft.png");
	public BorderRight(IPosition position) {
		super(SPRITE, position);
	}
}
