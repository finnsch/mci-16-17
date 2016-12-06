import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
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
    private JButton saveTestResultsButton;

    private ResultsDatabase resultsDatabase = ResultsDatabase.getInstance();

    public Input() {
        setTitle("TLX Input");
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        saveTestResultsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ArrayList<Enumeration> buttonGroupList = new ArrayList<>();
                int mdCount = 0, pdCount = 0, tdCount = 0, opCount = 0, frCount = 0, efCount = 0;

                buttonGroupList.add(efFRButtonGroup.getElements());
                buttonGroupList.add(opEFButtonGroup.getElements());
                buttonGroupList.add(opFRButtonGroup.getElements());
                buttonGroupList.add(tdEFButtonGroup.getElements());
                buttonGroupList.add(tdFRButtonGroup.getElements());
                buttonGroupList.add(tdOPButtonGroup.getElements());
                buttonGroupList.add(efPDButtonGroup.getElements());
                buttonGroupList.add(frPDButtonGroup.getElements());
                buttonGroupList.add(opPDButtonGroup.getElements());
                buttonGroupList.add(tdPDButtonGroup.getElements());
                buttonGroupList.add(efMDButtonGroup.getElements());
                buttonGroupList.add(frMDButtonGroup.getElements());
                buttonGroupList.add(opMDButtonGroup.getElements());
                buttonGroupList.add(tdMDButtonGroup.getElements());
                buttonGroupList.add(pdMDButtonGroup.getElements());

                int selectCounter = 0; //to see if all buttons are filled out

                for(Enumeration elements: buttonGroupList )
                    while (elements.hasMoreElements()) {
                        AbstractButton button = (AbstractButton) elements.nextElement();
                        if (button.isSelected()) {
                            selectCounter++;
                            switch (button.getText()) {
                                case "Mental D.":
                                    mdCount++;
                                    break;
                                case "Physical D.":
                                    pdCount++;
                                    break;
                                case "Temporal D.":
                                    tdCount++;
                                    break;
                                case "Performance":
                                    opCount++;
                                    break;
                                case "Effort":
                                    efCount++;
                                    break;
                                case "Frustration":
                                    frCount++;
                                    break;
                                default:
                                    System.out.println("Ohoh, something is horribly wrong!!");
                            }
                        }
                    }

                if(selectCounter == 15) {
                    TLXResult result = new TLXResult(
                            mdSlider.getValue(), pdSlider.getValue(), tdSlider.getValue(),
                            opSlider.getValue(), efSlider.getValue(), frSlider.getValue(),
                            mdCount, pdCount, tdCount, opCount, frCount, efCount);
                    resultsDatabase.add(result);
                    JOptionPane.showMessageDialog(null, "Thank You for participating in this wonderful survey!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Ohoh, make sure you filled out all weights!", "You did something wrong!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

}