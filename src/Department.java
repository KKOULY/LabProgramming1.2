public class Department{
    private String nameOfDepartment = "Unknown";
    private Student[] students = new Student[0];
    private Teacher[] teachers = new Teacher[0];

    public Department(){

    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public Department(String nameOfDepartment){
        this.nameOfDepartment = nameOfDepartment;
    }

    public String toString(){
        return nameOfDepartment;
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
            students = studentListNow;
        }
    }
    public void deleteTeacher(int numberOfTeacher){
        if (numberOfTeacher<=teachers.length && numberOfTeacher>=0) {
            Teacher[] teacherListNow = new Teacher[teachers.length - 1];
            int numberTeachers=0;
            for (int i=0; i<teachers.length;i++){
                if (i!=numberOfTeacher) {
                    teacherListNow[numberTeachers] = teachers[i];
                    numberTeachers++;
                }
            }
            teachers = teacherListNow;
        }
    }

    public void setNameOfDepartment(String nameOfDepartment){
        this.nameOfDepartment = nameOfDepartment;
    }

    public Student studentIndex(int n){
        if(n >=0 && n < students.length){
            return students[n];
        } else return null;
    }
    public int studentsLength(){
        return students.length;
    }

    public Teacher teacherIndex(int n){
        if(n >=0 && n < teachers.length){
            return teachers[n];
        } else return null;
    }
    public int teachersLength(){
        return teachers.length;
    }
}
