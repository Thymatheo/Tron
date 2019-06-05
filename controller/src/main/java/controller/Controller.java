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
		while (this.model.getPlayer(1).isALive() == true && this.model.getPlayer(1).isALive() == true) {
			Thread.sleep(speed);
			for (ControllerOrder controllerOrder : Order) {
				switch (controllerOrder) {
				case RightPlayer1:
					break;
				case UpPlayer1:
					break;
				case DownPlayer1:
					break;
				case LeftPlayer1:
					break;
				case RightPlayer2:
					break;
				case UpPlayer2:
					break;
				case DownPlayer2:
					break;
				case LeftPlayer2:
					break;
				default:
					break;

				}
			}
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

}
