package HW_1;

public class Test1_HW1 {

    @BeforeSuite
    public void taskBefore() {
        System.out.println(getClass().getSimpleName() + " before");
    }

    @Test_HW1(value = 10, priority = 10)
    public void task1() {
        System.out.println(getClass().getSimpleName() + " task1");
    }

    @Test_HW1(value = 3, priority = 3)
    public void task2() {
        System.out.println(getClass().getSimpleName() + " task2");
    }

    @Test_HW1(value = 4, priority = 4)
    public void task3() {
        System.out.println(getClass().getSimpleName() + " task3");
    }

    @Test_HW1(value = 5, priority = 5)
    public void task4() {
        System.out.println(getClass().getSimpleName() + " task4");
    }

    @AfterSuite_HW1
    public void taskAfter() {
        System.out.println(getClass().getSimpleName() + " after");
    }
}
