package HW_1;

public class Test4_HW1 {

    @BeforeSuite
    public void taskBefore() {
        System.out.println(getClass().getSimpleName() + " before");
    }

    @BeforeSuite
    public void taskBefore2() {
        System.out.println(getClass().getSimpleName() + " before");
    }

    @Test_HW1(value = 10, priority = 10)
    public void task1() {
        System.out.println(getClass().getSimpleName() + " task1");
    }
}
