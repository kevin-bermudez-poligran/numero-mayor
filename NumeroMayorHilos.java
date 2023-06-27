public class NumeroMayorHilos {
	public static int[] getSlice(int[] array, int startIndex, int endIndex)   
	{   
	// Get the slice of the Array   
	int[] slicedArray = new int[endIndex - startIndex];   
	//copying array elements from the original array to the newly created sliced array  
	for (int i = 0; i < slicedArray.length; i++)   
	{   
	slicedArray[i] = array[startIndex + i];   
	}   
	//returns the slice of an array  
	return slicedArray;   
	} 
	
	public static void main(String[] args) {
		int quantityNumbers = 1000;
		int[] numbers = new int[quantityNumbers];
		
		for (int x=0;x<quantityNumbers;x++) {
			int newNumber;
			newNumber = (int) (Math.random()*2000)+1;
			System.out.println(newNumber);
			numbers[x] = newNumber;
		}
		System.out.println("Hola Mundo");

		
		long startTime = System.nanoTime();
		
		DeterminarNumeroMayor cx1 = new DeterminarNumeroMayor();
		cx1.list = getSlice(numbers,0,500);
		
		DeterminarNumeroMayor cx2 = new DeterminarNumeroMayor();
		cx2.list = getSlice(numbers,500,1000);
		
		
		cx1.start();
		cx2.start();
			
		int mayorDef = cx2.mayor;
		
		if(cx1.mayor > cx2.mayor) {
			mayorDef = cx1.mayor;
		}
		
		long endTime = System.nanoTime() - startTime; 
		
		System.out.println("El mayor es: ");
		System.out.println(mayorDef);
		System.out.println("Tiempo transcurrido es:");
		System.out.println(endTime);
	}
}

class DeterminarNumeroMayor extends Thread {
	public int mayor;
	public int[] list;

    @Override
    public void run() {
		int listLength = this.list.length;
		int[] orderedList = new int[listLength];
		int control = this.list[0];
		
		for (int x=1;x<listLength;x++) {		
			if(this.list[x] > control) {
				control = this.list[x];
			}
		}
		
		this.mayor = control;
	}
}
