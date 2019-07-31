package HW_1;

public class Test2_HW1 {
    @AfterSuite_HW1
    public void taskAfter() {
        System.out.println(getClass().getSimpleName() + " after");
    }

    @Test_HW1(priority = 1)
    public void task1() {
        System.out.println(getClass().getSimpleName() + " task1");
    }

    @Test_HW1(value = 3, priority = 3)
    public void task2() {
        System.out.println(getClass().getSimpleName() + " task2");
    }
}
