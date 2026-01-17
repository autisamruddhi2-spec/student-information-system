// Student class represents a single student record
// Implements encapsulation using private data members
class Student{
    // Private data members
    private int studentID;
    private String name;
    private int age;
    private double grade;
    private String contact;

    
    // Parameterized constructor to initialize student details
    public Student(int studentID, String name, int age, double grade, String contact){
        this.studentID=studentID;
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.contact=contact;
    }
      // Getter method for student ID
    public int getStudentID(){
         return studentID;
    }
     // Getter method for student name
    public String getName(){
        return name;
    }
    // Setter method for age with validation
    public void setAge(int age){
        if(age>0)
            this.age=age;
    }
    // Getter method for grade
    public double getGrade(){
        return grade;
    }
    // Setter method for grade
    public void  setGrade(double grade){
        this.grade=grade;
    }
    // Setter method for contact 
    public void setContact(String contact){
        this.contact=contact;
    }
    // Method to display student details in formatted manner
    public void display(){
        System.out.printf("%-10d %-15s %-5d %-5.2f %-15s\n", studentID, name, age, grade, contact);
    }
}
