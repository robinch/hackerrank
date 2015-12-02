import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Solution {

    class QueueEntry{
        int pos;
        int distance;
        public QueueEntry(int pos, int distance) {
            this.pos = pos;
            this.distance = distance;
        }
    }


    public int minDiceThrows(int[] board) {
        int N = board.length;

        // Default all boolean is false
        boolean[] visited = new boolean[N];

        Queue<QueueEntry> queue = new LinkedList<>();

        QueueEntry root = new QueueEntry(0, 0);
        QueueEntry currentQE;
        int neighbourPos;
        queue.add(root);

        while(!queue.isEmpty()) {
            currentQE = queue.poll();

            if(currentQE.pos == (N - 1)) return currentQE.distance;


            for (int i = 1; i <= 6; i++) {
                neighbourPos = currentQE.pos + i;
                if(neighbourPos > N-1) continue;

                if(board[neighbourPos] != -1) neighbourPos = board[neighbourPos];

                if(!visited[neighbourPos]){
                    visited[neighbourPos] = true;
                    QueueEntry qe;
                    qe = new QueueEntry(neighbourPos, currentQE.distance + 1);
                    queue.add(qe);
                }
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            Solution s = new Solution();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int N = 100;
            int[] board;
            int nrOfCases = Integer.parseInt(in.readLine());
            int nrOfSnakes;
            int nrOfLadders;
            String[] fromTo;
            // All cases
            for(int i = 0; i < nrOfCases; i++) {
                board = new int[N];
                for(int j = 0; j < board.length; j++) {
                    board[j] = - 1;
                }
                // Ladders

                nrOfLadders = Integer.parseInt(in.readLine());
                for(int j = 0; j < nrOfLadders; j++) {
                    fromTo = in.readLine().split(" ");
                    board[Integer.parseInt(fromTo[0]) - 1] = Integer.parseInt(fromTo[1]) - 1;
                }
                // Snakes
                nrOfSnakes = Integer.parseInt(in.readLine());
                for(int j = 0; j < nrOfSnakes; j++) {
                    fromTo = in.readLine().split(" ");
                    board[Integer.parseInt(fromTo[0]) - 1] = Integer.parseInt(fromTo[1]) - 1;
                }
                System.out.println(s.minDiceThrows(board));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}