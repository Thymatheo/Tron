package contract;

import java.awt.Image;

public interface ISprite {

		String getConsoleImage();
		
		Image getImage();
		
		void setImageName(String imageName);
		
		void loadImage(String imageName);
		
		String getImageName();
}
