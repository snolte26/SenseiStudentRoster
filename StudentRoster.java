import java.util.Scanner;
import java.util.ArrayList;

public class StudentRoster {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Student> student = new ArrayList<Student>(10);
		
		int select = 0;
		int id = 0;
		boolean exit = false;
		
		do {
			// Display main menu
			System.out.println();
			System.out.println("What would you like to do? 1-4");
			System.out.println();
			System.out.println("1. Sensei Menu");
			System.out.println("2. View All Students");
			System.out.println("3. Search Students");
			System.out.println("4. Exit");
			System.out.println();
			
			while (true) {
				select = input.nextInt();
				if (select > 0 && select < 5) {
					break;
				}else {
					System.out.println("Must be 1-4");
					continue;
				}
			}
			//`````````````````````````````````````````````````````````````````````````
			switch(select)
			{
			case 1:
				//go to sensei menu
				SenseiMenu(student);
				break;
			case 2:
				System.out.println("Heres your Students:");
				System.out.println();
				for(int i = 0; i < student.size(); i++) {
					System.out.println("ID: " + student.get(i).getID());
					System.out.println("Name: " + student.get(i).getName());
					System.out.println("Age: " + student.get(i).getAge());
					System.out.println("Gender: " + student.get(i).getGender());
					System.out.println("Belt: " + student.get(i).getRank());
					System.out.println("Date Tested: " + student.get(i).getDateTested());
					System.out.println("Ready to Test: " + student.get(i).getTestReady());
					System.out.println();
				}
				break;
			case 3:
				int choice = 0;
				System.out.println("How would you like to search? 1-2");
				System.out.println();
				System.out.println("1. ID");
				System.out.println("2. Ready to Test");
				
				
				while (true) {
					choice = input.nextInt();
					if (choice > 0 && choice < 3) {
						break;
					}else {
						System.out.println("Must be 1-2");
						continue;
					}
				}
				switch(choice)
				{
				case 1:
					System.out.println("Enter ID: ");
					id = input.nextInt();
					
					if (student.get(id-1) != null) {
						System.out.println("ID: " + student.get(id-1).getID());
						System.out.println("Name: " + student.get(id-1).getName());
						System.out.println("Age: " + student.get(id-1).getAge());
						System.out.println("Gender: " + student.get(id-1).getGender());
						System.out.println("Belt: " + student.get(id-1).getRank());
						System.out.println("Date Tested: " + student.get(id-1).getDateTested());
						System.out.println("Ready to Test: " + student.get(id-1).getTestReady());
						System.out.println();
					}
					
					break;
				case 2:
					String ready = "Yes";
					System.out.println("Searching...");
					for(int i = 0; i < student.size(); i++) {
						
						if (student.get(i).getTestReady().equals(ready)) {
							System.out.println("ID: " + student.get(i).getID());
							System.out.println("Name: " + student.get(i).getName());
							System.out.println("Age: " + student.get(i).getAge());
							System.out.println("Gender: " + student.get(i).getGender());
							System.out.println("Belt: " + student.get(i).getRank());
							System.out.println();
							
							
						}
						
					}
					break;
				}
				
				
				break;
			case 4:
				
				int confirmQuit;
				System.out.println("Are you sure? 1 for yes, 0 for no");
				confirmQuit = input.nextInt();
				// confirm user wants to exit
				if (confirmQuit == 1) {
					// set variable to break out of loop
					exit = true;
					System.out.println("Goodbye");
				} else {
					exit = false;
					input.close();
				}
					

				// break out of switch statement
				System.out.println();
				break;
				
			}
		}
		while(!exit);

	}
	//`````````````````````````````````````````````````````````````````````````
	public static ArrayList<Student> SenseiMenu(ArrayList<Student> s) {
		int selection = 0;
		Scanner input = new Scanner(System.in);
		boolean goBack = false;
		
		
		String name, rank, gender, comments;
		int age, id;
		String dateTested, testReady;
		
		do {
			System.out.println();
			System.out.println("What would you like to do? 1-4");
			System.out.println();
			System.out.println("1. Add Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. Main Menu");
			System.out.println();
			
			while (true) {
				selection = input.nextInt();
				if (selection > 0 && selection < 5) {
					System.out.println();
					break;
				}else {
					System.out.println("Must be 1-4");
					continue;
				}
			}
			switch(selection) 
			{
			case 1:
				// Add student
				
				// Get Student Info
				System.out.println("Name: ");
				input.nextLine();
				name = input.nextLine();
				
				System.out.println("Belt: ");
				rank = input.nextLine();
				
				System.out.println("Gender: ");
				gender = input.nextLine();
				
				System.out.println("Age: ");
				age = input.nextInt();
				
				System.out.println("Date Tested: ");
				input.nextLine();
				dateTested = input.nextLine();
				
				System.out.println("Ready to Test (Yes/No): ");
				testReady = input.nextLine();
				
				
				
				// Iterate through list
				
				if (s.isEmpty() || s == null) {
					System.out.println("Creating Student");
					// Create new student and set information
					Student newStudent = new Student();
					newStudent.setID(0);
					newStudent.setName(name);
					newStudent.setRank(rank);
					newStudent.setGender(gender);
					newStudent.setAge(age);
					newStudent.setDateTested(dateTested);
					newStudent.setTestReady(testReady);
					
					// Add new student to the list
					s.add(newStudent);
					
					
				}else {
					

					System.out.println("Creating Student");
					// Create new student and set information
					Student newStudent = new Student();
					
					newStudent.setID(s.size());
					newStudent.setName(name);
					newStudent.setRank(rank);
					newStudent.setGender(gender);
					newStudent.setAge(age);
					newStudent.setDateTested(dateTested);
					newStudent.setTestReady(testReady);
							
					// Add new student to the list
					s.add(newStudent);
							
				}
				
				break;
			case 2: 
				// Update field of student
				
				System.out.println("Enter Student ID: ");
				id = input.nextInt();
				
				System.out.println("what would you like to update? 1-4");
				System.out.println();
				System.out.println("1. Belt Rank");
				System.out.println("2. Age");
				System.out.println("3. Test Date");
				System.out.println("4. Ready to Test");
				System.out.println();
				
				while (true) {
					selection = input.nextInt();
					if (selection > 0 && selection < 5) {
						break;
					}else {
						System.out.println("Must be 1-4");
						continue;
					}
				}
				
				switch(selection)
				{
				case 1: 
					// get the info to update
					System.out.println("Belt: ");
					input.nextLine();
					rank = input.nextLine();
					
					// if student exists, update the field
					if (s.get(id-1) != null) {
						s.get(id-1).setRank(rank);
					} else {
						System.out.println("Error: No Student with that ID Exists");
					}
					break;
				case 2:
					// get the info to update
					System.out.println("Age: ");
					age = input.nextInt();
					
					// if student exists, update the field
					if (s.get(id-1) != null) {
						s.get(id-1).setAge(age);
					} else {
						System.out.println("Error: No Student with that ID Exists");
					}
					break;
				case 3: 
					// get the info to update
					System.out.println("Date Tested: ");
					input.nextLine();
					dateTested = input.nextLine();
					
					// if student exists, update the field
					if (s.get(id-1) != null) {
						s.get(id-1).setDateTested(dateTested);
					} else {
						System.out.println("Error: No Student with that ID Exists");
					}
					break;
				case 4:
					// get the info to update
					System.out.println("Ready to Test (Yes/No): ");
					input.nextLine();
					testReady = input.nextLine();
					
					// if student exists, update the field
					if (s.get(id-1) != null) {
						s.get(id-1).setTestReady(testReady);
					} else {
						System.out.println("Error: No Student with that ID Exists");
					}
					break;
				}
				System.out.println("Updated!");
				
				break;
			case 3: 
				System.out.println("Which Student to Delete: ");
				id = input.nextInt();
				
				s.remove(id);
				for (int i = 0; i < s.size(); i++) {
					s.get(i).setID(i);
				}
				break;
			case 4: 
				// back to main menu
				
				int confirmQuit;
				
				System.out.println("Are you sure? 1 for yes, 0 for no");
				confirmQuit = input.nextInt();
				
				// confirm user wants to exit
				if (confirmQuit == 1) {
					// set variable to break out of loop
					goBack = true;
					System.out.println("Back to Main Menu");
				} else {
					goBack = false;
					input.close();
				}
					
				// break out of switch statement
				System.out.println();
				break;
			}
		}
		while(!goBack);
		
		
		return s;
	}

}

class Student{
	private String name, rank, gender, comments;
	private int age, id;
	private String dateTested;
	private String testReady;
	
	public Student() {
		setName("");
		setRank("");
		setGender("");
		setComments("");
		setAge(0);
		setID(0);
		setDateTested("");
		setTestReady("");
	}
	//````````````````````````````````````````````````````````````````````````
	public void setID(int ID) {
		id = ID;
	}
	public int getID() {
		return id;
	}
	//````````````````````````````````````````````````````````````````````````
	public void setName(String Name) {
		name = Name;
	}
	public String getName() {
		return name;
	}
	//````````````````````````````````````````````````````````````````````````
	public void setRank(String Rank) {
		rank = Rank;
	}
	public String getRank() {
		return rank;
	}
	//````````````````````````````````````````````````````````````````````````
	public void setGender(String Gender) {
		gender = Gender;
	}
	public String getGender() {
		return gender;
	}
	//````````````````````````````````````````````````````````````````````````
	public void setComments(String Comments) {
		comments = Comments;
	}
	public String getComments() {
		return comments;
	}
	//````````````````````````````````````````````````````````````````````````
	public void setAge(int Age) {
		age = Age;
	}
	public int getAge() {
		return age;
	}
	//````````````````````````````````````````````````````````````````````````
	public void setDateTested(String DateTested) {
		dateTested = DateTested;
	}
	public String getDateTested() {
		return dateTested;
	}
	//````````````````````````````````````````````````````````````````````````
	public void setTestReady(String TestReady) {
		testReady = TestReady;
	}
	public String getTestReady() {
		return testReady;
	}
	//````````````````````````````````````````````````````````````````````````
}

