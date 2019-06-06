package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class TrailPlayer2 extends StaticElement{
	private static Sprite SPRITE = new Sprite("~","TrailPLayer2.png");
	public TrailPlayer2( IPosition position) {
		super(SPRITE, position);
	}
}
