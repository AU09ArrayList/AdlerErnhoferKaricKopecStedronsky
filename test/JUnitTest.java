
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
	
	@Test
	public void clear(){
		
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
	
	@Test
	public void ensureCapacity(){
		
	}
	
	@Test
	public void get(){
		
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
	
	@Test
	public void toArray(){
		
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
	
	@Test
	public void listIterator(){
		
	}
	
	@Test
	public void listIterator1(){
		
	}

}
