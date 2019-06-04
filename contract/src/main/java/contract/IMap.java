package contract;

public interface IMap {
	
	int heightMap 	= 40;
	
	int widthMap 	= 40;
	
	int nbMobile	= 2;
	
	int StartX 		= 5;
	
	int StartY		= 5;
	
	int DecalageEnemy = 10;
	
	IElement getOnTheMapXY(int x, int y);
}
