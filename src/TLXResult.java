import java.util.Date;
import java.io.Serializable;

/**
 * Created by Stephan on 05.12.16.
 */
public class TLXResult implements Serializable {

    private int mdSliderValue;
    private int pdSliderValue;
    private int tdSliderValue;
    private int opSliderValue;
    private int efSliderValue;
    private int frSliderValue;

    private int mdCount;
    private int pdCount;
    private int tdCount;
    private int opCount;
    private int frCount;
    private int efCount;

    private String date;

    public TLXResult(int mdSliderValue, int pdSliderValue, int tdSliderValue,
                     int opSliderValue, int efSliderValue, int frSliderValue,
                     int mdCount, int pdCount, int tdCount, int opCount, int frCount, int efCount ) {

        this.mdSliderValue = mdSliderValue;
        this.pdSliderValue = pdSliderValue;
        this.tdSliderValue = tdSliderValue;
        this.opSliderValue = opSliderValue;
        this.efSliderValue = efSliderValue;
        this.frSliderValue = frSliderValue;

        this.mdCount = mdCount;
        this.pdCount = pdCount;
        this.tdCount = tdCount;
        this.opCount = opCount;
        this.frCount = frCount;
        this.efCount = efCount;

        date = new Date().toString();

        System.out.println("New result added");
    }

    public int getResultSum() {
        return mdSliderValue * mdCount +
                pdSliderValue * pdCount +
                tdSliderValue * tdCount +
                opSliderValue * opCount +
                efSliderValue * efCount +
                frSliderValue * frCount;
    }

    public int getWeights() {
        return mdCount+pdCount+tdCount+opCount+efCount+frCount;
    }

    public int getResultAverage() {
        return (int) (getResultSum() / getWeights());
    }

    public String getDate() {
        return this.date;
    }

    public int getMdSliderValue() {
        return this.mdSliderValue;
    }

    public int getPdSliderValue() {
        return this.pdSliderValue;
    }

    public int getTdSliderValue() {
        return this.tdSliderValue;
    }

    public int getOpSliderValue() {
        return this.opSliderValue;
    }

    public int getEfSliderValue() {
        return this.efSliderValue;
    }

    public int getFrSliderValue() {
        return this.frSliderValue;
    }
}
