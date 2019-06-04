package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class BorderDown extends StaticElement{
	private static Sprite SPRITE = new Sprite("-");
	public BorderDown(IPosition position) {
		super(SPRITE, position);
	}

}
