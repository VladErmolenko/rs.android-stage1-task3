package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        fun fact(n : Int) : Int {
            var fact = 1
            for (i in 1..n) {
                fact *= i
            }
            return fact
        }
        for(n in 1..array[1]){
            if(array[0]*fact(n)*fact((array[1]-n))==fact(array[1]))
               return n
            else
                continue
        }
        return null
    }
}
