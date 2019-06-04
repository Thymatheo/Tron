package model.element.mobileelement;

import contract.IElement;
import contract.IPosition;
import model.element.Sprite;

public class Enemy extends mobileElement implements IElement{
		private static Sprite SPRITE = new Sprite("v");
		public Enemy(IPosition position) {
			super(SPRITE, position);
	}
}
