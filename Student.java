public class Student implements Comparable<Student> {
	private long studentID;
	private String lastName;
	
	public Student(long StudentID, String lastName)
	{
		this.studentID = StudentID;
		this.lastName = lastName;
	}
	
	public int compareTo(Student other)
	{
		int num = 0;
		if(this.studentID < other.studentID)
		{
			num = -1;
		}
		else if(this.studentID == other.studentID)
		{
			num = 0;
		}
		else if(this.studentID > other.studentID)
		{
			num = 1;
		}
		return num;
	}
	
	public String toString()
	{
		String res = "id #: " + studentID + ", name: " + lastName;
		return res;
	}
}
