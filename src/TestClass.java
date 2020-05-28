import java.io.*;
import java.util.StringTokenizer;

public class TestClass {
    private static Student[] students= new Student[5];
    public static void main(String[] args) {

        Faculty[] faculties = readFaculty();
        readDepartments(faculties);
        readPeople(faculties);
        Department[] firstDepartment = faculties[0].getDepartments();
        Department[] secondDepartment = faculties[1].getDepartments();
        System.out.println(firstDepartment[0].toString());
        System.out.println(secondDepartment[0].toString());
        System.out.println(Tools.getStringPerson(Tools.getAllStudents(faculties)));
        System.out.println(Tools.getStringPerson(Tools.getAllTeachers(faculties)));
    }
//public static Faculty[] readFaculty(){
//        Faculty[] faculties = {};
//    try {
//        BufferedReader rf = new BufferedReader(new FileReader("faculties.txt"));
//        String facultyLine = rf.readLine();
//        int firstLetter=0;
//        for (int i=0; i<facultyLine.length();i++){
//            if (facultyLine.charAt(i)=='|'){
//                faculties=addFaculty(faculties,new Faculty(facultyLine.substring(firstLetter,i)));
//                firstLetter=i+1;
//            }
//        }
//        rf.close();
//    }catch (FileNotFoundException ex){
//        System.out.println("Проблема з файлом");
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    return faculties;
//}
    public static Faculty[] addFaculty(Faculty[] faculties, Faculty faculty){
        Faculty[] facultiesTemporary = new Faculty[faculties.length+1];
        System.arraycopy(faculties,0,facultiesTemporary,0,faculties.length);
        facultiesTemporary[faculties.length] = faculty;
        return facultiesTemporary;
    }
//    public static void readDepartments(Faculty[] ourFaculties){
//        try {
//            BufferedReader rf = new BufferedReader(new FileReader("departments.txt"));
//            String departmentLine = rf.readLine();
//            int firstLetter=0;
//            Department newDepartment=new Department();
//            for (int i=0; i< departmentLine.length();i++){
//                if (departmentLine.charAt(i)=='|'){
//                   newDepartment = new Department(departmentLine.substring(firstLetter,i));
//                   firstLetter=i+1;
//                }
//                if (departmentLine.charAt(i)=='!'){
//                    Integer whatFaculty = Integer.valueOf(departmentLine.substring(firstLetter,i));
//                    ourFaculties[whatFaculty].addDepartment(newDepartment);
//                    firstLetter=i+1;
//                }
//            }
//            rf.close();
//        }catch (FileNotFoundException ex){
//            System.out.println("Проблема з файлом");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void readDepartments(Faculty[] ourFaculties){
        try {
            BufferedReader rf = new BufferedReader(new FileReader("departments.txt"));
            String departmentLine = rf.readLine();
            while (departmentLine != null){
                StringTokenizer tokenizer = new StringTokenizer(departmentLine,"|");
                String nameOfDepartments = tokenizer.nextToken();
                int numOfFaculty = Integer.valueOf(tokenizer.nextToken());
                ourFaculties[numOfFaculty].addDepartment(nameOfDepartments);
                departmentLine = rf.readLine();
            }
            rf.close();
        }catch (FileNotFoundException ex){
            System.out.println("Проблема з файлом");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Faculty[] readFaculty(){
        Faculty[] faculties = {};
        try {
            BufferedReader rf = new BufferedReader(new FileReader("faculties.txt"));
            String facultyLine = rf.readLine();
            while (facultyLine != null){
                faculties = addFaculty(faculties,new Faculty(facultyLine));
                facultyLine = rf.readLine();

            }
            rf.close();
        }catch (FileNotFoundException ex){
            System.out.println("Проблема з файлом");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return faculties;
    }

    public static void readPeople(Faculty[] faculties){
        try {
            BufferedReader rf = new BufferedReader(new FileReader("people.txt"));
            String personLine = rf.readLine();
            while (personLine != null){
                StringTokenizer tokenizer = new StringTokenizer(personLine,"|");
                String profession = tokenizer.nextToken();
                String name = tokenizer.nextToken();
                String lastName = tokenizer.nextToken();
                int numOfFaculty = Integer.valueOf(tokenizer.nextToken());
                int numOfDepartment = Integer.valueOf(tokenizer.nextToken());
                if(profession.equals("Student")){
                    int course = Integer.valueOf(tokenizer.nextToken());
                    int group = Integer.valueOf(tokenizer.nextToken());
                    addStudent(faculties,name,lastName,numOfFaculty,numOfDepartment,course,group);
                } else if(profession.equals("Teacher")){
                    addTeacher(faculties,name,lastName,numOfFaculty,numOfDepartment);
                }
                personLine = rf.readLine();
            }
            rf.close();
        }catch (FileNotFoundException ex){
            System.out.println("Проблема з файлом");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addTeacher(Faculty[] faculties, String name, String lastName, int numOfFaculty, int numOfDepartment) {
        if(name == null) name = "None";
        if(lastName == null) lastName = "None";
        if(numOfFaculty>=0 && numOfFaculty < faculties.length){
            if(numOfDepartment>=0 && numOfDepartment < faculties[numOfFaculty].departmentsLength()){
                faculties[numOfFaculty].departmentIndex(numOfDepartment).
                        addTeacher(new Teacher(name,lastName,faculties[numOfFaculty],
                                faculties[numOfFaculty].departmentIndex(numOfDepartment)));
            }
        }
    }

    private static void addStudent(Faculty[] faculties, String name, String lastName, int numOfFaculty, int numOfDepartment, int course, int group) {
        if(name == null) name = "None";
        if(lastName == null) lastName = "None";
        if(numOfFaculty>=0 && numOfFaculty < faculties.length){
            if(numOfDepartment>=0 && numOfDepartment < faculties[numOfFaculty].departmentsLength()){
                faculties[numOfFaculty].departmentIndex(numOfDepartment).
                        addStudent(new Student(name,lastName,faculties[numOfFaculty],
                                faculties[numOfFaculty].departmentIndex(numOfDepartment),
                                course,group));
            }
        }


    }
}

