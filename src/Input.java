import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by finn on 04/12/16.
 */
public class Input extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    // Weighting
    private ButtonGroup efFRButtonGroup;
    private ButtonGroup opEFButtonGroup;
    private ButtonGroup opFRButtonGroup;
    private ButtonGroup tdEFButtonGroup;
    private ButtonGroup tdFRButtonGroup;
    private ButtonGroup tdOPButtonGroup;
    private ButtonGroup efPDButtonGroup;
    private ButtonGroup frPDButtonGroup;
    private ButtonGroup opPDButtonGroup;
    private ButtonGroup tdPDButtonGroup;
    private ButtonGroup efMDButtonGroup;
    private ButtonGroup frMDButtonGroup;
    private ButtonGroup opMDButtonGroup;
    private ButtonGroup tdMDButtonGroup;
    private ButtonGroup pdMDButtonGroup;
    // Rating
    private JSlider mdSlider;
    private JSlider pdSlider;
    private JSlider tdSlider;
    private JSlider opSlider;
    private JSlider efSlider;
    private JSlider frSlider;

    public Input() {
        setTitle("TLX Input");
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}