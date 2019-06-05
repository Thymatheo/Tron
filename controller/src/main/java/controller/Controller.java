package controller;

import java.util.ArrayList;

import contract.ControllerOrder;
import contract.IController;
import contract.IInteractionPlayerMap;
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
	
	private IInteractionPlayerMap interactionPlayerMap;

	private ControllerOrder OrderPlayer1;
	
	private ControllerOrder OrderPlayer2;

	int speed = 500;

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
		this.view.printMessage("Appuyer sur les touches 'Z', 'Q', 'S' ou 'D', Pour deplacer le Joueur 1\n" + "Et Utiliser les fleche directionnel pour le Joueur 2.");
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
		while (this.model.getPlayer(0).isALive() == true && this.model.getPlayer(1).isALive() == true) {
			Thread.sleep(speed);
				switch (getOrderPlayer1()) {
				case RightPlayer1:
					interactionPlayerMap.playerMove(1, 0, 0);
					break;
				case UpPlayer1:
					interactionPlayerMap.playerMove(0, -1, 0);
					break;
				case DownPlayer1:
					interactionPlayerMap.playerMove(0, 1, 0);
					break;
				case LeftPlayer1:
					interactionPlayerMap.playerMove(-1, 0, 0);
					break;
				default:
					break;

				}
			switch(getOrderPlayer2()) {
			case RightPlayer2:
				interactionPlayerMap.playerMove(1, 0, 1);
				break;
			case UpPlayer2:
				interactionPlayerMap.playerMove(0, -1, 1);
				break;
			case DownPlayer2:
				interactionPlayerMap.playerMove(0, 1, 1);
				break;
			case LeftPlayer2:
				interactionPlayerMap.playerMove(-1, 0, 1);
				break;
			default:
				break;
			}
			this.model.getMap().refresh();
		}
	}

	public ControllerOrder getOrderPlayer1() {
		return OrderPlayer1;
	}

	public void setOrderPlayer1(ControllerOrder orderPlayer1) {
		OrderPlayer1 = orderPlayer1;
	}

	public ControllerOrder getOrderPlayer2() {
		return OrderPlayer2;
	}

	public void setOrderPlayer2(ControllerOrder orderPlayer2) {
		OrderPlayer2 = orderPlayer2;
	}

}
