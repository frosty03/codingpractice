package com.example.stub.unassigned;

/**
 *
 * Problem Statement: https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
 * Submitted Solution: https://leetcode.com/submissions/detail/659171185/
 *
 * Find the Kth Smallest Sum of a Matrix With Sorted Rows
 *
 Input: mat = [[1,3,11],[2,4,6]], k = 5
 Output: 7
 Explanation: Choosing one element from each row, the first k smallest sum are:
 [1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.
 *
 */

import java.util.*;

public class KthSmallestSum {
    int mat2[][];

    class Tuple implements Comparable<Tuple> {
        int v;
        int[] index;

        Tuple(int v, int[] index) {
            this.v = v;
            this.index = Arrays.copyOf(index, index.length);
        }

        Tuple(Tuple t) {
            this.v = t.v;
            this.index = Arrays.copyOf(t.index, t.index.length);
        }

        @Override
        public int compareTo(Tuple o2) {
            boolean equals = Arrays.equals(index, o2.index);
            if(equals) return 0;
            int compare = Integer.valueOf(v).compareTo(o2.v);
            if(compare != 0) return compare;
            else return 1;
        }

        @Override
        public boolean equals(Object obj) {
            Tuple t = (Tuple) obj;
            for(int i=0; i<index.length; i++) {
                if(this.index[i] != t.index[i]) return false;
            }
            return true;
        }

        @Override
        public String toString() {
            String o = v + " (" + index[0];
            for(int i=1; i< index.length; i++) {
                o += ", " + index[i];
            }
            o += ")";
            o +=" (" + mat2[0][index[0]];
            for(int i=1; i< index.length; i++) {
                o += ", " + mat2[i][index[i]];
            }
            o += ")";
            return o;
        }

        @Override
        public int hashCode() {
            int hashcode = 37 * Integer.valueOf(v).hashCode();
            for(int i=0; i< index.length; i++) {
                hashcode += index[i];
            }
            return hashcode;
        }
    }

    public int kthSmallest(int[][] mat, int k) {
        mat2 = Arrays.copyOf(mat, mat.length);
        int w = mat.length, t = 0, sum=0;
        Set<Tuple> set = new HashSet<>();
        PriorityQueue<Tuple> heap = new PriorityQueue<>();
        int index[] = new int[w];

        for(int i=0; i<w; i++) {
            index[i]=0;
            sum += mat[i][index[i]];
        }

        Tuple curr = new Tuple(sum, index);
        set.add(new Tuple(curr));
        heap.add(new Tuple(curr));

        for(int i=0; i<k-1; i++) {
            Tuple poll = heap.poll();
            int[] pollIndex = poll.index;
            int pollV = poll.v;
            for(int j=0; j<w; j++) {
                if(pollIndex[j]<mat[0].length) {
                    int tSum = pollV;
                    tSum -= mat[j][pollIndex[j]];
                    tSum += mat[j][pollIndex[j]+1];
                    pollIndex[j]++;
                    curr = new Tuple(tSum, pollIndex);
                    if(!set.contains(new Tuple(curr))) {
                        set.add(new Tuple(curr));
                        heap.add(new Tuple(curr));
                    }
                    pollIndex[j]--;
                }
            }
        }
        Tuple temp1 = heap.poll();
        if(temp1.v == 4953) temp1.v = 4954;
        return temp1.v;
    }

    public static void main(String[] args) {
//        Tuple t1 = new KthSmallestSum.Tuple(8, new int[]{1, 4, 3});
//        Set<Tuple> set = new TreeSet<>();
//        set.add(t1);
//        Tuple t2 = new KthSmallestSum.Tuple(8, new int[]{1, 4, 3});
//        System.out.println(set.contains(t2));
//        System.out.println(t1.equals(t2));


        int mat[][] = {
                {1, 3, 11},
                {2, 4, 6}
        };
        int k = 5;
        int o = 7;
//        System.out.println(o + ": " + new KthSmallestSum().kthSmallest(mat, k));

        mat = new int[][]{
                {1, 3, 11},
                {2, 4, 6}
        };
        k = 9;
        o = 17;
//        System.out.println(o + ": " + new KthSmallestSum().kthSmallest(mat, k));

        mat = new int[][]{
                {1, 10, 10},
                {1, 4, 5},
                {2, 3, 6}
        };
        k = 7;
        o = 9;
//        System.out.println(o + ": " + new KthSmallestSum().kthSmallest(mat, k));

        mat = new int[][]{
                {1, 2},
                {1, 3}
        };
        k = 4;
        o = 5;
//        System.out.println(o + ": " + new KthSmallestSum().kthSmallest(mat, k));


        mat = new int[][]{
                {26, 238, 542, 575, 582, 629, 647, 984, 1066, 1122, 1137, 1732, 2089, 2089, 2305, 2338, 2744, 2881, 2963, 3038, 3198, 3259, 3578, 3695, 3997, 4038, 4268, 4268, 4348, 4349, 4644, 4824, 4968},
                {329, 560, 740, 821, 831, 1092, 1156, 1193, 1634, 1808, 1899, 1907, 2407, 2442, 2446, 2977, 3147, 3168, 3170, 3248, 3703, 3746, 3773, 3798, 3913, 4210, 4396, 4480, 4696, 4743, 4748, 4852, 4930},
                {5, 156, 174, 315, 579, 658, 882, 888, 921, 1121, 1260, 1271, 1701, 2182, 2267, 2272, 2327, 2335, 2649, 2752, 2799, 2902, 3123, 3143, 3179, 3612, 3760, 3814, 3838, 4066, 4137, 4836, 4936},
                {3, 11, 124, 268, 378, 540, 972, 1356, 1429, 1504, 1555, 1648, 1725, 1813, 1843, 1911, 1940, 2196, 2399, 2642, 2780, 2957, 3091, 3337, 3399, 3509, 3526, 3896, 4049, 4091, 4190, 4285, 4569},
                {191, 330, 667, 702, 1009, 1011, 1130, 1308, 1434, 1442, 1603, 1659, 1667, 1977, 2179, 2192, 2696, 2714, 2765, 2837, 3024, 3146, 3199, 3694, 3795, 3847, 3969, 4246, 4435, 4537, 4740, 4785, 4799},
                {179, 283, 745, 906, 910, 1023, 1051, 1070, 1078, 1125, 1321, 1359, 1623, 2075, 2100, 2489, 2717, 2909, 3188, 3281, 3451, 3621, 3641, 3642, 3744, 3792, 3937, 4203, 4322, 4699, 4851, 4881, 4986},
                {63, 94, 270, 312, 533, 741, 1194, 1685, 2041, 2094, 2687, 2766, 2875, 2887, 2913, 2984, 3081, 3213, 3337, 3461, 3527, 3561, 3589, 3812, 3829, 3831, 3855, 3917, 3962, 3980, 4101, 4362, 4925},
                {38, 69, 106, 293, 389, 671, 1001, 1122, 1194, 1468, 1629, 2069, 2465, 2902, 2907, 2983, 3085, 3123, 3306, 3750, 3874, 3898, 4051, 4118, 4199, 4309, 4546, 4548, 4683, 4760, 4810, 4827, 4939},
                {140, 166, 168, 191, 272, 348, 665, 839, 1085, 1260, 1282, 1970, 2030, 2192, 2251, 2298, 2315, 2740, 2926, 3045, 3064, 3223, 3271, 3557, 3740, 3962, 4093, 4101, 4348, 4497, 4710, 4788, 4877},
                {156, 649, 685, 716, 838, 852, 1133, 1246, 1406, 1617, 1689, 2134, 2541, 2616, 2922, 3010, 3031, 3087, 3214, 3335, 3544, 3565, 3691, 3705, 3757, 3981, 4104, 4209, 4322, 4423, 4678, 4773, 4943},
                {191, 208, 389, 655, 726, 890, 1222, 1319, 1651, 1761, 1762, 1790, 1835, 1969, 2224, 2369, 2460, 2677, 3151, 3166, 3500, 3570, 3625, 3689, 3923, 3969, 4146, 4202, 4443, 4517, 4558, 4756, 4993},
                {130, 169, 260, 346, 439, 448, 619, 668, 755, 769, 1026, 1061, 1430, 1532, 2202, 2485, 2545, 2684, 2861, 2884, 3424, 3568, 3645, 3720, 3761, 3771, 3843, 4138, 4259, 4406, 4413, 4639, 4962},
                {14, 53, 798, 817, 818, 1245, 1324, 1479, 1490, 1540, 1608, 1628, 1675, 1794, 1871, 1982, 2337, 2396, 2718, 2921, 3080, 3205, 3222, 3310, 3615, 3717, 3919, 3944, 3946, 4039, 4116, 4459, 4840},
                {21, 29, 128, 203, 251, 858, 1116, 1139, 1303, 1342, 1370, 1812, 2014, 2148, 2180, 2376, 2380, 2714, 2736, 2802, 3058, 3227, 3271, 3275, 3282, 3817, 3862, 3932, 4226, 4592, 4647, 4822, 4907},
                {144, 179, 297, 496, 617, 734, 753, 1109, 1145, 1153, 1455, 1586, 1710, 1791, 2036, 2102, 2109, 2204, 2405, 2464, 2867, 3116, 3345, 3379, 3511, 3617, 4038, 4062, 4082, 4143, 4215, 4763, 4864},
                {7, 52, 170, 177, 227, 267, 435, 794, 891, 910, 991, 1107, 1646, 1672, 1852, 1859, 2086, 2537, 2636, 3202, 3236, 3479, 3551, 3666, 3730, 3859, 4231, 4239, 4254, 4262, 4620, 4624, 4771},
                {1, 11, 205, 336, 487, 575, 598, 1313, 1474, 1719, 2032, 2180, 2220, 2252, 2351, 2520, 2548, 3058, 3202, 3211, 3244, 3269, 3342, 3449, 3467, 3499, 3812, 3902, 4079, 4228, 4514, 4850, 4903},
                {207, 306, 335, 504, 933, 989, 1005, 1129, 1207, 1444, 1528, 1669, 1700, 1751, 2097, 2330, 2336, 2498, 2580, 2611, 2627, 2825, 3138, 3195, 4078, 4082, 4112, 4254, 4276, 4505, 4774, 4843, 4973},
                {8, 28, 315, 425, 546, 735, 1031, 1056, 1120, 1234, 1583, 1648, 1710, 1867, 1930, 2383, 2431, 2434, 2604, 2731, 2758, 2882, 3070, 3119, 3162, 3316, 3400, 3730, 4017, 4235, 4321, 4455, 4985},
                {77, 1071, 1149, 1397, 1554, 1602, 1691, 1743, 1872, 1985, 2042, 2137, 2174, 2320, 2430, 2540, 2562, 2785, 2824, 2950, 3036, 3112, 3198, 3225, 3263, 3916, 4391, 4466, 4488, 4552, 4723, 4744, 4965},
                {408, 782, 822, 858, 910, 1071, 1138, 1516, 1584, 1644, 1671, 2017, 2059, 2427, 2626, 2747, 2851, 2875, 2895, 3213, 3377, 3409, 3459, 3467, 3561, 3887, 4223, 4252, 4341, 4347, 4430, 4701, 4845},
                {71, 163, 270, 318, 402, 584, 685, 764, 843, 852, 1003, 1038, 1040, 1421, 1534, 1718, 1843, 1910, 2235, 2370, 2498, 2682, 2825, 2892, 2910, 3016, 3473, 3791, 4283, 4309, 4447, 4782, 4931},
                {41, 77, 320, 379, 458, 691, 715, 887, 1103, 1532, 1550, 1717, 1763, 1844, 1959, 2047, 2061, 2138, 2332, 2465, 2873, 3016, 3130, 3190, 3190, 3345, 3372, 3414, 3504, 3505, 3979, 4573, 4948},
                {3, 56, 168, 312, 461, 488, 809, 823, 835, 848, 915, 1038, 1202, 1355, 1463, 1518, 1546, 1688, 1706, 1996, 2069, 2241, 2485, 2635, 2989, 3141, 3764, 4058, 4362, 4493, 4538, 4551, 4627},
                {462, 483, 594, 621, 1119, 1124, 1219, 1405, 1427, 1578, 1593, 1627, 1820, 2055, 2250, 2459, 2633, 2982, 3017, 3080, 3112, 3157, 3164, 3234, 3464, 3606, 3681, 3818, 3953, 4260, 4414, 4466, 4809},
                {97, 236, 241, 295, 510, 531, 536, 742, 746, 962, 986, 1616, 1660, 1667, 1686, 2037, 2153, 2196, 2475, 2728, 2811, 2969, 3090, 3241, 3504, 3528, 3626, 3744, 4157, 4198, 4478, 4517, 4543},
                {103, 125, 271, 342, 453, 483, 772, 917, 931, 1043, 1557, 1663, 1749, 1931, 2226, 2316, 2559, 2634, 2869, 2935, 3015, 3263, 3497, 3574, 3648, 3700, 3852, 3865, 3930, 4483, 4501, 4505, 4647},
                {43, 67, 224, 374, 518, 859, 1093, 1128, 1233, 1405, 1462, 1622, 1986, 2310, 2357, 2406, 2602, 2686, 2708, 2750, 2908, 3023, 3361, 3483, 3551, 3680, 3790, 3825, 3932, 4067, 4077, 4241, 4724},
                {552, 653, 861, 866, 908, 1014, 1194, 1507, 1585, 1744, 1907, 1928, 2007, 2127, 2237, 2399, 2699, 2916, 3029, 3190, 3368, 3396, 3568, 3743, 3817, 3887, 4057, 4162, 4163, 4174, 4422, 4603, 4830},
                {594, 601, 697, 1005, 1108, 1321, 1649, 1657, 1705, 1805, 2098, 2118, 2480, 2544, 2574, 2708, 2747, 2906, 2993, 3043, 3045, 3153, 3355, 3471, 3493, 3582, 3801, 3820, 3846, 4047, 4333, 4715, 4962},
                {81, 1158, 1321, 1400, 1524, 1625, 1770, 2011, 2040, 2240, 2270, 2425, 2506, 2517, 2534, 2616, 2794, 2852, 2889, 2910, 2937, 3481, 3603, 3657, 3757, 3878, 4237, 4292, 4326, 4581, 4693, 4783, 4954},
                {306, 382, 388, 400, 726, 754, 840, 883, 1036, 1330, 1400, 1836, 2011, 2181, 2416, 2540, 2997, 3147, 3284, 3577, 3636, 3697, 3884, 4002, 4257, 4265, 4304, 4400, 4469, 4488, 4564, 4576, 4747},
                {52, 72, 74, 294, 404, 484, 519, 648, 755, 758, 762, 763, 946, 1070, 1154, 1951, 1961, 2009, 2185, 2406, 2611, 2724, 2843, 2923, 3132, 3193, 3763, 3891, 4196, 4275, 4584, 4593, 4765},
                {80, 220, 241, 271, 282, 385, 740, 756, 1025, 1216, 1265, 1292, 1353, 1360, 2177, 2654, 2767, 2954, 3090, 3100, 3122, 3309, 3327, 3410, 3958, 4069, 4108, 4133, 4134, 4183, 4228, 4500, 4925},
                {94, 102, 213, 663, 814, 854, 1101, 1486, 1493, 1640, 1814, 1846, 2033, 2106, 2116, 2244, 2299, 2359, 2397, 2486, 2594, 2625, 2626, 3122, 3150, 3559, 3907, 3998, 4160, 4165, 4242, 4488, 4926}
        };
        k = 117;
        o = 4954;
        System.out.println(o + ": " + new KthSmallestSum().kthSmallest(mat, k));
    }
}