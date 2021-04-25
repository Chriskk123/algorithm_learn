package week04.leetcode.editor.cn;
 
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 428 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.两次二分查找
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
//            return false;
//        }
//        if(target < matrix[0][0]){
//            return false;
//        }
//        int m = matrix.length,n = matrix[0].length;
//        int low = 0,high = m - 1,row = 0;
//        while(low <= high){
//            int mid = low + (high - low) / 2;
//            if(matrix[mid][0] == target){
//                return true;
//            }
//            else if(matrix[mid][0] > target){
//                high = mid - 1;
//            }
//            else{
//                low = mid + 1;
//                row = mid;
//            }
//        }
//        int left = 0,right = n - 1;
//        while(left <= right){
//            int mid = left + (right - left) / 2;
//            if(matrix[row][mid] == target){
//                return true;
//            }
//            else if(matrix[row][mid] > target){
//                right = mid - 1;
//            }
//            else{
//                left = mid + 1;
//            }
//        }
//        return false;
//    }

    //2.一次二分查找（注意此方法只有在二维数组中的每个一维数组中的元素个数相等时有效）
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length,n = matrix[0].length;
        int low = 0,high = m * n - 1,row = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int i = mid / n,j = mid % n;
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
