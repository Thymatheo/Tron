package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class CornerLeftDown extends StaticElement{
	private static Sprite SPRITE = new Sprite("#");
	public CornerLeftDown(IPosition position) {
		super(SPRITE, position);
	}
}
