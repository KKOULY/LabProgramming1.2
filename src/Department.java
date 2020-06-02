public class Department{
    /**
     * Назва кафедри
     */
    private String nameOfDepartment = "Unknown";
    /**
     * Масив студентів
     */
    private Student[] students = new Student[0];
    /**
     * Масив викладачів
     */
    private Teacher[] teachers = new Teacher[0];

    /**
     * Повертає масив студентів
     * @return масив студентів
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * Змінює масив студентів
     * @param students масив студентів
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     * Повертає масив викладачів
     * @return масив викладачів
     */
    public Teacher[] getTeachers() {
        return teachers;
    }

    /**
     * Змінює масив викладачів
     * @param teachers масив викладачів
     */
    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    /**
     * Конструктор кафедри
     * @param nameOfDepartment назва кафедри
     */
    public Department(String nameOfDepartment){
        this.nameOfDepartment = nameOfDepartment;
    }

    /**
     * Повертає назву кафедри
     * @return назва кафедри
     */
    public String toString(){
        return nameOfDepartment;
    }

    /**
     * Додає студента до массиву студентів
     * @param newStudent новий студент
     */
    public void addStudent(Student newStudent){
        Student[] studentListNow = new Student[students.length+1];
        System.arraycopy(students,0,studentListNow,0,students.length);
        studentListNow[students.length]=newStudent;
        students=studentListNow;
    }

    /**
     * Додає викладач до масиву викладачів
     * @param newTeacher новий викладач
     */
    public void addTeacher(Teacher newTeacher){
        Teacher[] teacherListNow = new Teacher[teachers.length+1];
        System.arraycopy(teachers,0,teacherListNow,0,teachers.length);
        teacherListNow[teachers.length]=newTeacher;
        teachers=teacherListNow;
    }

    /**
     * Видаляє студента з масиву студентів
     * @param numberOfStudent номер студента в масиві
     */
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

    /**
     * Видаляє вчителя з масиву викладач
     * @param numberOfTeacher Номер викладача в масиві
     */
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

    /**
     * Змінює назву кафедри
     * @param nameOfDepartment назва кафедри
     */
    public void setNameOfDepartment(String nameOfDepartment){
        this.nameOfDepartment = nameOfDepartment;
    }

    /**
     * Повертає назву кафедри
     * @return назва кафедри
     */
    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    /**
     * Повертає студента за індексом у масиві
     * @param n Індекс
     * @return Студент
     */
    public Student studentIndex(int n){
        if(n >=0 && n < students.length){
            return students[n];
        } else return null;
    }

    /**
     * Повертає довжину масиву студентів
     * @return
     */
    public int studentsLength(){
        return students.length;
    }

    /**
     * Повертає викладача за індексом у масиві
     * @param n Індекс
     * @return Викладач
     */
    public Teacher teacherIndex(int n){
        if(n >=0 && n < teachers.length){
            return teachers[n];
        } else return null;
    }

    /**
     * Повертає довжину масиву викладачів
     * @return
     */
    public int teachersLength(){
        return teachers.length;
    }
}
