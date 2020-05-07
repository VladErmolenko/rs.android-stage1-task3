package subtask4

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        val returnlist = mutableListOf<Int>()
        var temp=number*number
        var myaw=0
        var el = number-1
        do {
            returnlist.add(el)
            temp -=el*el
            if(temp==0)
                return returnlist.reversed().toTypedArray()
            if(el==1)
            {
                if (returnlist.size < 2) break
                temp += returnlist[returnlist.lastIndex] * returnlist[returnlist.lastIndex ]
                returnlist.removeAt(returnlist.lastIndex )
                el = returnlist[returnlist.lastIndex ] - 1
                temp += returnlist[returnlist.lastIndex ] * returnlist[returnlist.lastIndex ]
                returnlist.removeAt(returnlist.lastIndex )
            }
            else
            {
                myaw= kotlin.math.sqrt(temp.toFloat()).toInt()
                if(el<=myaw)
                    el--
                else
                    el=myaw
            }

        }while (el>0)
        return null
            }
        }
