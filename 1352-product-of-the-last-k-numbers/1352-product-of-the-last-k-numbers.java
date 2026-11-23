class ProductOfNumbers {
    private ArrayList<Integer> nums;

    public ProductOfNumbers() {
        nums = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0) {
            for(int i = 0; i < nums.size(); i++) {
                nums.set(i, 0);
            }
            nums.add(0);
            return;
        }

        if(nums.size() == 0 || nums.get(nums.size() - 1) == 0) {
            nums.add(num);
            return;
        }

        nums.add(nums.get(nums.size() - 1) * num);
    }
    
    public int getProduct(int k) {
        int n = nums.size();
        int idx = n - k - 1;
        int x = 1;
        if(idx > -1) {
            x = nums.get(idx);
        }

        if(nums.get(n - k) == 0) {
            return 0;
        }
        
        if(x == 0) {
            return nums.get(n - 1);
        }
        
        return nums.get(n - 1)/x;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
/**


    0 1 2  3   4     5   6      7
    1 2 3  4   5     6   0      2   
    1 2 6  24  120  720 120     1,440     
                |

                48
              / 6
              ------    
              1,344

    n = 8 - 8 - 1



    3,0,2,5,4

    5-4



 */