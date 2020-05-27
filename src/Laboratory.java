public class Laboratory {
    private static Faculty[] faculties = new Faculty[0];


    public static void main(String[] args) {
        addFaculty("fac1");
        addFaculty("fac2");
        faculties[0].addDepartment("dep11");
        faculties[0].addDepartment("dep12");
        Department dep11 = faculties[0].departmentIndex(0);
        dep11.addStudent(new Student("etud1","stud",faculties[0],dep11,-20,1));
        dep11.addStudent(new Student("btud2","stud",faculties[0],dep11,1,1));
        Department dep12 = faculties[0].departmentIndex(1);
        dep12.addStudent(new Student("buud3","stud",faculties[0],dep12,5,1));
        dep12.addStudent(new Student("ctud4","stud",faculties[0],dep12,1,50));
        faculties[1].addDepartment("dep21");
        faculties[1].addDepartment("dep22");
        Department dep21 = faculties[1].departmentIndex(0);
        dep21.addStudent(new Student("atud5","stud",faculties[1],dep21,1,2));
        dep21.addStudent(new Student("bbud6","stud",faculties[1],dep21,8,1));
        Department dep22 = faculties[1].departmentIndex(1);
        dep22.addStudent(new Student("gtud7","stud",faculties[1],dep21,1,1));
        dep22.addStudent(new Student("stud8","stud",faculties[1],dep22,3,1));

        Student[] studentsTemp = Tools.getAllStudents(faculties);
        System.out.println(Tools.getStringPerson(studentsTemp));
        studentsTemp = (Student[]) Tools.sortNames(true,studentsTemp);
        System.out.println(Tools.getStringPerson(studentsTemp));
        System.out.println(Tools.getStringPerson(Tools.findPersonName(studentsTemp,"b")));
    }

    public static void addFaculty(String nameOfFaculty){
        Faculty[] facultiesTemporary = new Faculty[faculties.length+1];
        System.arraycopy(faculties,0,facultiesTemporary,0,faculties.length);
        facultiesTemporary[faculties.length] = new Faculty(nameOfFaculty);
        faculties = facultiesTemporary;
    }

    public static void deleteFaculty(int numOfFaculty){
        if (numOfFaculty<=faculties.length && numOfFaculty>=0) {
            Faculty[] facultiesTemporary = new Faculty[faculties.length - 1];
            int num = 0;
            for (int i=0; i<faculties.length;i++){
                if (i!=numOfFaculty) {
                    facultiesTemporary[num] = faculties[i];
                    num++;
                }
            }
            faculties = facultiesTemporary;
        }
    }



}
