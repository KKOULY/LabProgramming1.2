import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestClass {
    private static Student[] students= new Student[5];
    public static void main(String[] args) {
     students[0]=new Student();
     students[1]=new Student();
     students[2]=new Student();
        students[3]=new Student();
        students[4]=new Student();
    students[0].setName("Костя");
    students[1].setName("Алеша");
    students[2].setName("Яна");
        students[3].setName("Янв");
        students[4].setName("Янб");
        Faculty[] faculties = readFaculty();
        for (int i=0;i<faculties.length;i++){
            System.out.println(faculties[i].toString());
        }
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

}

