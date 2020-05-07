package subtask1

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        if(numbers.isEmpty())
            return null
        var returnString = "${numbers[0]}x^${numbers.size-1}"
        var counter=2
        for ((index, value) in numbers.withIndex())
        {
            if(index==0)
                continue
            when{
                value<0->returnString += " - ${value*(-1)}x^${numbers.size-counter}"
                value>0->returnString +=" + ${value}x^${numbers.size-counter}"
                value==0->returnString+=""
            }
            counter++
        }
        returnString = returnString.replace("x^1", "x")
        returnString = returnString.replace("x^0", "")
        returnString = returnString.replace("1x", "x")
        return(returnString)
    }
}
