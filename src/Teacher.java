public class Teacher extends Person{
    public Teacher(String name,String lastName,Faculty personFaculty,Department personDepartment){
        super(name,lastName,personFaculty,personDepartment);
    }

    public String toString(){
        return "Викладач: "+getName()+" "+getLastName()
                +", Факультет: "+ getPersonFaculty()+", Кафедра: "+getPersonDepartment();
    }
}
