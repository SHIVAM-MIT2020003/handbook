package design_pattern.factory;

interface Spot{
    public void getDetails();
}

class CompactSpot implements Spot{
    public void getDetails(){}
}

class Large implements Spot{
    public void getDetails(){}
}

class SpotFactory{
    Spot getSpot(String p){
        if(p.equalsIgnoreCase("CompactSpot")) return new CompactSpot();
        else if(p.equalsIgnoreCase("Large")) return new Large();
        return null;
    }
}


public class Solution {
}

