/**
 * maxSubarraysum
 */
public class maxSubarraysum {
    
    public static int max_sum(int[] arr, int k){
            int Maxsum = Integer.MIN_VALUE;
            int sum=0;
            int n= arr.length;
            int  j=0;
            int i=0;
            while(j<n){
                //sum the element
                sum+=arr[j];
                if(j-i+1 !=k){
                    //until the window==k
                    j++;
                }
                else if(j-i+1 ==k){
                    Maxsum = Math.max(Maxsum, sum);
                    //makesure to remove the previous i
                    sum= sum- arr[i];
                    i++;
                    j++;
                }
            }


        return Maxsum;
    }

    public static void main(String[] args) {
        int [] arr = {2,5,1,8,2,9,1};
        int k=3;
        int ans = max_sum(arr,k);
        System.out.println(ans);

    }
}