package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class CornerLeftDown extends StaticElement{
	private static Sprite SPRITE = new Sprite("#","LeftDownCorner.png");
	public CornerLeftDown(IPosition position) {
		super(SPRITE, position);
	}
}
