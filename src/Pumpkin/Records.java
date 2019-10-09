package Pumpkin;

import java.util.ArrayList;
import java.util.List;

public class Records<T> extends ArrayList<T> {

    public List<T> precedingRecordSublist(T record, int precedingRecordAmount){
        int currentIndex = this.indexOf(record);

        List<T> recordHistoryList = new ArrayList<>();

        if(precedingRecordAmount > currentIndex){
            for (int i = 0; i <= currentIndex; i++) {
                recordHistoryList.add(this.get(i));
            }
        }else{
            for (int i = currentIndex - precedingRecordAmount + 1; i <= currentIndex; i++) {
                recordHistoryList.add(this.get(i));
            }
        }

        return recordHistoryList;
    }





}
