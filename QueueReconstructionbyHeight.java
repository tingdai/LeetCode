public class Solution {
	public int[][] reconstructQueue(int[][] people) {
        //int[][] newpeople= new int[people.length()][2];
        List<List<Integer>> newpeople = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> maps = new HashMap<Integer, List<Integer>>();
        List<Integer> lists = new ArrayList<Integer>();
        //sort the pairs, get the maps with height as the key, number as the value
        for(int i = 0; i < people.length; i++){
            if(!lists.contains(people[i][0])){
                List<Integer> list = new ArrayList<Integer>();
                list.add(people[i][1]);
                maps.put(people[i][0],list);
                lists.add(people[i][0]);
            } else {
                List<Integer> list = maps.get(people[i][0]);
                list.add(people[i][1]);
            }
        }
        Collections.sort(lists, Collections.reverseOrder());
        for(int i : lists){
            List<Integer> list = maps.get(i);
            Collections.sort(list);
            for(int j : list){
                int count = 0;
                List<Integer> newlist = new ArrayList<Integer>();
                newlist.add(i); newlist.add(j);
                if(j == 0){
                    newpeople.add(0, newlist);
                } else {
                	int k = 0;
                    for(k = 0; k < people.length; k++){
                        if(newpeople.get(k).get(0) >= i){
                            count++;
                        }
                        if(count == j){
                            break;
                        }
                    }
                    newpeople.add(k+1, newlist);
                }
            }
        }
        //int[][] retarray = (int[][]) ArrayUtils.toPrimitive(newpeople.toArray(new Integer[newpeople.size()][2]));
        int[][] retarray = toIntArray(newpeople);
        return retarray;
    }
	
	private int[][] toIntArray(List<List<Integer>> lists)  {
	    int[][] ret = new int[lists.size()][2];
	    int i = 0;
	    for (List<Integer> e : lists){
	        ret[i][0] = e.get(0).intValue();
	        ret[i][1] = e.get(1).intValue();
	        i++;
	    }
	    return ret;
	}
}
