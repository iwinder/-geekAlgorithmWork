package day2

// 217. 存在重复元素 https://leetcode-cn.com/problems/contains-duplicate/
func containsDuplicate(nums []int) bool {
	var flag bool = false
	var mapList = make(map[int]int, len(nums))
	for _, value := range nums {
		mapList[value]++
		if mapList[value] > 1 {
			flag = true
			break
		}
	}
	return flag
}
