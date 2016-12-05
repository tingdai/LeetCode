public class Solution {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null && s2 == null && s3 == null)
            return true;
        else if((s1 == null || (s1 != null && s1.length() == 0)))
        	if(s2.equals(s3))
        		return true;
        	else 
        		return false;
        else if((s2 == null || (s2 != null && s2.length() == 0)))
        	if(s1.equals(s3))
        		return true;
        	else
        		return false;
        else if(s1 != null && s2 != null && s3 != null){
            if(s3.length() != s1.length() + s2.length())
                return false;
            boolean intered[][] = new boolean[s1.length()+1][s2.length()+1];
            for(int i = 0; i <= s1.length(); i++)
                for(int j = 0; j <= s2.length(); j++){
                    if(i == 0 && j == 0){
                        intered[i][j] = true;
                    }
                    else if(i == 0){
                    	if(j != 0 && s2.charAt(j-1) == s3.charAt(i+j-1))
                    		intered[i][j] = intered[i][j-1];
                    }
                    else if(j == 0){
                    	if(i != 0 && s1.charAt(i-1) == s3.charAt(i+j-1))
                    		intered[i][j] = intered[i-1][j];
                    }
                    else if(s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1) != s3.charAt(i+j-1))
                        intered[i][j] = intered[i-1][j];
                    else if(s1.charAt(i-1) != s3.charAt(i+j-1) && s2.charAt(j-1) == s3.charAt(i+j-1))
                        intered[i][j] = intered[i][j-1];
                    else if(s1.charAt(i-1) == s3.charAt(i+j-1) || s2.charAt(j-1) == s3.charAt(i+j-1))
                        intered[i][j] = intered[i-1][j] || intered[i][j-1];
                }
            return intered[s1.length()][s2.length()];
            
        }
        else 
            return false;
    }
}
