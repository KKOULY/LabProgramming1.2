public class Teacher extends Person{
    public Teacher(String name,String lastName,Faculty personFaculty,Department personDepartment){
        super(name,lastName,personFaculty,personDepartment);
    }
    public Teacher(){

    }

    public String toString(){
        return "Teacher: "+getName()+" "+getLastName()
                +", Faculty: "+ getPersonFaculty()+", Department: "+getPersonDepartment();
    }
}