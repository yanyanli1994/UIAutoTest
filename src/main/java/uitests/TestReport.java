package uitests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestReport {
    @Test
    public void test(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test11(){
        Assert.assertEquals(1,2);
    }
}
