package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class CornerRightDown extends StaticElement {
	private static Sprite SPRITE = new Sprite("#");
	public CornerRightDown(IPosition position) {
		super(SPRITE, position);
	}

}
