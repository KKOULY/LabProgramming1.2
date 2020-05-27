public class Faculty {
    private String title;
    private String nameOfFaculty;
    private Department[] departments = new Department[0];
    public Faculty(){
    }
    public Faculty(String nameOfFaculty){
        this.nameOfFaculty = nameOfFaculty;
    }

    public void addDepartment(String nameOfDepartment){
        Department[] departmentsTemporary = new Department[departments.length+1];
        System.arraycopy(departments,0,departmentsTemporary,0,departments.length);
        departmentsTemporary[departments.length] = new Department(nameOfDepartment);
        departments = departmentsTemporary;
    }

    public void deleteDepartment(int numOfDepartment){
        if (numOfDepartment<=departments.length && numOfDepartment>=0) {
            Department[] departmentsTemporary = new Department[departments.length - 1];
            int num = 0;
            for (int i=0; i<departments.length;i++){
                if (i!=numOfDepartment) {
                    departmentsTemporary[num] = departments[i];
                    num++;
                }
            }
            departments = departmentsTemporary;
        }
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    public Department departmentIndex(int n){
        if(n >=0 && n < departments.length){
            return departments[n];
        } else return null;
    }
    public int departmentsLength(){
        return departments.length;
    }

    public String toString(){
        return nameOfFaculty;
    }
}
