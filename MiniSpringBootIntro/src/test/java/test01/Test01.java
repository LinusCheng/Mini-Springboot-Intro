package test01;

import org.junit.Assert;
import org.junit.Test;
import java.sql.Timestamp;
import java.util.Date;

public class Test01 {

    @Test
    public void test01_1(){
        int one = 1;
        Assert.assertEquals(1,one);
        Assert.assertTrue(true);
    }

    @Test
    public void createTimestamp(){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(timestamp);
    }


}
