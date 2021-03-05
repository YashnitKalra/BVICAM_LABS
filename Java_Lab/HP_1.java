import java.awt.*;
import java.awt.event.*;


class MessageBox extends Dialog{
    MessageBox(String message){
        super(new Frame(),"Alert");
        setLayout(new FlowLayout());
        setSize(300, 100);
        add(new Label(message));
        Button okButton = new Button("Ok");
        okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Ok button pressed");
            }
        });
        add(okButton);
        Button cancelButton = new Button("Cancel");
        cancelButton.addActionListener((e)->{
            System.out.println("Cancel Button Pressed");
            System.exit(0);
        });
        add(cancelButton);
        setVisible(true);

    }
} 

public class HP_1 {
    public static void main(String[] args) {
        new MessageBox("Hello World");
    }
}
