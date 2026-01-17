import java.util.*;
// Main class that provides menu-driven interface
public class StudentInformationSystem {
    // Scanner object for user input
    static Scanner sc= new Scanner(System.in);
    // ArrayList to store student records dynamically
    static ArrayList<Student> students = new ArrayList<>();

     // Main method
    public static void main(String arges[]){
        int choice;
        // Loop continues until user chooses Exit
        do{
            System.out.println("\n ===== Student Information System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("\nEnter your Choice: ");

            choice=sc.nextInt();

            // Menu selection using switch
            switch(choice){
                case 1: 
                    addStudent();
                    break;
                case 2: 
                    viewAllStudents();
                    break;
                case 3: 
                    searchStudent();
                    break;
                case 4: 
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6: System.out.println("Exiting Program...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }while(choice !=6);
    }
    // Method to add a new student
    static void addStudent(){
        System.out.println("\n=== ADD NEW STUDENT ===");
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();// clear buffer

        System.out.print("Enter Name: ");
        String name= sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        if(age<=0){
            System.out.println("Invalid Age");
            return;
        }

        System.out.print("Enter Grade: ");
        double grade= sc.nextDouble();
        sc.nextLine();// clear buffer

        System.out.print("Enter Contact: ");
        String contact= sc.nextLine();

        // Add student object to ArrayList
        students.add(new Student(id, name, age, grade, contact));
        System.out.println("\nStudent Added Successfully");
    }

    // Method to display all students
    static void viewAllStudents(){
        if(students.isEmpty()){
        System.out.println("No Student record found");
        return;
    }
     // Table header
    System.out.printf("%-10s %-15s %-5s %-5s %-15s\n",
    "ID","Name","Age","Grade","Contact");
    System.out.println("--------------------------------------------------");

    // Display each student
    for(Student s: students){
        s.display();
    }}

    // Method to search student by ID or Name
     static void searchStudent(){
        System.out.println("Search student by - \n1. ID\n2. Name");
        int option=sc.nextInt();
        sc.nextLine();// clear buffer

        if(option==1){
            System.out.print("Enter Student Id: ");
            int id= sc.nextInt();

            for(Student s: students){
                if(s.getStudentID()==id){
                    s.display();
                    return;
                }
            }
        }
        else if(option ==2){
            System.out.print("Enter Name: ");
            String name=sc.nextLine();

            for(Student s : students){
                if(s.getName().equalsIgnoreCase(name)){
                    s.display();
                    return;
                }
            }
        }
        System.out.println("Student not found!");
     }

    // Method to update student details
    static void updateStudent(){
        System.out.print("Enter Student ID to update: ");
        int id=sc.nextInt();

        for (Student s : students){
            if(s.getStudentID()==id){
                System.out.print("Enter new Age: ");
                s.setAge(sc.nextInt());

                System.out.print("Enter new Grade: ");
                s.setGrade(sc.nextDouble());

                System.out.print("Enter new Contact: ");
                sc.nextLine();
                s.setContact(sc.nextLine());

                System.out.println("Student Updated Successfully");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Method to delete a student
     static void deleteStudent(){
        System.out.print("Enter Student ID to delete: ");
        int id= sc.nextInt();

        Iterator<Student> is=students.iterator();
        while(is.hasNext()){
            if(is.next().getStudentID()==id){
                is.remove();
                System.out.println("Student Deleted Successfully");
                return;
            }
        }
        System.out.println("Student not found!");
     }

}

