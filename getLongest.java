import java.util.Arrays;

public class getLongest {
    // find out the longest period where work day is not more than 5 during each 7 continuous days.
    // 1 : work day 0 : rest day
    public static void main(String[] args){
        fun1();
        fun2();

    }
    private static void fun1(){
        // test data
        String str = "11111010111101";
        // the continuous work day in each 7 days
        int[] day = new int[str.length()];

        day[0] = Integer.parseInt(str.substring(0,1));
        int max = 1, current = 1;
        for(int i=1;i<str.length();i++){
            day[i] = day[i-1] + Integer.parseInt(str.substring(i,i+1));
            if(i >= 7){
                day[i] -= Integer.parseInt(str.substring(i-7,i-6));;
            }

            // continuous works day increatment
            if(day[i] < 6){
                current ++;
                if(current > max) max = current;
            }else{
                // reset continuous works day
                current = 6;
            }
        }

        System.out.println(max + ", " + current);
        System.out.println(Arrays.toString(day));
    }

    private static void fun2(){
        // test data
        String str = "11111010111101";
        int[] day = new int[str.length()];
        int max=0, current=0, check=0;

        for(int i=0;i<str.length()-6;i++){
            check = 0;
            for(int j=i;j<i+7 && j<str.length();j++) {
                check += Integer.parseInt(str.substring(j, j + 1));
            }
            System.out.print(check+", ");
            if(check>5){
                max = Math.max(max, current);
                current = 0;
            }else{
                if(current == 0){
                    current = 7;
                }else{
                    current++;
                }
                max = Math.max(max, current);
            }
        }
        System.out.println(max);
    }
}
