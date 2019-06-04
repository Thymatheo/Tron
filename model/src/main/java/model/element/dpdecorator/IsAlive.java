package model.element.dpdecorator;

import model.element.Element;

public class IsAlive extends Decorator {
	public IsAlive(final Element object) {
		super(object);
		ALive = true;
	}
}
