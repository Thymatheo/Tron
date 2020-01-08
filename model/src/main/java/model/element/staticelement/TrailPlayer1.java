package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class TrailPlayer1  extends StaticElement {
		private static Sprite SPRITE = new Sprite("~","TrailPLayer1.png");
		public TrailPlayer1( IPosition position) {
			super(SPRITE, position);
	}
}
