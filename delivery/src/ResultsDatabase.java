import java.util.ArrayList;

/**
 * Created by Stephan on 05.12.16.
 *
 * This is the singleton database, which handles all results. They get saved in a list which accepts TLXResult objects
 *
 */
public class ResultsDatabase {

    private static ResultsDatabase instance;

    private ArrayList<TLXResult> resultList = new ArrayList<>();

    private ResultsDatabase () {}

    public static ResultsDatabase getInstance () {
        if (ResultsDatabase.instance == null) {
            ResultsDatabase.instance = new ResultsDatabase ();
        }
        return ResultsDatabase.instance;
    }

    public void add(TLXResult item) {
        resultList.add(item);
    }

    public ArrayList<TLXResult> getResultList() {
        return this.resultList;
    }

    public int resultCount() {
        return resultList.size();
    }

    public void setResultList(ArrayList<TLXResult> resultList) {
        this.resultList = resultList;
    }

}
