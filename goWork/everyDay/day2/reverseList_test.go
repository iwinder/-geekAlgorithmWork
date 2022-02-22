package day2

import "testing"

func TestReverseList(t *testing.T) {
	head := getHead()
	newHead := reverseList(head)
	for newHead != nil {
		t.Log(newHead.Val)
		newHead = newHead.Next
	}

}

func TestReverseListByRecursion(t *testing.T) {
	head := getHead()
	newHead := reverseListByRecursion(head)
	for newHead != nil {
		t.Log(newHead.Val)
		newHead = newHead.Next
	}

}

func getHead() *ListNode {
	five := &ListNode{
		Val:  5,
		Next: nil,
	}
	four := &ListNode{
		Val:  4,
		Next: five,
	}
	three := &ListNode{
		Val:  3,
		Next: four,
	}
	tow := &ListNode{
		Val:  2,
		Next: three,
	}
	head := &ListNode{
		Val:  1,
		Next: tow,
	}
	return head
}
