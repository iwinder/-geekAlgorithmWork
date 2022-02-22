package day2

import "testing"

func TestContainsDuplicate(t *testing.T) {
	nums := []int{1, 2, 3, 1}
	t.Log("falg:", containsDuplicate(nums))
	nums = []int{1, 2, 3, 4}
	t.Log("falg:", containsDuplicate(nums))
}
