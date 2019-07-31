package HW_1;

public class Test3_HW1 {
    @BeforeSuite
    public void taskBefore() {
        System.out.println(getClass().getSimpleName() + " before");
    }

    @Test_HW1(value = 2, priority = 2)
    public void task1() {
        System.out.println(getClass().getSimpleName() + " task1");
    }

    @Test_HW1(value = 9, priority = 9)
    public void task2() {
        System.out.println(getClass().getSimpleName() + " task2");
    }

    @Test_HW1(value = 8, priority = 8)
    public void task3() {
        System.out.println(getClass().getSimpleName() + " task3");
    }

    @Test_HW1(value = 1, priority = 1)
    public void task4() {
        System.out.println(getClass().getSimpleName() + " task 3");
    }
}
