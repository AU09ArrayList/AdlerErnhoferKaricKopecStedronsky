import org.junit.*;
public class JUnitTest {


	@Test
	public void MyArrayList(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList();
		if(a.size()!=0){
			throw new RuntimeException("Fail Konstruktor");
		}
	}

	@Test
	public void MyArrayList1(){
		try{
			adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList(1);
		}catch(IllegalArgumentException f){
			throw new RuntimeException("Fail Konstruktor(int)");
		}
	}

	@Test 
	public void add(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList(0);
		try{
			a.add(0,"Test");
		}catch(IndexOutOfBoundsException f){
			throw new RuntimeException("Fail add(Object)");
		}
	}

	@Test
	public void add1(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList(1);
		a.add("Test");
		if(!a.get(0).equals("Test")){
			throw new RuntimeException("Fail add(int,Object)");
		}
	}

	@Test
	public void clear(){
		adler.dynamicData.MyArrayList array = new adler.dynamicData.MyArrayList();
		array.add("A");
		array.add("B");
		array.add("C");
		array.clear();
		if(array.isEmpty()==false) {
			throw new RuntimeException("Fail clear()");
		}
	}

	@Test
	public void clonee(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList();
		Object[] b = a.clone();
		if(a.array.length == b.length){
			for(int i = 0; i<b.length;i++){
				if(a.array[i]!=b[i]){
					throw new RuntimeException("Fail clone()");
				}
			}
		}else{
			throw new RuntimeException("Fail clone()");
		}

	}

	@Test
	public void contains(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList();
		a.add("A");
		a.add("B");
		if(!a.contains("B")){
			throw new RuntimeException("Fail contains(Object)");
		}
	}

	@Test
	public void ensureCapacity(){//Failed
		adler.dynamicData.MyArrayList array = new adler.dynamicData.MyArrayList(10);
		array.ensureCapacity(0);
		if(array.size()!=0) {
			throw new RuntimeException("Fail ensureCapacity(int)");
		}
	}

	@Test
	public void get(){
		adler.dynamicData.MyArrayList array = new adler.dynamicData.MyArrayList();
		array.add("A");
		array.add("B");
		array.add("C");
		try{
			Object o = array.get(2);
		}
		catch(IndexOutOfBoundsException f){
			throw new RuntimeException("Fail get(int)");
		}
	}

	@Test
	public void isEmpty(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList();
		if(!a.isEmpty()){
			throw new RuntimeException("Fail isEmpty()");
		}
	}

	@Test
	public void indexOf(){
		//Jakub
	}

	@Test
	public void lastIndexOf(){
		//Jakub
	}

	@Test
	public void remove(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList();
		a.add("A");
		a.add("B");
		a.add("C");
		try{
			a.remove(1);
		}catch(IndexOutOfBoundsException f){
			throw new RuntimeException("Fail remove(int)");
		}
	}

	@Test
	public void remove1(){
		adler.dynamicData.MyArrayList a = new adler.dynamicData.MyArrayList();
		a.add("A");
		a.add("B");
		if(!a.remove("A")){
			throw new RuntimeException("Fail remove(Object)");
		}
	}

	@Test
	public void removeRange(){
		//Jakub
	}

	@Test
	public void set(){
		//Jakub
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

	@Test
	public void toArray(){
		adler.dynamicData.MyArrayList array = new adler.dynamicData.MyArrayList();
		array.add("A");
		array.add("B");
		array.add("C");
		Object[] o = array.toArray();
	}

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

	/**
	@Test
	public void iterator(){
		adler.dynamicData.MyArrayList array = new adler.dynamicData.MyArrayList();
		array.add("A");
		array.add("B");
		array.add("C");
		array.iterator();
	}

	@Test
	public void listIterator(){
		adler.dynamicData.MyArrayList array = new adler.dynamicData.MyArrayList();
		array.add("A");
		array.add("B");
		array.add("C");
		array.listIterator();
	}

	@Test
	public void listIterator1(){
		//Jakub
	}
	**/
}
