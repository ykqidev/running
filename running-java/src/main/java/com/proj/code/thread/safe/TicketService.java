package com.proj.code.thread.safe;

import java.util.ArrayList;

public class TicketService {

    ArrayList<String> arrayList = new ArrayList<>();

    {
        arrayList.add("01车01A");
        arrayList.add("01车01B");
        arrayList.add("01车01C");
        arrayList.add("01车01D");
        arrayList.add("01车01F");

        arrayList.add("02车01A");
        arrayList.add("02车02B");
        arrayList.add("02车03C");
        arrayList.add("02车04D");
        arrayList.add("02车05F");

//        for (int i = 0; i < 1000; i++) {
//            arrayList.add("02车05F" + i);
//        }
    }


    public boolean hasTicket() {
        return arrayList.size() > 0;
    }

    public String sale() {
        return arrayList.remove(0);
    }

}
