package model.element;

import contract.IElement;
import contract.IPosition;
import contract.ISprite;

public abstract class Element implements IElement{
	private ISprite sprite;
	private IPosition position;
	
	public Element(ISprite sprite,IPosition position) {
		this.setSprite(sprite);
		this.setPosition(position);
	}

	public ISprite getSprite() {
		return sprite;
	}

	public void setSprite(ISprite sprite) {
		this.sprite = sprite;
	}

	public IPosition getPosition() {
		return position;
	}

	public void setPosition(IPosition position) {
		this.position = position;
	}
}
