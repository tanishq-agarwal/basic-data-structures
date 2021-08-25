import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = sc.nextInt();
      }

      int k = sc.nextInt();
      // write your code here
      
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for(int i=0; i < arr.length; i++){
          if(i < k){
              pq.add(arr[i]);
          }
          else {
              if(arr[i] > pq.peek()){
                  pq.remove();
                  pq.add(arr[i]);
              }
          }
      }
      while(pq.size() > 0){
          System.out.println(pq.remove());
      }
    }

}