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

        def bucketCapacity = 15

        classesToRunningTime.sort { it.value }
        .forEach {
            k, v -> println "${k}:${v}"
        }

    }

    def firstFit(Map classesToRunTime) {

    }

}
