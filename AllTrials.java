import java.util.ArrayList;
import java.util.List;


public class AllTrials {
	public List<Trial> trials_list;// = new ArrayList<Trial>();
	public List<Integer> amps;
	public List<Integer> widths;
	public int trials_total;
	public int screen_w;
	public int screen_h;
	public int subject_id;
	
	
	public AllTrials(ArrayList<Integer> amps, ArrayList<Integer> widths, int subject_id, int screen_w, int screen_h) {
		trials_list = new ArrayList<Trial>();
		trials_total = amps.size() * widths.size();
		this.amps = amps;
		this.widths = widths;
		this.subject_id = subject_id;
		this.screen_w = screen_w;
		this.screen_h = screen_h;
	}
	
	public void createTrials() {
		int i = 0;
		for (int a : amps) {
			for (int w : widths) {
				Trial new_trial = new Trial(subject_id,  i,  a,  w,  screen_w,  screen_h);
				trials_list.add(new_trial);
				i++;
			}
		}
	}
}
