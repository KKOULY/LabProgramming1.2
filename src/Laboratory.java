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
            System.out.println();
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
        System.out.println();
        switch (choice){
            case 0:
                System.out.println("Робота програми завершена");
                System.exit(1);
            case 1:
                System.out.println("Створити/Видалити/Редагувати факультет");
                firstMethod();
                break;
            case 2:
                System.out.println("Створити/видалити/редагувати кафедру факультета");
                CreateDeleteChangeDepartments();
                break;
            case 3:
                System.out.println("Додати/видалити/редагувати студента/викладача до кафедри.");
                addDeleteStudentTeachers();
                break;
            case 4:
                System.out.println("Знайти студента/викладача за ПІБ, курсом або групою");
                findStudentOrTeacher();
                break;
            case 5:
                System.out.println("Вивести всіх студентів впорядкованих за курсами");
                printAllStudentsSortByCourse();
                break;
            case 6:
                System.out.println("Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом");
                printAllStudentsOrTeachersSortByNamesInFaculty();
                break;
            case 7:
                System.out.println("Вивести всіх студентів кафедри впорядкованих за курсами");
                printAllStudentsSortByCourseInFaculty();
                break;
            case 8:
                System.out.println("Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом.");
                printAllStudentsOrTeachersOnDepartmentAlp();
                break;
            case 9:
                System.out.println("Вивести всіх студентів кафедри вказаного курсу.");
                allDepartmentStudentsCourse();
                break;
            case 10:
                System.out.println("Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом.");
                allDepartmentStudentsCourseAlp();
                break;
            default:
                System.out.println("Некоректний номер");
        }
        DataInput.getString("Натисніть enter, щоб продовжити ");
    }

    private static void printAllStudentsSortByCourseInFaculty() {
        Student[] students = Tools.getAllStudents(faculties);
        System.out.println("Всі факультети: ");
        for(int i = 0;i<faculties.length;i++){
            System.out.println(i+". "+faculties[i].toString());
        }
        int num = DataInput.getInt("Виберіть факультет: ");
        if(num >= 0 && num < faculties.length) {
            System.out.println("Всі кафедри факультету: " + faculties[num].toString());
            for (int i = 0; i < faculties[num].departmentsLength(); i++) {
                System.out.println(i + ". " + faculties[num].departmentIndex(i).toString());
            }
            int numDep = DataInput.getInt("Виберіть кафедру: ");

            if(numDep >= 0 && numDep < faculties[num].departmentsLength()){
                Student[] studentsDep = new Student[0];
                for(Student a : students){
                    if (a.getPersonFaculty().toString().equals(faculties[num].toString()) &&
                            a.getPersonDepartment().toString().equals(faculties[num].departmentIndex(numDep).toString())) {
                        studentsDep = (Student[]) Tools.addPerson(studentsDep, a);
                    }
                }
                if(studentsDep.length > 0){
                    Tools.sortCourse(true, studentsDep);
                    System.out.println(Tools.getStringPerson(studentsDep));
                } else System.out.println("В ції кафедрі студентів немає");
            }
        }

    }

    private static void printAllStudentsOrTeachersSortByNamesInFaculty() {
        Student[] students = Tools.getAllStudents(faculties);
        System.out.println("Всі факультети: ");
        for(int i = 0;i<faculties.length;i++){
            System.out.println(i+". "+faculties[i].toString());
        }
        int num = DataInput.getInt("Виберіть факультет: ");
        if(num >= 0 && num < faculties.length) {
            Student[] studentsFac = new Student[0];
            for (Student a : students) {
                if (a.getPersonFaculty().toString().equals(faculties[num].toString())){
                    studentsFac = (Student[]) Tools.addPerson(studentsFac,a);
                }
            }
            if(studentsFac.length > 0) {
                Tools.sortNames(true, studentsFac);
                System.out.println(Tools.getStringPerson(studentsFac));
            }else System.out.println("В цьому факультеті немає студентів");
        }
    }

    private static void printAllStudentsSortByCourse() {
        System.out.println();
        Student[] students = Tools.getAllStudents(faculties);
        Tools.sortCourse(true,students);
        System.out.println(Tools.getStringPerson(students));
    }

    private static void CreateDeleteChangeDepartments() {
        System.out.println("Всі факультети: ");
        for(int i = 0;i<faculties.length;i++){
            System.out.println(i+". "+faculties[i].toString());
        }
        int num = DataInput.getInt("Виберіть факультет: ");

        if(num >= 0 && num < faculties.length){
            System.out.println("Всі кафедри факультету: " + faculties[num].toString());
            for(int g = 0;g<faculties[num].departmentsLength();g++){
                System.out.println(g+". "+faculties[num].departmentIndex(g));
            }
            System.out.println("");
            System.out.println("1. Створити нову кафедру");
            System.out.println("2. Видалити/Редагувати кафедру");
            int choice = DataInput.getInt("Що зробити: ");
            if(choice == 1){
                System.out.println("Створення нової кафедри");
                String s = Tools.checkTitle("Введіть назву нової кафедри:");
                if (Tools.checkNameDepartment(s,faculties)) {
                    Tools.createDepartment(s, faculties, num);
                } else System.out.println("Існує кафедра з такою назвою");
            }
            if(choice == 2){
                int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
                if(numDep >=0 && numDep < faculties[num].departmentsLength()){
                    System.out.println("Кафедра: "+ faculties[num].departmentIndex(numDep).toString()+" (1-Видалити/2-Редагувати)");
                    int choice2 = DataInput.getInt("Введіть значення: ");
                    if(choice2 == 1) faculties[num].deleteDepartment(numDep);
                    else if(choice2 == 2){
                        String newName = Tools.checkTitle("Введіть нову назву: ");
                        if (Tools.checkNameDepartment(newName,faculties)) {
                            faculties[num].departmentIndex(numDep).setNameOfDepartment(newName);
                        } else System.out.println("Існує кафедра з такою назвою");
                    }
                }
            }
            Tools.savePeople(faculties);
            Tools.saveDepartments(faculties);
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
        switch (DataInput.getInt("Введіть: 1 - створити факультет, 2 - видалити факультет, 3 - редагувати факультет: ")){
            case 1:
                String name = Tools.checkTitle("Назва факультету, який ви створюєте: ");
                if (Tools.checkNameFaculty(name,faculties)) {
                    addFaculty(name);
                } else System.out.println("Існує факультет з такою назвою");
                break;
            case 2:
                for (int i=0; i<faculties.length;i++) System.out.println(i+". "+faculties[i].toString());
                deleteFaculty(DataInput.getInt("Номер факультету, який потрібно видалити: "));
                break;
            case 3:
                for (int i=0; i<faculties.length;i++) System.out.println(i+". "+faculties[i].toString());
                int numberOfFaculty = DataInput.getInt("Номер факультету, який потрібно редагувати: ");
                if (numberOfFaculty>=0 && numberOfFaculty<faculties.length){
                    String nameNew =Tools.checkTitle("Введіть нову назву факультету: ");
                    if (Tools.checkNameFaculty(nameNew,faculties)) {
                        faculties[numberOfFaculty].setNameOfFaculty(nameNew);
                    } else System.out.println("Існує факультет з такою назвою");
                } else System.out.println("Такого факультету не існує!");
                break;
        }
        Tools.saveFaculties(faculties);
    }
    private static void findStudentOrTeacher(){
        switch (DataInput.getInt("Введіть: 1 - шукати студента, 2 - шукати викладача: ")){
            case 1:
                int whatDo = DataInput.getInt("Введіть: 1 - шукати за ім'ям, 2 - за прізвищем, 3 - курсом, 4 - групою: ");
                if (whatDo==1){
                    Person[] findStudents = Tools.findPersonName(Tools.getAllStudents(faculties), Tools.checkName("Ім'я студента:"));
                    for (Person i : findStudents) System.out.println(i.toString());
                }
                if (whatDo == 2) {
                    Person[] findStudents = Tools.findPersonLastName(Tools.getAllStudents(faculties), Tools.checkName("Прізвище студента:"));
                    for (Person i : findStudents) System.out.println(i.toString());
                }
                if (whatDo == 3){
                    Student[] listOfStudents = Tools.getAllStudents(faculties);
                    int course = DataInput.getInt("Номер курсу: ");
                    if (course>=1 && course<=6) {
                        for (Student i : listOfStudents) {
                            if (i.getCourse() == course) System.out.println(i.toString());
                        }
                    } else System.out.println("Не існує такого курсу");
                }
                if (whatDo==4){
                    Student[] listOfStudents = Tools.getAllStudents(faculties);
                    int group = DataInput.getInt("Номер групи: ");
                    if (group>=1 && group<=2) {
                        for (Student i : listOfStudents) {
                            if (i.getGroup() == group) System.out.println(i.toString());
                        }
                    } else System.out.println("Не існує такої групи");
                }
                break;
            case 2:
                int whatToDo = DataInput.getInt("Введіть: 1 - шукати за ім'ям, 2 - за прізвищем: ");
                if (whatToDo == 1) {
                    Person[] findTeachers = Tools.findPersonName(Tools.getAllTeachers(faculties), Tools.checkName("Ім'я викладача:"));
                    for (Person i : findTeachers) System.out.println(i.toString());
                }
                if (whatToDo == 2) {
                    Person[] findTeachers =  Tools.findPersonLastName(Tools.getAllTeachers(faculties), Tools.checkName("Прізвище викладача:"));
                    for (Person i : findTeachers) System.out.println(i.toString());
                }
                break;
            default: System.out.println("Ви ввели невірні дані");
        }
    }
    public static void addDeleteStudentTeachers(){
        switch (DataInput.getInt("Введіть: 1 - працювати з студентами, 2 - з викладачами: ")){
            case 1:
                int whatDo = DataInput.getInt("Введіть: 1 - додати, 2 - видалити, 3 - змінити кафедру, 4 - змінити ім'я, 5 - призвище, 6 - курс, 7 - групу: ");
                if (whatDo==1){
                    System.out.println("Всі факультети: ");
                    for(int i = 0;i<faculties.length;i++){
                        System.out.println(i+". "+faculties[i].toString());
                    }
                    int num = DataInput.getInt("Виберіть факультет: ");
                    if(num >= 0 && num < faculties.length) {
                        System.out.println("Всі кафедри факультету: " + faculties[num].toString());
                        for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                            System.out.println(g + ". " + faculties[num].departmentIndex(g));
                        }
                        int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
                        if(numDep >=0 && numDep < faculties[num].departmentsLength()){
                            Student newStudent = new Student(Tools.checkName("Введіть ім'я студента: "),Tools.checkName("Введіть прізвище студента: "),faculties[num],faculties[num].departmentIndex(numDep));

                            int course=0;
                            while (course<1 || course>6){
                                course=DataInput.getInt("Введіть курс студента: ");
                            }
                            int group=0;
                            while (group<1 || group>2){
                                group=DataInput.getInt("Введіть групу студента: ");
                            }
                            newStudent.setCourse(course);
                            newStudent.setGroup(group);
                            faculties[num].departmentIndex(numDep).addStudent(newStudent);
                        }
                    }
                }
                if (whatDo==2) {
                    System.out.println("Всі факультети: ");
                    for (int i = 0; i < faculties.length; i++) {
                        System.out.println(i + ". " + faculties[i].toString());
                    }
                    int num = DataInput.getInt("Виберіть факультет: ");
                    if (num >= 0 && num < faculties.length) {
                        System.out.println("Всі кафедри факультету: " + faculties[num].toString());
                        for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                            System.out.println(g + ". " + faculties[num].departmentIndex(g));
                        }
                        int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
                        if (numDep >= 0 && numDep < faculties[num].departmentsLength()) {
                            Student[] listStudents = faculties[num].departmentIndex(numDep).getStudents();
                            if (listStudents.length==0){
                                System.out.println("В цій кафедрі немає студентів");
                                break;
                            }
                            System.out.println("Всі студенти кафедри");
                            for (int q=0;q<listStudents.length;q++){
                                System.out.println(q+". "+listStudents[q].toString());
                            }
                            int deleteStudent =DataInput.getInt("Номер студента, якого потрібно видалити: ");;
                            if (deleteStudent>=0 && deleteStudent<faculties[num].departmentIndex(numDep).getStudents().length) {
                                faculties[num].departmentIndex(numDep).deleteStudent(deleteStudent);
                            }
                        }
                    }
                }
                if (whatDo==3){
                    System.out.println("Всі факультети: ");
                    for (int i = 0; i < faculties.length; i++) {
                        System.out.println(i + ". " + faculties[i].toString());
                    }
                    int num = DataInput.getInt("Виберіть факультет: ");
                    if (num >= 0 && num < faculties.length) {
                        System.out.println("Всі кафедри факультету: " + faculties[num].toString());
                        for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                            System.out.println(g + ". " + faculties[num].departmentIndex(g));
                        }
                        int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
                        if (numDep >= 0 && numDep < faculties[num].departmentsLength()) {
                            Student[] listStudents = faculties[num].departmentIndex(numDep).getStudents();
                            if (listStudents.length==0){
                                System.out.println("В цій кафедрі немає студентів");
                                break;
                            }
                            System.out.println("Всі студенти кафедри");
                            for (int q=0;q<listStudents.length;q++){
                                System.out.println(q+". "+listStudents[q].toString());
                            }
                            int changeStudent =-1;
                            changeStudent = DataInput.getInt("Номер студента, якого потрібно перемістити: ");
                            if (changeStudent>=0 && changeStudent<faculties[num].departmentIndex(numDep).getStudents().length) {
                                System.out.println("Вкажіть куди перемістити студента");
                                System.out.println("Всі факультети: ");
                                for (int i = 0; i < faculties.length; i++) {
                                    System.out.println(i + ". " + faculties[i].toString());
                                }
                                int num1 = DataInput.getInt("Виберіть факультет: ");
                                if (num1 >= 0 && num1 < faculties.length) {
                                    System.out.println("Всі кафедри факультету: " + faculties[num1].toString());
                                    for (int g = 0; g < faculties[num1].departmentsLength(); g++) {
                                        System.out.println(g + ". " + faculties[num1].departmentIndex(g));
                                    }
                                    int numDep1 = DataInput.getInt("Введіть порядковий номер кафедри: ");
                                    if (numDep1 >= 0 && numDep1 < faculties[num1].departmentsLength()) {
                                        faculties[num1].departmentIndex(numDep1).addStudent(faculties[num].departmentIndex(num).studentIndex(changeStudent));
                                        faculties[num].departmentIndex(num).studentIndex(changeStudent).setPersonFaculty(faculties[num1]);
                                        faculties[num].departmentIndex(num).studentIndex(changeStudent).setPersonDepartment(faculties[num1].departmentIndex(numDep1));
                                        faculties[num].departmentIndex(numDep).deleteStudent(changeStudent);
                                    }
                                }
                            }
                        }
                    }
                }
                if (whatDo==4){
                    System.out.println("Всі факультети: ");
                    for (int i = 0; i < faculties.length; i++) {
                        System.out.println(i + ". " + faculties[i].toString());
                    }
                    int num = DataInput.getInt("Виберіть факультет: ");
                    if (num >= 0 && num < faculties.length) {
                        System.out.println("Всі кафедри факультету: " + faculties[num].toString());
                        for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                            System.out.println(g + ". " + faculties[num].departmentIndex(g));
                        }
                        int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
                        if (numDep >= 0 && numDep < faculties[num].departmentsLength()) {
                            Student[] listStudents = faculties[num].departmentIndex(numDep).getStudents();
                            if (listStudents.length==0){
                                System.out.println("В цій кафедрі немає студентів");
                                break;
                            }
                            System.out.println("Всі студенти кафедри");
                            for (int q=0;q<listStudents.length;q++){
                                System.out.println(q+". "+listStudents[q].toString());
                            }
                            int changeStudent =DataInput.getInt("Номер студента: ");;
                            if (changeStudent>=0 && changeStudent<faculties[num].departmentIndex(numDep).getStudents().length) {
                                faculties[num].departmentIndex(numDep).studentIndex(changeStudent).setName(Tools.checkName("Нове ім'я: "));
                            }
                        }
                    }
                }
                if (whatDo==5){
                    System.out.println("Всі факультети: ");
                    for (int i = 0; i < faculties.length; i++) {
                        System.out.println(i + ". " + faculties[i].toString());
                    }
                    int num = DataInput.getInt("Виберіть факультет: ");
                    if (num >= 0 && num < faculties.length) {
                        System.out.println("Всі кафедри факультету: " + faculties[num].toString());
                        for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                            System.out.println(g + ". " + faculties[num].departmentIndex(g));
                        }
                        int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
                        if (numDep >= 0 && numDep < faculties[num].departmentsLength()) {
                            Student[] listStudents = faculties[num].departmentIndex(numDep).getStudents();
                            if (listStudents.length==0){
                                System.out.println("В цій кафедрі немає студентів");
                                break;
                            }
                            System.out.println("Всі студенти кафедри");
                            for (int q=0;q<listStudents.length;q++){
                                System.out.println(q+". "+listStudents[q].toString());
                            }
                            int changeStudent =DataInput.getInt("Номер студента: ");;
                            if (changeStudent>=0 && changeStudent<faculties[num].departmentIndex(numDep).getStudents().length) {
                                faculties[num].departmentIndex(numDep).studentIndex(changeStudent).setLastName(Tools.checkName("Нове прізвище: "));
                            }
                        }
                    }
                }
                if (whatDo==6){
                    System.out.println("Всі факультети: ");
                    for (int i = 0; i < faculties.length; i++) {
                        System.out.println(i + ". " + faculties[i].toString());
                    }
                    int num = DataInput.getInt("Виберіть факультет: ");
                    if (num >= 0 && num < faculties.length) {
                        System.out.println("Всі кафедри факультету: " + faculties[num].toString());
                        for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                            System.out.println(g + ". " + faculties[num].departmentIndex(g));
                        }
                        int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
                        if (numDep >= 0 && numDep < faculties[num].departmentsLength()) {
                            Student[] listStudents = faculties[num].departmentIndex(numDep).getStudents();
                            if (listStudents.length==0){
                                System.out.println("В цій кафедрі немає студентів");
                                break;
                            }
                            System.out.println("Всі студенти кафедри");
                            for (int q=0;q<listStudents.length;q++){
                                System.out.println(q+". "+listStudents[q].toString());
                            }
                            int changeStudent =DataInput.getInt("Номер студента: ");;
                            if (changeStudent>=0 && changeStudent<faculties[num].departmentIndex(numDep).getStudents().length) {
                                faculties[num].departmentIndex(numDep).studentIndex(changeStudent).setCourse(DataInput.getInt("Введіть новий курс: "));
                            }
                        }
                    }
                }
                if (whatDo==7){
                    System.out.println("Всі факультети: ");
                    for (int i = 0; i < faculties.length; i++) {
                        System.out.println(i + ". " + faculties[i].toString());
                    }
                    int num = DataInput.getInt("Виберіть факультет: ");
                    if (num >= 0 && num < faculties.length) {
                        System.out.println("Всі кафедри факультету: " + faculties[num].toString());
                        for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                            System.out.println(g + ". " + faculties[num].departmentIndex(g));
                        }
                        int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
                        if (numDep >= 0 && numDep < faculties[num].departmentsLength()) {
                            Student[] listStudents = faculties[num].departmentIndex(numDep).getStudents();
                            if (listStudents.length==0){
                                System.out.println("В цій кафедрі немає студентів");
                                break;
                            }
                            System.out.println("Всі студенти кафедри");
                            for (int q=0;q<listStudents.length;q++){
                                System.out.println(q+". "+listStudents[q].toString());
                            }
                            int changeStudent =DataInput.getInt("Номер студента: ");;
                            if (changeStudent>=0 && changeStudent<faculties[num].departmentIndex(numDep).getStudents().length) {
                                faculties[num].departmentIndex(numDep).studentIndex(changeStudent).setGroup(DataInput.getInt("Введіть нову групу: "));
                            }
                        }
                    }
                }
                break;
            case 2:
                int whatToDo = DataInput.getInt("Введіть: 1 - додати, 2 - видалити, 3 - змінити кафедру, 4 - змінити ім'я, 5 - призвище: ");
                if (whatToDo==1){
                    System.out.println("Всі факультети: ");
                    for(int i = 0;i<faculties.length;i++){
                        System.out.println(i+". "+faculties[i].toString());
                    }
                    int num = DataInput.getInt("Виберіть факультет: ");
                    if(num >= 0 && num < faculties.length) {
                        System.out.println("Всі кафедри факультету: " + faculties[num].toString());
                        for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                            System.out.println(g + ". " + faculties[num].departmentIndex(g));
                        }
                        int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
                        if(numDep >=0 && numDep < faculties[num].departmentsLength()){
                            Teacher newTeacher = new Teacher(Tools.checkName("Введіть ім'я викладача: "),Tools.checkName("Введіть прізвище викладача: "),faculties[num],faculties[num].departmentIndex(numDep));
                            faculties[num].departmentIndex(numDep).addTeacher(newTeacher);
                        }
                    }
                }
                if (whatToDo==2) {
                    System.out.println("Всі факультети: ");
                    for (int i = 0; i < faculties.length; i++) {
                        System.out.println(i + ". " + faculties[i].toString());
                    }
                    int num = DataInput.getInt("Виберіть факультет: ");
                    if (num >= 0 && num < faculties.length) {
                        System.out.println("Всі кафедри факультету: " + faculties[num].toString());
                        for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                            System.out.println(g + ". " + faculties[num].departmentIndex(g));
                        }
                        int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
                        if (numDep >= 0 && numDep < faculties[num].departmentsLength()) {
                            Teacher[] listTeachers = faculties[num].departmentIndex(numDep).getTeachers();
                            if (listTeachers.length==0){
                                System.out.println("В цій кафедрі немає викладачів");
                                break;
                            }
                            System.out.println("Всі викладачі кафедри");
                            for (int q=0;q<listTeachers.length;q++){
                                System.out.println(q+". "+listTeachers[q].toString());
                            }
                            int deleteTeacher =DataInput.getInt("Номер викладача, якого потрібно видалити: ");;
                            if (deleteTeacher>=0 && deleteTeacher<faculties[num].departmentIndex(numDep).getTeachers().length) {
                                faculties[num].departmentIndex(numDep).deleteTeacher(deleteTeacher);
                            }
                        }
                    }
                }
                if (whatToDo==3){
                    System.out.println("Всі факультети: ");
                    for (int i = 0; i < faculties.length; i++) {
                        System.out.println(i + ". " + faculties[i].toString());
                    }
                    int num = DataInput.getInt("Виберіть факультет: ");
                    if (num >= 0 && num < faculties.length) {
                        System.out.println("Всі кафедри факультету: " + faculties[num].toString());
                        for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                            System.out.println(g + ". " + faculties[num].departmentIndex(g));
                        }
                        int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
                        if (numDep >= 0 && numDep < faculties[num].departmentsLength()) {
                            Teacher[] listTeachers = faculties[num].departmentIndex(numDep).getTeachers();
                            if (listTeachers.length==0){
                                System.out.println("В цій кафедрі немає викладачів");
                                break;
                            }
                            System.out.println("Всі викладачі кафедри");
                            for (int q=0;q<listTeachers.length;q++){
                                System.out.println(q+". "+listTeachers[q].toString());
                            }
                            int changeTeacher =-1;
                            changeTeacher = DataInput.getInt("Номер викладача, якого потрібно перемістити: ");
                            if (changeTeacher>=0 && changeTeacher<faculties[num].departmentIndex(numDep).getTeachers().length) {
                                System.out.println("Вкажіть куди перемістити викладача");
                                System.out.println("Всі факультети: ");
                                for (int i = 0; i < faculties.length; i++) {
                                    System.out.println(i + ". " + faculties[i].toString());
                                }
                                int num1 = DataInput.getInt("Виберіть факультет: ");
                                if (num1 >= 0 && num1 < faculties.length) {
                                    System.out.println("Всі кафедри факультету: " + faculties[num1].toString());
                                    for (int g = 0; g < faculties[num1].departmentsLength(); g++) {
                                        System.out.println(g + ". " + faculties[num1].departmentIndex(g));
                                    }
                                    int numDep1 = DataInput.getInt("Введіть порядковий номер кафедри: ");
                                    if (numDep1 >= 0 && numDep1 < faculties[num1].departmentsLength()) {
                                        faculties[num1].departmentIndex(numDep1).addTeacher(faculties[num].departmentIndex(num).teacherIndex(changeTeacher));
                                        faculties[num].departmentIndex(num).teacherIndex(changeTeacher).setPersonFaculty(faculties[num1]);
                                        faculties[num].departmentIndex(num).teacherIndex(changeTeacher).setPersonDepartment(faculties[num1].departmentIndex(numDep1));
                                        faculties[num].departmentIndex(numDep).deleteTeacher(changeTeacher);
                                    }
                                }
                            }
                        }
                    }
                }
                if (whatToDo==4){
                    System.out.println("Всі факультети: ");
                    for (int i = 0; i < faculties.length; i++) {
                        System.out.println(i + ". " + faculties[i].toString());
                    }
                    int num = DataInput.getInt("Виберіть факультет: ");
                    if (num >= 0 && num < faculties.length) {
                        System.out.println("Всі кафедри факультету: " + faculties[num].toString());
                        for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                            System.out.println(g + ". " + faculties[num].departmentIndex(g));
                        }
                        int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
                        if (numDep >= 0 && numDep < faculties[num].departmentsLength()) {
                            Teacher[] listTeachers = faculties[num].departmentIndex(numDep).getTeachers();
                            if (listTeachers.length==0){
                                System.out.println("В цій кафедрі немає викладачів");
                                break;
                            }
                            System.out.println("Всі викладачі кафедри");
                            for (int q=0;q<listTeachers.length;q++){
                                System.out.println(q+". "+listTeachers[q].toString());
                            }
                            int changeTeacher =DataInput.getInt("Номер викладача: ");;
                            if (changeTeacher>=0 && changeTeacher<faculties[num].departmentIndex(numDep).getTeachers().length) {
                                faculties[num].departmentIndex(numDep).teacherIndex(changeTeacher).setName(Tools.checkName("Нове ім'я викладача: "));
                            }
                        }
                    }
                }
                if (whatToDo==5){
                    System.out.println("Всі факультети: ");
                    for (int i = 0; i < faculties.length; i++) {
                        System.out.println(i + ". " + faculties[i].toString());
                    }
                    int num = DataInput.getInt("Виберіть факультет: ");
                    if (num >= 0 && num < faculties.length) {
                        System.out.println("Всі кафедри факультету: " + faculties[num].toString());
                        for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                            System.out.println(g + ". " + faculties[num].departmentIndex(g));
                        }
                        int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
                        if (numDep >= 0 && numDep < faculties[num].departmentsLength()) {
                            Teacher[] listTeachers = faculties[num].departmentIndex(numDep).getTeachers();
                            System.out.println("Всі викладачі кафедри");
                            if (listTeachers.length==0){
                                System.out.println("В цій кафедрі немає викладачів");
                                break;
                            }
                            for (int q=0;q<listTeachers.length;q++){
                                System.out.println(q+". "+listTeachers[q].toString());
                            }
                            int changeTeacher =DataInput.getInt("Номер викладача: ");;
                            if (changeTeacher>=0 && changeTeacher<faculties[num].departmentIndex(numDep).getTeachers().length) {
                                faculties[num].departmentIndex(numDep).teacherIndex(changeTeacher).setLastName(Tools.checkName("Нове прізвище викладача: "));
                            }
                        }
                    }
                }
                break;
        }
        Tools.savePeople(faculties);
    }
    private static void printAllStudentsOrTeachersOnDepartmentAlp(){
        System.out.println("Всі факультети: ");
        for(int i = 0;i<faculties.length;i++){
            System.out.println(i+". "+faculties[i].toString());
        }
        int num = DataInput.getInt("Виберіть факультет: ");
        if(num >= 0 && num < faculties.length) {
            System.out.println("Всі кафедри факультету: " + faculties[num].toString());
            for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                System.out.println(g + ". " + faculties[num].departmentIndex(g));
            }
            int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
            if(numDep >=0 && numDep < faculties[num].departmentsLength()) {
                int who = DataInput.getInt("Вивети студентів - 1, вивести викладачів - 2:");
                if (who==1){
                    Student[] students = faculties[num].departmentIndex(numDep).getStudents();
                    if (students.length>0){
                        Tools.sortNames(true,students);
                        System.out.println(Tools.getStringPerson(students));
                    }
                }
                if (who == 2 ){
                    Teacher[] teachers = faculties[num].departmentIndex(numDep).getTeachers();
                    if (teachers.length>0){
                        Tools.sortNames(true,teachers);
                        System.out.println(Tools.getStringPerson(teachers));
                    }
                }
            }
            }
    }
    private static void allDepartmentStudentsCourse(){
        System.out.println("Всі факультети: ");
        for(int i = 0;i<faculties.length;i++){
            System.out.println(i+". "+faculties[i].toString());
        }
        int num = DataInput.getInt("Виберіть факультет: ");
        if(num >= 0 && num < faculties.length) {
            System.out.println("Всі кафедри факультету: " + faculties[num].toString());
            for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                System.out.println(g + ". " + faculties[num].departmentIndex(g));
            }
            int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
            if(numDep >=0 && numDep < faculties[num].departmentsLength()) {
                Student[] students = faculties[num].departmentIndex(numDep).getStudents();
                if (students.length>0){
                    int course = DataInput.getInt("Введіть курс: ");
                    if (course>0 && course<7) {
                        Student[] studentsCourse={};
                        for (Student i : students){
                            if (course==i.getCourse()){
                                studentsCourse= (Student[]) Tools.addPerson(studentsCourse,i);
                            }
                        }
                        if (studentsCourse.length!=0){
                            System.out.println(Tools.getStringPerson(studentsCourse));
                        }
                    }
                }
            }
            }
    }
    private static void allDepartmentStudentsCourseAlp(){
        System.out.println("Всі факультети: ");
        for(int i = 0;i<faculties.length;i++){
            System.out.println(i+". "+faculties[i].toString());
        }
        int num = DataInput.getInt("Виберіть факультет: ");
        if(num >= 0 && num < faculties.length) {
            System.out.println("Всі кафедри факультету: " + faculties[num].toString());
            for (int g = 0; g < faculties[num].departmentsLength(); g++) {
                System.out.println(g + ". " + faculties[num].departmentIndex(g));
            }
            int numDep = DataInput.getInt("Введіть порядковий номер кафедри: ");
            if(numDep >=0 && numDep < faculties[num].departmentsLength()) {
                Student[] students = faculties[num].departmentIndex(numDep).getStudents();
                if (students.length>0){
                    int course = DataInput.getInt("Введіть курс: ");
                    if (course>0 && course<7) {
                        Student[] studentsCourse={};
                        for (Student i : students){
                            if (course==i.getCourse()){
                                studentsCourse= (Student[]) Tools.addPerson(studentsCourse,i);
                            }
                        }
                        if (studentsCourse.length!=0){
                            Tools.sortNames(true,studentsCourse);
                            System.out.println(Tools.getStringPerson(studentsCourse));
                        }
                    }
                }
            }
        }
    }
}
