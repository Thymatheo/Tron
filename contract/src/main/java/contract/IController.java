package contract;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();
	
	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 * @throws InterruptedException 
	 */
	public void play() throws InterruptedException;
	
	ControllerOrder getOrderPlayer1();
	
	ControllerOrder getOrderPlayer2();
	
	void setOrderPlayer1(ControllerOrder orderPlayer1);
	
	void setOrderPlayer2(ControllerOrder orderPlayer2);
	
	IController getController();
	
	 boolean tryAgain();
}
