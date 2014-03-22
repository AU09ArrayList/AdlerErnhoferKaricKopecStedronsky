
import org.junit.*;
public class JUnitTest {
	
		
	@Test
	public void MyArrayList(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList();
		if(a.size()!=0){
			throw new RuntimeException("Fail");
		}
	}

	@Test
	public void MyArrayList1(){
		try{
			adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList(1);
		}catch(IllegalArgumentException f){
			throw new RuntimeException("Fail");
		}
	}
	
	@Test 
	public void add(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList(0);
		try{
			a.add(0,"Test");
		}catch(IndexOutOfBoundsException f){
			throw new RuntimeException("Fail");
		}
	}
	
	@Test
	public void add1(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList(1);
		a.add("Test");
	}
	
	/**
	 * JUnit test der Methode clear()
	 * @author Stedronsky Thomas
	 */
	@Test
	public void clear(){
		adler.dynamicData.MyArrayList array = adler.dynamicData.MyArrayList();
		array.add("A");
		array.add("B");
		array.add("C");
		array.clear();
		if(array.isEmpty()==false) {
			throw new RuntimeException("clear() Fehler");
		}
	}
	
	@Test
	public void clonee(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList();
		Object[] b = a.clone();
		if(a.array.length == b.length){
			for(int i = 0; i<b.length;i++){
				if(a.array[i]!=b[i]){
					throw new RuntimeException("Fail");
				}
			}
		}else{
			throw new RuntimeException("Fail");
		}
		
	}
	
	@Test
	public void contains(){
		
	}
	/**
	 * JUnit Test für die Klasse ensureCapacity()
	 * @author Stedronsky Thomas
	 */
	@Test
	public void ensureCapacity(){
		int x=array.size();
		array.ensureCapacity(5);
		if(array.size()!=5) {
			throw new RuntimeException("ensureCapacity() Fehler");
		}
	}
	
	/**
	 * JUnit Test der Klasse get()
	 * @author Stedronsky Thomas
	 */
	@Test
	public void get(){
		adler.dynamicData.MyArrayList array = adler.dynamicData.MyArrayList();
		array.add("A");
		array.add("B");
		array.add("C");
		Object o = array.get(2);
	}
	
	@Test
	public void isEmpty(){
		
	}
	
	@Test
	public void indexOf(){
		
	}
	
	@Test
	public void lastIndexOf(){
		
	}
	
	@Test
	public void remove(){
		
	}
	
	@Test
	public void remove1(){
		
	}
	
	@Test
	public void removeRange(){
		
	}
	
	@Test
	public void set(){
		
	}
	
	@Test
	public void size(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList();
		a.add("A");
		a.add("B");
		a.add("C");
		int size = a.size();
		if(size!=3){
			throw new RuntimeException("Fail");
		}
		
	}
	
	/**
	 * JUnit Test der Klasse toArray()
	 * @author Stedronsky Thomas
	 */
	@Test
	public void toArray(){
		adler.dynamicData.MyArrayList array = adler.dynamicData.MyArrayList();
		array.add("A");
		array.add("B");
		array.add("C");
		Object[] o = array.toArray();
	}
	
	
	//sollte eigentlich funktionieren, glaube iwas in der trimtosize methode funktioniert nicht
	@Test
	public void trimToSize(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList();
		a.add("A");
		a.add("B");
		a.add("C");
		a.add(null);
		a.add(null);
		a.trimToSize();
		int size = a.size();
		if(size!=3){
			throw new RuntimeException("Fail");
		}
		
		
	}
	
	@Test
	public void iterator(){
		
	}
	/**
	 * JUnit test der Klasse listIterator()
	 * @author Stedronsky Thomas
	 */
	@Test
	public void listIterator(){
		adler.dynamicData.MyArrayList array = adler.dynamicData.MyArrayList();
		array.add("A");
		array.add("B");
		array.add("C");
		array.listIterator()
	}
	
	@Test
	public void listIterator1(){
		
	}

}
