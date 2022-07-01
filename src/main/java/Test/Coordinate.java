package Test;

import java.util.ArrayList;
import java.util.List;

public final class Coordinate {
    private List<String> list;

    public Coordinate(List<String> list){
        if(null != list){
            this.list = new ArrayList<>();
            for(String s : list){
                this.list.add(s);
            }
        }
    }

    public List<String> getList() {
        return list;
    }
}
