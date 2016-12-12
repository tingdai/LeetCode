public class Solution {
	public static String fractionToDecimal(int numerator, int denominator) {
	    if(numerator == 0)
        	return "0";
        Map<Long, Long> map = new HashMap<Long, Long>();
        List<Long> list = new ArrayList<Long>();
        boolean neg = (numerator < 0) ^(denominator < 0);
        long lnumerator = Math.abs((long)numerator);
        long ldenominator = Math.abs((long) denominator);
        int flag = -1;
        String ret1 = Long.toString(lnumerator/ldenominator);
        lnumerator = lnumerator % ldenominator;
        while(lnumerator != 0){
            if(!list.contains(lnumerator)){
                long ldivide = lnumerator*10/ldenominator;
                map.put(lnumerator, ldivide);
                list.add(lnumerator);
                lnumerator = (lnumerator*10)%ldenominator;
            }else{
                flag = list.indexOf(lnumerator);
                break;
            }
        }
        if(flag != -1){
        	String ret2  = "";
        	for(int i = 0; i < flag; i++){
        		ret2 += Long.toString(map.get(list.get(i)));
        	}
        	ret2 += "(";
        	for(int i = flag; i < list.size(); i++){
        		ret2 += Long.toString(map.get(list.get(i)));
        	}
        	ret2 += ")";
        	ret1 += "." + ret2;
        } else {
        	String ret2  = "";
        	if(list.size() > 0){
        		for(int i = 0; i < list.size(); i++){
        			ret2 += Long.toString(map.get(list.get(i)));
        		}
        		ret1 += "." + ret2;
        	}
        }
        if(neg) return "-"+ret1;
        else  return ret1;
    }
}
