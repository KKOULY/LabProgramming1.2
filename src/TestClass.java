import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestClass {
    private static Student[] students= new Student[5];
    public static void main(String[] args) {

        Faculty[] faculties = readFaculty();
        readDepartments(faculties);
        Department[] firstDepartment = faculties[0].getDepartments();
        Department[] secondDepartment = faculties[1].getDepartments();
        System.out.println(firstDepartment[0].toString());
        System.out.println(secondDepartment[0].toString());
    }
public static Faculty[] readFaculty(){
        Faculty[] faculties = {};
    try {
        BufferedReader rf = new BufferedReader(new FileReader("faculties.txt"));
        String facultyLine = rf.readLine();
        int firstLetter=0;
        for (int i=0; i<facultyLine.length();i++){
            if (facultyLine.charAt(i)=='|'){
                faculties=addFaculty(faculties,new Faculty(facultyLine.substring(firstLetter,i)));
                firstLetter=i+1;
            }
        }
        rf.close();
    }catch (FileNotFoundException ex){
        System.out.println("Проблема з файлом");
    } catch (IOException e) {
        e.printStackTrace();
    }
    return faculties;
}
    public static Faculty[] addFaculty(Faculty[] faculties, Faculty faculty){
        Faculty[] facultiesTemporary = new Faculty[faculties.length+1];
        System.arraycopy(faculties,0,facultiesTemporary,0,faculties.length);
        facultiesTemporary[faculties.length] = faculty;
        return facultiesTemporary;
    }
    public static void readDepartments(Faculty[] ourFaculties){
        try {
            BufferedReader rf = new BufferedReader(new FileReader("departments.txt"));
            String departmentLine = rf.readLine();
            int firstLetter=0;
            Department newDepartment=new Department();
            for (int i=0; i< departmentLine.length();i++){
                if (departmentLine.charAt(i)=='|'){
                   newDepartment = new Department(departmentLine.substring(firstLetter,i));
                   firstLetter=i+1;
                }
                if (departmentLine.charAt(i)=='!'){
                    Integer whatFaculty = Integer.valueOf(departmentLine.substring(firstLetter,i));
                    ourFaculties[whatFaculty].addDepartment(newDepartment);
                    firstLetter=i+1;
                }
            }
            rf.close();
        }catch (FileNotFoundException ex){
            System.out.println("Проблема з файлом");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

