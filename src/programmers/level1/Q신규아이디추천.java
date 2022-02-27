package programmers.level1;

public class Q신규아이디추천 {
     class Solution {
        public String solution(String new_id) {
            char[] idChars = new_id.toCharArray();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < idChars.length; i++) {
                if(idChars[i] >= 'A' && idChars[i] <= 'Z'){
                    sb.append((char)(idChars[i] + 32));
                }else if((idChars[i] >= 'a' && idChars[i] <= 'z')
                        || (idChars[i] >= '0' && idChars[i] <= '9')
                        || idChars[i] == '-' || idChars[i] == '_'){
                    sb.append(idChars[i]);
                }else if(idChars[i] == '.'){
                    if(sb.length() > 0 && sb.charAt(sb.length() -1) != '.'){
                        sb.append(idChars[i]);
                    }
                }
            }
            String refinedId = sb.toString();
            if(refinedId.length() > 0 && refinedId.charAt(0) == '.'){
                refinedId = refinedId.substring(1);
            }
            if(refinedId.length() > 0 && refinedId.charAt(refinedId.length() - 1) == '.'){
                refinedId = refinedId.substring(0, refinedId.length() - 1);
            }
            if(refinedId.length() == 0){
                refinedId = "a";
            }
            if(refinedId.length() >= 16){
                refinedId = refinedId.substring(0, 15);
                if(refinedId.endsWith(".")){
                    refinedId = refinedId.substring(0, refinedId.length() - 1);
                }
            }
            if(refinedId.length() < 3){
                StringBuilder rsb = new StringBuilder(refinedId);
                char addChar = refinedId.charAt(refinedId.length() - 1);
                for (int i = refinedId.length(); i < 3; i++) {
                    rsb.append(addChar);
                }
                refinedId = rsb.toString();
            }
            return refinedId;
        }
    }
}
