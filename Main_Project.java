import java.util.*;
public class Main_Project{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Student students[] = new Student[0];
        Teacher teachers[] = new Teacher[0];
        School school = new School("ABC Public School","B/109 Janakpuri",students,teachers);
        boolean exit = false;
        int choice;
        do{
            System.out.println("                         SCHOOL MANAGEMENT SYSTEM");
            System.out.println("***************************************************************************");
            System.out.println("                        Welcome to ABC Public School");
            System.out.println("1. Enter Student Details");
            System.out.println("2. Enter Teacher Details");
            System.out.println("3. Display Student Details");
            System.out.println("4. Display Teacher Details");
            System.out.println("5. Display Fee Record");
            System.out.println("6. Check School Information");
            System.out.println("7. Exit");
            System.out.print("Enter your choice[1-7]: ");
            choice = sc.nextInt();
            System.out.println();
            switch (choice){
                case 1: 
                        System.out.print("How many students' details you want to enter? ");
                        int num = sc.nextInt();
                        students = new Student[num];
                        for (int i=0; i<num; i++){
                            System.out.println("Enter the details for Student " + (i+1) + ":");
                            System.out.print("Enter name:");
                            String name = sc.next();
                            System.out.print("Enter roll no.:");
                            int rollNo = sc.nextInt();
                            System.out.print("Enter marks:" );
                            int marks = sc.nextInt();
                            System.out.print("Enter fees:");
                            double fees = sc.nextDouble();
                            System.out.println();
                            students[i] = new Student(name, rollNo, marks, fees);
                        }
                        break;
                case 2:
                        System.out.print("How many teachers' details you want to enter? ");
                        int num2 = sc.nextInt();
                        teachers = new Teacher[num2];
                        for (int i=0; i<num2; i++) {
                            System.out.println("Enter the details for Teacher " + (i+1) + ":");
                            System.out.print("Enter name: ");
                            String name = sc.next();
                            System.out.print("Enter subject: ");
                            String subject = sc.next();
                            System.out.print("Enter salary: ");
                            double salary = sc.nextDouble();
                            System.out.println();
                            teachers[i] = new Teacher(name, subject, salary);
                        }
                        break;
                case 3: 
                        if (students.length == 0){
                            System.out.println("Students Details Not Available! First enter the details.");
                        } 
                        else{
                            System.out.println("There are " + students.length + " students in the school\nDetails are as follows:");
                            for (int i=0; i<students.length; i++){
                                Student student = students[i];
                                student.display();
                                System.out.println();
                            }
                        }
                        break;
                case 4: 
                        if (teachers.length == 0){
                            System.out.println("No Teacher Registered! First enter the details.");
                        } 
                        else{
                            System.out.println("There are " + teachers.length + " teachers in the school\nDetails are as follows:");
                            for (int i=0; i<teachers.length; i++){
                                Teacher teacher = teachers[i];
                                teacher.display();
                                System.out.println();
                            }
                        }
                        break;
                case 5: 
                        if (students.length == 0){
                            System.out.println("No Student Registered! First enter the details.");
                        } 
                        else{
                            double totalFee = 0.0;
                            for (int i=0; i<students.length; i++) {
                                Student student = students[i];
                                totalFee += student.getFees();
                            }
                            System.out.println("Total fee collected from " + students.length + " students is = Rs " + totalFee);
                        }
                        break;
                case 6: 
                        System.out.println("School Name:    " + school.getName());
                        System.out.println("School Address: " + school.getAddress());
                        System.out.println("Total Income:   " + school.getTotalIncome());
                        System.out.println("Average Marks:  " + school.getAverageMarks());
                        break;
                case 7:
                        System.out.println("***************************************************************************");;
                        break;
                default:
                        System.out.println("Invalid option! Enter number between [1-7]");
            }
        } while(choice!=7);
        System.out.println("Thank you for using ABC management System! ");
        System.out.println();
        return;
    }
}
class Student {
    String name;
    int rollno;
    int marks;
    double fees;
    public Student(String name, int rollno, int marks, double fees){
        this.name = name;
        this.rollno = rollno;
        this.marks = marks;
        this.fees = fees;
    }
    public String getName(){
        return this.name;
    }
    public int getRollno(){
        return this.rollno;
    }
    public int getMarks(){
        return this.marks;
    }
    public double getFees(){
        return this.fees;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setRollno(int rollno){
        this.rollno = rollno;
    }
    public void setMarks(int marks){
        this.marks = marks;
    }
    public void setFees(double fees){
        this.fees = fees;
    }
    public void display() {
        System.out.println("Name= " + name);
        System.out.println("Roll No.= " + rollno);
        System.out.println("Marks= " + marks);
        System.out.println("Fees= " + fees);
    }
}
class Teacher {
    String name;
    String subject;
    double salary;
    public Teacher(String name, String subject, double salary){
        this.name = name;
        this.subject = subject;
        this.salary = salary;
    }
    public String getName(){
        return this.name;
    }
    public String getSubject(){
        return this.subject;
    }
    public double getSalary(){
        return this.salary;
    }
    public String setName(String name){
        return this.name = name;
    }
    public String setSubject(String subject){
        return this.subject = subject;
    }
    public void display(){
        System.out.println("Name= " + name);
        System.out.println("Subject= " + subject);
        System.out.println("Salary= " + salary);
    }
}
class School {
    String name;
    String address;
    Student students[];
    Teacher teachers[];
    public School(String name, String address, Student[] students, Teacher[] teachers) {
        this.name = name;
        this.address = address;
        this.students = students;
        this.teachers = teachers;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public  void setStudent(Student[] students){
        this.students = students;
    }
    public void setTeacher(Teacher[] teachers){
        this.teachers = teachers;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public Student[] getStudents() {
        return students;
    }
    public Teacher[] getTeachers() {
        return teachers;
    }
    public double getTotalIncome() {
        double income =0.0;
        for (Teacher teacher : teachers) {
            income += teacher.getSalary();
        }
        return income; 
    }
    public double getAverageMarks() {
        double sum =0.0;
        for (int i=0;i<students.length;i++) {
            Student student = students[i];
            sum += student.getMarks();
        }
        return sum / students.length;
   }
}