import javax.swing.*;

public class HP_2 {
    public static void main(String[] args) {
        String days[] = new String[31];
        for(int i=0;i<days.length;i++)
            days[i] = Integer.toString(i+1);
        String years[] = new String[50];
        for(int i=0;i<years.length;i++)
            years[i] = Integer.toString(1985 + i);
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        JFrame f = new JFrame("HP 2");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,400);
        f.setLayout(null);

        int height = 50, width = 240;
        int buttonHeight = 25, buttonWidth = 100;
        
        JLabel l1 = new JLabel("Name"), l2 = new JLabel("Date of Joining"), l3 = new JLabel("Address");
        l1.setBounds(10, 0, width, height);
        l2.setBounds(10, 76, width, height);
        l3.setBounds(10, 151, width, height);
        f.add(l1); f.add(l2); f.add(l3);

        JTextField tf1 = new JTextField(), tf2 = new JTextField();
        tf1.setBounds(251, 0, width, height);
        tf2.setBounds(251, 151, width, height);
        f.add(tf1); f.add(tf2);

        JComboBox cb1 = new JComboBox(days), cb2 = new JComboBox(months), cb3 = new JComboBox(years);
        cb1.setBounds(251, 76, 75, 25);
        cb2.setBounds(327, 76, 75, 25);
        cb3.setBounds(403, 76, 87, 25);
        f.add(cb1); f.add(cb2); f.add(cb3);

        JButton b1 = new JButton("Display"), b2 = new JButton("Clear");
        b1.setBounds(100, 226, buttonWidth, buttonHeight);
        b2.setBounds(250, 226, buttonWidth, buttonHeight);

        // Display buttong functionality
        b1.addActionListener((e)->{
            JFrame df = new JFrame("Display");
            df.setSize(300,200);
            df.setLayout(null);
            JLabel dl1 = new JLabel("Name: "+tf1.getText()), dl2 = new JLabel(String.format(
                "Date of Joining: %s-%s-%s", days[cb1.getSelectedIndex()], months[cb2.getSelectedIndex()], years[cb3.getSelectedIndex()]
            )), dl3 = new JLabel("Address: "+tf2.getText());
            dl1.setBounds(10, 10, 280, 20);
            dl2.setBounds(10, 40, 280, 20);
            dl3.setBounds(10, 70, 280, 20);
            df.add(dl1); df.add(dl2); df.add(dl3);
            df.setVisible(true);
        });

        // clear button functionality
        b2.addActionListener((e)->{
            tf1.setText(""); tf2.setText(""); cb1.setSelectedIndex(0); cb2.setSelectedIndex(0); cb3.setSelectedIndex(0);
        });

        f.add(b1); f.add(b2);
        f.setVisible(true);
    }
}