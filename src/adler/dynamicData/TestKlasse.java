package adler.dynamicData;

/**
 * Diese Klasse ist die Testklasse für die MyArrayList.
 * @author Philipp Adler
 * @version 2014-03-14
 */
public class TestKlasse {
	/**
	 * Die Main-Methode wo alles getestet wird
	 */
	public static void main(String[] args) {
		MyArrayList array = new MyArrayList(2);//erzeugt eine Liste mit der Größe von 2
		array.add("A");//fügt am Ende der Liste hinzu
		array.add("D");//fügt am Ende der Liste hinzu
		array.add("E");//fügt am Ende der Liste hinzu
		array.add(1,"B");//fügt an einem bestimmten Index hinzu und schiebt alle die danach sind um 1 nachvorne
		array.add(2,"C");//fügt an einem bestimmten Index hinzu und schiebt alle die danach sind um 1 nachvorne
		array.add("F");//fügt am Ende der Liste hinzu
	}

}
