import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	private ArrayList<Rectangle> shapes = new ArrayList<Rectangle>();
	private Settings start_panel = new Settings();
	
	private static AllTrials trials_in_game;
	private int trials_left;
	private static Canvas canvas;
	
	
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

		public void addRect(int xPos, int yPos, int width, int height, int pos) {
			shapes.set(pos, new Rectangle(xPos, yPos, width, height));
			System.out.println("yayayayay");
			repaint();
		}

		public Dimension getPreferredSize() {
			return new Dimension(width, height);
		}
	}
	public FittsLawGame() throws InterruptedException {
		shapes.add(new Rectangle(0,0,0,0));
		shapes.add(new Rectangle(0,0,0,0));
		canvas = new Canvas();
		int result = JOptionPane.showConfirmDialog(null, start_panel,
				"Edit Settings", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			System.out.println("omg" + Settings.target_width.getValue());
			System.out.println("omg2" + Settings.amplitude.getValue());
			canvas.addRect(20, 40, (int)Settings.target_width.getValue() * 10, 40, 0);
		}
		add(canvas);
		canvas.setVisible(true);
		ArrayList<Integer> amps = new ArrayList<Integer>();
		amps.add(50);
		amps.add(150);
		amps.add(200);
		ArrayList<Integer> widths = new ArrayList<Integer>();
		widths.add(10);
		widths.add(20);
		widths.add(15);
		trials_in_game = new AllTrials(amps, widths, 0, width, height);
		trials_in_game.createTrials();
		//trials_in_game = at.trials_list;
		System.out.println(trials_in_game.trials_list.get(0).start_pos);
		System.out.println(trials_in_game.trials_list.get(0).target_pos);
//		trials_left = trials_in_game.trials_list.size();
//		for (Trial t : trials_in_game.trials_list) {
//			canvas.addRect(t.start_pos.x, t.start_pos.y, t.start_side_size, t.start_side_size, 0);
//			canvas.addRect(t.target_pos.x, t.target_pos.y, t.target_width, t.target_width, 1);
//			TimeUnit.SECONDS.sleep(2);
//		}
	}
	private static void createAndShowGui() throws InterruptedException {
		FittsLawGame game = new FittsLawGame();

		JFrame frame = new JFrame("Fitts");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(game);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setLocation((window_width-width) / 2, (window_height-height) / 2);
		frame.setVisible(true);
		for (Trial t : trials_in_game.trials_list) {
			canvas.addRect(t.start_pos.x, t.start_pos.y, t.start_side_size, t.start_side_size, 0);
			canvas.addRect(t.target_pos.x, t.target_pos.y, t.target_width, t.target_width, 1);
			//TimeUnit.SECONDS.sleep(2);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGui();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
