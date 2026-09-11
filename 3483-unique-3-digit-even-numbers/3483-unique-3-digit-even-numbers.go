func totalNumbers(digits []int) int {
    n := len(digits)

    visited := make(map[int]struct{})

    for i := 0; i < n; i++ {
        if digits[i] == 0 {
            continue
        }

        for j := 0; j < n; j++ {
            if i == j {
                continue
            }

            for k := 0; k < n; k++ {
                if k == i || k == j || digits[k]%2 != 0 {
                    continue
                }

                num := digits[i] * 100 + digits[j] * 10 + digits[k]

                _, ok := visited[num]
                if !ok {
                    visited[num] = struct{}{}
                }
            }
        }
    }

    return len(visited)
}