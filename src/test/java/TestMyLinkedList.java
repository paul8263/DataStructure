import com.paultech.MyLinkedList;
import com.paultech.MyList;
import org.junit.Assert;
import org.junit.Test;

public class TestMyLinkedList {

    @Test
    public void test() {
        MyList<Integer> integerMyList = new MyLinkedList<>();
        integerMyList.add(10);
        integerMyList.add(20);
        integerMyList.add(30);

        Assert.assertEquals(integerMyList.size(), 3);
        Assert.assertEquals(integerMyList.get(2).intValue(), 30);

        Assert.assertNull(integerMyList.get(5));
        integerMyList.remove(0);
        Assert.assertEquals(integerMyList.get(1).intValue(), 20);
    }
}
