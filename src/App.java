import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by finn on 05/12/16.
 */
public class App extends JFrame {

    private JPanel panel1;
    private JButton newTLXButton;
    private JButton analyzeButton;

    public App() {
        newTLXButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Input tlxInput = new Input();
                tlxInput.setVisible(true);
            }
        });

        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Analysis tlxAnalysis = new Analysis();
                tlxAnalysis.setVisible(true);
            }
        });

        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }

}
