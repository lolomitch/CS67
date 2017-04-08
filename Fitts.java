import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class FittsLawGame extends JPanel{
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static int window_width = (int)screenSize.getWidth();
	private static int window_height = (int)screenSize.getHeight();
	private static int width = window_width/2, height = window_height/2;
	private Rectangle target, start;
	private List<Rectangle> shapes = new ArrayList<Rectangle>();
	private Settings start_panel = new Settings();
	
	
	private class Canvas extends JComponent {

		public void paint(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.white);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.black);
			for (Rectangle r : shapes) {
				g.fillRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
			}
		}

		public void addRect(int xPos, int yPos, int width, int height) {
			shapes.add(new Rectangle(xPos, yPos, width, height));
			System.out.println("yayayayay");
			repaint();
		}

		public Dimension getPreferredSize() {
			return new Dimension(width, height);
		}
	}
	public FittsLawGame() {
		final Canvas canvas = new Canvas();
		int result = JOptionPane.showConfirmDialog(null, start_panel,
				"Edit Settings", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			System.out.println("omg" + Settings.target_width.getValue());
			System.out.println("omg2" + Settings.amplitude.getValue());
			canvas.addRect(20, 40, (int)Settings.target_width.getValue() * 10, 40);
		}
		add(canvas);
		canvas.setVisible(true);
	}
	private static void createAndShowGui() {
		FittsLawGame game = new FittsLawGame();

		JFrame frame = new JFrame("Fitts");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(game);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setLocation((window_width-width) / 2, (window_height-height) / 2);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}
}
