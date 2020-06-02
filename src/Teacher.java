public class Teacher extends Person{
    /**
     * Конструктор
     * @param name Ім^я
     * @param lastName Прізвище
     * @param personFaculty Факультет
     * @param personDepartment Кафедра
     */
    public Teacher(String name,String lastName,Faculty personFaculty,Department personDepartment){
        super(name,lastName,personFaculty,personDepartment);
    }

    /**
     * Виводить всю інформацію про викладача
     * @return String
     */
    public String toString(){
        return "Викладач: "+getName()+" "+getLastName()
                +", Факультет: "+ getPersonFaculty()+", Кафедра: "+getPersonDepartment();
    }
}
