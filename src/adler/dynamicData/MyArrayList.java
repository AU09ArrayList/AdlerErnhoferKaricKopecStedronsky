package adler.dynamicData;

/**
 * Diese Klasse sollte der ArrayList immitieren. In der Klasse befinden sich die gleichen Methoden wie in der ArrayList
 * @author Philipp Adler
 * @version 2014-03-14
 */
public class MyArrayList {
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
	
	/*
	public Object clone(){

	}
	*/
	
	/**
	 * Die Methode returnt ob sich das Element in der Liste befindet.
	 * @param o das Element was in der Liste gesucht werden soll
	 * @return true wenn sich das Element in der Liste befindet
	 */
	public boolean contains(Object o){
		boolean ausgabe = false;
		for(int i=0;i<this.index;i++){
			if(o.equals(this.get(i))){
				ausgabe = true;
				i=this.index;
			}
		}
		return ausgabe;
	}
	
	
	/*
	public void ensureCapacity(int minCapacity){

	}
	 */

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

	/*
	public int indexOf(Object o){

	}

	public boolean isEmpty(){

	}


	public int lastIndexOf(Object o){

	}
	 */
	
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
			Object[] zw = new Object[this.array.length]; //Zwischenvariable
			for(int i = 0; i < this.array.length; ++i){
				zw[i] = this.array[i];
			}
			this.array = new Object[this.array.length-1]; //Array verkleinern
			int x = 0;
			for(int i = 0; i < zw.length; ++i){
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

	/*
	public boolean remove(Object o){

	}

	protected void removeRange(int fromIndex, int toIndex){

	}
	*/
	
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
		return this.index;
	}

	/*
	public Object[] toArray(){

	}

	public void trimToSize(){

	}
	 */
}
