package tutorial1;
import java.util.*;
import java.lang.String;


class lzw{
    private String s;
int cnt;
    Vector<Integer>answer;
    public lzw(String s){
        this.s=s;
        cnt=128;

    }
   public lzw(){};
    public Vector<Integer> comperis() {
        answer=new Vector<>();
        Map<String,Integer>m=new HashMap<>();
        for (int i=0;i<s.length();i++){
            int i2=i;
            String temp="";
            temp+=s.charAt(i);
            while (i2 < s.length()-1 && (m.containsKey(temp) || temp.length() == 1)) {
                temp += s.charAt(++i2);
            }
            if (temp.length()==2&&!m.containsKey(temp))
                answer.add((int)temp.charAt(0)) ;
            else if (m.containsKey(temp))
                answer.add(m.get(temp));
             else
                answer.add(m.get(temp.substring(0,temp.length()-1))) ;
            m.put(temp,cnt++);
            if (i2==s.length()-1)
                break;
            i=i2-1;
        }
        return answer;
    }
    public String Decompris(Vector<Integer>v){
        String ans="";
        return ans;
    }
}
public class Main {
    static void add(int a,int b){
        System.out.println(a+b);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s="ABAABABBAABAABAAAABABBBBBBBB";
//A B A A B A B B A A B A A B A A A A B A B B B B B B B B
        lzw ob=new lzw(s);
       Vector<Integer>v= ob.comperis();
        for (int i = 0; i <v.size() ; i++) {
            System.out.println(v.get(i));
        }
    }
}
