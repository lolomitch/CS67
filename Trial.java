import java.awt.Point;
import java.awt.Rectangle;


public class Trial {
	public int subject_id;
	public int trial_num;
	public int amplitude;
	public int target_width;
	public Point start_pos;
	public Point target_pos;
	public int time;
	public int success;
	public int start_side_size = 38; //10mm in pixels
	
	public Trial(int subject_id, int trial_num, int amplitude, int target_width, int canvas_w, int canvas_h) {
		this.subject_id = subject_id;
		this.trial_num = trial_num;
		this.amplitude = amplitude;
		this.target_width = target_width;
		
		int random_startx = (int)(Math.random() * (canvas_w - (start_side_size + 1))); 
		int random_starty = (int)(Math.random() * (canvas_h - (start_side_size + 1))); 
		
		this.start_pos = new Point(random_startx, random_starty);
		Rectangle r = new Rectangle(0, 0, canvas_w, canvas_h);
		this.target_pos = getTargetPos(random_startx, random_starty, amplitude, r);
	}
	
	public Point getTargetPos(int start_x, int start_y, int amp, Rectangle r) {
		double rand_radian = (Math.random() * 2.0 * Math.PI);
		int x = (int)(amp * Math.cos(rand_radian));
		int y = (int)(amp * Math.sin(rand_radian));
		Point p = new Point(x + start_x, y + start_y);
		while (!r.contains(p)) {
			rand_radian = (Math.random() * 2.0 * Math.PI);
			x = (int)(amp * Math.cos(rand_radian));
			y = (int)(amp * Math.sin(rand_radian));
			p = new Point(x,y);
		}
		return p;
	}
	
}
