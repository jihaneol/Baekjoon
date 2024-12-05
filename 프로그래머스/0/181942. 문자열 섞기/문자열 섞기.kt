class Solution {
    fun solution(str1: String, str2: String): String {
        var answer: String = ""
        
        for(i in 0..str1.length-1){
            answer +=str1[i]
            answer +=str2[i]
        }
        return answer
    }
}