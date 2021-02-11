package String.KMP;

public class Solution {
    public static void main(String[]args){
        String src = "abaabacd";
        String tar = "abcabcd";
        int[] pi = prefix(tar.toCharArray());
        for (int val : pi){
            System.out.print(val + " ");
        }
        System.out.println("\n" + KMP(src.toCharArray(), tar.toCharArray(), pi));
    }

    public static boolean KMP(char[] src, char[] target, int[] pi){
        if(src.length < target.length) return false;
        int m = src.length;
        for (int i = 0, j = 0; i < m; i++){
            while(j > 0 && src[i] != target[j]){
                j = pi[j - 1];
            }
            if(src[i] == target[j]){
                j++;
            }
            if(j == target.length) return true;
        }
        return false;
    }

    public static int[] prefix(char[] target){
        int n = target.length;
        int[] pi = new int[n];
        pi[0] = 0; // matched length t then prefix length t - 1
        for (int i = 1, j = 0; i < n; i++){
            while(j > 0 && target[j] != target[i]){
                j = pi[j - 1];
            }
            if(target[j] == target[i]){
                pi[i] = j + 1;
                j++;
            }else{
                pi[i] = 0;
            }
        }
        return pi;
    }
}


