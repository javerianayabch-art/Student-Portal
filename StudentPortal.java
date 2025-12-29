
import java.util.Scanner;
public class StudentPortal{
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    Teacher teacher = new Teacher("Abid", "abid1234");
    Student student = new Student("Javeria", "Javi1234");
    boolean loggedIn = false;
    do{
        
    System.out.println("Welcome to the BBSUL Academic Portal");
    System.out.println("Enter Username");
    String username = sc.nextLine();
    System.out.println("Enter Password");
    String password = sc.nextLine();
        
    if(teacher.login(username, password)){
    loggedIn = true;
    boolean logout = false;
    teacher.dashboard();
    while (!logout) {
    System.out.println("Enter Your Choice");
    int choice = sc.nextInt();
    switch (choice) {
    case 1:
    System.out.println("1. " + student.getUserName());
    System.out.println("Enter marks");
    int marks = sc.nextInt();
    teacher.enterMarks(student, marks);
    break;
    case 2:
    System.out.println();
    System.out.println("Enter resource name: ");
    String notes = sc.nextLine();
    sc.nextLine(); 
    teacher.uploadResource(notes);
    break;

    case 3:
    System.out.println("Choose \n 1. Username \n 2. Password ");
    int opt = sc.nextInt();
    sc.nextLine(); 
    if(opt == 1) {
    System.out.println("Enter new username");
    String newUser = sc.nextLine();
    teacher.setUserName(newUser);
    } else if(opt == 2) {
    System.out.println("Enter new password and it should not be in less than 8 characters");
    String newPass = sc.nextLine();
    teacher.setPassword(newPass);
    }
    break;
        
    case 4:
    logout = true;
    System.out.println("Logging out...");
    break;            
    default:
    System.out.println("Invalid Choice");
    break;
        }    
    }
}
    else{
    loggedIn = true;
    boolean logout = false;
    student.dashboard();
    while (!logout) {
    System.out.println("Choose an option");
    int choice = sc.nextInt();
    sc.nextLine();
    switch(choice) {
    case 1:
    student.showResult();
    break;
    case 2:
    System.out.println("---- Resources ----");
    String[] resList = teacher.getResources();
    for(String r : resList) {
    if(r != null) System.out.println(r);
    }
    System.out.println("------------------");
    break;
    case 3:
    System.out.println("Change \n 1. Username \n 2. Password");
    int opt = sc.nextInt();
    sc.nextLine(); 
    if(opt == 1) {
    System.out.println("Enter new username");
    String newUser = sc.nextLine();
    student.setUserName(newUser);
    } else if(opt == 2) {
    System.out.println("Enter new password & it should not be less than 8 characters");
    String newPass = sc.nextLine();
    student.setPassword(newPass);
    }
    break;
    case 4:
    logout = true;
    System.out.println("Logging out...");
    break;
    default:
    System.out.println("Invalid choice!");
            }
        }
    }
    }while(!loggedIn);
    }
}
                                    
abstract class UserLogin{
        
    private String userName,password;
    UserLogin(String userName,String password){
    
    this.userName=userName;
    this.password=password;
    }
        
    public boolean login(String userName, String password){
        return this.userName.equals(userName) && this.password.equals(password);
    }
        
    public String getUserName(){
        return userName;
    }
        
    public void setUserName(String newUserName){
    if (newUserName != null && !newUserName.trim().isEmpty()) {
    this.userName = newUserName;
        }
    }
        
    public void setPassword(String newPassword){
    if (newPassword != null && newPassword.length() >= 8) {
    this.password = newPassword;
        }
    }
        
    public abstract void dashboard();
}
                                    
class Student extends UserLogin{
    private int marks;
    private double percentage;
    private String grade;
    private double cgpa;
    
    Student(String userName, String password){
    super(userName, password);
    }
        
    public void setMarks(int marks) {
    if (marks >= 0 && marks <= 100) {
    this.marks = marks;
    calculateResult(); 
        }
    }
    
    private void calculateResult() {
        calculatePercentage();
        calculateGrade();
        calculateCGPA();
    }
        
    private void calculatePercentage() {
        this.percentage = marks; 
    }
        
    private void calculateGrade() {
        if (percentage >= 90) {
            grade = "A";
        } else if (percentage >= 80) {
            grade = "B";
        } else if (percentage >= 70) {
            grade = "C";
        } else if (percentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
    }
        
    private void calculateCGPA() {
        if (marks >= 85) cgpa = 4.0;
        else if (marks >= 80) cgpa = 3.7;
        else if (marks >= 70) cgpa = 3.0;
        else if (marks >= 60) cgpa = 2.0;
        else cgpa = 0.0;
    }
        
     public void showResult() {
        System.out.println("Marks: " + marks);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("CGPA: " + cgpa);
    }

        
    @Override
    public void dashboard(){
        System.out.println("________________Welcome to the Student Dashboard, " + getUserName() + "!__________________");
        System.out.println("1.View Results");
        System.out.println("2.Get Resources");
        System.out.println("3.Update Profile");
        System.out.println("4.Logout");
        }
}
                                        
class Teacher extends UserLogin{
    private String[] resources = new String[20]; 
    private int resourceCount = 0;

        
    public Teacher(String userName, String password) {
        super(userName, password);
    }
        
    public void enterMarks(Student s, int marks) {
        s.setMarks(marks);
        System.out.println("Marks updated for: " + s.getUserName());
    }
        
    public void uploadResource(String resource) {
        if (resourceCount < resources.length) {
            resources[resourceCount++] = resource;
            System.out.println("Resource uploaded: " + resource);
        } else {
            System.out.println("Resource limit reached. Cannot upload more resources.");
        }
    }
        
    public String[] getResources() {
        return resources;
    }
        
    @Override
    public void dashboard(){
        System.out.println("________________Welcome to the Teacher Dashboard, " + getUserName() + "!__________________");
        System.out.println("1.Update Student Marks");
        System.out.println("2.Upload Resources");
        System.out.println("3.Update Profile");
        System.out.println("4.Logout");
    }
}