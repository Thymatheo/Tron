package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IElement;
import contract.IInteractionPlayerMap;
import contract.IModel;
import contract.IView;

public final class Controller implements IController {

	private IView		view;

	private IModel	model;

	private ControllerOrder orderPlayer1 = ControllerOrder.DownPlayer1;

	private ControllerOrder orderPlayer2 = ControllerOrder.UpPlayer2;
	
	private ControllerOrder orderTryAgain = null;

	int speed = 150;

	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	public void control() {
		this.view.printMessage("Appuyer sur les touches 'Z', 'Q', 'S' ou 'D', Pour deplacer le Joueur 1\n" + "Et Utiliser les fleche directionnel pour le Joueur 2.");
	}

	public void end() {
		if ( this.model.getPlayer(0).isALive() == true) {
			this.view.printMessage("Player Blue Win");
		} else if ( this.model.getPlayer(1).isALive() == true) {
			this.view.printMessage("Player Orange Win");
		}

	}

	private void setView(final IView pview) {
		this.view = pview;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}

	public void play() throws InterruptedException{
		IInteractionPlayerMap Interact = this.model.getInteractionPlayerMap();
		IElement player1 = this.model.getPlayer(0);
		IElement player2 = this.model.getPlayer(1);
		int t = 0;
		while (player1.isALive() == true && player2.isALive() == true) {
			Thread.sleep(speed);
			System.out.println("Tour de boucle n°" + t);
				switch (getOrderPlayer1()) {
				case RightPlayer1:
					Interact.playerMove(0, 1, 0);
					break;
				case UpPlayer1:
					Interact.playerMove(-1, 0, 0);
					break;
				case DownPlayer1:
					Interact.playerMove(1, 0, 0);
					break;
				case LeftPlayer1:
					Interact.playerMove(0, -1, 0);
					break;
				default:
					break;
				}
				switch(getOrderPlayer2()) {
				case RightPlayer2:
					Interact.playerMove(0, 1, 1);
					break;
				case UpPlayer2:
					Interact.playerMove(-1, 0, 1);
					break;
				case DownPlayer2:
					Interact.playerMove(1, 0, 1);
					break;
				case LeftPlayer2:
					Interact.playerMove(0,-1, 1);
					break;
				default:
					break;
				}
			t++; 
			if (t == 100) {
				
			}
			this.model.getMap().refresh();
			if ( player1.isALive() == false) {
				player1.getSprite().setImageName("PlayerDeath.png");
				player1.getSprite().loadImage(player1.getSprite().getImageName());
			} else if ( player2.isALive() == false) {
				player2.getSprite().setImageName("PlayerDeath.png");
				player2.getSprite().loadImage(player2.getSprite().getImageName());			}
		}
	}
	
	public boolean tryAgain() {
		switch(orderTryAgain) {
		case Exit:
			return false;
		case Continue:
			return true;
		default :
			return false;
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
}
