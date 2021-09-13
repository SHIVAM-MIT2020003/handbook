package RangeQueries.SegmentTree_itr;

class NumArray {
    int N;
    int[] st;
    public NumArray(int[] nums) {
        N = getSize(nums.length); // after 0 padding
        st = new int[2 * N];
        for (int i = 0; i < nums.length; i++){
            update(i, nums[i]);
        }
    }

    public void update(int i, int v) {
        i += N;
        st[i] += v - st[i];
        for (i /= 2; i >= 1; i /= 2){
            st[i] = st[i * 2] + st[2 * i + 1];
        }
    }

    public int sumRange(int a, int b) {
        a += N; b += N;
        int sum = 0;
        while(a <= b){
            if(a % 2 == 1) sum += st[a++];
            if(b % 2 == 0) sum += st[b--];
            a /= 2; b/= 2;
        }
        return sum;
    }

    public int getSize(int n){
        return (int)Math.pow(2, (int)(Math.ceil(Math.log(n) / Math.log(2))));
    }
}