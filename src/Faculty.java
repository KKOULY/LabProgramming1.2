public class Faculty {
    private String title;
    private String nameOfFaculty;
    private Department[] departments;
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

    public String toString(){
        return nameOfFaculty;
    }
}
