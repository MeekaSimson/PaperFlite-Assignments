package RemoveKDigits;
import java.util.*;
public class Main {
public static String removeK(String num, int k) {
    if(k>=num.length()) return "0";
    Stack <Character> stack = new Stack<>();
    for(int i=0;i<num.length();i++){
       char n=num.charAt(i);
       while(!stack.empty()&& k>0 && stack.peek()>n){
        stack.pop();
        k--;
       }
       stack.push(n);
    }
    while(k>0 && !stack.empty()) {
        stack.pop();
        k--;
    }
    StringBuilder res = new StringBuilder();
    for(char c: stack){
        res.append(c);
    }
    int i=0;
    while(i<res.length() && res.charAt(i)=='0') i++;
    res.delete(0,i);
    if(res.length()==0) return "0";
    return res.toString();     
}
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        String num = sc.next();
        System.out.print("Enter k: ");
        int k = sc.nextInt();
        String result = removeK(num, k);
        System.out.println("Smallest number: " + result);
        sc.close();
    }
}
// 1. I am using a stack to store the digits one by one.
//    If the current digit is smaller than the top of the stack,
//    I keep popping from the stack until k becomes 0 or the order is correct.
// 2. After popping, if still k!=0 i remove the remaining digits at the end of the stack
// 3. I used StringBuilder to build the result because
//    it is easier to modify compared to normal String.
// 4. Then I remove the leading zeros and return the final number as string.
