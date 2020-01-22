class binPacking {
    static void main(String[] args) {
        def bucketRunningLimit = 15
        Map classesToRunningTime = [
                "class1": 5,
                "class2": 1,
                "class3": 15,
                "class4": 14,
                "class5": 2,
                "class6": 9,
                "class7": 10,
                "class8": 0,
                "class9": 0
        ]

        List<TestClass> classesToAttach = getDescendingOrderTestClasses(classesToRunningTime)
        List<Bucket> buckets = firstFit(classesToAttach, bucketRunningLimit)
        printBucketsResult(buckets)
    }

    private static List<TestClass> getDescendingOrderTestClasses(LinkedHashMap<String, Integer> classesToRunningTime) {
        List<TestClass> classesToAttach = []

        for (entry in classesToRunningTime) {
            TestClass testClass = new TestClass(entry.key, entry.value)
            classesToAttach.add(testClass)
        }

        return classesToAttach.sort { -it.runTime }
    }

    private static List<Bucket> firstFit(List<TestClass> classesToAttach, int bucketCapacity) {
        List<Bucket> bucketList = []

        for (int i = 0; i < classesToAttach.size(); i++) {
            TestClass currentClass = classesToAttach[i]
            boolean isClassMatched = false
            int j
            for (j = 0; j < bucketList.size(); j++) {

                if (bucketList[j].remainingBinSpace >= currentClass.runTime) {
                    bucketList[j].add(currentClass)
                    isClassMatched = true
                    break
                }
            }

            if (!isClassMatched) {
                Bucket newBucket = new Bucket(bucketCapacity)
                newBucket.add(currentClass)
                bucketList.add(newBucket)
            }
        }
        return bucketList
    }

    private static void printBucketsResult(List<Bucket> buckets, int runningLimit) {
        println("Total buckets: " + buckets.size() + " with running time limit: " + runningLimit)
        for (Bucket bucket : buckets) {
            println("**** New bucket run time: " + bucket.totalRunTime)
            println(bucket.attachedClasses.size() + " classes")
            for (String className : bucket.attachedClasses) {
                println(className)
            }
        }
    }
}
