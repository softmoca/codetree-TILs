import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 100;
    
    public static int n, m, endOfArray;
    public static int[] numbers = new int[MAX_NUM];
    
    public static int getEndIdxOfExplosion(int startIdx, int currNum) {
        int endIdx = startIdx + 1;
        while(endIdx < endOfArray) {
            if(numbers[endIdx] == currNum)
                endIdx++;
            else{
                break;
            }
        }
    
        return endIdx - 1;
    }
    
    public static void cutArray(int startIdx, int endIdx) {
        int cutLen = endIdx - startIdx + 1;
        for(int i = endIdx + 1; i < endOfArray; i++) {
            numbers[i - cutLen] = numbers[i];
        }
        
        endOfArray -= cutLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            numbers[i] = sc.nextInt();
        endOfArray = n;

        boolean didExplode;
        int currIdx;
        do {
            didExplode = false;
            currIdx = 0;

            while(currIdx < endOfArray) {
                int endIdx = getEndIdxOfExplosion(currIdx, numbers[currIdx]);

                if(endIdx - currIdx + 1 >=  m) {
                    // 연속한 숫자의 개수가 m개 이상이면
                    // 폭탄이 터질 수 있는 경우 해당 부분 수열을 잘라내고
                    // 폭탄이 터졌음을 기록해줍니다.
                    cutArray(currIdx, endIdx);
                    didExplode = true;
                }
                else {
                    // 폭탄이 터질 수 없는 경우 
                    // 순회할 필요가 없는 원소에 대한 탐색을 생략해줍니다.
                    currIdx = endIdx + 1;
                }
            }
        }
        while(didExplode); 

        System.out.println(endOfArray);
        for(int i = 0; i < endOfArray; i++)
            System.out.println(numbers[i]);
    }
}
