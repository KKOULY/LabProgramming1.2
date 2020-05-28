public class Laboratory {
    private static Faculty[] faculties = new Faculty[0];


    public static void main(String[] args) {
        Tools.init();

        addFaculty("fac1");
        addFaculty("fac2");
        faculties[0].addDepartment("dep11");
        faculties[0].addDepartment("dep12");
        Department dep11 = faculties[0].departmentIndex(0);
        dep11.addStudent(new Student("їtud1","stud",faculties[0],dep11,-20,1));
        dep11.addStudent(new Student("фtud2","stud",faculties[0],dep11,1,1));
        Department dep12 = faculties[0].departmentIndex(1);
        dep12.addStudent(new Student("іuud3","stud",faculties[0],dep12,5,1));
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
        Tools.saveFaculties(faculties);
        Tools.saveDepartments(faculties);
        Tools.savePeople(faculties);
        dep22.addStudent(new Student("new","new",faculties[1],dep22,3,3));
        Tools.savePeople(faculties);
        startMenu();
    }

    private static void startMenu() {
        int choice;
        do{
            System.out.println("0. Вихід");
            System.out.println("1. Створити/Видалити/Редагувати факультет");
            System.out.println("2. Створити/видалити/редагувати кафедру факультета.");
            System.out.println("3. Додати/видалити/редагувати студента/викладача до кафедри.");
            System.out.println("4. Знайти студента/викладача за ПІБ, курсом або групою.");
            System.out.println("5. Вивести всіх студентів впорядкованих за курсами.");
            System.out.println("6. Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом.");
            System.out.println("7. Вивести всіх студентів кафедри впорядкованих за курсами.");
            System.out.println("8. Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом.");
            System.out.println("9. Вивести всіх студентів кафедри вказаного курсу.");
            System.out.println("10. Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом.");
            choice = DataInput.getInt("Введіть номер: ");
            UserChoice(choice);
        }while (choice != 0);
        System.exit(1);
    }

    private static void UserChoice(int choice) {
        switch (choice){
            case 0:
                System.out.println("Робота програми завершена");
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                System.out.println("Некоректний номер");
        }
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
    private static void firstMethod(){
        int whatToDo = DataInput.getInt("Введіть: 1 - створити факультет, 2 - видалити факультет, 3 - редагувати факультет: ");
        switch (whatToDo){
            case 1:
                addFaculty(Tools.checkTitle("Назва факультету, який ви створюєте: "));
                break;
            case 2:
                for (int i=0; i<faculties.length;i++) System.out.println(i+". "+faculties[i].toString());
                deleteFaculty(DataInput.getInt("Номер факультету, який потрібно видалити: "));
                break;
            case 3:
                for (int i=0; i<faculties.length;i++) System.out.println(i+". "+faculties[i].toString());
                int numberOfFaculty = DataInput.getInt("Номер факультету, який потрібно редагувати: ");
                if (numberOfFaculty>=0 && numberOfFaculty<faculties.length){
                    faculties[numberOfFaculty].setNameOfFaculty(Tools.checkTitle("Введіть нову назву факультету: "));
                } else System.out.println("Такого факультету не існує!");
        }
    }

}
