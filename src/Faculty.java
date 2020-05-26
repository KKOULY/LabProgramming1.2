public class Faculty {
    private String title;
    private Student[] students;
    private Teacher[] teachers;
    private Department[] departments;
    Faculty(){

    }
    public void addStudent(Student newStudent){
        Student[] studentListNow = new Student[students.length+1];
        System.arraycopy(students,0,studentListNow,0,students.length);
        studentListNow[students.length]=newStudent;
        students=studentListNow;
    }
    public void addTeacher(Teacher newTeacher){
        Teacher[] teacherListNow = new Teacher[teachers.length+1];
        System.arraycopy(teachers,0,teacherListNow,0,teachers.length);
        teacherListNow[teachers.length]=newTeacher;
        teachers=teacherListNow;
    }
    public void deleteStudent(int numberOfStudent){
        if (numberOfStudent<=students.length && numberOfStudent>=0) {
            Student[] studentListNow = new Student[students.length - 1];
            int numberStudents=0;
            for (int i=0; i<students.length;i++){
                if (i!=numberOfStudent) {
                    studentListNow[numberStudents] = students[i];
                    numberStudents++;
                }
            }
        }
    }
    public void deleteTeacher(int numberOfTeacher){
        if (numberOfTeacher<=teachers.length && numberOfTeacher>=0) {
            Teacher[] teacherListNow = new Teacher[students.length - 1];
            int numberTeachers=0;
            for (int i=0; i<teachers.length;i++){
                if (i!=numberOfTeacher) {
                    teacherListNow[numberTeachers] = teachers[i];
                    numberTeachers++;
                }
            }
        }
    }
}
