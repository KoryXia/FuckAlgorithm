/*
 * @lc app=leetcode id=707 lang=golang
 *
 * [707] Design Linked List
 */

// @lc code=start
type Node struct {
	Val  int
	Next *Node
	Prev *Node
}

type MyLinkedList struct {
	head *Node
	tail *Node
	size int
}

func Constructor() MyLinkedList {
	tail := &Node{
		Val:  0,
		Next: nil,
		Prev: nil,
	}
	head := &Node{
		Val:  0,
		Next: nil,
		Prev: nil,
	}
	head.Next = tail
	tail.Prev = head
	return MyLinkedList{
		head: head,
		tail: tail,
		size: 0,
	}
}

func (this *MyLinkedList) Get(index int) int {
	if index < 0 || index >= this.size {
		return -1
	}

	node := this.head
	if index <= this.size/2 {
		for i := 0; i <= index; i++ {
			node = node.Next
		}
	} else {
		node = this.tail
		for i := 0; i < this.size-index; i++ {
			node = node.Prev
		}
	}
	return node.Val
}

func (this *MyLinkedList) AddAtHead(val int) {
	this.AddAtIndex(0, val)
}

func (this *MyLinkedList) AddAtTail(val int) {
	this.AddAtIndex(this.size, val)
}

func (this *MyLinkedList) AddAtIndex(index int, val int) {
	if index < 0 || index > this.size {
		return
	}

	prev := this.head
	for i := 0; i < index; i++ {
		prev = prev.Next
	}

	node := &Node{
		Val:  val,
		Next: nil,
		Prev: nil,
	}
	node.Next = prev.Next
	prev.Next.Prev = node
	node.Prev = prev
	prev.Next = node
	this.size++
}

func (this *MyLinkedList) DeleteAtIndex(index int) {
	if index < 0 || index >= this.size {
		return
	}

	prev := this.head
	for i := 0; i < index; i++ {
		prev = prev.Next
	}
	prev.Next.Next.Prev = prev
	prev.Next = prev.Next.Next
	this.size--
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Get(index);
 * obj.AddAtHead(val);
 * obj.AddAtTail(val);
 * obj.AddAtIndex(index,val);
 * obj.DeleteAtIndex(index);
 */
// @lc code=end

