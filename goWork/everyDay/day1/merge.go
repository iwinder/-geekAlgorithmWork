package day1

// 88. 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
func merge(nums1 []int, m int, nums2 []int, n int) {
	var len, i, j = m + n, m - 1, n - 1
	for k := len - 1; k >= 0; k-- {
		if j < 0 || (i >= 0 && nums1[i] >= nums2[j]) {
			nums1[k] = nums1[i]
			i--
		} else {
			nums1[k] = nums2[j]
			j--
		}
	}
}
