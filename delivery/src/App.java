import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;

/**
 * Created by finn on 05/12/16.
 *
 * This is the main class of the application. It also represents the main menu from which
 * all other forms are called.
 *
 */
public class App extends JFrame {

    private JPanel panel1;
    private JButton newTLXButton;
    private JButton analyzeButton;
    private JButton saveResultsButton;
    private JButton loadResultsButton;

    private ResultsDatabase resultsDatabase = ResultsDatabase.getInstance();

    private String resultsFilename = "results.ser";

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

        loadResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTestResultsFromFile();
            }
        });

        saveResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(resultsDatabase.resultCount() != 0) {
                    saveTestResultsToFile();
                } else {
                    JOptionPane.showMessageDialog(null, "There are no results to save!", "No results!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadTestResultsFromFile() {
        ArrayList<TLXResult> resultList = new ArrayList<>();

        InputStream fis = null;

        try {
            fis = new FileInputStream(resultsFilename);
            ObjectInputStream o = new ObjectInputStream(fis);
            resultList = (ArrayList<TLXResult>) o.readObject();
        }
        catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                JOptionPane.showMessageDialog(null, "No results found");
            }

            System.err.println(e);
        }
        catch (ClassNotFoundException e) { System.err.println(e); }
        finally {
            try {
                fis.close();

                JOptionPane.showMessageDialog(null, "Imported " + resultList.size() + " test result(s)");

                ResultsDatabase.getInstance().setResultList(resultList);
            } catch ( Exception e ) { e.printStackTrace(); }
        }
    }

    private void saveTestResultsToFile() {
        ArrayList<TLXResult> resultList = ResultsDatabase.getInstance().getResultList();

        OutputStream fos = null;

        try {
            fos = new FileOutputStream(resultsFilename);
            ObjectOutputStream o = new ObjectOutputStream(fos);
            o.writeObject(resultList);
        }
        catch (IOException e) { System.err.println(e); }
        finally {
            try {
                fos.close();

                JOptionPane.showMessageDialog(null, "Saved " + resultList.size() + " test result(s)");
            } catch ( Exception e ) { e.printStackTrace(); }
        }
    }

    public static void main(String[] args) {
        new App();
    }

}
