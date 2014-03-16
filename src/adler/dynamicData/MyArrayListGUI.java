package adler.dynamicData;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Diese Klasse ist stellt die FUI für MyArrayList dar.
 * @author Philipp Adler
 * @author Andi Ernhofer
 * @author Thomas Stedronsky
 * @author Jakub Kopec
 * @version 2014-03-14
 */
public class MyArrayListGUI implements ActionListener{

	/**
	 * @param args
	 */
	MyArrayList array1;
	String[] text = {"new ArrayList","add(String)","add(int,String)","clear()","contains(String)","set(int,String)","size()","get(int)","remove(int)","removeRange(int,int)","indexOf(String)","lastIndexOf(String)","isEmpty()"};
	public MyArrayListGUI() {
		JFrame frame = new JFrame("Test-GUI");
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,7));
		JButton[] buttonArray = new JButton[13];
		for(int i=0; i<=12; i++){
			buttonArray[i] = new JButton(text[i]);
			buttonArray[i].addActionListener(this);
			panel1.add(buttonArray[i]);
		}
		frame.add(panel1);
		frame.setSize(1000, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	 public void actionPerformed (ActionEvent e){
	        if(((JButton) e.getSource()).getText().equals(this.text[0])){
	        	int groesse = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Größe!"));
	        	array1 = new MyArrayList(groesse);
	        }else if(((JButton) e.getSource()).getText().equals(this.text[1])){
	        	String text1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text ein!");
	        	array1.add(text1);
	        }else if(((JButton) e.getSource()).getText().equals(this.text[2])){
	        	int stelle = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Stelle!"));
	        	String text1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text ein!");
	        	array1.add(stelle, text1);
	        }else if(((JButton) e.getSource()).getText().equals(this.text[3])){
		        array1.clear();
		    }else if(((JButton) e.getSource()).getText().equals(this.text[4])){
		    	String text1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text ein!");
	        	JOptionPane.showMessageDialog(null, array1.contains(text1)); 
		    }else if(((JButton) e.getSource()).getText().equals(this.text[5])){
		    	int stelle = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Stelle!"));
	        	String text1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text ein!");
	        	array1.set(stelle, text1);
		    }else if(((JButton) e.getSource()).getText().equals(this.text[6])){
		        JOptionPane.showMessageDialog(null, "Größe: "+array1.size());
		    }else if(((JButton) e.getSource()).getText().equals(this.text[7])){
		    	int stelle = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Stelle!"));
		    	JOptionPane.showMessageDialog(null, array1.get(stelle));
		    }else if(((JButton) e.getSource()).getText().equals(this.text[8])){
		    	int stelle = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Stelle!"));
		    	array1.remove(stelle);
		    }else if(((JButton) e.getSource()).getText().equals(this.text[9])){
		    	int stelle1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Stelle!"));
		    	int stelle2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Stelle!"));
		    	array1.removeRange(stelle1, stelle2);
		    }else if(((JButton) e.getSource()).getText().equals(this.text[10])){
		    	String text1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text ein!");
		    	JOptionPane.showMessageDialog(null, array1.indexOf(text1));
		    }else if(((JButton) e.getSource()).getText().equals(this.text[11])){
		    	String text1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text ein!");
		    	JOptionPane.showMessageDialog(null, array1.lastIndexOf(text1));
		    }else if(((JButton) e.getSource()).getText().equals(this.text[12])){
		    	JOptionPane.showMessageDialog(null, array1.isEmpty());  
		    }
	    }

}
