package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

public final class View implements IView, Runnable {

	private final ViewFrame viewFrame;

	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_Z:
				return ControllerOrder.UpPlayer1;
			case KeyEvent.VK_S:
				return ControllerOrder.DownPlayer1;
			case KeyEvent.VK_Q:
				return ControllerOrder.LeftPlayer1;
			case KeyEvent.VK_D:
				return ControllerOrder.RightPlayer1;
			case KeyEvent.VK_UP:
				return ControllerOrder.UpPlayer2;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.DownPlayer2;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.LeftPlayer2;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.RightPlayer2;
			default:
				return ControllerOrder.Nothing;
		}
	}

	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	public void run() {
		this.viewFrame.setVisible(true);
	}

	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
