public class Faculty {
    /**
     *Назва факультету
     */
    private String nameOfFaculty;

    /**
     * Масив кафедр
     */
    private Department[] departments = new Department[0];

    /**
     * Конструктор факультету
     * @param nameOfFaculty назва факультету
     */
    public Faculty(String nameOfFaculty){
        this.nameOfFaculty = nameOfFaculty;
    }

    /**
     * Повертає назву факультету
     * @return назва факультеу
     */
    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    /**
     * Повертає масив кафедр
     * @return масив кафедр
     */
    public Department[] getDepartments() {
        return departments;
    }

    /**
     * Змінює масив кфаедр
     * @param departments масив кафедр
     */
    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    /**
     * Створює і додає нову кфедру до масиву кафедр
     * @param nameOfDepartment назва кафедри
     */
    public void addDepartment(String nameOfDepartment){
        Department[] departmentsTemporary = new Department[departments.length+1];
        System.arraycopy(departments,0,departmentsTemporary,0,departments.length);
        departmentsTemporary[departments.length] = new Department(nameOfDepartment);
        departments = departmentsTemporary;
    }

    /**
     * Додає кафедру до масиву кафедр
     * @param newDepartment кафедра
     */
    public void addDepartment(Department newDepartment){
        Department[] departmentsTemporary = new Department[departments.length+1];
        System.arraycopy(departments,0,departmentsTemporary,0,departments.length);
        departmentsTemporary[departments.length] = newDepartment;
        departments = departmentsTemporary;
    }

    /**
     * Видаляє кафедру за індексом
     * @param numOfDepartment номер кафедри
     */
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

    /**
     * Змінює назву кафедри
     * @param nameOfFaculty назва кафедри
     */
    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    /**
     * Повертає кафедру за індексом
     * @param n індекс
     * @return кафедра
     */
    public Department departmentIndex(int n){
        if(n >=0 && n < departments.length){
            return departments[n];
        } else return null;
    }

    /**
     * Повертає довжину масиву кафедр
     * @return довжина масиву кафедр
     */
    public int departmentsLength(){
        return departments.length;
    }

    /**
     * Повертає назву факультету
     * @return назва факультету
     */
    public String toString(){
        return nameOfFaculty;
    }
}
