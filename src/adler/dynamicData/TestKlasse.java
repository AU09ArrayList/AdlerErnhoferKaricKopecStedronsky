package adler.dynamicData;

/**
 * Diese Klasse ist die Testklasse f�r die MyArrayList.
 * @author Philipp Adler
 * @author Andi Ernhofer
 * @version 2014-03-14
 */
public class TestKlasse {
	/**
	 * Die Main-Methode wo alles getestet wird
	 */
	public static void main(String[] args) {
		MyArrayList array = new MyArrayList(2);//erzeugt eine Liste mit der Gr��e von 2
		array.add("A");//f�gt am Ende der Liste hinzu
		array.add("B");//f�gt am Ende der Liste hinzu
		array.add("C");//f�gt am Ende der Liste hinzu
		array.add(1,"D");//f�gt an einem bestimmten Index hinzu und schiebt alle die danach sind um 1 nach hinten
		array.add(2,"E");//f�gt an einem bestimmten Index hinzu und schiebt alle die danach sind um 1 nach hinten
		array.add("F");//f�gt am Ende der Liste hinzu
		System.out.println("Size: "+array.size());//Gibt die aktuelle Gr��e der Liste aus
		System.out.println("Vor dem L�schen des zweiten Eintrages:  "+array.get(3));//Gibt das Objekt, welches an der dritten Stelle liegt aus.
		array.remove(2);//L�scht das Objekt, welches an der zweiten Stelle liegt.
		System.out.println("Size: "+array.size());//Gibt die aktuelle Gr��e der Liste aus
		System.out.println("Nach dem L�schen des zweiten Eintrages: "+array.get(3));//Gibt das Objekt, welches an der dritten Stelle liegt aus.
		array.remove(3);//L�scht den dritten Eintrag in der Liste und schiebt alle die danach sind um eins nach vorne
		System.out.println("Size: "+array.size());//Gibt die aktuelle Gr��e der Liste aus
	}

}
