public class Tools {

    private static void swap(Student[] students, int i, int y) {
        Student temp = students[i];
        students[i] = students[y];
        students[y] = temp;
    }

    public static Student[] sortNames(boolean up, Student[] students) {
        initValueArr();
        if(students != null && students.length > 1){
            for(int x = 1; x < students.length;x++){
                for (int y = students.length-1; y >= x; y--) {
                    if(up) {
                        if (!alphabetCompare(students,y-1,y))
                            swap(students, y - 1, y);
                    } else {
                        if (alphabetCompare(students,y-1,y))
                            swap(students, y - 1, y);
                    }
                }
            }
        }
        return students;
    }

    private static boolean alphabetCompare(Student[] students,int i, int y) {
        String s0 = students[i].getName();
        String s1 = students[y].getName();
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
    private static int[] value = new int[1169];

    private static void initValueArr(){
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

    public static String getStringStudents(Student[] students){
        String str = "";
        if(students != null){
            for(int i = 0;i<students.length;i++){
               str+=students[i].toString()+"\n";
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
                    studentsTemp = addStudent(studentsTemp,departmentTemp.studentIndex(iStud));
                }
            }
        }

        return studentsTemp;
    }

    private static Student[] addStudent(Student[] studArr, Student student){
        Student[] studArrTemp = new Student[studArr.length+1];
        System.arraycopy(studArr,0,studArrTemp,0,studArr.length);
        studArrTemp[studArr.length] = student;
        studArr = studArrTemp;
        return studArr;
    }

    //перевіряє чи це слово(в стрічці тільки букви)
    private boolean isWord(String word){
        for(int i =0; i<word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    //робить першу літеру великою, а всі наступні маленькими + не пропускає далі поки не введеш слово
    private String checkName(String whatToWrite) {
        String realName = "";
        while (true) {
            String name = DataInput.getString(whatToWrite);
            if (name.equals("")) {
                return "немає ім'я в базі";
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
}
