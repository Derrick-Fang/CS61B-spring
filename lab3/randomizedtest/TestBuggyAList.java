package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                broken.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeB = broken.size();
            } else if(operationNumber == 2){
                int ele = 0;
                if (L.size() != 0) {
                    ele = L.getLast();
                }
            } else if (operationNumber == 3){
                int randVal = StdRandom.uniform(0, L.size());
                int ele = 0;
                if (L.size()!=0)
                    ele = L.get(randVal);
            } else if (operationNumber == 4){
                if (L.size() !=0){
                    L.removeLast();
                }
            } else if (operationNumber == 5){

            }

        }
    }
}
