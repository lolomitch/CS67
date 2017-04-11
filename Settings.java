import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Settings extends JPanel{
	public static JSpinner target_width, amplitude, subject_id, trials;
	
	public static ArrayList<Integer> amp_list = new ArrayList<Integer>();
	public static ArrayList<Integer> w_list = new ArrayList<Integer>();
	
	public Settings() {
		setPreferredSize(new Dimension(400, 300));
		
		GridBagLayout gridbag = new GridBagLayout();
		setLayout(gridbag);
		GridBagConstraints c = new GridBagConstraints();
		
		trials = new JSpinner();
		subject_id = new JSpinner();
		target_width = new JSpinner();
		amplitude = new JSpinner();
		
		c.fill = GridBagConstraints.BOTH;
        //c.weightx = 1.0;
        //c.weighty = 0.0;
        
        JLabel l1 = new JLabel("subject_id");
        gridbag.setConstraints(l1, c);
        add(l1);
        c.gridwidth = GridBagConstraints.REMAINDER;
		//add(new JLabel("subject_id", JLabel.LEFT));
		gridbag.setConstraints(subject_id, c);
        add(subject_id);
        
        //c.gridheight = 1;
        c.gridwidth = 1;
        
        JLabel l2 = new JLabel("trials per condition");
        gridbag.setConstraints(l2, c);
        add(l2);
        c.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(trials, c);
        add(trials);
        
//        c.gridheight = 1;
//        c.gridwidth = 1;
//        c.fill = GridBagConstraints.BOTH;
//        c.weightx = 1.0;
//        //c.weighty = 1.0;
//        c.gridheight = 1;
        c.gridwidth = 1;
        //c.weighty = 0.0;
        
        gridbag.setConstraints(target_width, c);
        add(target_width);
        JButton add_wid = new JButton("add widths");
        //c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(add_wid, c);
        add(add_wid);
        
        gridbag.setConstraints(amplitude, c);
        add(amplitude);
        JButton add_amps = new JButton("add amps");
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(add_amps, c);
        add(add_amps);
        
        
        
        //c.fill = GridBagConstraints.BOTH;
        //c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.0;
        c.ipady = 20;
        //c.gridheight = 5;
        c.gridwidth = 1;
        
        c.insets = new Insets(0,0,0,50);
        
        JTextArea wid = new JTextArea();
        wid.setMinimumSize(new Dimension(200, 200));
        //c.gridwidth = GridBagConstraints.RELATIVE;
        gridbag.setConstraints(wid, c);
        add(wid);
        
        c.insets = new Insets(0,10,0,0);
        
        JTextArea amps = new JTextArea();
        //amps.setPreferredSize(new Dimension(100, 200));
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(amps, c);
        add(amps);
        
        //c.insets = new Insets(0,10,0,0);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        //c.weighty = 1.0;
        //c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        
        JLabel l3 = new JLabel("Indices of Diff");
        gridbag.setConstraints(l3, c);
        add(l3);
        
        JLabel l4 = new JLabel(" ");
        gridbag.setConstraints(l4, c);
        add(l4);
        
        c.insets = new Insets(20,10,0,0);
        
        JTextArea IOD = new JTextArea();
        //IOD.setPreferredSize(new Dimension(200, 200));
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(IOD, c);
        add(IOD);
        
        add_amps.addActionListener(new ActionListener()
        {
        	  public void actionPerformed(ActionEvent e)
        	  {
        	    // display/center the jdialog when the button is pressed
        	    //System.out.println(amplitude.getValue());
        		  amp_list.add((int)amplitude.getValue());
        		  amps.append(Integer.toString((int)amplitude.getValue()));
        		  amps.append("\n");
        	  }
        });
		
        JComponent trial_editor = ((JSpinner.DefaultEditor) trials.getEditor());
		Dimension trial_pref_size = new Dimension(40, 40);
	    //prefSize = new Dimension(40, 40);
		trial_editor.setPreferredSize(trial_pref_size);
		trials.addChangeListener(new ChangeListener(){
	    	public void stateChanged(ChangeEvent e) {}
	    });
        
		JComponent subj_editor = ((JSpinner.DefaultEditor) subject_id.getEditor());
		Dimension subj_pref_size = new Dimension(40, 40);
	    //prefSize = new Dimension(40, 40);
		subj_editor.setPreferredSize(subj_pref_size);
		subject_id.addChangeListener(new ChangeListener(){
	    	public void stateChanged(ChangeEvent e) {}
	    });
	    
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
