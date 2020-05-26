public class Department{
    private String nameOfDepartment = "Unknown";

    public Department(){

    }

    public Department(String nameOfDepartment){
        this.nameOfDepartment = nameOfDepartment;
    }

    public String toString(){
        return nameOfDepartment;
    }
}
