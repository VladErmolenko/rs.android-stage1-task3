package subtask6

class FullBinaryTrees {

    // TODO: Complete the following function
    fun stringForNodeCount(count: Int): String {
        if (count == 1) return "[[0]]"
        if (count <= 0 || count % 2 == 0) return "[]"
        val outputString = StringBuilder()
        for (n in allPossibleFBT(count)) {
            val l = recurLeftNode(n.leftNode)
            val r = recurRightNode(n.rightNode)
            outputString.append(("[${n.x}$l$r]".substringBeforeLast(",null,null") + "]"))
        }
        return outputString.toString()

    }
    private fun recurLeftNode(node: TreeNode?): String{
        if (node == null) return ""
        val l = StringBuilder()
        if (node.leftNode == null) {
            l.append(",$node".substringBeforeLast(",null,null"))
        } else {
            l.append(",0")
            l.append(recurRightNode(node.rightNode))
            if (node.rightNode!!.leftNode != null) {
                l.append(",null,null")
            }
            l.append(recurLeftNode(node.leftNode))
        }
        return l.toString()
    }

    private fun recurRightNode(node: TreeNode?): String{
        if (node == null) return ""
        val r = StringBuilder()

        if (node.rightNode == null)
            r.append(",$node")
        else {
            r.append(",0")
            r.append(recurLeftNode(node.leftNode))
            if (node.leftNode!!.rightNode?.leftNode != null) {
                r.insert(r.length - 2, ",null,null")
                if (node.leftNode!!.rightNode?.rightNode?.leftNode != null)
                    r.append(",null,null")
            }
            r.append(recurRightNode(node.rightNode))
        }
        return r.toString()
    }


    class TreeNode(var x: Int = 0) {
        var leftNode: TreeNode? = null
        var rightNode: TreeNode? = null

        override fun toString(): String {
            return StringBuffer().apply {
                append(x.toString())
                append(",${leftNode.toString()}")
                append(",${rightNode.toString()}")
            }.toString()
        }
    }
    //val res: Stack<TreeNode> = Stack<TreeNode>() //ArrayDeque  LinkedList mutableListOf
    fun allPossibleFBT(N: Int): MutableList<TreeNode> {
        if (N <= 0 || N % 2 == 0) return ArrayList()
        val res: MutableList<TreeNode> = ArrayList()
        if (N == 1) {
            res.add(TreeNode(0))
            return res
        }
        var i = 1
        while (i < N) {
            val leftSubTrees = allPossibleFBT(i)
            val rightSubTrees = allPossibleFBT(N - i - 1)
            for (l in leftSubTrees) {
                for (r in rightSubTrees) {
                    val root = TreeNode(0)
                    root.leftNode = l
                    root.rightNode = r
                    res.add(root)
                }
            }
            i += 2
        }
        return res
    }
}
