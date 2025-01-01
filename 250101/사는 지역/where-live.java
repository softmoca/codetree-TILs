import java.util.Scanner;

// Person 정보를 나타내는 클래스 선언
class Person {
    String name;
    String streetAddress;
    String region;

    public Person(String name, String streetAddress, String region){
        this.name = name;
        this.streetAddress = streetAddress;
        this.region = region;
    }
	Person(){}
};

public class Main {
    public static final int MAXN = 10;

    public static Person[] people = new Person[MAXN];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            String address = sc.next();
            String region = sc.next();
            
            // 객체 생성 및 리스트에 추가
            people[i] = new Person(name, address, region);
        }
        
        // 사전순으로 이름이 가장 느린 사람 찾기
        int lastIdx = 0;
        for(int i = 1; i < n; i++) {
            if(people[i].name.compareTo(people[lastIdx].name) > 0)
                lastIdx = i;
        }

        // 결과를 출력합니다.
        System.out.println("name " + people[lastIdx].name);
        System.out.println("addr " + people[lastIdx].streetAddress);
        System.out.println("city " + people[lastIdx].region);
    }
}