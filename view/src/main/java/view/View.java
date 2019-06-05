package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
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
			case KeyEvent.VK_KP_UP:
				return ControllerOrder.UpPlayer2;
			case KeyEvent.VK_KP_DOWN:
				return ControllerOrder.DownPlayer2;
			case KeyEvent.VK_KP_LEFT:
				return ControllerOrder.LeftPlayer2;
			case KeyEvent.VK_KP_RIGHT:
				return ControllerOrder.RightPlayer2;
			default:
				return ControllerOrder.Nothing;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
