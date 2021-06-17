package cheatsheet;

public class BinaryLifting {


    public void powerOF2Jump(){
        int LOG = 14;
        int k = 13; //cover this distance exactly
        for (int j = LOG - 1; j >= 0; j--){
            if((k & (1 << j)) > 0){
                //Take 8, 4, 1 jumps
                // 8 + 4 + 1 == 13
            }
        }
    }
}
