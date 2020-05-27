public class Laboratory {
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
    private String checkName(String whatToWrite){
        String realName="";
        while (true){
            String name = DataInput.getString(whatToWrite);
            if(name.equals("")){
                return "немає ім'я в базі";
            }
            if (!isWord(name)){
                System.out.println("Ви ввели недопустимі символи!");
                continue;
            }
            if (Character.isLowerCase(name.charAt(0))){
                char newLetter = Character.toUpperCase(name.charAt(0));
                realName = realName+newLetter;
            } else realName=realName+name.charAt(0);
            if (name.length()>1){
                for (int i = 1; i<name.length();i++){
                    if (Character.isUpperCase(name.charAt(i))){
                        char newLetter = Character.toLowerCase(name.charAt(i));
                        realName = realName+newLetter;
                    } else realName=realName+name.charAt(i);
                }
            }
            return realName;
        }
    }
    public static void main(String[] args) {

    }


    String[] students = new String[10];//delete
    
    private void swap(Student[] students, int i, int y) {
        Student temp = students[i];
        students[i] = students[y];
        students[y] = temp;
    }

    public void sortNames(boolean up) {
        if(students != null && students.length > 1){
            for(int x = 1; x < students.length;x++){
                for (int y = students.length-1; y >= x; y--) {
                    if(up) {
                        if (!alphabetCompare(y-1,y))
                            swap(students, y - 1, y);
                    } else {
                        if (alphabetCompare(y-1,y))
                            swap(students, y - 1, y);
                    }
                }
            }
        }
    }

    private boolean alphabetCompare(int i, int y) {
        String s0 = students[i].getName();
        String s1 = students[y].getName();
        boolean flag = s0.length() <= s1.length();
        for(int x = 0;x < s0.length() && x < s1.length();x++){
            char c0 = Character.toLowerCase(s0.charAt(x));
            char c1 = Character.toLowerCase(s1.charAt(x));
            if(c0 < c1){
                flag = true;
                break;
            } else if(c0 > c1) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
