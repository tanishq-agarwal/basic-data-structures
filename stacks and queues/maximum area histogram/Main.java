import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }

    // code
    int right[] = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    st.push(arr.length-1);
    right[arr.length-1]=arr.length;
    
    for(int i = arr.length - 2; i >= 0; i--){
        while(st.size() > 0 && arr[i] <= arr[st.peek()]){
            st.pop();
        }
        if(st.size() == 0){
            right[i] = arr.length;
        }
        else {
            right[i] = st.peek();
        }
        st.push(i);
    }
    
    int left[] = new int[arr.length];
    st = new Stack<>();
    st.push(0);
    left[0] = -1;
    
    for(int i = 1; i < arr.length; i++){
        while(st.size() > 0 && arr[i] <= arr[st.peek()]){
            st.pop();
        }
        if(st.size() == 0){
            left[i] = arr.length;
        }
        else {
            left[i] = st.peek();
        }
        st.push(i);
    }
    int maxArea = 0;
    for(int i = 0; i < arr.length; i++){
        int width = right[i] - left[i] - 1;
        int area = arr[i] * width;
        if(area > maxArea){
            maxArea = area;
        }
    }
    System.out.println(maxArea);
 }
}