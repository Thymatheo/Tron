package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import contract.IMap;
import contract.IModel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	private Image image;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getMap().getObservable().addObserver(this);
		try {
			this.image = ImageIO.read(getClass().getResource("/"+"Ground.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		IModel model = this.getViewFrame().getModel();
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		for ( int x  = 0 ; x < IMap.heightMap ; x++ ) {
			for ( int y = 0 ; y < IMap.widthMap ; y ++) {
				if ( model.getMap().getOnTheMapXY(x, y) != null ) {
					graphics.drawImage(model.getMap().getOnTheMapXY(x, y).getSprite().getImage(), y*IMap.renderImage, x*IMap.renderImage, IMap.renderImage, IMap.renderImage, this);
					System.out.print(model.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage()+ " ");
				} else if ( model.getMap().getOnTheMapXY(x, y) == null ) {
					System.out.print("  ");
					graphics.drawImage(this.image, y*IMap.renderImage, x*IMap.renderImage, IMap.renderImage, IMap.renderImage, this);
				}
			}
			System.out.println("");
		}
		for (int x = 0 ; x < model.getPlayerList().size(); x++) {
			System.out.println("Player "+ (x+1)+" : " + model.getPlayer(x).getPosition().getX() + "x/" + model.getPlayer(x).getPosition().getX() + "y" );
		}
	}
}
