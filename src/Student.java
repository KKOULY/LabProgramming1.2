public class Student extends Person{
    private int course;
    private int group;
public Student(String name,String lastName,Faculty personFaculty,Department personDepartment){
    super(name,lastName,personFaculty,personDepartment);
}
public Student(){

}
    public int getCourse() {
        return course;
    }
// 4 курса бакалавра + 2 курса магістра =макс 6
    public void setCourse(int course) {
        this.course = course;
        if (course>6) this.course=6;
        if (course<0) this.course=0;
    }

    public int getGroup() {
        return group;
    }
//всього можно 2 групи
    public void setGroup(int group) {
        this.group = group;
        if (group>2) this.group=2;
        if (group<0) this.group=0;
    }
}
