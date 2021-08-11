/**
 Problem Statement: https://leetcode.com/problems/container-with-most-water/
 Submitted Solution: https://leetcode.com/submissions/detail/536966226/
 */

public class ContainerMaxWater {
    public static void main(String[] args) {
        System.out.println(new ContainerMaxWater().maxArea(new int[]{1}));
        System.out.println(new ContainerMaxWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(new ContainerMaxWater().maxArea(new int[]{4,3,2,1,4}));
        System.out.println(new ContainerMaxWater().maxArea(new int[]{1,2,1}));

        System.out.println(new ContainerMaxWater().maxArea(new int[]{2,3,4,5,18,17,6}));
    }

    public int maxArea(int[] height) {
        int a=0, b=height.length-1;
        int max=0;
        while( a < b ) {
            max=Math.max(max, (b-a)*Math.min(height[a], height[b]));
            if(height[a] < height[b]) a++;
            else b--;
        }
        return max;
    }
}
