

import java.util.Arrays;
import java.util.HashMap;

public class Solution200706 {
	public static void main(String[] args) {
		// get top k more frequency appears in an integer array.
		int nums[] = {1,1,1,2,2,3,1,2,2,2,2,3,3,3,3,3,3};
		int k = 3;
		int result[] = new int[k];

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length;i++) {
			int key = nums[i];
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}else {
				map.put(key, 1);
			}
			
			for(int j=k-1;j>=0;j--) {
				int comp = result[j];
				if(comp == 0) {
					result[j] = key;
					break;
				}else if(comp == key) {
					break;
				} else if(map.get(comp) >= map.get(key)) {
					continue;
				}else {
					for(int s=0;s<j;s++) {
						if(result[s+1] == key) continue;
						result[s]= result[s+1];
					}
					result[j] = key;
					break;
				}	
			}	
			System.out.println(i + " - " + Arrays.toString(result) + " - " + map);
		}
		System.out.println(Arrays.toString(result));
	}
}
