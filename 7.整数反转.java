/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */
//
//
/*
由于不确定是否会越界，所以把结果保存在long型数据中，最后把结果和整型的两个范围比较即可
*/
class Solution {
    public int reverse(int x) {
        long res = 0; //这里之所以定义long型，是因为不确定是否会越界
        while (x != 0){
            res = res * 10 + x % 10; //注意这是反转的常用做法
            x /= 10;                      
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ){
                return 0;
            }
        return (int)res;  //注意这里的res要强制转换成int型
        
    }
}
//要注意越界的问题

