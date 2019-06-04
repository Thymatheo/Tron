package model.element.dpdecorator;

import model.element.Element;

public class IsUnPenetrable extends Decorator{

	public IsUnPenetrable(Element object) {
		super(object);
		unPenetrable = false;
	}

}
