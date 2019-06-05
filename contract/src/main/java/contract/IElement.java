package contract;

public interface IElement {
	ISprite getSprite();
	
	IPosition getPosition();
	
	boolean isALive();
	
	boolean isUnPenetrable();
	
	void setUnPenetrable();
	
	void setALive();
}
