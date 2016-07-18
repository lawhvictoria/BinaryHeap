import java.util.Scanner;

public class HeapTest {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		BinHeap binHeap = null;
		int size = -1;
		while(size == -1)
		{
			System.out.println("Give the size of the heap");
			if(scan.hasNextInt())
			{
				size = scan.nextInt();	
				if(size > 0)
				{
					binHeap = new BinHeap(size);
				}
			}
			else
			{
				System.out.println("Invalid Option!");
				scan.next();
				size = -1;
			}
		}
				
		System.out.println("Choose one of the following operations:\n"
				+ "add an element (enter the letter a)\n"
				+ "delete the smallest element (enter the letter d)\n"
				+ "is the heap empty (enter the letter e)\n"
				+ "size of the collection (enter the letter s)\n"
				+ "print the collection (enter the letter p)\n"
				+ "Quit (enter the letter q)");

		boolean cont = true;
		while(cont)
		{
			System.out.println("Please enter a menu choice.");
			String choice = scan.next();
			switch(choice)
			{
			case "a":
				System.out.println("What value would you like to insert?");
				scan.nextLine();
				String str = scan.nextLine();
				binHeap.insert(str);
				System.out.println(str + " inserted");
				break;		
				
			case "d":
				try{
					System.out.println(binHeap.deleteMin() + " deleted");
					break;
				}
				catch(Exception MyException){
                    System.out.println("Invalid operation: The Heap is Empty!");
                    break;
                }
				
			case "e":
				if(binHeap.isEmpty() == true)
				{
					System.out.println("Heap is empty");
				}
				else
				{
					System.out.println("Heap is not empty");
				}
				break;
				
			case "s":
				System.out.println("The size is " + binHeap.size());
				break;
				
			case "p":
				System.out.println(binHeap.toString());
				break;
				
			case "q":
				System.out.println("Quitting...");
				cont = false;
/*				System.out.println(binHeap.toString());*/
				int sizeB = binHeap.size();
				for(int i = 1; i < sizeB + 1; i++)
				{
					System.out.print(binHeap.deleteMin() + " ");
				}
				break;
				
			default:
				System.out.println("Invalid Option");
				break;
			}
		}
	}
}
