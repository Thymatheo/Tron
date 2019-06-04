package model.element;

import contract.ISprite;

public class Sprite implements ISprite {

		private String ConsoleImage;
		
		public Sprite(String consoleImage) {
			this.setConsoleImage(consoleImage);
		}

		public String getConsoleImage() {
			return ConsoleImage;
		}

		public void setConsoleImage(String consoleImage) {
			ConsoleImage = consoleImage;
		}
}
