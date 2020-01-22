public class TestClass {
    public TestClass(String className, double runTime) {
        this.className = className
        this.runTime = runTime
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getRunTime() {
        return runTime;
    }

    public void setRunTime(double runTime) {
        this.runTime = runTime;
    }

    String className;
    double runTime;


}
