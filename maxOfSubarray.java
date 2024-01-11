import java.util.*;

public class maxOfSubarray {

        public static int[] max_subaaray(int[] arr, int k){

            Queue<Integer> q = new ArrayDeque<>();
            List<Integer> ans_list = new ArrayList<>();
            int n= arr.length;
            int i=0;
            int j=0;
          
            while(j<n){
                //1. prior calculation
                while(q.size()>0 && arr[j]>q.peek()){
                    q.poll();
                };
                q.add(arr[j]);

                if(j-i+1 <k){
                    j++;
                }
                else if(j-i+1 ==k){
                    ans_list.add(q.peek());
                    if(q.peek()==arr[i]){
                        q.poll();
                    }
                    i++;
                    j++;
                    
                }


            }
            //arraylist to array
            int [] ans = ans_list.stream().mapToInt(Integer::intValue).toArray();


            return ans;
        }
        public static void main(String[] args) {
            int [] arr = {1,3,-1,-3,5,3,6,7};
            int  k=3;

            int[] ans = max_subaaray(arr, k);
            
            for(int i:ans){
                System.out.print(i+" ");
            }

        }
}
