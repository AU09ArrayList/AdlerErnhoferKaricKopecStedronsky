package adler.dynamicData;

import java.util.Iterator;

import javax.swing.*;


/**
 * Diese Klasse ist die Testklasse f�r die MyArrayList.
 * @author Philipp Adler
 * @author Andi Ernhofer
 * @author Thomas Stedronsky
 * @author Jakub Kopec
 * @author Adin Karic
 * @version 2014-03-14
 */
public class TestKlasse {
	/**
	 * Die Main-Methode wo alles getestet wird
	 */
	public static void main(String[] args) {
		Object[] options = {"Nein","Abbrechen","Ja"};
		int n = JOptionPane.showOptionDialog(null,"Wollen Sie mit der graphischen Oberfl�che arbeiten?","Mit GUI?",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
		if(n==0){
			test();
		}else if(n==1){
			System.exit(0);
		}else if(n==2){
			new MyArrayListGUI();
		}
	}
	public static void test(){
		MyArrayList array = new MyArrayList(1);//erzeugt eine Liste mit der Gr��e von 2
		array.add("A");//f�gt am Ende der Liste hinzu
		array.add("B");//f�gt am Ende der Liste hinzu
		array.clear();//l�scht den Inhalt der Liste
		array.add("C");//f�gt am Ende der Liste hinzu
		array.add(0,"D");//f�gt an einem bestimmten Index hinzu und schiebt alle die danach sind um 1 nach hinten
		array.add(0,"E");//f�gt an einem bestimmten Index hinzu und schiebt alle die danach sind um 1 nach hinten
		array.add("F");//f�gt am Ende der Liste hinzu
		System.out.println("Das Element D befindet sich in der Liste: "+array.contains("D"));//Gibt aus ob sich das Element in der Liste befindet
		array.set(0, "AA");//f�gt anstelle dem vorherigen Element A AA ein
		System.out.println("Size: "+array.size());//Gibt die aktuelle Gr��e der Liste aus
		System.out.println("Vor dem L�schen des zweiten Eintrages:  "+array.get(3));//Gibt das Objekt, welches an der dritten Stelle liegt aus.
		array.remove(2);//L�scht das Objekt, welches an der zweiten Stelle liegt.
		System.out.println("Size: "+array.size());//Gibt die aktuelle Gr��e der Liste aus
		System.out.println("Nach dem L�schen des zweiten Eintrages: "+array.get(1));//Gibt das Objekt, welches an der dritten Stelle liegt aus.
		array.remove(1);//L�scht den dritten Eintrag in der Liste und schiebt alle die danach sind um eins nach vorne
		System.out.println("Size: "+array.size());//Gibt die aktuelle Gr��e der Liste aus
		array.remove("F");//L�scht F aus der Liste
		System.out.println("Size: "+array.size());//Gibt die aktuelle Gr��e der Liste aus
		array.clear();
		array.add("A");//f�gt am Ende der Liste hinzu
		array.add("B");//f�gt am Ende der Liste hinzu
		array.add("C");//f�gt am Ende der Liste hinzu
		array.add(0,"D");//f�gt an einem bestimmten Index hinzu und schiebt alle die danach sind um 1 nach hinten
		array.add(0,"E");//f�gt an einem bestimmten Index hinzu und schiebt alle die danach sind um 1 nach hinten
		array.add("F");//f�gt am Ende der Liste hinzu
		System.out.println("\nSize: "+array.size());//Gibt die aktuelle Gr��e der Liste aus
		array.removeRange(1, 3);
		System.out.println("Size: "+array.size());//Gibt die aktuelle Gr��e der Liste aus
		array.add("A");
		System.out.println("\nIndex of A:      "+array.indexOf("A"));
		System.out.println("Index of last A: "+array.lastIndexOf("A"));
		System.out.println("Ist das Array leer: "+array.isEmpty());
		array.clear();
		System.out.println("Ist das Array leer: "+array.isEmpty());
		
		}
	}

