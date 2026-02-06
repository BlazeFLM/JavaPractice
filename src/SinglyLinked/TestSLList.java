package SinglyLinked;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSLList {
    public static void main(String[] args){
        new TestSLList().tests();
    }

    @Test
    void tests(){
        SLList<Integer> myList = new SLList<>();
        myList.addFirst(67);
        myList.addFirst(23);

        assertEquals(23, myList.get(0));
        assertEquals(67, myList.get(1));

        SLList<String> ppl = new SLList<>();
        ppl.addFirst("Stupid");
        ppl.addLast("buddy");
        ppl.addFirst("Bobby");

        assertEquals("Stupid", ppl.get(1));


//        SLList myList = new SLList(23);
//        myList.addFirst(67);
//        myList.addLast(90);
//
//        assertEquals(3, myList.size());
//        assertEquals(67, myList.get(0));
//        assertEquals(23, myList.get(1));
//        assertEquals(90, myList.get(2));


//        assertEquals(23, myList.get(0));
//
//        myList.addFirst(2);
//        assertEquals(2, myList.get(0));
//
//        //assertEquals(myList.fdsfsf, myList.getNode(23));
//        myList.addFirst(67);
//        assertEquals(3, myList.size());



    }
}
