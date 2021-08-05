package iiita_placement.cisco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(derive_phone_number("zerozerotwo"));

    }

    public static String derive_phone_number(String s) {
        ans = "";
        s = s.toUpperCase();
        String[] ntoString = new String[10];
        ntoString[0] = "ZERO";
        ntoString[1] = "ONE";
        ntoString[2] = "TWO";
        ntoString[3] = "THREE";
        ntoString[4] = "FOUR";
        ntoString[5] = "FIVE";
        ntoString[6] = "SIX";
        ntoString[7] = "SEVEN";
        ntoString[8] = "EIGHT";
        ntoString[9] = "NINE";

        int[] sfreq = getFreq(s);
        f(sfreq, ntoString, "");
        return ans;
    }


    public static boolean check(int[] freq){
        for (int i = 0; i < freq.length; i++){
            if(freq[i] > 0) return false;
        }
        return true;
    }

    static String ans = "";
    public static boolean f(int[] sfreq, String[] ns, String res){
        if(check(sfreq)){
            ans = res;
            return true;
        }

        for (int i = 9; i >= 0; i--){
            int[] temp = getFreq(ns[i]);
            if(isValid(temp, sfreq)){
                remove(temp, sfreq);
                if(f(sfreq, ns, res + i)){
                    return true;
                }
                add(temp, sfreq);
            }
        }
        return false;
    }

    public static void remove(int[] t, int[] s){
        for (int i = 0; i < 26; i++){
            s[i] -= t[i];
        }
    }

    public static void add(int[] t, int[] s){
        for (int i = 0; i < 26; i++){
            s[i] += t[i];
        }
    }

    public static int[] getFreq(String s){
        int[] f = new int[26];
        for (char c : s.toCharArray()){
            f[c - 'A']++;
        }
        return f;
    }

    public static boolean isValid(int[] t, int[] s){
        for (int i = 0; i < 26; i++){
            if(s[i] < t[i]) return false;
        }
        return true;
    }
}