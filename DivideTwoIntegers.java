public class Solution {
	public static int divide(int dividend, int divisor) {
        if(dividend == 0)
            return 0;
        if(divisor == 1)
            return dividend;
        if(dividend <= Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if(divisor == -1)
        	return (0-dividend);
        boolean neg = (dividend < 0)^(divisor < 0);
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if(neg) return 0-ldivide(ldividend, ldivisor);
        else return ldivide(ldividend, ldivisor);
    }
	
	public static int ldivide(long ldividend, long ldivisor){
		if(ldividend < ldivisor)
			return 0;
		int po = 0;
    	while(ldividend - Math.pow(ldivisor, po) >= 0){
    		po += 1;
    	}
    	ldividend -= Math.pow(ldivisor, po-1);
    	return (int) Math.pow(ldivisor,(po-2)) + ldivide(ldividend,ldivisor);
	}
}
