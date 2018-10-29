package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {



	public static void main(String[] args){

	}

	static void getPrime(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		int count = list.size();
		int number = 3;

		while (count != 100) {
		    boolean isPrime = true;
		    for (int i = 0; i < list.size(); i++) {
		        if (number % list.get(i) == 0) {
		            isPrime = false;
		        }
		    }
		    if (isPrime) {
		        list.add(number);
		    }
		    number++;
		    count = list.size();
		}
		System.out.println(list);
	}

	/*
	public static void main(String[] args) {
        // Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		String[] source = new String[s];
		for(int i=0;i<s;i++){
			source[i] = in.next();
		}

		int f = in.nextInt();
		String[] find = new String[f];
		for(int i=0;i<f;i++){
			find[i] = in.next();
		}
		instr(source ,find);
		in.close();

    }*/

	static void instr(String[] source, String[] find){
		for(int i=0;i<find.length;i++){
			int cnt = 0;
			for(int j=0;j<source.length;j++){
				if(find[i].equals(source[j])) cnt++;
			}
			System.out.println(cnt);
		}
	}

	static void reverse(){
		Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        int[] ar = new int[Q];

        for(int i=0;i<Q;i++){
        	ar[i] = in.nextInt();
        }
        for(int i=Q-1;i>=0;i--){
        	System.out.print(ar[i]);
        	if(i > 0) System.out.print(" ");
        }
        System.out.println();
	}

//System.out.println(i+" : "+strangeCode(3));
// v1=4-t1 v2=10-t2 v3=22-t3 v4=46-t4
	static long strangeCode(long t) {
        // Complete this function
		long start = 3, k=1;
		while(t > start+k-1){
			k += start;
			start *= 2;
		}

		return start+k-t;
    }

//System.out.println(check("RBY_YBR"));
	static String check(String b){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<b.length();i++){
			String key = b.substring(i,i+1);
			if(map.containsKey(key)){
				map.put(key, map.get(key)+1);
			}else{
				map.put(key, 1);
			}
		}

		if(map.containsKey("_")){
			for(String key : map.keySet()){
				if(!key.equals("_") && map.get(key) == 1) {
					return "NO";
				}
			}
		}else{
			if(b.length() <= 1) return "NO";
			if(b.charAt(0) != b.charAt(1) || b.charAt(b.length()-2) != b.charAt(b.length()-1)) return "NO";
			for(int i=1;i<b.length()-1;i++){
				if(b.charAt(i) != b.charAt(i+1) && b.charAt(i) != b.charAt(i-1)){
					return "NO";
				}
			}
		}

		return "YES";
	}

    static void miniMaxSum(int[] arr) {
        // Complete this function
        Arrays.sort(arr);
        BigInteger min=new BigInteger("0");
        BigInteger max=new BigInteger("0");

        for(int i=0;i<4;i++) min = min.add(new BigInteger(String.valueOf(arr[i])));
        for(int i=1;i<5;i++) max = max.add(new BigInteger(String.valueOf(arr[i])));
        System.out.println(min+" "+max);
        System.out.println(String.format("%02d%s", 1, "sdfsdf"));
    }

	/*
	public static void main(String[] args){
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(numJewelsInStones("z", "ZZ"));
	}*/
	public static int numJewelsInStones(String J, String S) {
		int result = 0;

		char[] s = S.toCharArray();
		for(int i=0;i<s.length;i++){
			for(int j=0;j<J.length();j++){
				if(s[i] == J.charAt(j)){
					result++;
					break;
				}
			}
		}

		return result;
	}


/*
	public static void main(String args[]){
		System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,-1,2,1,-5,4}));
	}*/
	public static int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;

		if(nums == null | nums.length == 0) return 0;

		int sum = 0;
		for( int i=0;i<nums.length;i++){
			if (sum < 0)
	            sum = nums[i];
	        else
	            sum += nums[i];
	        if (sum > max)
	            max = sum;

		}

		return max;
	}

/*
	public static void main(String args[]){
//		System.out.println(coinChange(new int[]{1}, 0));
		System.out.println(coinChange(new int[]{3,5}, 11));
		System.out.println(coinChange(new int[]{1,2,4}, 11));
//		System.out.println(coinChange(new int[]{2}, 3));
//		System.out.println(coinChange(new int[]{3,7}, 26));
		System.out.println(coinChange(new int[]{186,83,408}, 6249));
		System.out.println(coinChange(new int[]{186,419,83,408}, 6249));
	}*/
	public static int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount <= 0)
			return 0;
		int[] minNumber = new int[amount + 1];
		Map<Integer, int[]> map = new HashMap<Integer,int[]>();
		for (int i = 1; i <= amount; i++) {
			minNumber[i] = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {

				if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE){
					minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
					int[] temp = new int[coins.length];
					if(map.get(i-coins[j]) != null) temp = map.get(i-coins[j]).clone();
					temp[j] += 1;
					map.put(i, temp);
				}
//				System.out.print(String.format("%s - ", Arrays.toString(minNumber)));
			}
//			System.out.println(String.format("%2d : %s", i, Arrays.toString(minNumber)));
		}

		System.out.println(Arrays.toString(map.get(amount)));

		if (minNumber[amount] == Integer.MAX_VALUE)
			return -1;
		else
			return minNumber[amount];
	}

	public static int coinChange_x(int[] coins, int amount) {

		if(amount == 0) return 0;

		int[] count = getCount(coins, amount);
		if(count[0] == -1)return -1;

		int result = 0;
		for(int i=0;i<count.length;i++) result += count[i];

		return result;

	}
	private static int[] getCount(int[] coins, int amount) {
		int[] count = new int[coins.length];

		Arrays.sort(coins);
		if(amount == 0) return new int[]{0};

		for (int i=coins.length-1; i>=0; i--) {
			count[i]= amount / coins[i];
			amount = amount % coins[i];
		}
		if(amount == 0) return count;

//		for(int i=1; i<coins.length; i++){
		for(int i=coins.length-1; i>0; i--){
			int[] temp = getNo(coins, count, i, amount);
			if(temp.length > 0){
				System.out.println(amount + " :: " + Arrays.toString(coins) + " : " + Arrays.toString(count));
				return temp;
			}
			System.out.println(amount + " : " + Arrays.toString(coins) + " : " + Arrays.toString(count));
		}

		return new int[]{-1};
	}
	private static int[] getNo(int[] coins, int count[], int i, int amount){

		if(coins.length == 0) return new int[]{};

//		for(int j=i;j<count.length;j++){
		for(int j=i;j>0;j--){
			int rate = 1;
			int temp = count[j];
			while(count[j] != 0){
				count[j]--;
				int[] sub = getCount(Arrays.copyOf(coins, j), amount+coins[j]*rate);
				if(sub[0] > -1) {
					amount = 0;
					for(int t=0;t<sub.length;t++) count[t] += sub[t];
					return count;
				}
				rate++;
			}
			count[j] = temp;
		}

		return new int[]{};
	}




/*
	public static void main(String args[]){
//		System.out.println(letterCombinations("1"));
		System.out.println(letterCombinations("2"));
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations("456"));
	}*/
	public static List<String> letterCombinations2(String digits) {

		if(digits.isEmpty() || digits.indexOf("0") > -1 || digits.indexOf("1") > -1) return new ArrayList<String>();

		Map<String, char[]> m = new HashMap<String, char[]>();

		m.put("2", "abc".toCharArray());
		m.put("3", "def".toCharArray());
		m.put("4", "ghi".toCharArray());
		m.put("5", "jkl".toCharArray());
		m.put("6", "mno".toCharArray());
		m.put("7", "pqrs".toCharArray());
		m.put("8", "tuv".toCharArray());
		m.put("9", "wxyz".toCharArray());

		int num = 1, step=1;
		for(int i=0;i<digits.length();i++) num *= m.get(digits.substring(i,i+1)).length;

		String[] result = new String[num];
		for(int i=0;i<digits.length();i++){
			char[] temp = m.get(digits.substring(i,i+1));
			step *= temp.length;

			for(int j=0;j<num;j++){
				if(result[j] == null) result[j] = new String();
				result[j] = result[j].concat(String.valueOf(temp[(j/(num/step))%temp.length]));
			}
		}

		return Arrays.asList(result);
	}
	public static List<String> letterCombinations(String digits) {
	    LinkedList<String> ans = new LinkedList<String>();
	    if(digits.isEmpty()) return ans;
	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    ans.add("");
	    for(int i =0; i<digits.length();i++){
	        int x = Character.getNumericValue(digits.charAt(i));
	        while(ans.peek().length()==i){
	            String t = ans.remove();
	            for(char s : mapping[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
	    return ans;
	}

	/*
	public static void main(String args[]){
//		System.out.println(threeSumClosest(new int[]{0,0,0}, 1));
//		System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
//		System.out.println(threeSumClosest(new int[]{0,2,1,-3}, 1));
//		System.out.println(threeSumClosest(new int[]{1,1,-1,-1,3}, -1));
		System.out.println(threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
	}*/
	public static int threeSumClosest(int[] nums, int target) {
		int result = 0;

		if(nums.length <= 3) {
			for(int i=0;i<nums.length;i++) result += nums[i];
			return result;
		}
		Arrays.sort(nums);

		int l=0, m=1, r=nums.length-1;
		int sum = nums[l]+nums[m]+nums[r];
		    result = sum;
		while(l < r){
			m = l+1;
			r=nums.length-1;
			while(m<r){
				sum = nums[l]+nums[m]+nums[r];
				if(sum == target){
					return target;
				}else{
					if(Math.abs(sum-target) < Math.abs(result-target)){
						result = sum;
					}
					if(sum < target){
						m++;
					}else{
						r--;
					}
				}
			}
			l++;
		}

		return result;
	}


	/* copy cannt understand means of problem
	public static void main(String args[]){
//		System.out.println(countAndSay(1));
//		System.out.println(countAndSay(2));
//		System.out.println(countAndSay(3));
//		System.out.println(countAndSay(4));
//		System.out.println(countAndSay(5));
		for(int i=1;i<=20;i++) System.out.println(countAndSay(i));
	}*/
	public static String countAndSay(int n) {
		StringBuilder curr=new StringBuilder("1");
    	StringBuilder prev;
    	int count;
    	char say;
        for (int i=1;i<n;i++){
        	prev=curr;
 	        curr=new StringBuilder();
 	        count=1;
 	        say=prev.charAt(0);

 	        for (int j=1,len=prev.length();j<len;j++){
 	        	if (prev.charAt(j)!=say){
 	        		curr.append(count).append(say);
 	        		count=1;
 	        		say=prev.charAt(j);
 	        	}
 	        	else count++;
 	        }
 	        curr.append(count).append(say);
        }
        return curr.toString();
	}

	/*
	public static void main(String args[]){
		System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
		System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
		System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
		System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
		System.out.println(searchInsert(new int[]{1,3,5,6}, 4));
	}*/
	public static int searchInsert(int[] nums, int target) {
//		int low = 0, high = nums.length-1;
//        while(low<=high){
//            int mid = (low+high)/2;
//            if(nums[mid] == target) return mid;
//            else if(nums[mid] > target) high = mid-1;
//            else low = mid+1;
//        }
//        return low;
		return getNo(nums, 0, nums.length-1, target);

	}
	private static int getNo(int[] nums, int start, int end, int target){
		int mid = (end+start) / 2;

		if(start > end) return start;

		if(nums[mid] == target) return mid;
		else if(nums[mid] > target)
			return getNo(nums, start, mid-1, target);
		else
			return getNo(nums, mid+1, end, target);

	}

	/*
	public static void main(String[] args){
		System.out.println(strStr("", ""));
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "aab"));
	}*/
	public static int strStr(String haystack, String needle) {
		int result = -1;

		if(needle.isEmpty()) return 0;

		for(int i=0;i<haystack.length();i++){
			if(i > haystack.length() - needle.length()) return -1;
			int len = 0;
			for(int j=0;j<needle.length();j++){
				if(haystack.charAt(i+j) == needle.charAt(j)){
					len++;
				}
			}
			if(len == needle.length()) return i;
		}

		return result;
	}

	/*
	public static void main(String[] args){
		System.out.println(removeElement(new int[]{3,2,2,3}, 3));
		System.out.println(removeElement(new int[]{3,3,3,3}, 3));
		System.out.println(removeElement(new int[]{2}, 3));
		System.out.println(removeElement(new int[]{3}, 3));
	}*/
	public static int removeElement(int[] nums, int val) {

		int i = 0;
		for(int j=0;j<nums.length;j++){
			if(nums[j] != val){
				nums[i] = nums[j];
				i++;
			}
		}
		System.out.println(Arrays.toString(nums));

		return i;
	}

	/*
	public static void main(String args[]){
//		System.out.println(removeDuplicates(new int[]{1,1,2}));
//		System.out.println(removeDuplicates(new int[]{1,1,1,2}));
//		System.out.println(removeDuplicates(new int[]{1,2,2}));
//		System.out.println(removeDuplicates(new int[]{1,2,3}));
//		System.out.println(removeDuplicates(new int[]{1,1,2,3}));
		System.out.println(removeDuplicates(new int[]{0,0,0,0,0,1,2,2,3,3,4,4}));
	}*/
	public static int removeDuplicates(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	    	if(nums[i] == nums[nums.length-1]) break;
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    System.out.println(Arrays.toString(nums));
	    return i + 1;
	}
	public static int removeDuplicates1(int[] nums) {

		if(nums.length == 0) return 0;

		int result = 1;
		for(int i=0;i<nums.length-1;i++){

			if(nums[i] == nums[nums.length-1]) break;

			for(int j=i+1;j<nums.length-1;j++){
				if(nums[i] >= nums[i+1] && nums[i] < nums[j+1]){
					nums[i+1] = nums[j+1];
					break;
				}

			}
			if(nums[i] != nums[i+1]) result++;
		}


//		int result = 1, offset = 0;
//		for(int i=0;i<nums.length-offset;i++){
//
//			if(nums[i] == nums[nums.length-1]) break;
//			if(nums[i] == nums[i+1]){
//				for(int j=i;j<nums.length-offset-1;j++){
//					nums[j] = nums[j+1];
//				}
//				i--;
//				offset++;
//			}else{
//				result++;
//			}
//		}
		System.out.println(Arrays.toString(nums));
		return result;
	}


	/*
	public static void main (String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);

		n1.next  = new ListNode(2);
		n1.next.next = new ListNode(4);
		n2.next = new ListNode(3);
		n2.next.next = new ListNode(4);

		ListNode result = mergeTwoLists(n1, n2);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}*/
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode result = new ListNode(0);

		if(l1 == null) return l2;
		if(l2 == null) return l1;

		if(l1.val <= l2.val){
			result.val = l1.val;
			result.next = mergeTwoLists(l1.next, l2);
		}else{
			result.val = l2.val;
			result.next = mergeTwoLists(l1, l2.next);
		}

		return result;

	}

	/*
	public static void main(String args[]){
//		System.out.println(isValid("(("));
//		System.out.println(isValid("(([]){})"));
//		System.out.println(isValid("){"));
//		System.out.println(isValid("()[]{}"));
//		System.out.println(isValid("(]"));
//		System.out.println(isValid("([)]"));
//		System.out.println(isValid("([])"));
//		System.out.println(isValid("([]){}"));
		System.out.println(isValid("(()])}[}[}[]][}}[}{})][[(]({])])}}(])){)((){"));
	}*/
	public static boolean isValid(String s) {

		if(s.length() % 2 == 1) return false;

		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("(", 0);
		m.put(")", 1);
		m.put("[", 2);
		m.put("]", 3);
		m.put("{", 4);
		m.put("}", 5);

		char[] left = new char[s.length()];
		int sl=0, sr=0;

		for(int i=0;i<s.length();i++){
			int r = m.get(s.substring(i,i+1));
			if(r % 2 == 1){
				if(sr >= sl) return false;
				if(r - m.get(String.valueOf(left[sl-1])) == 1){
					sl--;
					sr--;
				}else{
					return false;
				}

			}else{
				left[sl++] = s.charAt(i);
			}
		}

		return sl==0;
	}
	public static boolean isValid1(String s) {

		if (s.length() % 2 == 1)
			return false;

		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("(", 0);
		m.put(")", 1);
		m.put("[", 2);
		m.put("]", 3);
		m.put("{", 4);
		m.put("}", 5);

		int step = 0;
		while (s.length() > step) {

			int r = m.get(s.substring(step, step + 1));
			if (r % 2 == 1) {

				if (step == 0)
					return false;

				int l = m.get(s.substring(step - 1, step));
				if (r - l == 1) {
					s = s.substring(0, step - 1) + s.substring(step + 1);
					step -= 2;
				}
			}
			step++;
		}

		return step == 0;
	}

	/*
	public static void main(String args[]){
//		System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//		System.out.println(threeSum(new int[]{82597,-9243,62390,83030,-97960,-26521,-61011,83390,-38677,12333,75987,46091,83794,19355,-71037,-6242,-28801,324,1202,-90885,-2989,-95597,-34333,35528,5680,89093,-90606,50360,-29393,-27012,53313,65213,99818,-82405,-41661,-3333,-51952,72135,-1523,26377,74685,96992,92263,15929,5467,-99555,-43348,-41689,-60383,-3990,32165,65265,-72973,-58372,12741,-48568,-46596,72419,-1859,34153,62937,81310,-61823,-96770,-54944,8845,-91184,24208,-29078,31495,65258,14198,85395,70506,-40908,56740,-12228,-40072,32429,93001,68445,-73927,25731,-91859,-24150,10093,-60271,-81683,-18126,51055,48189,-6468,25057,81194,-58628,74042,66158,-14452,-49851,-43667,11092,39189,-17025,-79173,13606,83172,92647,-59741,19343,-26644,-57607,82908,-20655,1637,80060,98994,39331,-31274,-61523,91225,-72953,13211,-75116,-98421,-41571,-69074,99587,39345,42151,-2460,98236,15690,-52507,-95803,-48935,-46492,-45606,-79254,-99851,52533,73486,39948,-7240,71815,-585,-96252,90990,-93815,93340,-71848,58733,-14859,-83082,-75794,-82082,-24871,-15206,91207,-56469,-93618,67131,-8682,75719,87429,-98757,-7535,-24890,-94160,85003,33928,75538,97456,-66424,-60074,-8527,-28697,-22308,2246,-70134,-82319,-10184,87081,-34949,-28645,-47352,-83966,-60418,-15293,-53067,-25921,55172,75064,95859,48049,34311,-86931,-38586,33686,-36714,96922,76713,-22165,-80585,-34503,-44516,39217,-28457,47227,-94036,43457,24626,-87359,26898,-70819,30528,-32397,-69486,84912,-1187,-98986,-32958,4280,-79129,-65604,9344,58964,50584,71128,-55480,24986,15086,-62360,-42977,-49482,-77256,-36895,-74818,20,3063,-49426,28152,-97329,6086,86035,-88743,35241,44249,19927,-10660,89404,24179,-26621,-6511,57745,-28750,96340,-97160,-97822,-49979,52307,79462,94273,-24808,77104,9255,-83057,77655,21361,55956,-9096,48599,-40490,-55107,2689,29608,20497,66834,-34678,23553,-81400,-66630,-96321,-34499,-12957,-20564,25610,-4322,-58462,20801,53700,71527,24669,-54534,57879,-3221,33636,3900,97832,-27688,-98715,5992,24520,-55401,-57613,-69926,57377,-77610,20123,52174,860,60429,-91994,-62403,-6218,-90610,-37263,-15052,62069,-96465,44254,89892,-3406,19121,-41842,-87783,-64125,-56120,73904,-22797,-58118,-4866,5356,75318,46119,21276,-19246,-9241,-97425,57333,-15802,93149,25689,-5532,95716,39209,-87672,-29470,-16324,-15331,27632,-39454,56530,-16000,29853,46475,78242,-46602,83192,-73440,-15816,50964,-36601,89758,38375,-40007,-36675,-94030,67576,46811,-64919,45595,76530,40398,35845,41791,67697,-30439,-82944,63115,33447,-36046,-50122,-34789,43003,-78947,-38763,-89210,32756,-20389,-31358,-90526,-81607,88741,86643,98422,47389,-75189,13091,95993,-15501,94260,-25584,-1483,-67261,-70753,25160,89614,-90620,-48542,83889,-12388,-9642,-37043,-67663,28794,-8801,13621,12241,55379,84290,21692,-95906,-85617,-17341,-63767,80183,-4942,-51478,30997,-13658,8838,17452,-82869,-39897,68449,31964,98158,-49489,62283,-62209,-92792,-59342,55146,-38533,20496,62667,62593,36095,-12470,5453,-50451,74716,-17902,3302,-16760,-71642,-34819,96459,-72860,21638,47342,-69897,-40180,44466,76496,84659,13848,-91600,-90887,-63742,-2156,-84981,-99280,94326,-33854,92029,-50811,98711,-36459,-75555,79110,-88164,-97397,-84217,97457,64387,30513,-53190,-83215,252,2344,-27177,-92945,-89010,82662,-11670,86069,53417,42702,97082,3695,-14530,-46334,17910,77999,28009,-12374,15498,-46941,97088,-35030,95040,92095,-59469,-24761,46491,67357,-66658,37446,-65130,-50416,99197,30925,27308,54122,-44719,12582,-99525,-38446,-69050,-22352,94757,-56062,33684,-40199,-46399,96842,-50881,-22380,-65021,40582,53623,-76034,77018,-97074,-84838,-22953,-74205,79715,-33920,-35794,-91369,73421,-82492,63680,-14915,-33295,37145,76852,-69442,60125,-74166,74308,-1900,-30195,-16267,-60781,-27760,5852,38917,25742,-3765,49097,-63541,98612,-92865,-30248,9612,-8798,53262,95781,-42278,-36529,7252,-27394,-5021,59178,80934,-48480,-75131,-54439,-19145,-48140,98457,-6601,-51616,-89730,78028,32083,-48904,16822,-81153,-8832,48720,-80728,-45133,-86647,-4259,-40453,2590,28613,50523,-4105,-27790,-74579,-17223,63721,33489,-47921,97628,-97691,-14782,-65644,18008,-93651,-71266,80990,-76732,-47104,35368,28632,59818,-86269,-89753,34557,-92230,-5933,-3487,-73557,-13174,-43981,-43630,-55171,30254,-83710,-99583,-13500,71787,5017,-25117,-78586,86941,-3251,-23867,-36315,75973,86272,-45575,77462,-98836,-10859,70168,-32971,-38739,-12761,93410,14014,-30706,-77356,-85965,-62316,63918,-59914,-64088,1591,-10957,38004,15129,-83602,-51791,34381,-89382,-26056,8942,5465,71458,-73805,-87445,-19921,-80784,69150,-34168,28301,-68955,18041,6059,82342,9947,39795,44047,-57313,48569,81936,-2863,-80932,32976,-86454,-84207,33033,32867,9104,-16580,-25727,80157,-70169,53741,86522,84651,68480,84018,61932,7332,-61322,-69663,76370,41206,12326,-34689,17016,82975,-23386,39417,72793,44774,-96259,3213,79952,29265,-61492,-49337,14162,65886,3342,-41622,-62659,-90402,-24751,88511,54739,-21383,-40161,-96610,-24944,-602,-76842,-21856,69964,43994,-15121,-85530,12718,13170,-13547,69222,62417,-75305,-81446,-38786,-52075,-23110,97681,-82800,-53178,11474,35857,94197,-58148,-23689,32506,92154,-64536,-73930,-77138,97446,-83459,70963,22452,68472,-3728,-25059,-49405,95129,-6167,12808,99918,30113,-12641,-26665,86362,-33505,50661,26714,33701,89012,-91540,40517,-12716,-57185,-87230,29914,-59560,13200,-72723,58272,23913,-45586,-96593,-26265,-2141,31087,81399,92511,-34049,20577,2803,26003,8940,42117,40887,-82715,38269,40969,-50022,72088,21291,-67280,-16523,90535,18669,94342,-39568,-88080,-99486,-20716,23108,-28037,63342,36863,-29420,-44016,75135,73415,16059,-4899,86893,43136,-7041,33483,-67612,25327,40830,6184,61805,4247,81119,-22854,-26104,-63466,63093,-63685,60369,51023,51644,-16350,74438,-83514,99083,10079,-58451,-79621,48471,67131,-86940,99093,11855,-22272,-67683,-44371,9541,18123,37766,-70922,80385,-57513,-76021,-47890,36154,72935,84387,-92681,-88303,-7810,59902,-90,-64704,-28396,-66403,8860,13343,33882,85680,7228,28160,-14003,54369,-58893,92606,-63492,-10101,64714,58486,29948,-44679,-22763,10151,-56695,4031,-18242,-36232,86168,-14263,9883,47124,47271,92761,-24958,-73263,-79661,-69147,-18874,29546,-92588,-85771,26451,-86650,-43306,-59094,-47492,-34821,-91763,-47670,33537,22843,67417,-759,92159,63075,94065,-26988,55276,65903,30414,-67129,-99508,-83092,-91493,-50426,14349,-83216,-76090,32742,-5306,-93310,-60750,-60620,-45484,-21108,-58341,-28048,-52803,69735,78906,81649,32565,-86804,-83202,-65688,-1760,89707,93322,-72750,84134,71900,-37720,19450,-78018,22001,-23604,26276,-21498,65892,-72117,-89834,-23867,55817,-77963,42518,93123,-83916,63260,-2243,-97108,85442,-36775,17984,-58810,99664,-19082,93075,-69329,87061,79713,16296,70996,13483,-74582,49900,-27669,-40562,1209,-20572,34660,83193,75579,7344,64925,88361,60969,3114,44611,-27445,53049,-16085,-92851,-53306,13859,-33532,86622,-75666,-18159,-98256,51875,-42251,-27977,-18080,23772,38160,41779,9147,94175,99905,-85755,62535,-88412,-52038,-68171,93255,-44684,-11242,-104,31796,62346,-54931,-55790,-70032,46221,56541,-91947,90592,93503,4071,20646,4856,-63598,15396,-50708,32138,-85164,38528,-89959,53852,57915,-42421,-88916,-75072,67030,-29066,49542,-71591,61708,-53985,-43051,28483,46991,-83216,80991,-46254,-48716,39356,-8270,-47763,-34410,874,-1186,-7049,28846,11276,21960,-13304,-11433,-4913,55754,79616,70423,-27523,64803,49277,14906,-97401,-92390,91075,70736,21971,-3303,55333,-93996,76538,54603,-75899,98801,46887,35041,48302,-52318,55439,24574,14079,-24889,83440,14961,34312,-89260,-22293,-81271,-2586,-71059,-10640,-93095,-5453,-70041,66543,74012,-11662,-52477,-37597,-70919,92971,-17452,-67306,-80418,7225,-89296,24296,86547,37154,-10696,74436,-63959,58860,33590,-88925,-97814,-83664,85484,-8385,-50879,57729,-74728,-87852,-15524,-91120,22062,28134,80917,32026,49707,-54252,-44319,-35139,13777,44660,85274,25043,58781,-89035,-76274,6364,-63625,72855,43242,-35033,12820,-27460,77372,-47578,-61162,-70758,-1343,-4159,64935,56024,-2151,43770,19758,-30186,-86040,24666,-62332,-67542,73180,-25821,-27826,-45504,-36858,-12041,20017,-24066,-56625,-52097,-47239,-90694,8959,7712,-14258,-5860,55349,61808,-4423,-93703,64681,-98641,-25222,46999,-83831,-54714,19997,-68477,66073,51801,-66491,52061,-52866,79907,-39736,-68331,68937,91464,98892,910,93501,31295,-85873,27036,-57340,50412,21,-2445,29471,71317,82093,-94823,-54458,-97410,39560,-7628,66452,39701,54029,37906,46773,58296,60370,-61090,85501,-86874,71443,-72702,-72047,14848,34102,77975,-66294,-36576,31349,52493,-70833,-80287,94435,39745,-98291,84524,-18942,10236,93448,50846,94023,-6939,47999,14740,30165,81048,84935,-19177,-13594,32289,62628,-90612,-542,-66627,64255,71199,-83841,-82943,-73885,8623,-67214,-9474,-35249,62254,-14087,-90969,21515,-83303,94377,-91619,19956,-98810,96727,-91939,29119,-85473,-82153,-69008,44850,74299,-76459,-86464,8315,-49912,-28665,59052,-69708,76024,-92738,50098,18683,-91438,18096,-19335,35659,91826,15779,-73070,67873,-12458,-71440,-46721,54856,97212,-81875,35805,36952,68498,81627,-34231,81712,27100,-9741,-82612,18766,-36392,2759,41728,69743,26825,48355,-17790,17165,56558,3295,-24375,55669,-16109,24079,73414,48990,-11931,-78214,90745,19878,35673,-15317,-89086,94675,-92513,88410,-93248,-19475,-74041,-19165,32329,-26266,-46828,-18747,45328,8990,-78219,-25874,-74801,-44956,-54577,-29756,-99822,-35731,-18348,-68915,-83518,-53451,95471,-2954,-13706,-8763,-21642,-37210,16814,-60070,-42743,27697,-36333,-42362,11576,85742,-82536,68767,-56103,-63012,71396,-78464,-68101,-15917,-11113,-3596,77626,-60191,-30585,-73584,6214,-84303,18403,23618,-15619,-89755,-59515,-59103,-74308,-63725,-29364,-52376,-96130,70894,-12609,50845,-2314,42264,-70825,64481,55752,4460,-68603,-88701,4713,-50441,-51333,-77907,97412,-66616,-49430,60489,-85262,-97621,-18980,44727,-69321,-57730,66287,-92566,-64427,-14270,11515,-92612,-87645,61557,24197,-81923,-39831,-10301,-23640,-76219,-68025,92761,-76493,68554,-77734,-95620,-11753,-51700,98234,-68544,-61838,29467,46603,-18221,-35441,74537,40327,-58293,75755,-57301,-7532,-94163,18179,-14388,-22258,-46417,-48285,18242,-77551,82620,250,-20060,-79568,-77259,82052,-98897,-75464,48773,-79040,-11293,45941,-67876,-69204,-46477,-46107,792,60546,-34573,-12879,-94562,20356,-48004,-62429,96242,40594,2099,99494,25724,-39394,-2388,-18563,-56510,-83570,-29214,3015,74454,74197,76678,-46597,60630,-76093,37578,-82045,-24077,62082,-87787,-74936,58687,12200,-98952,70155,-77370,21710,-84625,-60556,-84128,925,65474,-15741,-94619,88377,89334,44749,22002,-45750,-93081,-14600,-83447,46691,85040,-66447,-80085,56308,44310,24979,-29694,57991,4675,-71273,-44508,13615,-54710,23552,-78253,-34637,50497,68706,81543,-88408,-21405,6001,-33834,-21570,-46692,-25344,20310,71258,-97680,11721,59977,59247,-48949,98955,-50276,-80844,-27935,-76102,55858,-33492,40680,66691,-33188,8284,64893,-7528,6019,-85523,8434,-64366,-56663,26862,30008,-7611,-12179,-70076,21426,-11261,-36864,-61937,-59677,929,-21052,3848,-20888,-16065,98995,-32293,-86121,-54564,77831,68602,74977,31658,40699,29755,98424,80358,-69337,26339,13213,-46016,-18331,64713,-46883,-58451,-70024,-92393,-4088,70628,-51185,71164,-75791,-1636,-29102,-16929,-87650,-84589,-24229,-42137,-15653,94825,13042,88499,-47100,-90358,-7180,29754,-65727,-42659,-85560,-9037,-52459,20997,-47425,17318,21122,20472,-23037,65216,-63625,-7877,-91907,24100,-72516,22903,-85247,-8938,73878,54953,87480,-31466,-99524,35369,-78376,89984,-15982,94045,-7269,23319,-80456,-37653,-76756,2909,81936,54958,-12393,60560,-84664,-82413,66941,-26573,-97532,64460,18593,-85789,-38820,-92575,-43663,-89435,83272,-50585,13616,-71541,-53156,727,-27644,16538,34049,57745,34348,35009,16634,-18791,23271,-63844,95817,21781,16590,59669,15966,-6864,48050,-36143,97427,-59390,96931,78939,-1958,50777,43338,-51149,39235,-27054,-43492,67457,-83616,37179,10390,85818,2391,73635,87579,-49127,-81264,-79023,-81590,53554,-74972,-83940,-13726,-39095,29174,78072,76104,47778,25797,-29515,-6493,-92793,22481,-36197,-65560,42342,15750,97556,99634,-56048,-35688,13501,63969,-74291,50911,39225,93702,-3490,-59461,-30105,-46761,-80113,92906,-68487,50742,36152,-90240,-83631,24597,-50566,-15477,18470,77038,40223,-80364,-98676,70957,-63647,99537,13041,31679,86631,37633,-16866,13686,-71565,21652,-46053,-80578,-61382,68487,-6417,4656,20811,67013,-30868,-11219,46,74944,14627,56965,42275,-52480,52162,-84883,-52579,-90331,92792,42184,-73422,-58440,65308,-25069,5475,-57996,59557,-17561,2826,-56939,14996,-94855,-53707,99159,43645,-67719,-1331,21412,41704,31612,32622,1919,-69333,-69828,22422,-78842,57896,-17363,27979,-76897,35008,46482,-75289,65799,20057,7170,41326,-76069,90840,-81253,-50749,3649,-42315,45238,-33924,62101,96906,58884,-7617,-28689,-66578,62458,50876,-57553,6739,41014,-64040,-34916,37940,13048,-97478,-11318,-89440,-31933,-40357,-59737,-76718,-14104,-31774,28001,4103,41702,-25120,-31654,63085,-3642,84870,-83896,-76422,-61520,12900,88678,85547,33132,-88627,52820,63915,-27472,78867,-51439,33005,-23447,-3271,-39308,39726,-74260,-31874,-36893,93656,910,-98362,60450,-88048,99308,13947,83996,-90415,-35117,70858,-55332,-31721,97528,82982,-86218,6822,25227,36946,97077,-4257,-41526,56795,89870,75860,-70802,21779,14184,-16511,-89156,-31422,71470,69600,-78498,74079,-19410,40311,28501,26397,-67574,-32518,68510,38615,19355,-6088,-97159,-29255,-92523,3023,-42536,-88681,64255,41206,44119,52208,39522,-52108,91276,-70514,83436,63289,-79741,9623,99559,12642,85950,83735,-21156,-67208,98088,-7341,-27763,-30048,-44099,-14866,-45504,-91704,19369,13700,10481,-49344,-85686,33994,19672,36028,60842,66564,-24919,33950,-93616,-47430,-35391,-28279,56806,74690,39284,-96683,-7642,-75232,37657,-14531,-86870,-9274,-26173,98640,88652,64257,46457,37814,-19370,9337,-22556,-41525,39105,-28719,51611,-93252,98044,-90996,21710,-47605,-64259,-32727,53611,-31918,-3555,33316,-66472,21274,-37731,-2919,15016,48779,-88868,1897,41728,46344,-89667,37848,68092,-44011,85354,-43776,38739,-31423,-66330,65167,-22016,59405,34328,-60042,87660,-67698,-59174,-1408,-46809,-43485,-88807,-60489,13974,22319,55836,-62995,-37375,-4185,32687,-36551,-75237,58280,26942,-73756,71756,78775,-40573,14367,-71622,-77338,24112,23414,-7679,-51721,87492,85066,-21612,57045,10673,-96836,52461,-62218,-9310,65862,-22748,89906,-96987,-98698,26956,-43428,46141,47456,28095,55952,67323,-36455,-60202,-43302,-82932,42020,77036,10142,60406,70331,63836,58850,-66752,52109,21395,-10238,-98647,-41962,27778,69060,98535,-28680,-52263,-56679,66103,-42426,27203,80021,10153,58678,36398,63112,34911,20515,62082,-15659,-40785,27054,43767,-20289,65838,-6954,-60228,-72226,52236,-35464,25209,-15462,-79617,-41668,-84083,62404,-69062,18913,46545,20757,13805,24717,-18461,-47009,-25779,68834,64824,34473,39576,31570,14861,-15114,-41233,95509,68232,67846,84902,-83060,17642,-18422,73688,77671,-26930,64484,-99637,73875,6428,21034,-73471,19664,-68031,15922,-27028,48137,54955,-82793,-41144,-10218,-24921,-28299,-2288,68518,-54452,15686,-41814,66165,-72207,-61986,80020,50544,-99500,16244,78998,40989,14525,-56061,-24692,-94790,21111,37296,-90794,72100,70550,-31757,17708,-74290,61910,78039,-78629,-25033,73172,-91953,10052,64502,99585,-1741,90324,-73723,68942,28149,30218,24422,16659,10710,-62594,94249,96588,46192,34251,73500,-65995,-81168,41412,-98724,-63710,-54696,-52407,19746,45869,27821,-94866,-76705,-13417,-61995,-71560,43450,67384,-8838,-80293,-28937,23330,-89694,-40586,46918,80429,-5475,78013,25309,-34162,37236,-77577,86744,26281,-29033,-91813,35347,13033,-13631,-24459,3325,-71078,-75359,81311,19700,47678,-74680,-84113,45192,35502,37675,19553,76522,-51098,-18211,89717,4508,-82946,27749,85995,89912,-53678,-64727,-14778,32075,-63412,-40524,86440,-2707,-36821,63850,-30883,67294,-99468,-23708,34932,34386,98899,29239,-23385,5897,54882,98660,49098,70275,17718,88533,52161,63340,50061,-89457,19491,-99156,24873,-17008,64610,-55543,50495,17056,-10400,-56678,-29073,-42960,-76418,98562,-88104,-96255,10159,-90724,54011,12052,45871,-90933,-69420,67039,37202,78051,-52197,-40278,-58425,65414,-23394,-1415,6912,-53447,7352,17307,-78147,63727,98905,55412,-57658,-32884,-44878,22755,39730,3638,35111,39777,74193,38736,-11829,-61188,-92757,55946,-71232,-63032,-83947,39147,-96684,-99233,25131,-32197,24406,-55428,-61941,25874,-69453,64483,-19644,-68441,12783,87338,-48676,66451,-447,-61590,50932,-11270,29035,65698,-63544,10029,80499,-9461,86368,91365,-81810,-71914,-52056,-13782,44240,-30093,-2437,24007,67581,-17365,-69164,-8420,-69289,-29370,48010,90439,13141,69243,50668,39328,61731,78266,-81313,17921,-38196,55261,9948,-24970,75712,-72106,28696,7461,31621,61047,51476,56512,11839,-96916,-82739,28924,-99927,58449,37280,69357,11219,-32119,-62050,-48745,-83486,-52376,42668,82659,68882,38773,46269,-96005,97630,25009,-2951,-67811,99801,81587,-79793,-18547,-83086,69512,33127,-92145,-88497,47703,59527,1909,88785,-88882,69188,-46131,-5589,-15086,36255,-53238,-33009,82664,53901,35939,-42946,-25571,33298,69291,53199,74746,-40127,-39050,91033,51717,-98048,87240,36172,65453,-94425,-63694,-30027,59004,88660,3649,-20267,-52565,-67321,34037,4320,91515,-56753,60115,27134,68617,-61395,-26503,-98929,-8849,-63318,10709,-16151,61905,-95785,5262,23670,-25277,90206,-19391,45735,37208,-31992,-92450,18516,-90452,-58870,-58602,93383,14333,17994,82411,-54126,-32576,35440,-60526,-78764,-25069,-9022,-394,92186,-38057,55328,-61569,67780,77169,19546,-92664,-94948,44484,-13439,83529,27518,-48333,72998,38342,-90553,-98578,-76906,81515,-16464,78439,92529,35225,-39968,-10130,-7845,-32245,-74955,-74996,67731,-13897,-82493,33407,93619,59560,-24404,-57553,19486,-45341,34098,-24978,-33612,79058,71847,76713,-95422,6421,-96075,-59130,-28976,-16922,-62203,69970,68331,21874,40551,89650,51908,58181,66480,-68177,34323,-3046,-49656,-59758,43564,-10960,-30796,15473,-20216,46085,-85355,41515,-30669,-87498,57711,56067,63199,-83805,62042,91213,-14606,4394,-562,74913,10406,96810,-61595,32564,31640,-9732,42058,98052,-7908,-72330,1558,-80301,34878,32900,3939,-8824,88316,20937,21566,-3218,-66080,-31620,86859,54289,90476,-42889,-15016,-18838,75456,30159,-67101,42328,-92703,85850,-5475,23470,-80806,68206,17764,88235,46421,-41578,74005,-81142,80545,20868,-1560,64017,83784,68863,-97516,-13016,-72223,79630,-55692,82255,88467,28007,-34686,-69049,-41677,88535,-8217,68060,-51280,28971,49088,49235,26905,-81117,-44888,40623,74337,-24662,97476,79542,-72082,-35093,98175,-61761,-68169,59697,-62542,-72965,59883,-64026,-37656,-92392,-12113,-73495,98258,68379,-21545,64607,-70957,-92254,-97460,-63436,-8853,-19357,-51965,-76582,12687,-49712,45413,-60043,33496,31539,-57347,41837,67280,-68813,52088,-13155,-86430,-15239,-45030,96041,18749,-23992,46048,35243,-79450,85425,-58524,88781,-39454,53073,-48864,-82289,39086,82540,-11555,25014,-5431,-39585,-89526,2705,31953,-81611,36985,-56022,68684,-27101,11422,64655,-26965,-63081,-13840,-91003,-78147,-8966,41488,1988,99021,-61575,-47060,65260,-23844,-21781,-91865,-19607,44808,2890,63692,-88663,-58272,15970,-65195,-45416,-48444,-78226,-65332,-24568,42833,-1806,-71595,80002,-52250,30952,48452,-90106,31015,-22073,62339,63318,78391,28699,77900,-4026,-76870,-45943,33665,9174,-84360,-22684,-16832,-67949,-38077,-38987,-32847,51443,-53580,-13505,9344,-92337,26585,70458,-52764,-67471,-68411,-1119,-2072,-93476,67981,40887,-89304,-12235,41488,1454,5355,-34855,-72080,24514,-58305,3340,34331,8731,77451,-64983,-57876,82874,62481,-32754,-39902,22451,-79095,-23904,78409,-7418,77916}));
//		System.out.println(threeSum(new int[]{0, 0, 0}));
		System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));

	}*/
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(nums.length < 3) return result;
		Arrays.sort(nums);

		int l=0, m=1, r=nums.length-1;
		while(l < r){
			m = l+1;
			r=nums.length-1;
			while(m<r){
				if(nums[l]+nums[m]+nums[r] == 0){
					result.add(Arrays.asList(nums[l], nums[m], nums[r]));
					while(m<r && nums[m] == nums[m+1]) m++;
					while(m<r && nums[r] == nums[r-1]) r--;
					m++;
					r--;
				}else if(nums[l]+nums[m]+nums[r] > 0){
					while(m<r && nums[r] == nums[r-1]) r--;
					r--;
				}else{
					while(m<r && nums[m] == nums[m+1]) m++;
					m++;
				}
			}
			while(l<r && nums[l] == nums[l+1]) l++;
			l++;
		}
//		for(int i=0;i<nums.length;i++){
//			int l = i, r = nums.length -1;
//			while(l < r){
//				if()
//			}
//		}


//		for(int i=0;i<nums.length;i++){
//			for(int j=i+1;j<nums.length;j++){
//				for(int k=j+1;k<nums.length;k++){
//					if(nums[i] + nums[j] + nums[k] == 0){
//						int min = Math.min(Math.min(nums[i], nums[j]), nums[k]);
//						int max = Math.max(Math.max(nums[i], nums[j]), nums[k]);
//						result.add(Arrays.asList(min,-min-max,max));
//					}
//				}
//			}
//		}

//		for (int i = 0; i < nums.length - 2; i++) {
//			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
//				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
//				while (lo < hi) {
//					if (nums[lo] + nums[hi] == sum) {
//						result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
//						while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
//						while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
//						lo++;
//						hi--;
//					} else if (nums[lo] + nums[hi] < sum)
//						lo++;
//					else
//						hi--;
//				}
//			}
//		}

		return result;
	}

	/*
	public static void main (String args[]){
		System.out.println(longestCommonPrefix(new String[]{"aa", "a"}));
		System.out.println(longestCommonPrefix(new String[]{}));
		System.out.println(longestCommonPrefix(new String[]{}));
		System.out.println(longestCommonPrefix(new String[]{}));
		System.out.println(longestCommonPrefix(new String[]{}));
	}*/
	public static String longestCommonPrefix(String[] strs) {
		StringBuilder result = new StringBuilder();
		char c;
		if(strs == null || strs.length == 0 || strs[0].length() == 0) return "";

		for(int l=0;l<strs[0].length();l++){
			c = strs[0].charAt(l);
			for(int i=1;i<strs.length;i++){
				if(strs[i].length() < l+1) return result.toString();
				if(c != strs[i].charAt(l)) return result.toString();
			}
			result.append(c);
		}

		return result.toString();
	}

	/*
	public static void main(String args[]){
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("MDCCLXXVI"));
		System.out.println(romanToInt("MCMLIV"));
		System.out.println(romanToInt("MCMXC"));
		System.out.println(romanToInt("MMXIV"));

	}*/
	public static int romanToInt(String s) {
		int result = 0;

		HashMap<String, Integer> m = new HashMap<String, Integer>();
		m.put("M", 1000);
		m.put("D", 500);
		m.put("C", 100);
		m.put("L", 50);
		m.put("X", 10);
		m.put("V", 5);
		m.put("I", 1);

		int flg = -1;
		for(int i=0;i<s.length()-1;i++){
			flg = m.get(s.substring(i,i+1))<m.get(s.substring(i+1,i+2)) ? -1 : 1;
			result += m.get(s.substring(i,i+1)) * flg;
		}
		result += m.get(s.substring(s.length()-1));

		return result;
	}
	public static int romanToInt1(String s) {
		int result = 0;

		String[] roman = {"M" , "CM", "D" , "CD", "C", "XC", "L","XL", "X", "IX", "V", "IV", "I"};
		int[] values   = {1000,  900,  500,  400, 100,  90 ,  50, 40 , 10 ,  9  ,  5 ,  4  ,  1 };

		int index = 0;
		while(s.length() > 0){

			while(s.startsWith(roman[index])){
				s = s.substring(roman[index].length());
				result += values[index];
			}

			index++;
		}

		return result;
	}

	/*
	public static void main(String[] args){
		System.out.println(intToRoman(4));
		System.out.println(intToRoman(9));
		System.out.println(intToRoman(1776));
		System.out.println(intToRoman(1954));
		System.out.println(intToRoman(1990));
		System.out.println(intToRoman(2014));
	}*/
	public static String intToRoman(int num) {
		StringBuilder result = new StringBuilder("");

		String[] roman = {"M" , "CM", "D" , "CD", "C", "XC", "L","XL", "X", "IX", "V", "IV", "I"};
		int[] values   = {1000,  900,  500,  400, 100,  90 ,  50, 40 , 10 ,  9  ,  5 ,  4  ,  1 };

		int step = 0;
		while(num > 0){
			while(num >= values[step]){
				result.append(roman[step]);
				num -= values[step];
			}
			step++;
		}

		return result.toString();

	}
	public static String intToRoman1(int num) {
		StringBuilder result = new StringBuilder("");
		StringBuilder sub = new StringBuilder("");
		String[] s = new String[]{"I","V","X","L","C","D","M"};
		int step = 1, temp = 0;

		while(num>0){
			temp = num % 10;
			if(temp > 0){
				 if(temp == 9){
					sub.append(s[2*(step-1)]);
					sub.append(s[2*step]);
					temp = 0;
				}else if(temp >= 5){
					sub.append(s[2*(step-1)+1]);
					temp -= 5;
				}else if(temp == 4){
					sub.append(s[2*(step-1)]);
					sub.append(s[2*(step-1)+1]);
					temp = 0;
				}
				for(int i=0;i<temp;i++){
					sub.append(s[2*(step-1)]);
				}
				result.insert(0, sub);
				sub = new StringBuilder();
			}

			num = num / 10;
			step++;
		}

		return result.toString();

	}


	/*
	public static void main(String[] args){
		System.out.println(maxArea(new int[]{0,2}));
		System.out.println(maxArea(new int[]{1,2,4,3}));
		System.out.println(maxArea(new int[]{2,3}));
		System.out.println(maxArea(new int[]{5,8,2}));
		System.out.println(maxArea(new int[]{1,9,6,4}));
		System.out.println(maxArea(new int[]{3,6,4,8,9}));
		int[] test = new int[15000];
		for(int i=0;i<15000;i++)test[i] = i+1;
		System.out.println(maxArea(test));
	}*/
	public static int maxArea(int[] height) {
		int result = 0;
		int s = 0, t = height.length-1;

		while(s<t){
			result = Math.max(result, (t-s) * Math.min(height[s],height[t]));
			if(height[s] < height[t]){
				s++;
			}else{
				t--;
			}
		}

//		for(int i=0;i<height.length;i++){
//			for(int j=i+1;j<height.length;j++){
//				result = Math.max(result, (j-i) * Math.min(height[i],height[j]));
//			}
//		}

		return result;
	}

	/*
	public static void main(String[] args){
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(12321));
		System.out.println(isPalindrome(123321));
	}*/
	public static boolean isPalindrome(int x) {

		if(x >= Integer.MAX_VALUE) return false;
		if(x <= 0) return false;
		int temp = 0;
		int param = x;

		while(param >= 10){
			temp = temp*10 + param%10;

			param = param / 10;
		}
		temp = temp*10 + param;

		return temp == x;
	}

	public static void main1(String[] args){
		System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2  }));
		System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
		System.out.println(findMedianSortedArrays(new int[]{4,5,6,8,9}, new int[]{}));
		System.out.println(findMedianSortedArrays(
				new int[]{131,135,195,241,274,288,330,334,342,358,361,391,392,430,470,497,578,627,659,660,756,798,807,819,835,863,869,875,884,912,913,923,928,971,1018,1021,1100,1129,1182,1244,1357,1389,1418,1433,1454,1471,1472,1512,1593,1602,1636,1665,1737,1747,1754,1823,1832,1839,1895,1917,1921,1952,1992,1998,2014,2018,2062,2101,2110,2160,2170,2207,2314,2432,2444,2504,2564,2573,2584,2679,2720,2738,2750,2780,2817,2823,2856,2889,2907,2926,2934,2940,2948,2985,2998,3012,3061,3085,3120,3143,3193,3210,3248,3304,3307,3322,3383,3388,3392,3393,3401,3410,3438,3483,3578,3646,3669,3688,3690,3811,3881,3886,3927,3938,3949,3965,4025,4026,4037,4059,4064,4071,4119,4131,4142,4166,4186,4251,4261,4301,4377,4383,4434,4452,4467,4473,4474,4516,4589,4644,4681,4717,4730,4736,4791,4868,4885,4904,4995,4996,5026,5054,5066,5104,5110,5115,5173,5201,5217,5219,5268,5269,5325,5353,5361,5400,5442,5443,5496,5586,5618,5705,5765,5784,5832,5863,5883,5903,5929,5936,5946,5966,5978,6002,6019,6057,6119,6165,6188,6204,6208,6220,6306,6318,6478,6495,6519,6660,6694,6706,6727,6764,6789,6805,6810,6822,6842,6893,6903,6903,6904,6917,6946,7021,7147,7151,7153,7348,7385,7448,7476,7508,7554,7573,7620,7662,7673,7693,7717,7748,7770,7772,7827,7931,8038,8081,8100,8101,8162,8236,8311,8409,8422,8450,8451,8465,8480,8501,8578,8599,8644,8712,8741,8784,8821,8873,8899,8902,8932,8991,9012,9014,9040,9066,9075,9204,9247,9351,9356,9361,9427,9427,9474,9482,9525,9539,9570,9588,9596,9597,9610,9619,9676,9687,9693,9709,9715,9761,9767,9775,9814,9839,9884,9969,9978,9999,10053,10055,10120,10198,10225,10266,10336,10355,10363,10368,10375,10380,10400,10417,10435,10509,10525,10609,10610,10676,10692,10762,10791,10801,10818,10876,10877,10963,10972,11007,11089,11111,11121,11140,11185,11192,11265,11293,11309,11357,11415,11428,11526,11526,11544,11549,11611,11636,11637,11653,11700,11794,11807,11818,11826,11855,11856,11888,11911,11960,11973,12039,12046,12079,12103,12111,12165,12244,12271,12276,12307,12325,12337,12376,12421,12431,12439,12483,12547,12567,12578,12609,12610,12623,12631,12701,12731,12750,12756,12764,12790,12830,12902,12931,12997,13015,13151,13154,13156,13252,13282,13298,13399,13457,13464,13473,13546,13551,13566,13582,13604,13605,13612,13729,13734,13814,13885,13903,13914,13914,13939,13944,14043,14055,14077,14088,14090,14109,14185,14198,14220,14265,14314,14333,14363,14375,14376,14427,14430,14502,14504,14516,14555,14657,14663,14679,14752,14764,14804,14831,14836,14894,14951,14968,15005,15069,15091,15091,15096,15163,15185,15239,15244,15255,15315,15326,15350,15406,15436,15444,15472,15538,15628,15654,15669,15699,15729,15742,15757,15767,15784,15798,15827,15851,15869,15887,15887,15909,15918,16074,16078,16173,16212,16257,16301,16332,16335,16344,16397,16401,16408,16425,16461,16479,16486,16487,16517,16531,16532,16570,16579,16598,16634,16650,16682,16708,16726,16747,16758,16758,16813,16832,16890,16908,16926,16943,16948,17037,17048,17078,17081,17097,17150,17188,17214,17235,17244,17247,17256,17334,17431,17450,17509,17512,17514,17521,17525,17539,17566,17595,17653,17665,17667,17703,17730,17765,17768,17773,17788,17827,17852,17884,17893,17909,17959,18016,18072,18103,18115,18150,18164,18245,18251,18316,18341,18383,18536,18548,18557,18608,18651,18653,18674,18732,18798,18819,18883,19012,19021,19087,19120,19130,19202,19206,19217,19230,19296,19310,19340,19384,19459,19460,19471,19537,19544,19552,19626,19763,19785,19859,19880,19892,19900,19910,19920,19963,19984,20017,20099,20105,20137,20139,20175,20244,20359,20381,20389,20415,20530,20561,20649,20739,20779,20785,20789,20836,20877,20894,20955,20983,21005,21055,21148,21164,21165,21172,21181,21272,21303,21318,21343,21353,21356,21464,21529,21577,21595,21606,21621,21672,21699,21731,21732,21765,21780,21915,21928,21946,21970,21977,22023,22047,22048,22099,22168,22207,22231,22251,22263,22274,22296,22301,22334,22450,22464,22534,22687,22730,22734,22808,22823,22890,22937,22975,22983,23010,23056,23089,23105,23120,23146,23159,23250,23274,23281,23310,23333,23340,23394,23427,23435,23473,23497,23536,23563,23570,23624,23626,23664,23704,23725,23734,23739,23749,23797,23814,23901,23905,23988,24028,24053,24195,24225,24273,24293,24321,24347,24412,24417,24442,24447,24475,24533,24603,24734,24762,24818,24819,24847,24858,24867,24881,24882,24895,24920,24945,24946,25010,25012,25020,25070,25076,25088,25107,25108,25157,25159,25189,25195,25244,25264,25357,25395,25429,25472,25490,25515,25575,25615,25622,25629,25731,25752,25803,25828,25850,25876,25979,26030,26041,26067,26083,26111,26124,26163,26218,26232,26278,26293,26347,26348,26397,26412,26413,26420,26474,26485,26511,26556,26595,26614,26682,26698,26752,26793,26870,26896,26919,26933,26946,26996,27017,27022,27065,27110,27131,27136,27161,27165,27183,27359,27403,27408,27426,27434,27581,27603,27620,27645,27688,27702,27716,27731,27742,27759,27768,27809,27818,27837,27851,28200,28225,28253,28308,28353,28383,28407,28440,28457,28473,28494,28546,28575,28584,28586,28595,28620,28674,28675,28675,28831,28835,28938,28963,28992,28994,29068,29123,29156,29194,29204,29313,29381,29404,29434,29460,29487,29527,29556,29681,29688,29690,29691,29757,29760,29788,29802,29894,29898,29959,29989,29991,29994,30016,30024,30058,30084,30089,30089,30123,30143,30167,30167,30210,30233,30236,30312,30324,30400,30486,30524,30555,30556,30602,30609,30619,30630,30666,30671,30676,30780,30784,30788,30818,30861,30863,30890,30912,30952,31242,31258,31273,31304,31394,31403,31408,31411,31461,31470,31472,31477,31505,31562,31593,31597,31699,31711,31762,31778,31803,31812,31906,31912,31944,31945,31946,31955,32005,32016,32042,32052,32130,32153,32183,32194,32197,32205,32220,32367,32368,32401,32424,32498,32508,32521,32546,32601,32615,32632,32699,32716,32736,32751,32751},
				new int[]{39,99,100,114,149,221,235,238,300,312,381,400,406,457,498,519,521,539,539,573,595,602,610,669,684,695,701,707,781,804,809,817,851,885,896,993,1058,1069,1148,1162,1186,1200,1213,1221,1263,1278,1299,1301,1334,1392,1421,1500,1513,1566,1575,1585,1666,1669,1722,1782,1922,1947,1987,1993,2010,2066,2096,2149,2152,2176,2188,2224,2357,2358,2417,2424,2450,2500,2541,2693,2729,2776,2885,2892,2896,2919,2940,2952,3026,3042,3092,3107,3160,3160,3205,3330,3349,3360,3387,3394,3459,3460,3465,3478,3504,3520,3530,3556,3557,3569,3589,3591,3591,3592,3632,3670,3674,3691,3735,3747,3942,3943,3947,3964,3973,3993,4019,4091,4210,4257,4265,4306,4364,4428,4429,4500,4502,4542,4549,4590,4623,4744,4762,4774,4833,4850,4853,4867,4894,4924,4925,4973,5001,5018,5031,5063,5089,5091,5092,5103,5152,5156,5222,5223,5239,5307,5314,5365,5400,5459,5460,5486,5498,5522,5546,5585,5648,5649,5664,5669,5731,5801,5818,5880,5908,5956,5972,6007,6016,6085,6131,6205,6207,6213,6220,6237,6254,6299,6351,6378,6429,6486,6499,6515,6528,6610,6612,6652,6655,6732,6757,6774,6948,6962,6971,7028,7031,7044,7062,7134,7138,7168,7193,7212,7230,7237,7304,7393,7447,7447,7574,7607,7620,7655,7680,7727,7762,7817,7916,8044,8044,8052,8174,8189,8247,8261,8292,8293,8300,8312,8316,8347,8371,8481,8484,8513,8543,8572,8586,8595,8597,8647,8693,8750,8764,8770,8772,8797,8833,8857,8875,8887,8896,8925,8934,8952,8972,8998,9050,9092,9117,9179,9203,9229,9248,9308,9346,9358,9367,9381,9388,9403,9407,9444,9448,9512,9524,9540,9679,9744,9769,9769,9833,9842,9858,9977,10083,10096,10119,10126,10132,10146,10187,10236,10279,10291,10314,10317,10325,10358,10430,10503,10523,10549,10562,10599,10605,10695,10714,10722,10798,10800,10811,10838,10858,10861,10882,11011,11021,11038,11052,11084,11100,11138,11161,11180,11186,11219,11246,11250,11271,11344,11421,11474,11481,11538,11571,11574,11642,11654,11681,11738,11756,11788,11803,11826,11894,11912,11935,11969,11978,12014,12030,12033,12037,12061,12085,12106,12107,12141,12201,12206,12245,12300,12384,12390,12420,12443,12448,12455,12476,12564,12575,12578,12606,12684,12731,12733,12751,12777,12795,12820,12859,12908,13003,13045,13083,13149,13149,13171,13240,13304,13307,13372,13401,13423,13449,13484,13505,13540,13556,13638,13698,13726,13729,13737,13783,13786,13813,13866,13893,13954,13976,13983,14042,14065,14107,14112,14151,14210,14255,14292,14297,14319,14329,14346,14415,14427,14430,14435,14445,14609,14610,14646,14707,14737,14865,14917,15081,15123,15137,15152,15170,15180,15209,15216,15238,15291,15305,15309,15330,15336,15348,15369,15416,15481,15493,15525,15640,15737,15750,15787,15793,15799,15826,15869,15980,16031,16044,16090,16193,16321,16331,16368,16404,16417,16442,16455,16573,16591,16593,16656,16734,16752,16765,16796,16997,17030,17114,17160,17162,17172,17173,17181,17225,17226,17239,17239,17243,17286,17290,17357,17427,17474,17499,17512,17517,17567,17726,17731,17781,17834,17874,17940,17944,17949,17962,17979,17979,18036,18042,18054,18089,18103,18126,18137,18145,18176,18206,18286,18369,18377,18569,18571,18591,18611,18624,18666,18672,18698,18707,18779,18790,18937,18956,18967,18968,18970,18991,18992,19003,19010,19076,19092,19095,19113,19155,19216,19216,19232,19247,19259,19262,19338,19358,19362,19397,19425,19459,19611,19631,19641,19665,19743,19765,19775,19798,19817,19827,19847,19850,19951,19980,20033,20041,20077,20097,20107,20141,20190,20211,20242,20328,20393,20414,20467,20479,20501,20525,20545,20548,20614,20660,20752,20874,20925,20957,20966,21028,21067,21108,21146,21153,21210,21273,21298,21331,21334,21349,21357,21517,21557,21588,21614,21623,21671,21681,21782,21836,21866,21968,21969,22000,22002,22020,22059,22090,22162,22259,22290,22314,22370,22381,22391,22562,22582,22615,22705,22708,22757,22771,22785,22825,22881,22885,22901,22942,22969,22975,22988,23028,23039,23064,23072,23115,23156,23175,23182,23206,23210,23277,23315,23342,23401,23408,23475,23477,23501,23517,23579,23615,23644,23691,23702,23727,23729,23733,23808,23823,23831,23853,23933,24002,24010,24019,24045,24073,24218,24238,24244,24280,24297,24360,24362,24389,24400,24461,24495,24515,24532,24554,24602,24615,24654,24698,24739,24758,24835,24841,24916,25021,25061,25101,25102,25153,25153,25287,25292,25296,25311,25316,25316,25319,25327,25395,25432,25454,25472,25557,25621,25622,25631,25649,25689,25724,25741,25742,25796,25839,25865,25866,25871,25874,25911,25916,25925,25941,25958,25981,26092,26098,26113,26160,26173,26315,26318,26355,26385,26390,26417,26429,26466,26488,26535,26542,26618,26674,26724,26773,26785,26807,26837,26840,26861,26891,26969,26971,27009,27027,27063,27196,27220,27251,27289,27308,27326,27331,27340,27356,27428,27428,27499,27524,27596,27700,27708,27856,27873,27923,27947,27990,27992,28008,28072,28081,28112,28150,28220,28253,28286,28316,28323,28326,28344,28366,28421,28436,28441,28471,28486,28585,28592,28684,28690,28698,28704,28731,28750,28761,28782,28851,28931,28935,28945,28953,28974,29080,29090,29107,29196,29200,29207,29224,29234,29253,29258,29303,29322,29325,29334,29348,29382,29396,29409,29410,29450,29491,29504,29522,29555,29641,29644,29647,29653,29676,29690,29834,29885,29896,29909,29963,30035,30064,30104,30175,30195,30227,30232,30260,30268,30294,30332,30340,30348,30393,30412,30449,30465,30519,30571,30580,30601,30627,30678,30713,30726,30745,30748,30757,30806,30808,30813,30822,30916,30924,30930,30997,31001,31069,31132,31181,31190,31202,31231,31249,31256,31339,31348,31365,31384,31436,31460,31550,31574,31596,31685,31698,31710,31730,31736,31761,31799,31857,31891,31916,31950,31962,31969,31988,32039,32059,32067,32159,32162,32164,32188,32196,32268,32289,32315,32327,32355,32361,32374,32485,32489,32539,32569,32577,32602,32613,32631,32645,32658,32667,32674,32692,32697,32700,32737}));
		System.out.println(findMedianSortedArrays(
				new int[]{131,135,195,241,274,288,330,334,342,358,361},
				new int[]{ 39, 99,100,114,149,221,235,238,300,312,381}));

	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;

		int l = (m+n+1) / 2;
		int r = (m+n+2) / 2;
		//if(l==r) return getKth(nums1, 0, nums2, 0, l);

		return (getKth(nums1, m/2, nums2, n/2, l) + getKth(nums1, m/2, nums2, n/2, r))/ 2.0;
	}
	private static double getKth(int[] nums1, int s1, int[] nums2, int s2, int pos){

		if(s1+s2 == pos){
			return Math.min(nums1[s1], nums2[s2]);
		}
		if(s1 > nums1.length) return nums2[pos-nums1.length-1];
		if(s2 > nums2.length) return nums1[pos-nums2.length-1];

		if(nums1[s1] < nums2[s2]){
			return getKth(nums1, s1+s1/2, nums2, s2, pos);
		}else{
			return getKth(nums1, s1, nums2, s2+s2/2, pos);
		}

//		getKth(nums1, s1+pos/2, nums2, s2, pos);
//		getKth(nums1, s1-pos/2, nums2, s2, pos);
//		getKth(nums1, s1, nums2, s2+pos/2, pos);
//		getKth(nums1, s1, nums2, s2-pos/2, pos);
//
//		return 0;
	}
	private static double getKth1(int[] nums1, int s1, int[] nums2, int s2, int pos){

		if(s1 == nums1.length) return nums2[pos-s1-1];
		if(s2 == nums2.length) return nums1[pos-s2-1];
		if(s1+s2 == pos-1){
			return Math.min(nums1[s1], nums2[s2]);
		}

		if(nums1[s1] < nums2[s2]){
			return getKth1(nums1, s1+1, nums2, s2, pos);
		}else{
			return getKth1(nums1, s1, nums2, s2+1, pos);
		}
	}


	/*
	------------------
	02468   +2   2*(2-1)

	13579   +2   2*(2-1)
	------------------
	0 4 8 2    +4   2*(3-1)
	1357913    +2   2*(3-2)
	2 6 0      +4   2*(3-1)
	------------------
	0  6   2  8    +6     2*(4-1)
	1 57  13 79    +4+2   2*(4-2) / 2*(4-3)
	24 8 0 46 0    +2+4   2*(4-3) / 2*(4-2)
	3  9   5       +6     2*(4-1)
	------------------
	0   8   6    4   2     +8       2*(5-1)
	1  79  57   35  13     +6+2     2*(5-2) / 2*(5-4)
	2 6 0 4 8  2 6 0 4     +4       2*(5-3)
	35  13  9 1  79  5     +2+6     2*(5-4) / 2*(5-2)
	4   2   0    8         +8       2*(5-1)
	------------------
	0    0    0    0    0   2*(6-1)
	1   91   91   91   91   2*(6-2) / 2*(6-5)
	2  8 2  8 2  8 2  8 2   2*(6-3) / 2*(6-4)
	3 7  3 7  3 7  3 7  3   2*(6-4) / 2*(6-3)
	46   46   46   46   4   2*(6-5) / 2*(6-2)
	5    5    5    5        2*(6-1)
	------------------
	*/
	/*
	public static void main(String[] args){
		System.out.println(convert("", 1));
		System.out.println(convert("AB", 2));
		System.out.println(convert("ABCD", 2));
		System.out.println(convert("PAYPALISHIRING", 3));

	}*/

	public static String convert(String s, int numRows) {

		if(s.isEmpty() || numRows == 1 || s.length() <= numRows) return s;

		StringBuilder result = new StringBuilder();

		int row=1, index=0;
		while(result.length() < s.length()){
			if(index >= s.length()) {
				index = row++;
				continue;
			}
			result.append(s.charAt(index));
			index += 2*(numRows-row);

			if(numRows-row == 0)index += 2*(row-1);

			if(row > 1 && row < numRows){
				if(index >= s.length()){
					index = row++;
					continue;
				}
				result.append(s.charAt(index));
				index += 2*(row-1);
			}
		}

		return result.toString();
	}
	public static String convert1(String s, int numRows) {

		if(s.isEmpty() || numRows == 1 || s.length() < numRows) return s;

		String result = "";
		StringBuilder[] arr = new StringBuilder[numRows];
		int row=0,flg=1;

		for(int i=0;i<s.length();i++){
			if(i<numRows){
				arr[row] = new StringBuilder();
			}
			arr[row] = arr[row].append(s.substring(i,i+1));

			if(row == numRows-1){
				flg = -1;
			}else if(row == 0){
				flg = 1;
			}
			row += flg;
		}

		for(int i=0;i<numRows;i++){
			result = result.concat(arr[i].toString());
		}

		return result;
	}

	/*
	public static void main(String[] args) {
//		System.out.println(longestPalindrome("adam"));
//		System.out.println(longestPalindrome("babad"));
//		System.out.println(longestPalindrome("cbbd"));
//		System.out.println(longestPalindrome("abcdasdfghjkldcba"));
//		System.out.println(longestPalindrome("kyyrjtdplseovzwjkykrjwhxquwxsfsorjiumvxjhjmgeueafubtonhlerrgsgohfosqssmizcuqryqomsipovhhodpfyudtusjhonlqabhxfahfcjqxyckycstcqwxvicwkjeuboerkmjshfgiglceycmycadpnvoeaurqatesivajoqdilynbcihnidbizwkuaoegmytopzdmvvoewvhebqzskseeubnretjgnmyjwwgcooytfojeuzcuyhsznbcaiqpwcyusyyywqmmvqzvvceylnuwcbxybhqpvjumzomnabrjgcfaabqmiotlfojnyuolostmtacbwmwlqdfkbfikusuqtupdwdrjwqmuudbcvtpieiwteqbeyfyqejglmxofdjksqmzeugwvuniaxdrunyunnqpbnfbgqemvamaxuhjbyzqmhalrprhnindrkbopwbwsjeqrmyqipnqvjqzpjalqyfvaavyhytetllzupxjwozdfpmjhjlrnitnjgapzrakcqahaqetwllaaiadalmxgvpawqpgecojxfvcgxsbrldktufdrogkogbltcezflyctklpqrjymqzyzmtlssnavzcquytcskcnjzzrytsvawkavzboncxlhqfiofuohehaygxidxsofhmhzygklliovnwqbwwiiyarxtoihvjkdrzqsnmhdtdlpckuayhtfyirnhkrhbrwkdymjrjklonyggqnxhfvtkqxoicakzsxmgczpwhpkzcntkcwhkdkxvfnjbvjjoumczjyvdgkfukfuldolqnauvoyhoheoqvpwoisniv"));
//		System.out.println(longestPalindrome("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir"));
		System.out.println(longestPalindrome("ccc"));
		System.out.println(longestPalindrome("cccc"));
		System.out.println(longestPalindrome("ccccc"));
		System.out.println(longestPalindrome("cccccc"));
	}*/

	public static String longestPalindrome(String s) {
		byte[] b = s.getBytes();
		int st =0,ed=0,len=0;

		if(s.length() == 1)return s;
		for(int i=1;i<b.length;i++){
			int t = (b[i]==b[i-1])?1:0;

			for(int j=1;j<=i && i+j-t<b.length;j++){
				if(b[i-j] == b[i+j-t]){
					if(len < 2*j-t){
						st = i-j;
						ed = i+j-t;
					}
				}else{
					break;
				}

			}
			len = ed - st;

			for(int j=1;t==1 && j<=i && i+j<b.length;j++){
				if(b[i-j] == b[i+j]){
					if(len < 2*j){
						st = i-j;
						ed = i+j;
					}
				}else{
					break;
				}

			}
			len = ed - st;
		}

		if(len > 0)return s.substring(st,ed+1);
		else return s.substring(0,1);

	}
	public static String longestPalindrome1(String s) {
		String reverse = new StringBuilder(s).reverse().toString();
		int len = s.length();

		for(int i=len;i>=0;i--){
			for(int j=0;j<=len-i;j++){
				if(s.substring(j,j+i).equals(reverse.substring(len-i-j,len-j))) return s.substring(j,j+i);
			}
		}

		return "";
	}

	/*
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("dvdw"));
		System.out.println(lengthOfLongestSubstring("bpfbhmipx"));
		System.out.println(lengthOfLongestSubstring("c"));
		System.out.println(lengthOfLongestSubstring(""));
	}*/
	public static int lengthOfLongestSubstring(String s) {
		int start = 0, ms = 0, me = 0;

		for(int i=0;i<s.length();i++){
			int index = s.substring(start,i).indexOf(s.substring(i,i+1));
			if(index >=0){
				start += index+1;
			}
			if(i-start >= me-ms-1){
				ms = start;
				me = i+1;
				System.out.println(ms + "," + me);
			}
		}

		return me - ms;
	}
	public static int lengthOfLongestSubstring1(String s) {
		String sub = "";
		String temp = "";

		for(int i=0;i<s.length();i++){
			int index = temp.indexOf(s.charAt(i));
			if(index >= 0){
				temp = temp.substring(index+1, temp.length()).concat(s.substring(i, i+1));
			}else{
				temp = temp.concat(s.substring(i, i+1));
				if(temp.length() > sub.length()) sub = temp;
			}
		}

		return sub.length();
	}

    /*
	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(5);

		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode result = addTwoNumbers(l1, l2);
		System.out.println(result.val);
		while(result.next != null){
			result = result.next;
			System.out.println(result.val);
		}

	}*/
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);

		if(l1 == null) return l2;
		if(l2 == null) return l1;

		result.val += l1.val + l2.val ;
		if(result.val>= 10) {
			result.val = result.val - 10;
			result.next = new ListNode(1);
		}
		if(l1.next != null) result.next = addTwoNumbers(result.next, l1.next);
		if(l2.next != null) result.next = addTwoNumbers(result.next, l2.next);


		return result;
	}

	/*
	public static void main(String[] args) {
		 int[] result = twoSum(new int[]{2,7,11,15}, 9);
		 System.out.println(result[0] + "," + result[1]);
	}*/
	public static int[] twoSum(int[] nums, int target) {
		int[] result = { 0, 0 };

		for (int i = 0; i < nums.length - 1; i++) {
			result[0] = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[1] = j;
					break;
				}

			}
			if (result[1] > 0)
				break;
		}

		return result;

	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
