import java.awt.*;
import java.io.*;
import javax.swing.BoxLayout;

public class HP_3 {
    public static void main(String[] args){
        Frame f = new Frame("HP 3");
        f.setSize(700, 600);
        f.setLayout(new BorderLayout());

        TextArea ta = new TextArea();
        f.add(ta, BorderLayout.CENTER);

        TextField tf = new TextField();
        f.add(tf, BorderLayout.SOUTH);

        Button b1 = new Button("New"), b2 = new Button("Open"), b3 = new Button("Save"), b4 = new Button("Exit");
        Panel p1 = new Panel(), p2 = new Panel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        p1.add(b1); p1.add(b2);
        p2.add(b3); p2.add(b4);
        f.add(p1, BorderLayout.WEST); f.add(p2, BorderLayout.EAST);

        b1.addActionListener((e)->{
            tf.setText(""); ta.setText("");
        });

        b2.addActionListener((e)->{
            try{
                BufferedReader reader = new BufferedReader(new FileReader(tf.getText()));
                String s;
                while((s=reader.readLine())!=null)
                    ta.append(s+"\n");
                reader.close();
            }catch(Exception E){}
        });

        b3.addActionListener((e)->{
            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(tf.getText()));
                bw.write(ta.getText()); bw.flush(); bw.close();
            }catch(Exception E){}
        });

        b4.addActionListener((e)->{System.exit(0);});

        f.setVisible(true);
    }
}