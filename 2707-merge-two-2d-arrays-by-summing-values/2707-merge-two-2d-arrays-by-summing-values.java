import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        int n = nums1.length, m = nums2.length;
        
        while (i < n && j < m) {
            if (nums1[i][0] == nums2[j][0]) { 
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                result.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            } else { 
                result.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            }
        }
        
        while (i < n) {
            result.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }
        
        while (j < m) {
            result.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
