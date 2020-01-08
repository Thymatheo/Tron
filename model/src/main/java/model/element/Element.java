package model.element;

import contract.IElement;
import contract.IPosition;
import contract.ISprite;

public abstract class Element extends GameObject implements IElement{

	protected boolean ALive = false;
	
	protected boolean unPenetrable = false;
	
	
	
	public Element(Element element) {
		super(element.getSprite(), element.getPosition());
		this.setALive(element.isALive());
		this.setUnPenetrable(element.isUnPenetrable());
		
		
	}



	public Element(ISprite sprite, IPosition position) {
		super(sprite, position);
	}



	public boolean isUnPenetrable() {
		return unPenetrable;
	}



	public void setUnPenetrable(boolean unPenetrable) {
		this.unPenetrable = unPenetrable;
	}



	public boolean isALive() {
		return ALive;
	}



	public void setALive(boolean aLive) {
		this.ALive = aLive;
	}
}
