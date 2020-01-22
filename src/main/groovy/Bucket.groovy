class Bucket {
    def attachedClasses = []
    double totalRuntime = 0
    double remainingBinSpace = 0

    public Bucket(int bucketCapacity) {
        remainingBinSpace = bucketCapacity
    }

    void add(TestClass testClass) {
        attachedClasses.add(testClass.className)
        totalRuntime += testClass.runTime
        remainingBinSpace -= testClass.runTime
    }

    double getTotalRunTime() {
        return totalRuntime;
    }
}
