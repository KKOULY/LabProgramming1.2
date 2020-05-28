public class Laboratory {
    private static Faculty[] faculties = new Faculty[0];


    public static void main(String[] args) {
        Tools.init();
        faculties = Tools.readFaculty();
        Tools.readDepartments(faculties);
        Tools.readPeople(faculties);
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
                System.out.println("Створити/видалити/редагувати кафедру факультета");
                CreateDeleteChangeDepartments();
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

    private static void CreateDeleteChangeDepartments() {
        System.out.println("Всі факультети: ");
        for(int i = 0;i<faculties.length;i++){
            System.out.println(i+". "+faculties[i].toString());
        }
        int num = DataInput.getInt("Виберіть факультет: ");

        if(num >= 0 || num < faculties.length){
            System.out.println("Всі кафедри факультету: " + faculties[num].toString());
            for(int g = 0;g<faculties[num].departmentsLength();g++){
                System.out.println(g+". "+faculties[num].departmentIndex(g));
            }
            System.out.println("1. Створити нову кафедру");
            System.out.println("2. Видалити/Редагувати кафедру");
            int choice = DataInput.getInt("Введіть значення: ");
            if(choice == 1){
                System.out.println("Створення нової кафедри");
                String s = DataInput.getString("Введіть назву нової кафедри:");
                Tools.createDepartment(s,faculties,num);
            }
            if(choice == 2){
                int numDep = DataInput.getInt("Введіть значення: ");
                if(numDep >=0 && numDep < faculties[num].departmentsLength()){
                    System.out.println("Кафедра: "+ faculties[num].departmentIndex(numDep).toString()+" (1-Видалити/2-Редагувати)");
                    int choice2 = DataInput.getInt("Введіть значення: ");
                    if(choice2 == 1) faculties[num].deleteDepartment(numDep);
                    else if(choice2 == 2){
                        String newName = DataInput.getString("Введіть нову назву: ");
                        faculties[num].departmentIndex(numDep).setNameOfDepartment(newName);
                    }
                }
            }
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
