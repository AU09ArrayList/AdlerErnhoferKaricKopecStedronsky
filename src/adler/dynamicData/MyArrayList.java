package adler.dynamicData;

/**
 * Diese Klasse sollte der ArrayList immitieren. In der Klasse befinden sich die gleichen Methoden wie in der ArrayList
 * @author Philipp Adler
 * @version 2014-03-14
 */
public class MyArrayList {
	private Object[] array;//dieses Array vom Typ Object soll eine ArrayList darstellen
	private int index;//Z�hlvariable um sich zu merken wieviele Elemente schon in der Liste gespeichert sind, also die L�nge der Liste


	/**
	 * Das ist der Default-Konstruktor der Klasse, welcher eine leere Liste mit der Kapazit�t aus 10 Elemente inizialisiert.
	 */
	public MyArrayList(){
		this(10);//leitet es an den Konstruktor mit Parameter weiter
	}


	/**
	 * Dieser Konstruktor erzeugt eine leere Liste, welche anhand des �bergebenen Parameter die 
	 * Kapazit�t der List inizialisiert.
	 * @param initialCapacity legt die inizialisiert Kapazit�t der Liste fest
	 * @throw Falls die Parameter negativ ist kommt es zu einer Fehlermeldung;
	 */
	public MyArrayList(int initialCapacity) throws IllegalArgumentException{
		if(initialCapacity < 0){//wenn der Parameter negativ ist
			IllegalArgumentException f = new IllegalArgumentException("Illegal Capacity: "+initialCapacity);//erzeugt ein Objekt welche eine Fehlermeldung zur�ckgibt
			throw f;//wirft eine Exception
		}else{//wenn der Parameter positiv ist
			this.array = new Object[initialCapacity];//erzeugt ein Array mit der Gr��e des Parameters
			this.index = 0;//die Z�hlvariable index ist gleich 0
		}
	}


	/**
	 * F�gt das �bergebene Objekt am Ende der Liste hinzu
	 * @param e das Element welches am Ende der Liste hinzugef�gt wird
	 * @return gibt true zur�ck
	 */
	public boolean add(Object e){
		this.add(this.index, e);//benutzt die add-Methode mit dem Index
		return true;
	}


	/**
	 * F�gt das �bergebene Element an der spezifischen Stellen der Liste ein.
	 * Falls das Elemente in der Mitte der Liste hinzugef�gt wird werden die nachfolgenden Indexes um 1 erh�ht
	 * @param index der Index an welcher Position das Element hinzugef�gt werden soll
	 * @param element das Element welches hinzugef�gt wird
	 * @throw Falls der �bergebene Index kleiner 0 oder gr��er als die L�nge der Liste ist kommt es zu einer Fehlermeldung
	 */
	public void add(int index, Object element) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){//wenn der Parameter index kleiner 0 oder gr��er als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft eine Exception
		}
		else{// falls sich der �bergebene Index im erlaubten Rahmen befindet
			if(index < this.index){//falls ein Element in Mitten der Liste hinzugef�gt wird
				Object[] hilfsarray=new Object[this.array.length+1];//das neue Array soll uns helfen das alte Array zu vergr��ern
				int z = 0;
				for(int i=0;i<this.array.length;i++){
					if(index == i){
						hilfsarray[i]=element;
						z = 1;
					}
					hilfsarray[i+z]=this.array[i];//das neue Array �bernimmt die einzelnen Elemante von dem alten Array
				}
				this.array=hilfsarray;//das alte Array ist nun das neue Array
			}
			else{
				try{
					this.array[index] = element;//f�gt das Element beim �bergebenen Index hinzu
				}catch(java.lang.ArrayIndexOutOfBoundsException f){//falls Limit erreicht wird wird die Liste vergr��ert
					Object[] hilfsarray=new Object[this.array.length+1];//das neue Array soll uns helfen das alte Array zu vergr��ern
					for(int i=0;i<this.array.length;i++){
						hilfsarray[i]=this.array[i];//das neue Array �bernimmt die einzelnen Elemante von dem alten Array
					}
					hilfsarray[hilfsarray.length-1]=element;//das neue Objekt wird der neuen Liste hinzugef�gt
					this.array=hilfsarray;//das alte Array ist nun das neue Array
				}
			}
		}
		this.index++;//erh�ht den Index im 1
	}

	
	/**
	 * L�scht alle Elemente von der Liste. Die wird nach diesem Aufruf leer sein.
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
	 * Gibt das Objekt zur�ck, welches den angegebenen Index hat.
	 * @param index Der Index des gew�nschten Objekts.
	 * @throw Falls der �bergebene Index kleiner 0 oder gr��er als die L�nge der Liste ist kommt es zu einer Fehlermeldung.
	 * @return Das gew�nschte Objekt.
	 */
	public Object get(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){//wenn der Parameter index kleiner 0 oder gr��er als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft eine Exception
		}else{// falls sich der �bergebene Index im erlaubten Rahmen befindet
			return this.array[index];//Gibt das gew�nschte Objekt zur�ck
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
	 * L�scht das Element an der spezifischen Stellen der Liste ein.
	 * Falls das Elemente am Anfang oder in der Mitte der Liste gel�scht wird werden die nachfolgenden Indexes um 1 verringert.
	 * @param index der Index an welcher Position das Element gel�scht werden soll.
	 * @throw Falls der �bergebene Index kleiner 0 oder gr��er als die L�nge der Liste ist kommt es zu einer Fehlermeldung
	 * @return Das Obejkt, welches gel�scht wurde.
	 */
	public Object remove(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){//wenn der Parameter index kleiner 0 oder gr��er als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft eine Exception
		}else{// falls sich der �bergebene Index im erlaubten Rahmen befindet
			Object o = this.get(index);
			Object[] zw = new Object[this.array.length]; //Zwischenvariable
			for(int i = 0; i < this.array.length; ++i){
				zw[i] = this.array[i];
			}
			this.array = new Object[this.array.length-1]; //Array verkleinern
			int x = 0;
			for(int i = 0; i < zw.length; ++i){
				if(i != index){
					this.array[x] = zw[i]; //Array wieder f�llen
				}
				if(this.array.length > 0 && this.array.length > x){ //Das gel�schte Element wird nicht wieder eingef�gt
					if(i != index){
						++x;
					}
				}
			}
			this.index--;
			return o;//Gibt das gew�nschte Objekt zur�ck
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
	 * @param element das neue Element welches hinzugef�gt wird
	 * @throw Falls der �bergebene Index kleiner 0 oder gr��er als die L�nge der Liste ist kommt es zu einer Fehlermeldung
	 * @return das Element was vorher in der Liste stand
	 */
	public Object set(int index, Object element) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){//wenn der Parameter index kleiner 0 oder gr��er als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft die Exception
		}else{// falls sich der �bergebene Index im erlaubten Rahmen befindet
			Object o = get(index);//Speichert den alten Wert.
			array[index] = element;//Ersetzt den alten Wert durch den neuen
			return o;//Gibt den alten Wert zur�ck
		}
	}

	/**
	 * Gibt die aktuelle anzahl an Eintr�gen zur�ck.
	 * @return Die anzahl der Eintr�ge
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
