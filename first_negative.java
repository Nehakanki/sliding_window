import java.util.ArrayList;
import java.util.List;

public class first_negative {

    public static int[] first_neg(int []arr, int k){

        if (arr == null || k <= 0) {
            return new int[0]; // Handle invalid input
        }
        int n= arr.length;
        int i=0;
        int j=0;
        List<Integer> list = new ArrayList<>();
        List<Integer>ans_list = new ArrayList<>();
       

        while(j<n){
            if(arr[j]<0)
            {
                list.add(arr[j]);
            }
            if(j-i+1 <k){
                j++;
            }
            else if(j-i+1 ==k){

                if(list.size()==0){
                    ans_list.add(0);
                }
                else{
                    int num = list.remove(0);
                    ans_list.add(num);
                }
                i++;
                j++;
                
            }


        }
        int[] ansArray = ans_list.stream().mapToInt(Integer::intValue).toArray();
        return ansArray;
       
    }
    public static void main(String[] args) {
        int [] arr = {12,-1,-7,8,-15,30,16,28};
        int k=3;
        int [] ans = first_neg(arr, k);
        for(int x: ans){
            System.out.print(x+" ");
        }
    }
}
