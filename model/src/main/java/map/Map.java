package map;

import java.util.ArrayList;
import java.util.Observable;

import contract.IElement;
import contract.IMap;
import contract.IMobileElementFactory;
import contract.IStaticElementFactory;
import model.element.mobileelement.MobileElementFactory;
import model.element.staticelement.StaticElementFactory;

public class Map extends Observable implements IMap {

	private IElement[][] onTheMap;
	
	public Map(int heightMap, int widthMap) {
		this.setOnTheMap(new IElement[heightMap][widthMap]);
		this.loadTheMap();
		this.setMobileOnTheMap();
	}

	private void setMobileOnTheMap() {
		IMobileElementFactory mobileElementFactory = new MobileElementFactory();
		ArrayList<IElement> mobile = new ArrayList<IElement>();
		for (int  m = 0 ; m < nbMobile ; m++ ) {
			mobile.add(m, mobileElementFactory.createMobile(m));
		}
		for ( int x = 0; x < mobile.size(); x++) {
			this.setOnThMapXY(mobile.get(x), mobile.get(x).getPosition().getX(), mobile.get(x).getPosition().getX());
		}
			
		
	}

	public IElement[][] getOnTheMap() {
		return onTheMap;
	}

	public void setOnTheMap(IElement[][] onTheMap) {
		this.onTheMap = onTheMap;
	}
	
	public void setOnThMapXY(IElement element, int x, int y) {
		this.onTheMap[x][y] = element;
	}
	
	public IElement getOnTheMapXY(int x, int y) {
		return this.onTheMap[x][y];
	}
	
	public void loadTheMap() {
		IStaticElementFactory Factory = new StaticElementFactory();
			
		for ( int x  = 0 ; x < heightMap ; x++ ) {
			for ( int y = 0 ; y < widthMap ; y ++) {
				this.onTheMap[x][y] = Factory.createStaticElement(x, y);
			}
		}
	}
	
	public void refresh() {
		setChanged();
		notifyObservers();
	}
	
	public Observable getObservable() {
		return this;
	}
	
}
