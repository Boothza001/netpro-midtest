
import java.io.*;

public class test2 extends Thread{
    int [] valtxt;
    int c;
        
    public test2(int [] valtxt,int c){
        this.valtxt = valtxt;
        this.c = c; 
    }
    
    public void run(){
        for(int ii = 0 ; ii < c; ii++){
            valtxt[0]++;
            valtxt[1]++;
            valtxt[2]++;
            valtxt[3]++;
            valtxt[4]++;
            valtxt[5]++;
            valtxt[6]++;
            valtxt[7]++;
            valtxt[8]++;
            valtxt[9]++;
        }
    }
    
    public int [] getResult() {
        return valtxt;
    }
    
    public static void main(String[] args) {
        try {
            String msg;
            int[] valtxt1 = new int[10];
            int[] valtxt2 = new int[10];
            int[] valtxt3 = new int[10];
            int i = 0;
            int[] sum1,sum2,sum3;
            
            File f = new File(args[0]);
            FileInputStream fin = new FileInputStream(f);
            InputStreamReader ir = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(ir);
            
            while ((msg = br.readLine()) != null) {
                valtxt1[i] = Integer.parseInt(msg);
                valtxt2[i] = Integer.parseInt(msg);
                valtxt3[i] = Integer.parseInt(msg);
                i++;
            }fin.close();
            
            test2 n1 = new test2(valtxt1,10000);
            test2 n2 = new test2(valtxt2,20000);
            test2 n3 = new test2(valtxt3,30000);
            Thread t1 = new Thread(n1);
            Thread t2 = new Thread(n2);
            Thread t3 = new Thread(n3);
            t1.start();t2.start();t3.start();
            t1.join();t2.join();t3.join();
            
            sum1 = n1.getResult();
            sum2 = n2.getResult();
            sum3 = n3.getResult();
            
            for(int jj = 0 ; jj< valtxt1.length ; jj++){
                System.out.println(sum1[jj]+sum2[jj]+sum3[jj]);
            }
        } catch (Exception e) {
        }
    }
}
