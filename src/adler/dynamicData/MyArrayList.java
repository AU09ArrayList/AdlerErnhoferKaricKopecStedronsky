package adler.dynamicData;
import java.util.Iterator;
/**
 * Diese Klasse sollte der ArrayList immitieren. In der Klasse befinden sich die gleichen Methoden wie in der ArrayList
 * @author Philipp Adler
 * @author Andi Ernhofer
 * @author Thomas Stedronsky
 * @author Jakub Kopec
 * @author Adin Karic
 * @version 2014-03-16
 */
public class MyArrayList implements MyArrayListIterator  {
	private Object[] array;//dieses Array vom Typ Object soll eine ArrayList darstellen
	private int index;//Zählvariable um sich zu merken wieviele Elemente schon in der Liste gespeichert sind, also die Länge der Liste


	/**
	 * Das ist der Default-Konstruktor der Klasse, welcher eine leere Liste mit der Kapazität aus 10 Elemente inizialisiert.
	 */
	public MyArrayList(){
		this(10);//leitet es an den Konstruktor mit Parameter weiter
	}

 
	/**
	 * Dieser Konstruktor erzeugt eine leere Liste, welche anhand des übergebenen Parameter die 
	 * Kapazität der List inizialisiert.
	 * @param initialCapacity legt die inizialisiert Kapazität der Liste fest
	 * @throw Falls die Parameter negativ ist kommt es zu einer Fehlermeldung;
	 */
	public MyArrayList(int initialCapacity) throws IllegalArgumentException{
		if(initialCapacity < 0){//wenn der Parameter negativ ist
			IllegalArgumentException f = new IllegalArgumentException("Illegal Capacity: "+initialCapacity);//erzeugt ein Objekt welche eine Fehlermeldung zurückgibt
			throw f;//wirft eine Exception
		}else{//wenn der Parameter positiv ist
			this.array = new Object[initialCapacity];//erzeugt ein Array mit der Größe des Parameters
			this.index = 0;//die Zählvariable index ist gleich 0
		}
	}


	/**
	 * Fügt das übergebene Objekt am Ende der Liste hinzu
	 * @param e das Element welches am Ende der Liste hinzugefügt wird
	 * @return gibt true zurück
	 */
	public boolean add(Object e){
		this.add(this.index, e);//benutzt die add-Methode mit dem Index
		return true;
	}


	/**
	 * Fügt das übergebene Element an der spezifischen Stellen der Liste ein.
	 * Falls das Elemente in der Mitte der Liste hinzugefügt wird werden die nachfolgenden Indexes um 1 erhöht
	 * @param index der Index an welcher Position das Element hinzugefügt werden soll
	 * @param element das Element welches hinzugefügt wird
	 * @throw Falls der übergebene Index kleiner 0 oder größer als die Länge der Liste ist kommt es zu einer Fehlermeldung
	 */
	public void add(int index, Object element) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){//wenn der Parameter index kleiner 0 oder größer als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft eine Exception
		}
		else{// falls sich der übergebene Index im erlaubten Rahmen befindet
			if(index < this.index){//falls ein Element in Mitten der Liste hinzugefügt wird
				Object[] hilfsarray=new Object[this.array.length+1];//das neue Array soll uns helfen das alte Array zu vergrößern
				int z = 0;
				for(int i=0;i<this.array.length;i++){
					if(index == i){
						hilfsarray[i]=element;
						z = 1;
					}
					hilfsarray[i+z]=this.array[i];//das neue Array übernimmt die einzelnen Elemante von dem alten Array
				}
				this.array=hilfsarray;//das alte Array ist nun das neue Array
			}
			else{
				try{
					this.array[index] = element;//fügt das Element beim übergebenen Index hinzu
				}catch(java.lang.ArrayIndexOutOfBoundsException f){//falls Limit erreicht wird wird die Liste vergrößert
					Object[] hilfsarray=new Object[this.array.length+1];//das neue Array soll uns helfen das alte Array zu vergrößern
					for(int i=0;i<this.array.length;i++){
						hilfsarray[i]=this.array[i];//das neue Array übernimmt die einzelnen Elemante von dem alten Array
					}
					hilfsarray[hilfsarray.length-1]=element;//das neue Objekt wird der neuen Liste hinzugefügt
					this.array=hilfsarray;//das alte Array ist nun das neue Array
				}
			}
		}
		this.index++;//erhöht den Index im 1
	}


	/**
	 * Löscht alle Elemente von der Liste. Die wird nach diesem Aufruf leer sein.
	 */
	public void clear(){
		this.array = new Object[this.array.length];
		this.index = 0;
	}

	/**
	 * gibt die Liste geklont zurück
	 */
	public Object[] clone(){
		return this.array.clone();
	}
	 

	/**
	 * Die Methode returnt ob sich das Element in der Liste befindet.
	 * @param o das Element was in der Liste gesucht werden soll
	 * @return true wenn sich das Element in der Liste befindet
	 */
	public boolean contains(Object o){
		for(int i=0;i<this.index;i++){//Geht alle Listeneinträge durch und sucht nach dem Objekt
			if(o.equals(this.get(i))){//Vergleicht das Objekt am aktuellen Index und das gesuchte Objekt
				return true;//Das Objekt wurde gefunden
			}
		}
		return false;//Das Objekt wurde nicht gefunden
	}

	/**
	 * Vergrößert die minimum Größe der Liste
	 * @param minCapacity Die Minimumgröße
	 */
	public void ensureCapacity(int minCapacity){
		Object[] zw = new Object[this.array.length];//Erzeugt eine Zwischenvariable
		for(int i = 0; i < this.index; i++){
			zw[i] = this.get(i);//Speichert die Objekte in die Zwischenvariable
		}
		this.array = new Object[minCapacity];//Erstellt eine neue Liste mit der gewünschten minimumgröße.
		for(int i = 0; i < zw.length; i++){
			this.array[i] = zw[i];//Speichern der Objekte von der Zwischenvariable in die Liste.
		}
	}

	/**
	 * Gibt das Objekt zurück, welches den angegebenen Index hat.
	 * @param index Der Index des gewünschten Objekts.
	 * @throw Falls der übergebene Index kleiner 0 oder größer als die Länge der Liste ist kommt es zu einer Fehlermeldung.
	 * @return Das gewünschte Objekt.
	 */
	public Object get(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){//wenn der Parameter index kleiner 0 oder größer als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft eine Exception
		}else{// falls sich der übergebene Index im erlaubten Rahmen befindet
			return this.array[index];//Gibt das gewünschte Objekt zurück
		}
	}

	/**
	 * Diese Methode überprüft ob die ArrayList leer ist.
	 * @return true oder false
	 */
	public boolean isEmpty(){
		if(this.index==0) { //Checkt ob die Zählervariable 0 ist. (Die ArrayList ist bei 0 leer).
			return true;
		}else {
			return false;
		}
	}
	 

	/**
	 * Gibt den ersten Index eines gesuchten Objekts zurück
	 * @param o Das gesuchte Objekt
	 * @return Der Index des gesuchten Objekts
	 */
	public int indexOf(Object o){
		for(int i=0;i<this.index;i++){//Geht alle Listeneinträge durch und sucht nach dem Objekt
			if(o.equals(this.get(i))){//Vergleicht das Objekt am aktuellen Index und das gesuchte Objekt
				return i;//Gibt den Index zurück
			}
		}
		return -1;//Das Objekt wurde nicht gefunden
	}

	/**
	 * Gibt den letzten Index eines gesuchten Objekts zurück
	 * @param o Das gesuchte Objekt
	 * @return Der Index des gesuchten Objekts
	 */
	public int lastIndexOf(Object o){
		for(int i=this.index-1;i>=0;i--){//Geht alle Listeneinträge durch und sucht nach dem Objekt
			if(o.equals(this.get(i))){//Vergleicht das Objekt am aktuellen Index und das gesuchte Objekt
				return i;//Gibt den Index zurück
			}
		}
		return -1;//Das Objekt wurde nicht gefunden
	}

	/**
	 * Löscht das Element an der spezifischen Stellen der Liste ein.
	 * Falls das Elemente am Anfang oder in der Mitte der Liste gelöscht wird werden die nachfolgenden Indexes um 1 verringert.
	 * @param index der Index an welcher Position das Element gelöscht werden soll.
	 * @throw Falls der übergebene Index kleiner 0 oder größer als die Länge der Liste ist kommt es zu einer Fehlermeldung
	 * @return Das Obejkt, welches gelöscht wurde.
	 */
	public Object remove(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){//wenn der Parameter index kleiner 0 oder größer als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft eine Exception
		}else{// falls sich der übergebene Index im erlaubten Rahmen befindet
			Object o = this.get(index);
			Object[] zw = new Object[this.array.length];//Speichert die Liste in eine Zwischenvariable
			for(int i = 0; i < this.array.length; i++){
				zw[i] = this.get(i);
			}
			this.array = new Object[this.array.length-1]; //Array verkleinern
			int x = 0;
			for(int i = 0; i < zw.length; i++){
				if(i != index){
					this.array[x] = zw[i]; //Array wieder füllen
				}
				if(this.array.length > 0 && this.array.length > x){ //Das gelöschte Element wird nicht wieder eingefügt
					if(i != index){
						++x;
					}
				}
			}
			this.index--;
			return o;//Gibt das gewünschte Objekt zurück
		}
	}

	/**
	 * Löscht einen bestimmten Eintrag aus der Liste.
	 * @param o Das Objekt, welches gelöscht werden soll
	 * @return Ob das Objekt erfolgreich gelöscht wurde
	 */
	public boolean remove(Object o){
		if(this.contains(o)){//Kontrolliert, ob es das Objekt gibt
			remove(this.indexOf(o));//Löscht das Objekt
			return true;
		}else{
			return false;//Das Objekt wurde nicht gelöscht
		}
	}

	/**
	 * Löscht einen Bereich an Einträge aus der Liste.
	 * @param fromIndex der kleinere Index
	 * @param toIndex Der größere Index
	 * @throw Falls einer der übergebene Index kleiner 0 oder größer als die Länge der Liste ist
	 *  	  oder der kleinere Index größer als der Größere ist, kommt es zu einer Fehlermeldung 
	 */
	protected void removeRange(int fromIndex, int toIndex) throws IndexOutOfBoundsException{
		if(fromIndex < 0 || fromIndex > this.index || toIndex < 0 || toIndex > this.index || fromIndex > toIndex){//wenn der Parameter index kleiner 0 oder größer als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft eine Exception
		}else{// falls sich der übergebene Index im erlaubten Rahmen befindet
			for(int i=fromIndex;i<=toIndex;i++){//Eine Schleife, die alle zu löschenden Index durchgeht.
				this.remove(i);//Löschen des Eintrages
			}
		}
	}

	/**
	 * Ersetzt das Objekt an einem bestimmten Index durch ein neues.
	 * @param index der Index an welcher Position das Element erzetzt werden soll
	 * @param element das neue Element welches hinzugefügt wird
	 * @throw Falls der übergebene Index kleiner 0 oder größer als die Länge der Liste ist kommt es zu einer Fehlermeldung
	 * @return das Element was vorher in der Liste stand
	 */
	public Object set(int index, Object element) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){//wenn der Parameter index kleiner 0 oder größer als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft die Exception
		}else{// falls sich der übergebene Index im erlaubten Rahmen befindet
			Object o = get(index);//Speichert den alten Wert.
			array[index] = element;//Ersetzt den alten Wert durch den neuen
			return o;//Gibt den alten Wert zurück
		}
	}

	/**
	 * Gibt die aktuelle anzahl an Einträgen zurück.
	 * @return Die anzahl der Einträge
	 */
	public int size(){
		return this.index;//Gibt die Anzahl der Eintrage zurück
	}
	
	/**
	 * Gibt die Liste als Array zurück
	 * @return Die Liste als Array.
	 */
	public Object[] toArray(){
		return this.array;
	}

	/**
	 * Verkleinert die Liste kleinst möglich. Löscht leere Einträge am Ende.
	 */
	public void trimToSize(){
		Object[] zw = new Object[this.index];//Erzeugt eine Zwischenvariable
		for(int i = 0; i < this.index; ++i){
			zw[i] = this.get(i);//Speichert die Objekte in die Zwischenvariable
		}
		this.array = new Object[this.index];//Verkleinern der Liste
		for(int i = 0; i < zw.length; ++i){
			this.array[i] = zw[i];//Speichern der Objekte von der Zwischenvariable in die Liste.
		}
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
