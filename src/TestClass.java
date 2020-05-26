public class TestClass {
    public static void main(String[] args) {
        Faculty fac = new Faculty("FI");
        Department dep = new Department("Math");
        Student test = new Student("Tom","Ford",fac,dep,232,2);
        System.out.println(test);
    }
}
