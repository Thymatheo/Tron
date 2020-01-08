package contract;

import java.util.ArrayList;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {
	
	IMap getMap();
	
	IElement getPlayer(int x);
	
	ArrayList<IElement> getPlayerList();
	
	IInteractionPlayerMap getInteractionPlayerMap();
}
