package SingleNumber;
import java.util.*;
public class Main{
    public static int FindSingleNumber(int nums[]){
        if(nums.length==0) return -1;
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums){
            if(map.get(num)==1) return num;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = FindSingleNumber(arr);
        System.out.println("Single number is: " + result);
        sc.close();
    }
}
// To solve this I used HashMap to track the count of each element.
// First pass is to count how many times each number comes.
// Second pass is to find the element whose count is 1 that is the single number.