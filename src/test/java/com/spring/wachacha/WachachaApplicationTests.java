package com.spring.wachacha;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
class WachachaApplicationTests {

//    public static void main(String[] args) {
//        solution();
//    }
//    public static void solution(){
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int[] price = new int[a];
//        int[] money = new int[a];
//        int temp = 0;
//        int result = 0;
//        int cnt = 0;
//
//        for(int i=0; i<a; i++){ //입력
//            price[i] = sc.nextInt();
//        }
//
//        for(int i=0; i<a-1; i++){
//            if(price[i] <= price[i+1]){ //다음날 물건이 더비쌀때
//                money[i] = price[i]; //구매
//            }
//        }
//        for(int i=0; i<a; i++){ //판매
//            if(money[i] != 0){
//                temp+=money[i];
//                cnt++;
//            }
//            if(money[i] == 0){ //이전의 구매한것들을 i일때 다 판다.
//                result += price[i]*cnt - temp;
//                temp = 0;
//                cnt =0;
//            }
//        }
//
//        if(result < 0){
//            System.out.println(0);
//        }else{
//            System.out.println(result);
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] price = new int[a];
        int temp = 0;
        int result = 0;
        int cnt = 0;
        int maxVal = 0;

        for(int i=0; i<a; i++){ //입력
            price[i] = sc.nextInt();
        }

        maxVal = getMax(price);

        for(int i=0; i<price.length; i++){
            if(price[i] != maxVal){ //max값 전까지 모두 구매
                temp += price[i];
                cnt++;
            }else if(price[i] == maxVal){ //그 후 max값이 있을 경우 다시 찾아야함.
                for(int j=0; j<price.length; j++){
                    if(maxVal == price[j]){ //판매
                        result += maxVal*cnt - temp;
                        break;
                    }
                }
                int[] tempArr = new int[price.length -cnt -1];
                if(tempArr.length <=1) break; //tempArr 크기가 1이하이면 모두 종료
                for(int j=0; j<tempArr.length; j++){
                    tempArr[j] = price[++cnt];
                }
                price = tempArr;
                maxVal = getMax(price);
                i=-1;
                cnt=0;
                temp=0;
                continue;
            }
        }
        System.out.println(result);
    }

    public static int getMax(int[] arr){
        int max = 0;
        for(int i=0; i<arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}