package test02;

import MiniSpringBootIntro.dao.TransactionTempDao;
import MiniSpringBootIntro.model.TransactionTemp;
import MiniSpringBootIntro.service.TransactionTempServiceForTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
public class MockSomething {

    @Mock
    TransactionTempDao transactionTempDao;

    private TransactionTempServiceForTest transactionTempServiceForTest;

    @Before
    public void before(){
        transactionTempServiceForTest = new TransactionTempServiceForTest(transactionTempDao);

        Date date = new Date();

        List<TransactionTemp> transactionTemps = new ArrayList<TransactionTemp>(){{
            add(TransactionTemp.builder()
                    .rootTxnId("BUJBFE-R2QXLN-KPSPSG-5K5IHI")
                    .branchId("100598888")
                    .initDate(new Timestamp(date.getTime()))
                    .paymentContent("Some contents")
                    .build()
            );
        }};
        Mockito.when(transactionTempDao.fetchAllByBranchId(Mockito.anyString())).thenReturn(transactionTemps);
    }


    @Test
    public void matchSomething(){
        Assert.assertEquals(1,transactionTempServiceForTest.fetchByBranchName("LA").size());
    }

}
