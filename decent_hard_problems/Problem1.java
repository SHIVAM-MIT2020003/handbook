package decent_hard_problems;

//https://leetcode.com/problems/gcd-sort-of-an-array/

import java.util.*;

class Problem1 {
    private static class UF
    {
        int[] parent;
        byte[] rank;
        int n;
        UF(int n)
        {
            this.n = n;
            parent = new int[n];
            rank = new byte[n];
            for(int i = 0; i < n; i++)
            {
                parent[i] = i;
            }
        }
        private int find(int i)
        {
            while(i != parent[i])
            {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public boolean connected(int a, int b)
        {
            return find(a) == find(b);
        }

        public void union(int a, int b)
        {
            int pa = find(a);
            int pb = find(b);

            if(pa == pb)    return;

            if(rank[pa] > rank[pb]) parent[pb] = pa;
            if(rank[pa] < rank[pb]) parent[pa] = pb;
            else
            {
                parent[pb] = pa;
                rank[pa] ++;
            }
        }
    }

    public boolean gcdSort(int[] a)
    {
        int n = a.length;
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int i : a)  {
            set.add(i);
            max = Math.max(max, i);
        }

        UF uf = new UF(max + 1);

        int[] sortedArr = new int[n];

        for(int i = 0; i < n; i++)
            sortedArr[i] = a[i];

        Arrays.sort(sortedArr);

        //sieve
        boolean[] sieve = new boolean[max + 1];
        Arrays.fill(sieve, true);

        sieve[1] = false;
        for(int i = 2; i <= max; i++){
            if(sieve[i]) {
                for (int j = i + i; j <= max; j += i) {
                    // i is a prime number
                    // i * j is connected to i (of course if i * j is there in arr)
                    if (set.contains(j)) uf.union(i, j);
                    sieve[j] = false;
                }
            }
        }

        //.checking if arr[i] and sorted[i] is in the same group
        for(int i = 0; i < n; i++) {
            if(!uf.connected(a[i], sortedArr[i])) return false;
        }
        return true;
    }
}