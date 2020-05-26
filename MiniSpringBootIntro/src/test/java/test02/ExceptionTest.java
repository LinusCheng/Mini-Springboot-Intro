package test02;

import MiniSpringBootIntro.exception.BranchNotFoundException;
import MiniSpringBootIntro.service.TransactionTempService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class ExceptionTest {

    private TransactionTempService transactionTempService;

    @Before
    public void before(){
        transactionTempService = new TransactionTempService();
    }


    @Test(expected = BranchNotFoundException.class)
    public void branchNotFoundExceptionTest(){
        transactionTempService.fetchByBranchName("Wakanda");


        // Can use assertThrows() in later version
        Executable executable = () ->  transactionTempService.fetchByBranchName("Wakanda");
        // Assert.assertThrows(BranchNotFoundException,executable);

    }

}
