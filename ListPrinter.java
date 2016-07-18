import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ListPrinter {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		BinHeap binHeap = new BinHeap();
		System.out.println("Please give the name of the file where student records are stored.");
		String filename = scan.nextLine();
		String line = null;
		
		try{
			FileReader fileReader = new FileReader(filename);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null)
			{
				Scanner s = new Scanner(line);
				try{
					if(s.hasNextLong())
					{
						long id = s.nextLong();
						if(id > 0)
						{
							if(s.hasNext())
							{
								String last = s.next();
								if(!s.hasNext())
								{
									Student student = new Student(id, last);
									binHeap.insert(student);
								}
							}
						}
					}
				}
				catch(Exception MyException)
				{
					;
				}
			}
			
			bufferedReader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("404! File Not Found!");
		}
		catch(IOException e)
		{
			System.out.println("Error reading file");
		}
		
//		System.out.println("toString: " + binHeap.toString());
		
		System.out.println("Student List: ");
		int size = binHeap.size();
		for(int i = 0; i < size; i++)
		{
			System.out.println(i+1 + ". { " + binHeap.deleteMin() + " }");
		}
		
	}
}
