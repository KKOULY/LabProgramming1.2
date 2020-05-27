public class Faculty {
    private String title;
    private String nameOfFaculty;
    private Department[] departments;
    public Faculty(){
    }
    public Faculty(String nameOfFaculty){
        this.nameOfFaculty = nameOfFaculty;
    }

    public String toString(){
        return nameOfFaculty;
    }
}
