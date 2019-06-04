package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class TrailUpDown extends StaticElement{
	private static Sprite SPRITE = new Sprite("^");
	public TrailUpDown( IPosition position) {
		super(SPRITE, position);
	}
}
