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
 * @author Adin Karic
 * @version 2014-03-14
 */
public class MyArrayListGUI implements ActionListener{

	/**
	 * @param args
	 */
	MyArrayList array1;
	String[] text = {"new ArrayList()","new ArrayList(int initialCapacity)","add(Object e)","add(int index, Object element)","clear()","clone()","contains(Object o)","ensureCapacity(int minCapacity)","set(int index, Object element)","size()","get(int index)","remove(int index)","remove(Object o)","removeRange(int fromIndex, int toIndex)","indexOf(Object o)","lastIndexOf(Object o)","isEmpty()","toArray()","trimToSize()"};
	public MyArrayListGUI() {
		JFrame frame = new JFrame("Test-GUI");
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,5));
		JButton[] buttonArray = new JButton[text.length];
		for(int i=0; i<this.text.length; i++){
			buttonArray[i] = new JButton(text[i]);
			buttonArray[i].addActionListener(this);
			panel1.add(buttonArray[i]);
		}
		frame.add(panel1);
		frame.setSize(1300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	public void actionPerformed (ActionEvent e){
		if(((JButton) e.getSource()).getText().equals(this.text[0])){
			array1 = new MyArrayList();
		}
		if(((JButton) e.getSource()).getText().equals(this.text[1])){
			int groesse = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Größe!"));
			array1 = new MyArrayList(groesse);
		}else if(((JButton) e.getSource()).getText().equals(this.text[2])){
			String text1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text ein!");
			array1.add(text1);
		}else if(((JButton) e.getSource()).getText().equals(this.text[3])){
			int stelle = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Stelle!"));
			String text1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text ein!");
			array1.add(stelle, text1);
		}else if(((JButton) e.getSource()).getText().equals(this.text[4])){
			array1.clear();
		}else if(((JButton) e.getSource()).getText().equals(this.text[5])){	
			Object[] array2 =array1.clone();
		}else if(((JButton) e.getSource()).getText().equals(this.text[6])){
			String text1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text ein!");
			JOptionPane.showMessageDialog(null, array1.contains(text1));
		}else if(((JButton) e.getSource()).getText().equals(this.text[7])){
			String text1 = JOptionPane.showInputDialog(null, "Um wieviel soll minimum Größe der Liste vergrößert werden");
			JOptionPane.showMessageDialog(null, array1.contains(text1));
		}else if(((JButton) e.getSource()).getText().equals(this.text[8])){
			int stelle = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Stelle!"));
			String text1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text ein!");
			array1.set(stelle, text1);
		}else if(((JButton) e.getSource()).getText().equals(this.text[9])){
			JOptionPane.showMessageDialog(null, "Größe: "+array1.size());
		}else if(((JButton) e.getSource()).getText().equals(this.text[10])){
			int stelle = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Stelle!"));
			JOptionPane.showMessageDialog(null, array1.get(stelle));
		}else if(((JButton) e.getSource()).getText().equals(this.text[11])){
			int stelle = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Stelle!"));
			array1.remove(stelle);
		}else if(((JButton) e.getSource()).getText().equals(this.text[12])){
			String text1 = JOptionPane.showInputDialog(null, "Was soll gelöscht werden!");
			array1.remove(text1);
		}else if(((JButton) e.getSource()).getText().equals(this.text[13])){
			int stelle1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Stelle!"));
			int stelle2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Bestimmen Sie die Stelle!"));
			array1.removeRange(stelle1, stelle2);
		}else if(((JButton) e.getSource()).getText().equals(this.text[14])){
			String text1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text ein!");
			JOptionPane.showMessageDialog(null, array1.indexOf(text1));
		}else if(((JButton) e.getSource()).getText().equals(this.text[15])){
			String text1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text ein!");
			JOptionPane.showMessageDialog(null, array1.lastIndexOf(text1));
		}else if(((JButton) e.getSource()).getText().equals(this.text[16])){
			JOptionPane.showMessageDialog(null, array1.isEmpty());  
		}else if(((JButton) e.getSource()).getText().equals(this.text[17])){
			Object[] array = array1.toArray();
		}else if(((JButton) e.getSource()).getText().equals(this.text[18])){
			JOptionPane.showMessageDialog(null, "Die Liste wird auf das kleinst mögliche verkleinert");
		}
	}

}
