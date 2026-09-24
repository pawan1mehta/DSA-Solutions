func digitSum(num int) int {
    sum := 0
    for num > 0 {
        digit := num%10
        sum += digit
        num /= 10
    }
    return sum
}

func smallestIndex(nums []int) int {
    n := len(nums)
    for i := 0; i < n; i++ {
        if i == digitSum(nums[i]) {
            return i
        }
    }
    return -1
}