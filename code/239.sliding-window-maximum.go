/*
 * @lc app=leetcode id=239 lang=golang
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
type MaxQueue struct {
	queue []int
}

func NewMaxQueue() *MaxQueue {
	return &MaxQueue{
		queue: make([]int, 0),
	}
}

func (m *MaxQueue) Front() int {
	return m.queue[0]
}

func (m *MaxQueue) Back() int {
	return m.queue[len(m.queue)-1]
}

func (m *MaxQueue) Push(val int) {
	for len(m.queue) > 0 && val > m.Back() {
		m.queue = m.queue[:len(m.queue)-1]
	}
	m.queue = append(m.queue, val)
}

func (m *MaxQueue) Pop(val int) {
	if len(m.queue) > 0 && val == m.Front() {
		m.queue = m.queue[1:]
	}
}

func maxSlidingWindow(nums []int, k int) []int {
	queue := NewMaxQueue()
	res := make([]int, len(nums)-k+1)
	for i := 0; i < k; i++ {
		queue.Push(nums[i])
	}

	res[0] = queue.Front()

	for i := k; i < len(nums); i++ {
		queue.Pop(nums[i-k])
		queue.Push(nums[i])
		res[i-k+1] = queue.Front()
	}
	return res
}

// @lc code=end

