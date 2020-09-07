public class CovidDataObject {
    CovidDataObject(String p, String c, String la,String lo,
                    String _x1,String _x2,String _x3,String _x4,String _x5,String _y){
        Province = p;
        Country = c;
        Lat = la;
        Long = lo;
        x1 = _x1;
        x2 = _x2;
        x3 = _x3;
        x4 = _x4;
        x5 = _x5;
        y = _y;
    }
    String Province,Country,Lat,Long,x1,x2,x3,x4,x5,y;
}
