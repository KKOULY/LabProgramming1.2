public class Laboratory {
    private Faculty[] faculties = new Faculty[0];


    public static void main(String[] args) {

    }

    public void addFaculty(String nameOfFaculty){
        Faculty[] facultiesTemporary = new Faculty[faculties.length+1];
        System.arraycopy(faculties,0,facultiesTemporary,0,faculties.length);
        facultiesTemporary[faculties.length] = new Faculty(nameOfFaculty);
        faculties = facultiesTemporary;
    }

    public void deleteFaculty(int numOfFaculty){
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
    
    
    //перевіряє чи це слово(в стрічці тільки букви)
    private boolean isWord(String word){
        for(int i =0; i<word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    //робить першу літеру великою, а всі наступні маленькими + не пропускає далі поки не введеш слово
    private String checkName(String whatToWrite) {
        String realName = "";
        while (true) {
            String name = DataInput.getString(whatToWrite);
            if (name.equals("")) {
                return "немає ім'я в базі";
            }
            if (!isWord(name)) {
                System.out.println("Ви ввели недопустимі символи!");
                continue;
            }
            if (Character.isLowerCase(name.charAt(0))) {
                char newLetter = Character.toUpperCase(name.charAt(0));
                realName = realName + newLetter;
            } else realName = realName + name.charAt(0);
            if (name.length() > 1) {
                for (int i = 1; i < name.length(); i++) {
                    if (Character.isUpperCase(name.charAt(i))) {
                        char newLetter = Character.toLowerCase(name.charAt(i));
                        realName = realName + newLetter;
                    } else realName = realName + name.charAt(i);
                }
            }
            return realName;
        }
    }

    public String getAllStudents(String name){
        return getString(faculties);
    }

    public static String getString(Faculty[] faculties) {
        String save = "";
        for(int iFac = 0; iFac< faculties.length; iFac++){
            Faculty facultyTemp = faculties[iFac];
            for(int iDep = 0;iDep < facultyTemp.departmentsLength();iDep++){
                Department departmentTemp = facultyTemp.departmentIndex(iDep);
                for (int iStud = 0;iStud < departmentTemp.studentsLength();iStud++){
                    save+=departmentTemp.studentIndex(iStud).toString()+"\n";
                }
            }
        }

        return save;
    }
}
