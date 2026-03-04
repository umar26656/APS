import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] result = new int[n];
        
        Stack<Integer> stack = new Stack<>(); // stores indices
        
        for (int i = 0; i < n; i++) {
            
            // If current temperature is warmer
            while (!stack.isEmpty() && 
                   temperatures[i] > temperatures[stack.peek()]) {
                
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            
            stack.push(i);
        }
        
        return result;
    }
}