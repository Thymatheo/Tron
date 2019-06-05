package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IElement;
import contract.IInteractionPlayerMap;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	private ControllerOrder orderPlayer1 = ControllerOrder.DownPlayer1;

	private ControllerOrder orderPlayer2 = ControllerOrder.UpPlayer2;

	private ControllerOrder previousOrderPlayer1 = ControllerOrder.DownPlayer1;

	private ControllerOrder previousOrderPlayer2 = ControllerOrder.UpPlayer2;

	int speed = 150;

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

	public void end() {
		this.view.printMessage("Game Over");
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
		IInteractionPlayerMap Interact = this.model.getInteractionPlayerMap();
		IElement player1 = this.model.getPlayer(0);
		IElement player2 = this.model.getPlayer(1);
		int t = 0;
		while (this.model.getPlayer(0).isALive() == true && this.model.getPlayer(1).isALive() == true) {
			Thread.sleep(speed);
			System.out.println("Tour de boucle n°" + t);
			if(this.getOrderPlayer1() !=null) {
				switch (getOrderPlayer1()) {
				case RightPlayer1:
					Interact.playerMove(0, 1, player1);
					break;
				case UpPlayer1:
					Interact.playerMove(-1, 0, player1);
					break;
				case DownPlayer1:
					Interact.playerMove(1, 0, player1);
					break;
				case LeftPlayer1:
					Interact.playerMove(0, -1, player1);
					break;
				default:
					break;
				}
			} else { 
				switch (getPreviousOrderPlayer1()) {
				case RightPlayer1:
					Interact.playerMove(0, 1, player1);
					break;
				case UpPlayer1:
					Interact.playerMove(-1, 0, player1);
					break;
				case DownPlayer1:
					Interact.playerMove(1, 0, player1);
					break;
				case LeftPlayer1:
					Interact.playerMove(0, -1, player1);
					break;
				default:
					break;
				}
			}
			if (getOrderPlayer1() != null) {
				this.setPreviousOrderPlayer1(this.getOrderPlayer1());
				this.setOrderPlayer1(null);
			}

			if (getOrderPlayer2() != null) {
				switch(getOrderPlayer2()) {
				case RightPlayer2:
					Interact.playerMove(0, 1, player2);
					break;
				case UpPlayer2:
					Interact.playerMove(-1, 0, player2);
					break;
				case DownPlayer2:
					Interact.playerMove(1, 0, player2);
					break;
				case LeftPlayer2:
					Interact.playerMove(0,-1, player2);
					break;
				default:
					break;
				}
			} else {
				switch(getPreviousOrderPlayer2()) {
				case RightPlayer2:
					Interact.playerMove(0, 1, player2);
					break;
				case UpPlayer2:
					Interact.playerMove(-1, 0, player2);
					break;
				case DownPlayer2:
					Interact.playerMove(1, 0, player2);
					break;
				case LeftPlayer2:
					Interact.playerMove(0,-1, player2);
				default:
					break;
				}
			}
			if (getOrderPlayer2() != null) {
				this.setPreviousOrderPlayer2(this.getOrderPlayer2());
				this.setOrderPlayer2(null);
			}
			t++; 
			if (t == 10) {
				speed = speed-50;
			}
			this.model.getMap().refresh();
		}
	}

	public ControllerOrder getOrderPlayer1() {
		return orderPlayer1;
	}

	public void setOrderPlayer1(ControllerOrder orderPlayer1) {
		this.orderPlayer1 = orderPlayer1;
	}

	public ControllerOrder getOrderPlayer2() {
		return orderPlayer2;
	}

	public void setOrderPlayer2(ControllerOrder orderPlayer2) {
		this.orderPlayer2 = orderPlayer2;
	}

	public IController getController() {
		return this;
	}

	public ControllerOrder getPreviousOrderPlayer1() {
		return previousOrderPlayer1;
	}

	public void setPreviousOrderPlayer1(ControllerOrder previousOrderPlayer1) {
		this.previousOrderPlayer1 = previousOrderPlayer1;
	}

	public ControllerOrder getPreviousOrderPlayer2() {
		return previousOrderPlayer2;
	}

	public void setPreviousOrderPlayer2(ControllerOrder previousOrderPlayer2) {
		this.previousOrderPlayer2 = previousOrderPlayer2;
	}

}
