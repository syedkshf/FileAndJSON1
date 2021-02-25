import java.util.HashMap;
import java.util.Map;

public class Database {
    private String[] colNames;
    private int numRows;
    private String[][] data;
    private int numCols;
    Map<String, Integer> colRef = new HashMap<String, Integer>();

    public String[] getColNames() {
        return colNames;
    }

    public void setColNames(String[] colNames) {
        this.colNames = colNames;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public Database(String contents) {
        /* TODO This constructor should take the contents of a CSV file and initialize the memember variables of the Database class. */
        String[] eachLine = contents.split("\n");

        colNames = eachLine[0].split(",");
        numRows = eachLine.length - 1;
        numCols = colNames.length;

        data = new String[numRows][numCols];
        for (int i = 1; i < eachLine.length; i++) {
            String[] dataPiece = eachLine[i].split(",");
            for (int j = 0; j < dataPiece.length; j++) {
                data[i - 1][j] = dataPiece[j];
                colRef.put(colNames[j], j);
            }
        }

    }

    public String getValue(String columnName, int row) {
        int col = colRef.get(columnName);
        String value = data[row][col];
        return value;
    }

}