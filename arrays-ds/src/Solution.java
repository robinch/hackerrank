import java.io.*;
import java.util.*;

public class Solution {

    public void printArrayInRevers(int[] ar) {
        StringBuilder sb = new StringBuilder();
        for(int i = ar.length - 1; i >= 0; i--){
            sb.append(ar[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        try {
            Solution s = new Solution();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            String[] numbers = in.readLine().split(" ");
            int[] ar = new int[n];
            for(int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(numbers[i]);
            }
            s.printArrayInRevers(ar);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}