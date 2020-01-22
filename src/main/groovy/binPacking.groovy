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
        firstFit(sortedTestClassList, bucketCapacity)


    }

    static def firstFit(List<TestClass> classesToAttach, int bucketCapacity) {
        List<Bucket> bucketList = []

        for (int i = 0; i < classesToAttach.size(); i++) {
            int j
            for (j = 0; j < bucketList.size(); j++) {
                if (bucketList[j].remainingBinSpace >= classesToAttach[i].runTime) {
                    double remainingBinSpace = bucketList[j].remainingBinSpace - classesToAttach[i].runTime
                    bucketList[j].setRemainingBinSpace(remainingBinSpace)
                    bucketList.add()
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
