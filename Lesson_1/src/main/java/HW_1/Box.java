package HW_1;

public class Box {

    private Object obj;

    public Box(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("Class: " + obj.getClass().getName());
        System.out.println("Object: " + obj);
    }
}
