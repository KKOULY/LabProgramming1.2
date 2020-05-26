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
}
