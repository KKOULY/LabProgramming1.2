public class Student extends Person{
    private int course;
    private int group;

    /**
     * Конструктор
     * @param name Імя
     * @param lastName Прізвище
     * @param personFaculty Факультет
     * @param personDepartment Кафедра
     */
    public Student(String name,String lastName,Faculty personFaculty,Department personDepartment){
    super(name,lastName,personFaculty,personDepartment);
    }

    /**
     * Конструктор
     */
    public Student(){

    }

    /**
     * Конструктор
     * @param name Імя
     * @param lastName Прізвище
     * @param personFaculty Факультет
     * @param personDepartment Кафедра
     * @param course курс
     * @param group група
     */
    public Student(String name,String lastName,Faculty personFaculty,Department personDepartment,int course, int group){
        super(name,lastName,personFaculty,personDepartment);
        setCourse(course);
        setGroup(group);
    }

    /**
     * Повертає курс
     * @return курс
     */
    public int getCourse() {
        return course;
    }

    /**
     * Змінює курс
     * @param course курс
     */
    public void setCourse(int course) {
        this.course = course;
        if (course>6) this.course=6;  // 4 курса бакалавра + 2 курса магістра =макс 6
        if (course<1) this.course=1;
    }

    /**
     * Повертає групу
     * @return група
     */
    public int getGroup() {
        return group;
    }

    /**
     * Змінює групу
     * @param group група
     */
//всього можно 2 групи
    public void setGroup(int group) {
        this.group = group;
        if (group>2) this.group=2;
        if (group<1) this.group=1;
    }

    /**
     * Виводить всю інформацію про студента
     * @return String
     */
    public String toString(){
        return "Студент: "+getName()+" "+getLastName()
                +", Факультет: "+ getPersonFaculty()+", Кафедра: "+getPersonDepartment()
                +", Курс: "+course+", Група: "+group;
    }
}
