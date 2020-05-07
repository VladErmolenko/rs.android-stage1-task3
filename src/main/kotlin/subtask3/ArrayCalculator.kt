package subtask3

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var prod=1
        var counter=numberOfItems
        val returnList=arrayListOf<Int>()
        val intList = arrayListOf<Int>()
        for(n in itemsFromArray)
            if(n is Int)
                intList.add(n)
            else
                continue
        if(intList.isEmpty())
            return 0

        if(numberOfItems>=intList.size)
        {
            for(n in 0 until intList.size)
                prod *= intList[n]
            return prod
        }
        intList.sortDescending()
        for(i in 1..numberOfItems) {
            if (i % 2 != 0) {
                returnList.add(intList.max()!!)
                intList.removeAt(0)
                counter--
            }
            else {
                if((intList[0]*intList[1])>=(intList[intList.lastIndex]*intList[intList.lastIndex-1]))
                { returnList.add(intList[0])
                    intList.removeAt(0)
                    returnList.add(intList[0])
                    intList.removeAt(0)
                }

                else
                {
                    returnList.add(intList[intList.lastIndex])
                    intList.removeAt(intList.lastIndex)
                    returnList.add(intList[intList.lastIndex])
                    intList.removeAt(intList.lastIndex)
                }
                counter-=2
            }
            if(counter==0)
                break
            else
                continue

        }
        for(n in 0 until returnList.size)
            prod *= returnList[n]
        return(prod)
    }
}
