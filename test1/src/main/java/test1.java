import java.io.*;
public class test1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error args");
            System.exit(0);
        }
        try {
            String msg;
            int count = 0;
            float sum = 0;
            File f = new File(args[0]);
            FileInputStream fin = new FileInputStream(f);
            InputStreamReader ir = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(ir);
            if (f.isFile() == false) {
                System.out.println("File not found");
                System.exit(0);
            }
            while ((msg = br.readLine()) != null) {
                try {
                    float n = Float.parseFloat(msg);
                    count++;
                    sum = sum + n;
                } catch (Exception e) {
                }
            }
            System.out.println("sum : "+ sum);
            System.out.println("count : "+ count);
            System.out.println(sum + " / " + count + " = " + sum/count);
            fin.close();
        } catch (Exception e) {
            System.out.println("Exception e");
        }
    }
}


