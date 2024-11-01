package tutorial1;
import java.util.*;
import java.lang.String;

class tuple{
   public int position;
   public int length;
   public Character nextchar;
    public tuple(int position, int length, Character nextChar) {
        this.position = position;
        this.length = length;
        this.nextchar = nextChar;
    }
    @Override
    public String toString() {
        return "(" + position + ", " + length + ", " + nextchar + ")";
    }
}
class lz77{
    private String s;
 
    Vector<tuple>answer;
    public lz77(String s){
        this.s=s;
    }
   public lz77(){};
    public Vector<tuple> comperis() {
        answer=new Vector<>();
        String searchWindow="";
        for(int i=0;i<s.length();i++){
            if (searchWindow.isEmpty()){
                answer.add(new tuple(0,0,s.charAt(i)));
                searchWindow+=s.charAt(i);
            }
            else{      //ABAABABAABBBBBBBBBBBB abaa
                String temp="";
                temp+=(s.charAt(i));
                if (searchWindow.lastIndexOf(temp)==-1){
                    answer.add(new tuple(0,0,s.charAt(i)));
                    searchWindow+=s.charAt(i);
                }
                else {
                    int cnt = i;
                    while (searchWindow.lastIndexOf(temp) != -1&&cnt<s.length()-1) {
                        cnt++;
                        temp += s.charAt(cnt);
                    }//bab       abaa
                    if (searchWindow.lastIndexOf(temp)==-1) {
                        char ne = temp.charAt(temp.length() - 1);
                        int inx = searchWindow.lastIndexOf(temp.substring(0, temp.length() - 1));
                        answer.add(new tuple(i - inx, temp.length() - 1, ne));
                    }
                    else{
                        int inx = searchWindow.lastIndexOf(temp);
                        answer.add(new tuple(i - inx, temp.length(), null));
                    }
                    i = cnt;
                    searchWindow+=temp;
                }
            }


        }
        return answer;
    }
    public String Decompris(Vector<tuple>v){
        String ans="";
        for (int i = 0; i <v.size() ; i++) {
            int p=v.get(i).position;
            int l=v.get(i).length;
            Character c=v.get(i).nextchar;
            if (p==0){
                ans+=(c==null?' ':c);
            }
            else{
                ans+=ans.substring(ans.length()-p,ans.length()-p+l);
                ans+=(c==null?' ':c);
            }
        }
        return ans;
    }
}
public class Main {
    static void add(int a,int b){
        System.out.println(a+b);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s="AAABBAA";
//                ABAABABAABBBBBBBBBBBBA
        lz77 ob1=new lz77(s);
       Vector<tuple>v=ob1.comperis();
        for (int i = 0; i <v.size() ; i++) {
            System.out.println(v.get(i));
        }
        int p,l;Character c;
//        Vector<tuple>v=new Vector<>();
//        for (int i = 0; i <8 ; i++) {
//            p=in.nextInt();
//            l= in.nextInt();
//            c=in.next().charAt(0);
//            v.add(new tuple(p,l,c));
//        }
        lz77 ob=new lz77();
       System.out.println( ob.Decompris(v));


    }
}
