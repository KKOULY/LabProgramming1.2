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
    for (int i=0;i<5;i++){
        System.out.println(students[i].getName());
        }
    Student[] find = findStudentsName(students,"Янв");
    for (int i = 0; i<find.length;i++)
        System.out.println(find[i].toString());
    }


    private static Student[] findStudentsName(Student[] students, String name){
        Student[] studentList = {};
        for(int j = 0; j<students.length;j++) {
            boolean find = false;
            if (name.length()<=students[j].getName().length()) {
                for (int i = 0; i < name.length(); i++) {
                    if (students[j].getName().charAt(i) == name.charAt(i)) find = true;
                    else {
                        find = false;
                        break;
                    }
                }
            }
            if (find==true){
                Student[] studentListNow = new Student[studentList.length+1];
                System.arraycopy(studentList,0,studentListNow,0,studentList.length);
                studentListNow[studentList.length]=students[j];
                studentList=studentListNow;
            }
        }
        return studentList;
    }
    private static Student[] findStudentsLastName(Student[] students, String name){
        Student[] studentList = {};
        for(int j = 0; j<students.length;j++) {
            boolean find = false;
            if (name.length()<=students[j].getLastName().length()) {
                for (int i = 0; i < name.length(); i++) {
                    if (students[j].getLastName().charAt(i) == name.charAt(i)) find = true;
                    else {
                        find = false;
                        break;
                    }
                }
            }
            if (find==true){
                Student[] studentListNow = new Student[studentList.length+1];
                System.arraycopy(studentList,0,studentListNow,0,studentList.length);
                studentListNow[studentList.length]=students[j];
                studentList=studentListNow;
            }
        }
        return studentList;
    }
}

