public class Addbinary {
    public static void main() {
        String a="1101";
        String b="11000";

       System.out.println(addBinary(a,b));

    }
        public static String addBinary(String a, String b) {
            StringBuilder s1=new StringBuilder(a);
            StringBuilder s2=new StringBuilder(b);
            int a1=a.length();
            int b1=b.length();
            if(a1!=b1){
                if(a1<b1){
                    int k=b1-a1;
                    for(int i=1;i<=k;i++){
                        s1.insert(0,'0');
                    }
                }
                else{
                    int k=a1-b1;
                    for(int i=1;i<=k;i++){
                        s2.insert(0,'0');
                    }
                }
            }
            int k=s1.length();
            StringBuilder sb=new StringBuilder();
            char c='0';
            for(int i=k-1;i>=0;i--){
                char ch1=s1.charAt(i);
                char ch2=s2.charAt(i);
                if(ch1=='0'&& ch2=='0' ){
                    if(c=='1'){
                        sb.insert(0,'1');
                        c='0';
                    }
                    else  {
                        sb.insert(0,'0');
                        c='0';
                    }
                }
                else if((ch1=='0'&& ch2=='1')||(ch1=='1' && ch2=='0')){
                    if(c=='0'){
                        sb.insert(0,'1');
                        c='0';
                    }
                    else{
                        sb.insert(0,'0');
                        c='1';
                    }
                }
                else{
                    if(c=='0'){
                        sb.insert(0,'0');
                        c='1';
                    }
                    else{
                        sb.insert(0,'1');
                        c='1';
                    }

                }


            }
            if(c=='1'){
                sb.insert(0,c);
            }

            return sb.toString();

        }
    }

