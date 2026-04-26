package ArrayList;

import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

public class TestAList {
    @Test
    public void testAList(){
        AList list = new AList();
        assertThat(list.size()).isEqualTo(0);

        list.addLast(231);
        list.addLast(909);
        list.addLast(392);

        assertThat(list.size()).isEqualTo(3);
        int posThree = list.get(2);
        assertThat(posThree).isEqualTo(392);


    }
}
