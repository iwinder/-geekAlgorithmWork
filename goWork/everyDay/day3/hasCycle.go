package day3

type ListNode struct {
	Val  int
	Next *ListNode
}

func hasCycle(head *ListNode) bool {
	cur := head
	fast := head
	for fast != nil && fast.Next != nil {
		cur = cur.Next
		fast = fast.Next.Next
		if cur == fast {
			return true
		}
	}
	return false
}
