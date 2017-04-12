import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
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
//		//setLayout(null);
		GridBagConstraints c = new GridBagConstraints();
//		Container cp = getContentPane();
//		cp.setLayout(null);
//		cp.setPreferredSize(new Dimension(400, 300));
		//setSize(300 + insets.left + insets.right,
	              //125 + insets.top + insets.bottom);
		
		SpinnerModel trial_model = new SpinnerNumberModel(1, 1, 12, 1); //default value,lower bound,upper bound,increment by
		trials = new JSpinner(trial_model);
		SpinnerModel subj_model = new SpinnerNumberModel(0, 0, 10, 1); //default value,lower bound,upper bound,increment by
		subject_id = new JSpinner(subj_model);
		SpinnerModel target_model = new SpinnerNumberModel(15, 5, 100, 5); //default value,lower bound,upper bound,increment by
		target_width = new JSpinner(target_model);
		SpinnerModel amp_model = new SpinnerNumberModel(60, 10, FittsLawGame.height, 2); // SHOULD HAVE A MIN OF 40 default value,lower bound,upper bound,increment by
		amplitude = new JSpinner(amp_model);
		
		c.fill = GridBagConstraints.BOTH;
        
        JLabel l1 = new JLabel("subject_id");
        gridbag.setConstraints(l1, c);
        add(l1);
        Dimension size = l1.getPreferredSize();
        l1.setBounds(0, 0, size.width + 20, size.height + 20);
        c.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(subject_id, c);
        add(subject_id);
        Dimension size2 = subject_id.getPreferredSize();
        l1.setBounds(200, 200, size2.width, size2.height);
        
        c.gridwidth = 1;
        
        JLabel l2 = new JLabel("trials per condition");
        gridbag.setConstraints(l2, c);
        add(l2);
        c.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(trials, c);
        add(trials);
        
        c.gridwidth = 1;
        
        gridbag.setConstraints(target_width, c);
        add(target_width);
        JButton add_wid = new JButton("+");
        gridbag.setConstraints(add_wid, c);
        add(add_wid);
        JButton rem_wid = new JButton("-");
        gridbag.setConstraints(rem_wid, c);
        add(rem_wid);
        
        gridbag.setConstraints(amplitude, c);
        add(amplitude);
        JButton add_amps = new JButton("+");
        gridbag.setConstraints(add_amps, c);
        add(add_amps);
        JButton rem_amps = new JButton("-");
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(rem_amps, c);
        add(rem_amps);
        
        c.weightx = 0.5;
        c.ipady = 20;
        c.gridwidth = 1;
        
        c.insets = new Insets(0,0,0,50);
        
        DefaultListModel widListModel = new DefaultListModel();
        JList widList = new JList(widListModel);
        gridbag.setConstraints(widList, c);
        add(widList);
        
        c.insets = new Insets(0,10,0,0);
        
        DefaultListModel ampListModel = new DefaultListModel();
        c.gridwidth = GridBagConstraints.REMAINDER;
        JList list = new JList(ampListModel);
        gridbag.setConstraints(list, c);
        add(list);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.gridwidth = 1;
        c.weighty = 0.0;
        
        JLabel l3 = new JLabel("Indices of Diff");
        gridbag.setConstraints(l3, c);
        add(l3);
        
        JLabel l4 = new JLabel(" "); //unique combos
        gridbag.setConstraints(l4, c);
        add(l4);
        
        c.insets = new Insets(20,10,0,0);
        
        JTextArea IOD = new JTextArea();
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(IOD, c);
        add(IOD);
        
        JLabel total_trials = new JLabel("Total Trials: 0");
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridbag.setConstraints(total_trials, c);
        add(total_trials);
        
        
        add_wid.addActionListener(new ActionListener()
        {
        	  public void actionPerformed(ActionEvent e)
        	  {
        	    // display/center the jdialog when the button is pressed
        	    //System.out.println(amplitude.getValue());
        		  w_list.add((int)target_width.getValue());
//        		  wid.append(Integer.toString((int)target_width.getValue()));
//        		  wid.append("\n");
        		  
        		  widListModel.addElement(target_width.getValue());
        		  
        		  total_trials.setText("Total Trials: " + Integer.toString(totalTrials()));
        		  
        		  IOD.setText(null);
        		  Set<Double> iod = calcIOD();
        		  if (iod != null){
        			  l4.setText(Integer.toString(iod.size()) + " unique combos");
	        		  for (double d : iod) {
	        			  IOD.append(Double.toString(d));
	        			  IOD.append("\n");
	        		  }
        		  }
        		  else {
        			  l4.setText(Integer.toString(0) + " unique combos");
        		  }
        	  }
        });
        
        rem_wid.addActionListener(new ActionListener()
        {
        	  public void actionPerformed(ActionEvent e)
        	  {
        		  int index = widList.getSelectedIndex();
        		  if (index >= 0) {
        			  System.out.println(w_list);
            		  w_list.remove(index);
            		  System.out.println(w_list);

            		  widListModel.remove(index);
        		  }
        		  
        		  
        		  total_trials.setText("Total Trials: " + Integer.toString(totalTrials()));
        		  
        		  IOD.setText(null);
        		  Set<Double> iod = calcIOD();
        		  if (iod != null){
        			  l4.setText(Integer.toString(iod.size()) + " unique combos");
	        		  for (double d : iod) {
	        			  IOD.append(Double.toString(d));
	        			  IOD.append("\n");
	        		  }
        		  }
        		  else {
        			  l4.setText(Integer.toString(0) + " unique combos");
        		  }
        	  }
        });
        
        add_amps.addActionListener(new ActionListener()
        {
        	  public void actionPerformed(ActionEvent e)
        	  {
        	    // display/center the jdialog when the button is pressed
        	    //System.out.println(amplitude.getValue());
        		  amp_list.add((int)amplitude.getValue());
//        		  amps.append(Integer.toString((int)amplitude.getValue()));
//        		  amps.append("\n");
        		  ampListModel.addElement(amplitude.getValue());
        		  
        		  total_trials.setText("Total Trials: " + Integer.toString(totalTrials()));
        		  
        		  IOD.setText(null);
        		  Set<Double> iod = calcIOD();
        		  if (iod != null){
        			  l4.setText(Integer.toString(iod.size()) + " unique combos");
	        		  for (double d : iod) {
	        			  IOD.append(Double.toString(d));
	        			  IOD.append("\n");
	        		  }
        		  }
        		  else {
        			  l4.setText(Integer.toString(0) + " unique combos");
        		  }
        	  }
        });
        
        rem_amps.addActionListener(new ActionListener()
        {
        	  public void actionPerformed(ActionEvent e)
        	  {
        		  int index = list.getSelectedIndex();
        	    // display/center the jdialog when the button is pressed
        		  if (index >= 0) {
        			  System.out.println(amp_list);
        			  amp_list.remove(index);
        			  System.out.println(amp_list);
        			  ampListModel.remove(index);
        		  }
        		  
        		  total_trials.setText("Total Trials: " + Integer.toString(totalTrials()));
        		  
        		  IOD.setText(null);
        		  Set<Double> iod = calcIOD();
        		  if (iod != null){
        			  l4.setText(Integer.toString(iod.size()) + " unique combos");
	        		  for (double d : iod) {
	        			  IOD.append(Double.toString(d));
	        			  IOD.append("\n");
	        		  }
        		  }
        		  else {
        			  l4.setText(Integer.toString(0) + " unique combos");
        		  }
        	  }
        });
        
		
        JComponent trial_editor = ((JSpinner.DefaultEditor) trials.getEditor());
		Dimension trial_pref_size = new Dimension(40, 40);
	    //prefSize = new Dimension(40, 40);
		trial_editor.setPreferredSize(trial_pref_size);
		trials.addChangeListener(new ChangeListener(){
	    	public void stateChanged(ChangeEvent e) {
	    		
	    		total_trials.setText("Total Trials: " + Integer.toString(totalTrials()));
	    	}
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
	
	public Set<Double> calcIOD() {
		 Set<Double> iod = new HashSet<Double>();
		if (amp_list.isEmpty() || w_list.isEmpty()) {
			return null;
		}
		for (int w : w_list) {
			for (int a : amp_list) {
				double inner = (2.0 * (double)a) / (double)w;
				double upper_log = Math.log10(inner);
				double lower_log = Math.log10(2.0);
				iod.add(upper_log/lower_log);
			}
		}
		return iod;
	}
	
	public int totalTrials() {
		return w_list.size() * amp_list.size() * (int)trials.getValue();
	}
}
