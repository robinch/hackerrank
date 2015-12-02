import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by robin on 02/12/15.
 */
public class Solution {

    public List<Integer> closestNumbers(int[] numbers) {
        int min = Integer.MAX_VALUE;
        List <Integer> closest = new LinkedList<>();
        Arrays.sort(numbers);
        int diff;
        int current;
        int next;
        for(int i = 0; i < numbers.length - 1; i++) {
            current = numbers[i];
            next = numbers[i + 1];
            diff = Math.abs(current - next);
            if(diff < min) {
                closest = new LinkedList<>();
                min = diff;
            }
            if(diff == min) {
                closest.add(current);
                closest.add(next);
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        try {
            Solution sol = new Solution();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            in.readLine();
            String[] input = in.readLine().split(" ");
            int[] numbers = new int[input.length];

            for(int i = 0; i < input.length; i++){
                numbers[i] = Integer.parseInt(input[i]);
            }

            List<Integer> closest = sol.closestNumbers(numbers);
            StringBuilder sb = new StringBuilder();
            for(Integer n : closest) {
                sb.append(n);
                sb.append(" ");
            }

            System.out.println(sb);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
