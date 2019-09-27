package HW7Test;

public class Test1 {

    @BeforeSuite
    public void taskBefore() {
        System.out.println(getClass().getSimpleName() + " До");
    }

    @Test(10)
    public void task1() {
        System.out.println(getClass().getSimpleName() + " задание 1");
    }

    @Test(3)
    public void task2() {
        System.out.println(getClass().getSimpleName() + " задание 2");
    }

    @Test(4)
    public void task3() {
        System.out.println(getClass().getSimpleName() + " задание 3");
    }

    @Test(3)
    public void task4() {
        System.out.println(getClass().getSimpleName() + " задание 4");
    }

    @AfterSuite
    public void taskAfter() {
        System.out.println(getClass().getSimpleName() + " После");
    }
}
