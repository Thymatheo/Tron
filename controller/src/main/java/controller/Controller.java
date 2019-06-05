package controller;

import java.util.ArrayList;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IOrderPerformer;
import contract.IView;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	private ArrayList<ControllerOrder> Order;

	private int speed = 1000;
	
	private String LastDirectionPlayer1;
	
	private String LastDirectionPlayer2;
	
	
	

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
	 * Control.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
	}

	/**
	 * Sets the view.
	 *
	 * @param pview
	 *            the new view
	 */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *            the controller order
	 */
	
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	
	public void play() throws InterruptedException{
		while (this.model.getPlayer(1).isALive() == true && this.model.getPlayer(2).isALive() == true) {
			Thread.sleep(speed);
			for (ControllerOrder controllerOrder : Order) {
				switch (controllerOrder) {
				case RightPlayer1:
					this.setLastDirectionPlayer1("x+1");
					break;
				case UpPlayer1:
					this.setLastDirectionPlayer1("y-1");
					break;
				case DownPlayer1:
					this.setLastDirectionPlayer1("y+1");
					break;
				case LeftPlayer1:
					this.setLastDirectionPlayer1("x-1");
					break;
				case RightPlayer2:
					this.setLastDirectionPlayer1("x+1");
					break;
				case UpPlayer2:
					this.setLastDirectionPlayer2("y-1");
					break;
				case DownPlayer2:
					this.setLastDirectionPlayer2("y+1");
					break;
				case LeftPlayer2:
					this.setLastDirectionPlayer2("x-1");
					break;
				default:
					if (LastDirectionPlayer1 == "y-1" || LastDirectionPlayer2 == "y-1" ) {
						//do move up
					} else if (LastDirectionPlayer1 == "y+1" || LastDirectionPlayer2 == "y+1" ) {
						//do move Down
					} else if (LastDirectionPlayer1 == "x+1" || LastDirectionPlayer2 == "x+1" ) {
						//do move Right
					} else if (LastDirectionPlayer1 == "x-1" || LastDirectionPlayer2 == "x-1" ) {
						//do move Left
					}
					break;

				}
			}
			this.clearOrder();
			this.model.getMap().refresh();
		}
	}

	public void clearOrder() {
		for (ControllerOrder controllerOrder : Order) {
			Order.remove(controllerOrder);
		}

	}

	public ArrayList<ControllerOrder> getOrder() {
		return Order;
	}

	public void setOrder(ControllerOrder order) {
		this.Order.add(order);
	}

	public String getLastDirectionPlayer1() {
		return LastDirectionPlayer1;
	}

	public void setLastDirectionPlayer1(String lastDirectionPlayer1) {
		LastDirectionPlayer1 = lastDirectionPlayer1;
	}

	public String getLastDirectionPlayer2() {
		return LastDirectionPlayer2;
	}

	public void setLastDirectionPlayer2(String lastDirectionPlayer2) {
		LastDirectionPlayer2 = lastDirectionPlayer2;
	}

}
