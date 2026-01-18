import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int[] prefix = new int[length+1];

        for (int i = 1; i<=length; i++){
            int curVal = sc.nextInt();
            prefix[i] = prefix[i-1] + curVal;
        }

        while(sc.hasNextInt()){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            int sum = prefix[x2+1] - prefix[x1];
            System.out.println(sum);
        }

    }
}