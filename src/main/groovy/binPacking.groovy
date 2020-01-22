class binPacking {
    static void main(String[] args) {
        Map classesToRunningTime = [
                "class1": 4,
                "class2": 2,
                "class3": 5,
                "class4": 4,
                "class5": 2,
                "class6": 5,
                "class7": 4,
                "class8": 2,
                "class9": 5
        ]

        List<TestClass> classesToAttach = []

        for (entry in classesToRunningTime) {
            TestClass testClass = [entry.key, entry.value]
            classesToAttach.add(testClass)
        }

        List<TestClass> sortedTestClassList = classesToAttach.sort { it.runTime }

        def bucketCapacity = 15
        print(sortedTestClassList.size())



    }

    static def firstFit(List<TestClass> classesToAttach, int bucketCapacity) {
        List<Bucket> bucketList = []

        List<Integer> remainingBinSpace = []

        for (int i = 0; i < classesToAttach.size(); i++) {
            int j
            for (j = 0; j < bucketList.size(); j++) {
                if (remainingBinSpace[j] >= classesToAttach[i].runTime) {
                    remainingBinSpace[j] = remainingBinSpace[j] - classesToAttach[i].runTime
                    bucketList.add()
                    break
                }
            }

            if (j == bucketList.size()) {
                Bucket newBucket = []
                newBucket.add(classesToAttach[i])
                bucketList.add(newBucket)
                remainingBinSpace[j] = bucketCapacity - classesToAttach[i].runTime
            }
        }
    }
}
