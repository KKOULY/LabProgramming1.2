public class Person {
    /**
     *Ім^я
     */
    private String name;
    /**
     * Прізвище
     */
    private String lastName;
    /**
     * Факультет
     */
    private Faculty personFaculty;
    /**
     * Кафедра
     */
    private Department personDepartment;

    /**
     * Пустий конструктор
     */
    public Person(){
    }

    /**
     * Конструктор
     * @param name Ім^я
     * @param lastName Прізвище
     * @param personFaculty Факультет
     * @param personDepartment Кафедра
     */
    public Person(String name, String lastName, Faculty personFaculty, Department personDepartment) {
        this.name = name;
        this.lastName = lastName;
        this.personFaculty = personFaculty;
        this.personDepartment = personDepartment;
    }

    /**
     * Повертає Ім^я
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Змінює Ім^я
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Повертає прізвище
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Змінює прізвище
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Повертає факульет
     * @return
     */
    public Faculty getPersonFaculty() {
        return personFaculty;
    }

    /**
     * Змінює факультет
     * @param personFaculty
     */
    public void setPersonFaculty(Faculty personFaculty) {
        this.personFaculty = personFaculty;
    }

    /**
     * Повертає кафедру
     * @return кафедра
     */
    public Department getPersonDepartment() {
        return personDepartment;
    }

    /**
     * Змінює кафедру
     * @param personDepartment
     */
    public void setPersonDepartment(Department personDepartment) {
        this.personDepartment = personDepartment;
    }

    /**
     * Повертає String з всією інформацією про людину
     * @return
     */
    public String toString(){
        return "Людина: "+name+" "+lastName
                +", Факультет: "+personFaculty+", Кафедра: "+personDepartment;
    }
}
