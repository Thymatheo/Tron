package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class BorderLeft extends StaticElement {
	private static Sprite SPRITE = new Sprite("[", "BorderRight.png");
	public BorderLeft( IPosition position) {
		super(SPRITE, position);
	}
}
