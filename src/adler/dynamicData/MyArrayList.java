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

	/**
	 * gibt die Liste geklont zur�ck
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
		for(int i=0;i<this.index;i++){//Geht alle Listeneintr�ge durch und sucht nach dem Objekt
			if(o.equals(this.get(i))){//Vergleicht das Objekt am aktuellen Index und das gesuchte Objekt
				return true;//Das Objekt wurde gefunden
			}
		}
		return false;//Das Objekt wurde nicht gefunden
	}

	/**
	 * Vergr��ert die minimum Gr��e der Liste
	 * @param minCapacity Die Minimumgr��e
	 */
	public void ensureCapacity(int minCapacity){
		Object[] zw = new Object[this.array.length];//Erzeugt eine Zwischenvariable
		for(int i = 0; i < this.index; i++){
			zw[i] = this.get(i);//Speichert die Objekte in die Zwischenvariable
		}
		this.array = new Object[minCapacity];//Erstellt eine neue Liste mit der gew�nschten minimumgr��e.
		for(int i = 0; i < zw.length; i++){
			this.array[i] = zw[i];//Speichern der Objekte von der Zwischenvariable in die Liste.
		}
	}

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

	/**
	 * Diese Methode �berpr�ft ob die ArrayList leer ist.
	 * @return true oder false
	 */
	public boolean isEmpty(){
		if(this.index==0) { //Checkt ob die Z�hlervariable 0 ist. (Die ArrayList ist bei 0 leer).
			return true;
		}else {
			return false;
		}
	}
	 

	/**
	 * Gibt den ersten Index eines gesuchten Objekts zur�ck
	 * @param o Das gesuchte Objekt
	 * @return Der Index des gesuchten Objekts
	 */
	public int indexOf(Object o){
		for(int i=0;i<this.index;i++){//Geht alle Listeneintr�ge durch und sucht nach dem Objekt
			if(o.equals(this.get(i))){//Vergleicht das Objekt am aktuellen Index und das gesuchte Objekt
				return i;//Gibt den Index zur�ck
			}
		}
		return -1;//Das Objekt wurde nicht gefunden
	}

	/**
	 * Gibt den letzten Index eines gesuchten Objekts zur�ck
	 * @param o Das gesuchte Objekt
	 * @return Der Index des gesuchten Objekts
	 */
	public int lastIndexOf(Object o){
		for(int i=this.index-1;i>=0;i--){//Geht alle Listeneintr�ge durch und sucht nach dem Objekt
			if(o.equals(this.get(i))){//Vergleicht das Objekt am aktuellen Index und das gesuchte Objekt
				return i;//Gibt den Index zur�ck
			}
		}
		return -1;//Das Objekt wurde nicht gefunden
	}

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
			Object[] zw = new Object[this.array.length];//Speichert die Liste in eine Zwischenvariable
			for(int i = 0; i < this.array.length; i++){
				zw[i] = this.get(i);
			}
			this.array = new Object[this.array.length-1]; //Array verkleinern
			int x = 0;
			for(int i = 0; i < zw.length; i++){
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

	/**
	 * L�scht einen bestimmten Eintrag aus der Liste.
	 * @param o Das Objekt, welches gel�scht werden soll
	 * @return Ob das Objekt erfolgreich gel�scht wurde
	 */
	public boolean remove(Object o){
		if(this.contains(o)){//Kontrolliert, ob es das Objekt gibt
			remove(this.indexOf(o));//L�scht das Objekt
			return true;
		}else{
			return false;//Das Objekt wurde nicht gel�scht
		}
	}

	/**
	 * L�scht einen Bereich an Eintr�ge aus der Liste.
	 * @param fromIndex der kleinere Index
	 * @param toIndex Der gr��ere Index
	 * @throw Falls einer der �bergebene Index kleiner 0 oder gr��er als die L�nge der Liste ist
	 *  	  oder der kleinere Index gr��er als der Gr��ere ist, kommt es zu einer Fehlermeldung 
	 */
	protected void removeRange(int fromIndex, int toIndex) throws IndexOutOfBoundsException{
		if(fromIndex < 0 || fromIndex > this.index || toIndex < 0 || toIndex > this.index || fromIndex > toIndex){//wenn der Parameter index kleiner 0 oder gr��er als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft eine Exception
		}else{// falls sich der �bergebene Index im erlaubten Rahmen befindet
			for(int i=fromIndex;i<=toIndex;i++){//Eine Schleife, die alle zu l�schenden Index durchgeht.
				this.remove(i);//L�schen des Eintrages
			}
		}
	}

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
		return this.index;//Gibt die Anzahl der Eintrage zur�ck
	}
	
	/**
	 * Gibt die Liste als Array zur�ck
	 * @return Die Liste als Array.
	 */
	public Object[] toArray(){
		return this.array;
	}

	/**
	 * Verkleinert die Liste kleinst m�glich. L�scht leere Eintr�ge am Ende.
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
