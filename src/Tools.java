import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tools {

    public static Student[] sortCourse(boolean up, Student[] students) {
        if(students != null && students.length > 1){
            for(int x = 1; x < students.length;x++){
                for (int y = students.length-1; y >= x; y--) {
                    if(up) {
                        if (students[y-1].getCourse()>students[y].getCourse())
                            swap(students, y - 1, y);
                    } else {
                        if (students[y-1].getCourse()>students[y].getCourse())
                            swap(students, y - 1, y);
                    }
                }
            }
        }
        return students;
    }

    public static Person[] sortNames(boolean up, Person[] people) {
        if(people != null && people.length > 1){
            for(int x = 1; x < people.length;x++){
                for (int y = people.length-1; y >= x; y--) {
                    if(up) {
                        if (!alphabetCompare(people,y-1,y))
                            swap(people, y - 1, y);
                    } else {
                        if (alphabetCompare(people,y-1,y))
                            swap(people, y - 1, y);
                    }
                }
            }
        }
        return people;
    }
    public static boolean checkNameFaculty(String name, Faculty[] faculties){
        for ( Faculty i : faculties){
            if (i.getNameOfFaculty().equals(name)) return false;
        }
        return true;
    }
    public static boolean checkNameDepartment(String name, Faculty[] faculties){
        for ( Faculty i : faculties){
            Department[] departments = i.getDepartments();
            for (Department j : departments) {
                if (j.getNameOfDepartment().equals(name)) return false;
            }
        }
        return true;
    }
    private static boolean alphabetCompare(Person[] people,int i, int y) {
        String s0 = people[i].getName()+people[i].getLastName();
        String s1 = people[y].getName()+people[y].getLastName();
        boolean flag = s0.length() <= s1.length();
        for(int x = 0;x < s0.length() && x < s1.length();x++){
            char c0 = Character.toUpperCase(s0.charAt(x));
            char c1 = Character.toUpperCase(s1.charAt(x));
            if(value[c0] < value[c1]){
                flag = true;
                break;
            } else if(value[c0] > value[c1]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static void swap(Person[] people, int i, int y) {
        Person temp = people[i];
        people[i] = people[y];
        people[y] = temp;
    }

    private static int[] value = new int[1169];

    public static void init(){
        value[1040]=1;
        value[1041]=2;
        value[1042]=3;
        value[1043]=4;
        value[1168]=5;
        value[1044]=6;
        value[1045]=7;
        value[1028]=8;
        value[1046]=9;
        value[1047]=10;
        value[1048]=11;
        value[1030]=12;
        value[1031]=13;
        value[1049]=14;
        value[1050]=15;
        value[1051]=16;
        value[1052]=17;
        value[1053]=18;
        value[1054]=19;
        value[1055]=20;
        value[1056]=21;
        value[1057]=22;
        value[1058]=23;
        value[1059]=24;
        value[1060]=25;
        value[1061]=26;
        value[1062]=27;
        value[1063]=28;
        value[1064]=29;
        value[1065]=30;
        value[1068]=31;
        value[1070]=32;
        value[1071]=33;
        value[65]=34;
        value[66]=35;
        value[67]=36;
        value[68]=37;
        value[69]=38;
        value[70]=39;
        value[71]=40;
        value[72]=41;
        value[73]=42;
        value[74]=43;
        value[75]=44;
        value[76]=45;
        value[77]=46;
        value[78]=47;
        value[79]=48;
        value[80]=49;
        value[81]=50;
        value[82]=51;
        value[83]=52;
        value[84]=53;
        value[85]=54;
        value[86]=55;
        value[87]=56;
        value[88]=57;
        value[89]=58;
        value[90]=59;
    }

    public static String getStringPerson(Person[] people){
        String str = "";
        if(people != null){
            for(int i = 0;i<people.length;i++){
                str+=people[i].toString()+"\n";
            }
        }
        return str;
    }

    public static Student[] getAllStudents(Faculty[] faculties){
        Student[] studentsTemp = new Student[0];
        for(int iFac = 0; iFac< faculties.length; iFac++){
            Faculty facultyTemp = faculties[iFac];
            for(int iDep = 0;iDep < facultyTemp.departmentsLength();iDep++){
                Department departmentTemp = facultyTemp.departmentIndex(iDep);
                for (int iStud = 0;iStud < departmentTemp.studentsLength();iStud++){
                    studentsTemp = (Student[]) addPerson(studentsTemp,departmentTemp.studentIndex(iStud));
                }
            }
        }

        return studentsTemp;
    }

    public static Teacher[] getAllTeachers(Faculty[] faculties){
        Teacher[] teachersTemp = new Teacher[0];
        for(int iFac = 0; iFac< faculties.length; iFac++){
            Faculty facultyTemp = faculties[iFac];
            for(int iDep = 0;iDep < facultyTemp.departmentsLength();iDep++){
                Department departmentTemp = facultyTemp.departmentIndex(iDep);
                for (int iTeach = 0;iTeach < departmentTemp.teachersLength();iTeach++){
                    teachersTemp = (Teacher[]) addPerson(teachersTemp,departmentTemp.teacherIndex(iTeach));
                }
            }
        }

        return teachersTemp;
    }

    public static Person[] addPerson(Student[] people, Student person){
        Student[] peopleTemp = new Student[people.length+1];
        System.arraycopy(people,0,peopleTemp,0,people.length);
        peopleTemp[people.length] = person;
        people = peopleTemp;
        return people;
    }

    public static Person[] addPerson(Teacher[] people, Teacher person){
        Teacher[] peopleTemp = new Teacher[people.length+1];
        System.arraycopy(people,0,peopleTemp,0,people.length);
        peopleTemp[people.length] = person;
        people = peopleTemp;
        return people;
    }

    public static Person[] addPerson(Person[] people, Person person){
        Person[] peopleTemp = new Person[people.length+1];
        System.arraycopy(people,0,peopleTemp,0,people.length);
        peopleTemp[people.length] = person;
        people = peopleTemp;
        return people;
    }

    public static Faculty[] addFaculty(Faculty[] faculties, Faculty faculty){
        Faculty[] facultiesTemporary = new Faculty[faculties.length+1];
        System.arraycopy(faculties,0,facultiesTemporary,0,faculties.length);
        facultiesTemporary[faculties.length] = faculty;
        return facultiesTemporary;
    }

    //перевіряє чи це слово(в стрічці тільки букви)
    public static boolean isWord(String word){
        for(int i =0; i<word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    //робить першу літеру великою, а всі наступні маленькими + не пропускає далі поки не введеш слово
    public static String checkName(String whatToWrite) {
        String realName = "";
        while (true) {
            String name = DataInput.getString(whatToWrite);
            if (name.equals("")) {
                System.out.println("Ви нічого не ввели");
                continue;
            }
            if (!isWord(name)) {
                System.out.println("Ви ввели недопустимі символи!");
                continue;
            }
            if (Character.isLowerCase(name.charAt(0))) {
                char newLetter = Character.toUpperCase(name.charAt(0));
                realName = realName + newLetter;
            } else realName = realName + name.charAt(0);
            if (name.length() > 1) {
                for (int i = 1; i < name.length(); i++) {
                    if (Character.isUpperCase(name.charAt(i))) {
                        char newLetter = Character.toLowerCase(name.charAt(i));
                        realName = realName + newLetter;
                    } else realName = realName + name.charAt(i);
                }
            }
            return realName;
        }
    }
    public static boolean isWordList(String wordList){
        if (wordList.charAt(0)==' ') return false;
        if (wordList.charAt(wordList.length()-1)==' ') return false;
        boolean space=false;
        for(int i =0; i<wordList.length(); i++) {
            if (space==true && wordList.charAt(i)==' ') return false;
            else space=false;
            if (!Character.isLetter(wordList.charAt(i)) && wordList.charAt(i)!=' ') {
                return false;
            }
            if (wordList.charAt(i)==' ')  space=true;
        }
        return true;
    }
    public static String checkTitle(String whatToWrite) {
        String realName = "";
        while (true) {
            String name = DataInput.getString(whatToWrite);
            if (name.equals("")) {
                System.out.println("Ви нічого не ввели");
                continue;
            }
            if (!isWordList(name)) {
                System.out.println("Ви ввели недопустимі символи!");
                continue;
            }
            if (Character.isLowerCase(name.charAt(0))) {
                char newLetter = Character.toUpperCase(name.charAt(0));
                realName = realName + newLetter;
            } else realName = realName + name.charAt(0);
            if (name.length() > 1) {
                for (int i = 1; i < name.length(); i++) {
                    if (Character.isUpperCase(name.charAt(i))) {
                        char newLetter = Character.toLowerCase(name.charAt(i));
                        realName = realName + newLetter;
                    } else realName = realName + name.charAt(i);
                }
            }
            return realName;
        }
    }
    public static Person[] findPersonName(Person[] people, String name){
        Person[] peopleList = {};
        for(int j = 0; j<people.length;j++) {
            boolean find = false;
            if (name.length()<=people[j].getName().length()) {
                for (int i = 0; i < name.length(); i++) {
                    if (people[j].getName().charAt(i) == name.charAt(i)) find = true;
                    else {
                        find = false;
                        break;
                    }
                }
            }
            if (find==true){
                peopleList = addPerson(peopleList,people[j]);
            }
        }
        return peopleList;
    }

    public static Person[] findPersonLastName(Person[] people, String name){
        Person[] peopleList = {};
        for(int j = 0; j<people.length;j++) {
            boolean find = false;
            if (name.length()<=people[j].getName().length()) {
                for (int i = 0; i < name.length(); i++) {
                    if (people[j].getLastName().charAt(i) == name.charAt(i)) find = true;
                    else {
                        find = false;
                        break;
                    }
                }
            }
            if (find==true){
                peopleList = addPerson(peopleList,people[j]);
            }
        }
        return peopleList;
    }

    public static Student[] findStudentCourse(int course, Student[] students){
        if (course>6) course=6;
        if (course<1) course=1;
        Student[] studentList = {};
        for(int j = 0; j<students.length;j++) {
            if (students[j].getCourse()==course) addPerson(studentList,students[j]);
        }
        return studentList;
    }
    public static Student[] findStudentGroup(int group, Student[] students){
        if (group>2) group=2;
        if (group<1) group=1;
        Student[] studentList = {};
        for(int j = 0; j<students.length;j++) {
            if (students[j].getGroup()== group) addPerson(studentList,students[j]);
        }
        return studentList;
    }

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
            while (personLine  != null){
                StringTokenizer tokenizer = new StringTokenizer(personLine,"|");
                String profession = tokenizer.nextToken();
                String name = tokenizer.nextToken();
                String lastName = tokenizer.nextToken();
                String nameOfFaculty = tokenizer.nextToken();
                String nameOfDepartment = tokenizer.nextToken();
                if(profession.equals("Student")){
                    int course = Integer.valueOf(tokenizer.nextToken());
                    int group = Integer.valueOf(tokenizer.nextToken());
                    createStudent(faculties,name,lastName,nameOfFaculty,nameOfDepartment,course,group);
                } else if(profession.equals("Teacher")){
                    createTeacher(faculties,name,lastName,nameOfFaculty,nameOfDepartment);
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

    private static void createTeacher(Faculty[] faculties, String name,
                                      String lastName, String nameOfFaculty, String nameOfDepartment) {
        if(name == null) name = "None";
        if(lastName == null) lastName = "None";
        for(Faculty a: faculties){
            if(a.toString().equals(nameOfFaculty)){
                Department[] departments = a.getDepartments();
                for(Department b:departments){
                    if(b.toString().equals(nameOfDepartment)){
                        b.addTeacher(new Teacher(name,lastName,a,b));
                    }
                    break;
                }
                break;
            }
        }
    }

    private static void createStudent(Faculty[] faculties, String name,
                                      String lastName, String nameOfFaculty, String nameOfDepartment, int course, int group) {
        if(name == null) name = "None";
        if(lastName == null) lastName = "None";
        for(Faculty a: faculties){
            if(a.toString().equals(nameOfFaculty)){
                Department[] departments = a.getDepartments();
                for(Department b:departments){
                    if(b.toString().equals(nameOfDepartment)){
                        b.addStudent(new Student(name,lastName,a,b,course,group));
                        break;
                    }
                }
                break;
            }
        }
    }

    public static void saveFaculties(Faculty[] faculties){
        try {
            PrintWriter wr = new PrintWriter(new FileWriter("faculties.txt"));
            for(Faculty a:faculties){
                wr.println(a.toString());
            }
            wr.close();
        }catch (FileNotFoundException ex){
            System.out.println("Проблема з файлом");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveDepartments(Faculty[] faculties){
        try {
            PrintWriter wr = new PrintWriter(new FileWriter("departments.txt"));
            for(int i = 0;i<faculties.length;i++){
                Department[] departments = faculties[i].getDepartments();
                for(Department a : departments){
                    wr.println(a.toString()+"|"+i);
                }
            }
            wr.close();
        }catch (FileNotFoundException ex){
            System.out.println("Проблема з файлом");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void savePeople(Faculty[] faculties){
        Student[] students = Tools.getAllStudents(faculties);
        Teacher[] teachers = Tools.getAllTeachers(faculties);
        try {
            PrintWriter wr = new PrintWriter(new FileWriter("people.txt"));
            for (int i = 0; i<students.length;i++){
                wr.println("Student|"+students[i].getName()+"|"+students[i].getLastName()+"|"+students[i].getPersonFaculty()+
                        "|"+students[i].getPersonDepartment()+"|"+students[i].getCourse()+"|"+students[i].getGroup());
            }
            for (int i = 0; i<teachers.length;i++){
                wr.println("Teacher|"+teachers[i].getName()+"|"+teachers[i].getLastName()+"|"+teachers[i].getPersonFaculty()+
                        "|"+teachers[i].getPersonDepartment());
            }
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createDepartment(String nameOfDepartment, Faculty[] faculties, int numberOfFaculty){
        if (numberOfFaculty>=0 && numberOfFaculty<faculties.length) {
            faculties[numberOfFaculty].addDepartment(nameOfDepartment);
            Tools.saveDepartments(faculties);
        }
    }
}
