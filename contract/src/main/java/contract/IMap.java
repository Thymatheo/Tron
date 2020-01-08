package contract;

import java.util.Observable;

public interface IMap {
	
	int heightMap 	= 40;
	
	int widthMap 	= 40;
	
	int nbMobile	= 2;
	
	int renderImage = 25;
	
	int StartXPlayer1 		= 5;
	
	int StartYPlayer1		= 5;
	
	int StartXPlayer2 		= 35;
	
	int StartYPlayer2		= 35;
	
	int DecalageEnemy = 10;
	
	IElement getOnTheMapXY(int x, int y);
	
	void refresh();
	
	Observable getObservable();
	
	void setOnThMapXY(IElement element, int x, int y);
}
