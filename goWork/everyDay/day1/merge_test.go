package day1

import (
	"testing"
)

func TestMergeTowArray(t *testing.T) {
	nums1 := []int{1, 2, 3, 0, 0, 0}
	nums2 := []int{2, 5, 6}
	m, n := 3, 3
	merge(nums1, m, nums2, n)
	t.Log(nums1)
}
