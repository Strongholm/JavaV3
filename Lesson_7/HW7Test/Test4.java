package HW7Test;

public class Test4 {

    @BeforeSuite
    public void taskBefore() {
        System.out.println(getClass().getSimpleName() + " До");
    }

    @Test(10)
    public void task1() {
        System.out.println(getClass().getSimpleName() + " задание 1");
    }
}