package adler.dynamicData;

/**
 * Diese Klasse ist die Testklasse f�r die MyArrayList.
 * @author Philipp Adler
 * @version 2014-03-14
 */
public class TestKlasse {
	/**
	 * Die Main-Methode wo alles getestet wird
	 */
	public static void main(String[] args) {
		MyArrayList array = new MyArrayList(2);//erzeugt eine Liste mit der Gr��e von 2
		array.add("A");//f�gt am Ende der Liste hinzu
		array.add("D");//f�gt am Ende der Liste hinzu
		array.add("E");//f�gt am Ende der Liste hinzu
		array.add(1,"B");//f�gt an einem bestimmten Index hinzu und schiebt alle die danach sind um 1 nachvorne
		array.add(2,"C");//f�gt an einem bestimmten Index hinzu und schiebt alle die danach sind um 1 nachvorne
		array.add("F");//f�gt am Ende der Liste hinzu
	}

}
