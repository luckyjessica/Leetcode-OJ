package medium;
//http://www.cnblogs.com/springfor/p/3884009.html

public class UniqueBinarySearchTrees {
	/**
     * 定义Count[i] 为以[0,i]能产生的Unique Binary Tree的数目，

    如果数组为空，毫无疑问，只有一种BST，即空树，
    Count[0] =1

    如果数组仅有一个元素{1}，只有一种BST，单个节点
    Count[1] = 1

    如果数组有两个元素{1,2}， 那么有如下两种可能
    1                       2
     \                    /
       2                1
    Count[2] = Count[0] * Count[1]  (1为根的情况)
             + Count[1] * Count[0]  (2为根的情况)

    再看一遍三个元素的数组，可以发现BST的取值方式如下：
    Count[3] = Count[0]*Count[2]  (1为根的情况)
             + Count[1]*Count[1]  (2为根的情况)
             + Count[2]*Count[0]  (3为根的情况)

    所以，由此观察，可以得出Count的递推公式为
    Count[i] = ∑ Count[0...k] * [ k+1....i]     0<=k<i-1
    问题至此划归为一维动态规划。
     **/
    public int numTrees(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        
        for(int i = 2 ; i< res.length ;i++){
            for(int j = 0 ; j<i ; j++){
                res[i] += res[j] * res[i-j-1];
            }
        }
        return res[n];
    }
}
