package HW7Test;

public class Test2 {
    @AfterSuite
    public void tastAfter() {
        System.out.println(getClass().getSimpleName() + " До");
    }

    @Test
    public void task1() {
        System.out.println(getClass().getSimpleName() + " задание 1");
    }

    @Test(3)
    public void task2(){
        System.out.println(getClass().getSimpleName() + " задание 2");
    }

}
