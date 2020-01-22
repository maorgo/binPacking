class Bucket {
    def attachedClasses
    double totalRuntime

    public Bucket() {
        attachedClasses = []
        totalRuntime = 0
    }

    void add(TestClass testClass) {
        attachedClasses.add(testClass.className)
        totalRuntime += testClass.runTime
    }

    double getTotalRunTime() {
        return totalRuntime;
    }
}
