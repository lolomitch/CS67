
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Game extends JPanel {
	private JComponent canvas, gui;
   private Settings settingsPanel = new Settings();
   private JTextArea textArea = new JTextArea(20, 40);

   public Game() {
      add(new JScrollPane(textArea));
      add(new JButton(new AbstractAction("Get Player Information") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            int result = JOptionPane.showConfirmDialog(null, settingsPanel,
                  "Edit Player", JOptionPane.OK_CANCEL_OPTION,
                  JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
            	System.out.println("omg" + Settings.hello.getValue());
//               for (Settings.FieldTitle fieldTitle : 
//            	   Settings.FieldTitle.values()) {
//                  //textArea.append(String.format("%10s: %s%n", fieldTitle.getTitle(),
//                        //settingsPanel.getFieldText(fieldTitle)));
//               }
            }
         }
      }));
   }
   

   private static void createAndShowGui() {
	   Game mainPanel = new Game();

	      JFrame frame = new JFrame("ComplexOptionPane");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().add(mainPanel);
	      frame.pack();
	      frame.setLocationByPlatform(true);
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
