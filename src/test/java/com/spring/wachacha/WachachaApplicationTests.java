package com.spring.wachacha;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

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

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int[] price = new int[a];
//        int temp = 0;
//        int result = 0;
//        int cnt = 0;
//        int maxVal = 0;
//
//        for(int i=0; i<a; i++){ //입력
//            price[i] = sc.nextInt();
//        }
//
//        maxVal = getMax(price);
//
//        for(int i=0; i<price.length; i++){
//            if(price[i] != maxVal){ //max값 전까지 모두 구매
//                temp += price[i];
//                cnt++;
//            }else if(price[i] == maxVal){ //그 후 max값이 있을 경우 다시 찾아야함.
//                for(int j=0; j<price.length; j++){
//                    if(maxVal == price[j]){ //판매
//                        result += maxVal*cnt - temp;
//                        break;
//                    }
//                }
//                int[] tempArr = new int[price.length -cnt -1];
//                if(tempArr.length <=1) break; //tempArr 크기가 1이하이면 모두 종료
//                for(int j=0; j<tempArr.length; j++){
//                    tempArr[j] = price[++cnt];
//                }
//                price = tempArr;
//                maxVal = getMax(price);
//                i=-1;
//                cnt=0;
//                temp=0;
//                continue;
//            }
//        }
//        System.out.println(result);
//    }
//
//    public static int getMax(int[] arr){
//        int max = 0;
//        for(int i=0; i<arr.length; i++){
//            if(max < arr[i]){
//                max = arr[i];
//            }
//        }
//        return max;
//    }

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int[] switches = new int[sc.nextInt()];
//        for(int i=0; i<switches.length; i++){
//            switches[i] = sc.nextInt();
//        }
//        int[] student = new int[sc.nextInt()*2];
//        for(int i=0; i<student.length; i++){
//            student[i] = sc.nextInt();
//
//        } //여기까지 입력
//
//        //출력
//        for(int i=0; i<student.length; i++){
//            int cnt = student[i+1];
//            if(student[i] == 1){ //남
//                man(switches, cnt);
//            }else{ //여
//                woman(switches, cnt);
//            }
//            i++;
//        }
//        for (int i=0; i<switches.length; i++) {
//            if(i%20 == 0){
//                System.out.println();
//            }
//            System.out.print(switches[i] + " ");
//        }
//    }
//    //남자 스위치변환
//    public static int[] man(int[] switches, int cnt){
//        int cnt2 = cnt;
//        while(cnt2 <= switches.length){
//            changeSwith(switches, cnt2-1);
//            cnt2 += cnt;
//        }
//        return switches;
//    }
//    //여자 스위치변환
//    public static int[] woman(int[] switches, int cnt){
//        cnt-=1;
//        if(cnt == 0 || switches[cnt+1] != switches[cnt-1]){ //대칭 아니라면 바로 리턴
//            return changeSwith(switches, cnt);
//        }
//        //대칭일때
//        changeSwith(switches, cnt);
//        int up = cnt, down = cnt;
//
//        while(down > 0 && up < switches.length-1){
//            if(switches[--down] == switches[++up]){
//                changeSwith(switches, down);
//                changeSwith(switches, up);
//            }
//        }
//        return switches;
//    }
//
//    //스위치 변환
//    public static int[] changeSwith(int[] switches, int cnt){
//        switches[cnt] = switches[cnt] == 0 ? 1 : 0;
//        return switches;
//    }

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        int result = a*b*c;
//        int[] num = new int[10];
//        String[] sArr = Integer.toString(result).split("");
//        String.valueOf(result).split("");
//        for(String s:sArr){
//            switch(s){
//                case "0":
//                    num[0]++;
//                    break;
//                case "1":
//                    num[1]++;
//                    break;
//                case "2":
//                    num[2]++;
//                    break;
//                case "3":
//                    num[3]++;
//                    break;
//                case "4":
//                    num[4]++;
//                    break;
//                case "5":
//                    num[5]++;
//                    break;
//                case "6":
//                    num[6]++;
//                    break;
//                case "7":
//                    num[7]++;
//                    break;
//                case "8":
//                    num[8]++;
//                    break;
//                case "9":
//                    num[9]++;
//                    break;
//            }
//        }
//        int s = 0;
//        s  = Math.max(s,2);
//        for(int i:num){
//            System.out.println(i);
//        }
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        double[] subject = new double[n];
//        int max = 0;
//        double result =0;
//        for(int i=0; i<n; i++){
//            subject[i] = sc.nextInt();
//            if(max < subject[i]){
//                max = (int)subject[i];
//            }
//        }
//        for(int i=0; i<n; i++){
//            subject[i] = subject[i]/max*100;
//            result+=subject[i];
//        }
//        System.out.println(result/n);
//    }
//        public static void main(String[] args){
//            Scanner sc = new Scanner(System.in);
//            String s = sc.next();
//            int[] arr = new int[26];
//            for(int i=0; i<arr.length; i++){
//                arr[i] = -1;
//            }
//
//            for(int i=0; i<s.length(); i++){
//                if(arr[s.charAt(i)-97] == -1){
//                    arr[s.charAt(i)-97] = i;
//                }
//            }
//            for(int i:arr){
//                System.out.print(i+" ");
//            }
//        }
}