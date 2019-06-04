package model.element.staticelement;

import contract.IElement;
import contract.IMap;
import contract.IPosition;
import contract.IStaticElementFactory;
import model.element.Position;
import model.element.dpdecorator.IsUnPenetrable;

public class StaticElementFactory implements IStaticElementFactory {

	public IElement createBorderUp(IPosition position) {
		return new IsUnPenetrable(new BorderUp(position));
	}
	
	public IElement createBorderDown(IPosition position) {
		return new IsUnPenetrable(new BorderDown(position));
	}
	
	public IElement createBorderLeft(IPosition position) {
		return new IsUnPenetrable(new BorderLeft(position));
	}
	
	public IElement createBorderRight(IPosition position) {
		return new IsUnPenetrable(new BorderRight(position));
	}
	
	public IElement createCornerLeftUp(IPosition position) {
		return new IsUnPenetrable(new CornerLeftUp(position));
	}
	
	public IElement createCornerLeftDown(IPosition position) {
		return new IsUnPenetrable(new CornerLeftDown(position));
	}
	
	public IElement createCornerRightUp(IPosition position) {
		return new IsUnPenetrable(new CornerRightUp(position));
	}
	
	public IElement createCornerRightDown(IPosition position) {
		return new IsUnPenetrable(new CornerRightDown(position));
	}
	
	
	
	
	
	public IElement createStaticElement(int x , int y ) {
		if ( x == 0 ) {
			if ( y == 0 ) {
				return createCornerLeftUp(new Position(x, y));
			} else if (y == IMap.widthMap-1) {
				return createCornerRightUp(new Position(x, y));
			} 
		return createBorderUp(new Position(x, y));
		} else if ( x == IMap.heightMap-1 ) {
			if ( y == 0 ) {
				return createCornerLeftDown(new Position(x, y));
			} else if (y == IMap.widthMap-1) {
				return createCornerRightDown(new Position(x, y));
			} 
		return createBorderDown(new Position(x, y));
		} else if ( y == 0 ) {
			return createBorderLeft(new Position(x, y));
		} else if ( y == IMap.widthMap -1) {
			return createBorderRight(new Position(x, y));
		}
		return null;
	}
}
