import javax.swing.*;

/**
 * Created by finn on 05/12/16.
 */
public class Analysis extends JFrame {
    private JTable table1;
    private JPanel panel1;

    public Analysis() {
        setTitle("TLX Analysis");
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
