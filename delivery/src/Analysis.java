import javax.swing.*;
import java.awt.Dimension;

/**
 * Created by finn on 05/12/16.
 *
 * The Analysis form. Loads all results from the ResultsDatabase.
 *
 */
public class Analysis extends JFrame {
    private JScrollPane scrollPane;
    private ResultsDatabase resultsDatabase = ResultsDatabase.getInstance();

    public Analysis() {
        setTitle("TLX Analysis");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel resultsPanel = new JPanel();
        BoxLayout panelLayout = new BoxLayout(resultsPanel, BoxLayout.Y_AXIS);
        resultsPanel.setLayout(panelLayout);

        scrollPane.setViewportView(resultsPanel);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        scrollPane.setSize(600, 400);
        setContentPane(scrollPane);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);

        if(resultsDatabase.resultCount() != 0) {

            int count = 0;
            for (TLXResult item : resultsDatabase.getResultList()) {
                count++;

                JLabel label = new JLabel("Participant " + count);
                resultsPanel.add(label);

                JLabel labelDate = new JLabel(item.getDate());
                resultsPanel.add(labelDate);

                JLabel label0 = new JLabel(" ");
                resultsPanel.add(label0);

                JLabel labelText = new JLabel("Results: ");
                resultsPanel.add(labelText);

                JLabel mdLabel = new JLabel("MD: " + item.getMdSliderValue());
                resultsPanel.add(mdLabel);

                JLabel pdLabel = new JLabel("PD: " + item.getPdSliderValue());
                resultsPanel.add(pdLabel);

                JLabel tdLabel = new JLabel("TD: " + item.getTdSliderValue());
                resultsPanel.add(tdLabel);

                JLabel opLabel = new JLabel("OP: " + item.getOpSliderValue());
                resultsPanel.add(opLabel);

                JLabel efLabel = new JLabel("EF: " + item.getEfSliderValue());
                resultsPanel.add(efLabel);

                JLabel frLabel = new JLabel("FR: " + item.getFrSliderValue());
                resultsPanel.add(frLabel);

                JLabel label00 = new JLabel(" ");
                resultsPanel.add(label00);

                JLabel sumLabel = new JLabel("Sum: " + item.getResultSum());
                resultsPanel.add(sumLabel);

                JLabel wLabel = new JLabel("Weight: " + item.getWeights());
                resultsPanel.add(wLabel);

                JLabel avgLabel = new JLabel("Average: " + item.getResultAverage());
                resultsPanel.add(avgLabel);

                JSeparator separator = new JSeparator();
                resultsPanel.add(separator);
            }
        } else {
            JLabel labelText = new JLabel("There are no saved Survey Results.");
            resultsPanel.add(labelText);
            JLabel labelText2 = new JLabel("You can create one by clicking on 'New TLX Survey' in the Main Menu.");
            resultsPanel.add(labelText2);

        }
    }
}
