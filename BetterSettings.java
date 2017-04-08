import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Settings extends JPanel{
	public static JSpinner target_width, amplitude;
	
	public Settings() {
		GridLayout experimentLayout = new GridLayout(0,3);
		experimentLayout.setVgap(5);
		experimentLayout.setHgap(5);
		setLayout(experimentLayout);
		JLabel label = new JLabel("Settings omg yay");
		add(label);
		
		this.target_width = new JSpinner();
		this.amplitude = new JSpinner();
		
		add(target_width);
		add(amplitude);
		
		JComponent target_editor = ((JSpinner.DefaultEditor) target_width.getEditor());
		Dimension pref_size = new Dimension(40, 40);
	    //prefSize = new Dimension(40, 40);
	    target_editor.setPreferredSize(pref_size);
	    target_width.addChangeListener(new ChangeListener(){
	    	public void stateChanged(ChangeEvent e) {}
	    });
	    
	    JComponent amp_editor = ((JSpinner.DefaultEditor) amplitude.getEditor());
		Dimension amp_pref_size = new Dimension(40, 40);
	    //prefSize = new Dimension(40, 40);
		amp_editor.setPreferredSize(amp_pref_size);
		amplitude.addChangeListener(new ChangeListener(){
	    	public void stateChanged(ChangeEvent e) {}
	    });
	}
}
