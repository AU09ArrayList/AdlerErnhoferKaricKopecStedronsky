package adler.dynamicData;

/**
 * Diese Klasse ist die Testklasse für die MyArrayList.
 * @author Philipp Adler
 * @author Andi Ernhofer
 * @version 2014-03-14
 */
public class TestKlasse {
	/**
	 * Die Main-Methode wo alles getestet wird
	 */
	public static void main(String[] args) {
		MyArrayList array = new MyArrayList(2);//erzeugt eine Liste mit der Größe von 2
		array.add("A");//fügt am Ende der Liste hinzu
		array.add("B");//fügt am Ende der Liste hinzu
		array.add("C");//fügt am Ende der Liste hinzu
		array.add(1,"D");//fügt an einem bestimmten Index hinzu und schiebt alle die danach sind um 1 nach hinten
		array.add(2,"E");//fügt an einem bestimmten Index hinzu und schiebt alle die danach sind um 1 nach hinten
		array.add("F");//fügt am Ende der Liste hinzu
		System.out.println("Size: "+array.size());//Gibt die aktuelle Größe der Liste aus
		System.out.println("Vor dem Löschen des zweiten Eintrages:  "+array.get(3));//Gibt das Objekt, welches an der dritten Stelle liegt aus.
		array.remove(2);//Löscht das Objekt, welches an der zweiten Stelle liegt.
		System.out.println("Size: "+array.size());//Gibt die aktuelle Größe der Liste aus
		System.out.println("Nach dem Löschen des zweiten Eintrages: "+array.get(3));//Gibt das Objekt, welches an der dritten Stelle liegt aus.
		array.remove(3);//Löscht den dritten Eintrag in der Liste und schiebt alle die danach sind um eins nach vorne
		System.out.println("Size: "+array.size());//Gibt die aktuelle Größe der Liste aus
	}

}
