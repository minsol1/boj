class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            
            if(c== ' ') {
                sb.append(c);
                start = true;
                continue;
            }
            if(start){
                if(Character.isLowerCase(c)){
                    c = Character.toUpperCase(c);
                }
                start = false;
                sb.append(c);
            }
            else{
                if(Character.isUpperCase(c)){
                    c = Character.toLowerCase(c);
                }
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}