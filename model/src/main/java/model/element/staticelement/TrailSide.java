package model.element.staticelement;

import contract.IPosition;
import model.element.Sprite;

public class TrailSide  extends StaticElement {
		private static Sprite SPRITE = new Sprite("~");
		public TrailSide( IPosition position) {
			super(SPRITE, position);
	}
}
