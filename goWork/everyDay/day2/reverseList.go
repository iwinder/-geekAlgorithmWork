package day2

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	var last *ListNode = nil
	cur := head
	for cur != nil {
		nextNode := cur.Next
		cur.Next = last
		last = cur
		cur = nextNode
	}
	return last

}

func reverseListByRecursion(head *ListNode) *ListNode {
	var last *ListNode = nil
	cur := head
	return recursion(cur, last)
}

func recursion(cur, last *ListNode) *ListNode {
	if cur == nil {
		return last
	}
	nextNode := cur.Next
	cur.Next = last
	last = cur
	cur = nextNode
	return recursion(cur, last)
}
