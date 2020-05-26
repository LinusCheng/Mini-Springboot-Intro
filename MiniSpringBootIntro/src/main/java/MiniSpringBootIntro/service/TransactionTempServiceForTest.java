package MiniSpringBootIntro.service;

import MiniSpringBootIntro.constance.BranchIdMap;
import MiniSpringBootIntro.dao.TransactionTempDao;
import MiniSpringBootIntro.exception.BranchNotFoundException;
import MiniSpringBootIntro.model.TransactionTemp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class TransactionTempServiceForTest {

    TransactionTempDao transactionTempDao;

    public List<TransactionTemp> fetchByBranchName(String branchName) throws BranchNotFoundException {

        if (BranchIdMap.branchExists(branchName)){
            return transactionTempDao.fetchAllByBranchId(BranchIdMap.getBranchId(branchName));
        } else {
            throw new BranchNotFoundException("Invalid Branch Name: " + branchName);
        }
    }


}
