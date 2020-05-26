public class Person {
    private String name;
    private String lastName;
    private Faculty personFaculty;
    public Person(){
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
}
