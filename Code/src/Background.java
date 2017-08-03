
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel {
	private static final long serialVersionUID = 1L;
	private String pathImage = "";

	public Background(String pathImage) {
		this.pathImage = pathImage;
	}

	@Override
	public void paintComponent(Graphics g) {

		Graphics2D gr = (Graphics2D) g.create();

		try {

			BufferedImage buffer = ImageIO.read(new File(pathImage));
			gr.drawImage(buffer, null, 0, 0);

		} catch (IOException ex) {
			Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
