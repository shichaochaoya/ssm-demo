package reflect_demo;

public class Demo {

    private String name;

    public Demo() { }

    public Demo(String name){}

    //@Deprecated//注明方法过时，
    @AnnoTest(value = "demo")//value没有默认值，必须设值
    public int add(int a, int b) {
        return a + b;
    }

    private String getName() {
        return name;
    }
    public String getPName() {
        return name;
    }
}
