

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Solution200620_1 {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
	// binary calculation eg: 10110,100001
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String[] sum = line.split(",");
      String result="";
      int len0 = sum[0].length();
      int len1 = sum[1].length();
      int i=0;
      int s=0;
      while(i<len0 || i<len1) {
    	  if(i<len0 && sum[0].charAt(len0-i-1)=='1') s++;
    	  if(i<len1 && sum[1].charAt(len1-i-1)=='1') s++;
    	  if(s==0) result='0'+result;
    	  if(s==1) {
    		  result='1'+result;
    		  s=0;
    	  }
    	  if(s==2) {
    		  result='0'+result;
    		  s=1;
    	  }
    	  if(s==3) {
    		  result='1'+result;
    		  s=1;
    	  }
    	  i++;
      }
      if(s==1)result='1'+result;
      int start=-1;
      for(int j=0;j<result.length();j++) {
    	  if(result.charAt(j)=='1') {
    		  start=j;
    		  break;
    	  }else {
    		  start++;
    	  }
      }
      System.out.println(result.substring(start));
    	  
    }
  }
}
