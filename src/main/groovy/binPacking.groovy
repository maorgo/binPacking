class binPacking {
    static void main(String[] args) {
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

        List<TestClass> classesToAttach = []

        for (entry in classesToRunningTime) {
            TestClass testClass = [entry.key, entry.value]
            classesToAttach.add(testClass)
        }

        List<TestClass> sortedTestClassList = classesToAttach.sort { -it.runTime }

        def bucketCapacity = 15
        List<Bucket> buckets = firstFit(sortedTestClassList, bucketCapacity)

        println("Total buckets: " + buckets.size())
        for (Bucket bucket: buckets) {
            println("**** New bucket run time: " + bucket.totalRunTime)
            println(bucket.attachedClasses.size() + " classes")
            for (String className: bucket.attachedClasses) {
                println(className)
            }
        }


    }

    static def firstFit(List<TestClass> classesToAttach, int bucketCapacity) {
        List<Bucket> bucketList = []

        for (int i = 0; i < classesToAttach.size(); i++) {
            int j
            for (j = 0; j < bucketList.size(); j++) {
                if (bucketList[j].remainingBinSpace >= classesToAttach[i].runTime) {
//                    double remainingBinSpace = bucketList[j].remainingBinSpace - classesToAttach[i].runTime
//                    bucketList[j].setRemainingBinSpace(remainingBinSpace)
                    bucketList[j].add(classesToAttach[i])
                    break
                }
            }

            if (j == bucketList.size()) {
                Bucket newBucket = [bucketCapacity]
                newBucket.add(classesToAttach[i])
                bucketList.add(newBucket)
            }
        }
        return bucketList
    }
}
