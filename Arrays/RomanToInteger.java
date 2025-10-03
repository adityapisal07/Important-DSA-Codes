import java.util.*;

class RomanToInteger{
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum = 0;
        int n = s.length();

        for(int i = 0 ; i < n ; i++){
            int value = map.get(s.charAt(i));
            if(i + 1 < n && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                sum -= value;
            } else {
                sum += value;
            }
        }
        return sum;
    }

    // main method to test
    public static void main(String[] args) {
        RomanToInteger sol = new RomanToInteger();

        System.out.println(sol.romanToInt("III"));      // 3
        System.out.println(sol.romanToInt("IV"));       // 4
        System.out.println(sol.romanToInt("IX"));       // 9
        System.out.println(sol.romanToInt("LVIII"));    // 58
        System.out.println(sol.romanToInt("MCMXCIV"));  // 1994
    }
}
