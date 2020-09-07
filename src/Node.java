import java.util.ArrayList;
import java.util.List;

public class Node {
    Node(){
        children = new ArrayList<Node>();
    }
    double value;
    String sValue;
    List<Node> children;

    public double getValue(CovidDataObject obj)
    {
        return value;
    }
}
