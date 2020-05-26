public class Person {

    private String name;
    private String lastName;
    private Faculty personFaculty;
    private Department personDepartment;
    public Person(){
    }

    public Person(String name, String lastName, Faculty personFaculty, Department personDepartment) {
        this.name = name;
        this.lastName = lastName;
        this.personFaculty = personFaculty;
        this.personDepartment = personDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Faculty getPersonFaculty() {
        return personFaculty;
    }

    public void setPersonFaculty(Faculty personFaculty) {
        this.personFaculty = personFaculty;
    }

    public Department getPersonDepartment() {
        return personDepartment;
    }

    public void setPersonDepartment(Department personDepartment) {
        this.personDepartment = personDepartment;
    }

    public String toString(){
        return "Person: "+name+" "+lastName
                +", Faculty: "+personFaculty+", Department: "+personDepartment;
    }
}
