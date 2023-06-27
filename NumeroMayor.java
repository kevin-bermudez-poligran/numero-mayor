public class NumeroMayor {
	public static int determine(int[] list) {
		int listLength = list.length;
		int[] orderedList = new int[listLength];
		int control = list[0];
		
		for (int x=1;x<listLength;x++) {		
			if(list[x] > control) {
				control = list[x];
			}
		}
		
		return control;
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

		System.out.println("El mayor es: ");
		long startTime = System.nanoTime();
		int may = determine(numbers);
		long endTime = System.nanoTime() - startTime; 
		
		System.out.println(may);
		System.out.println("Tiempo transcurrido es:");
		System.out.println(endTime);
	}
}
