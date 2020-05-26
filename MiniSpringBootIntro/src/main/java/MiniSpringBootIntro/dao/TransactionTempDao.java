package MiniSpringBootIntro.dao;

import MiniSpringBootIntro.constance.TransactionFields;
import MiniSpringBootIntro.exception.RootTxnIdNotFoundException;
import MiniSpringBootIntro.model.TransactionTemp;
import com.datastax.driver.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static MiniSpringBootIntro.constance.Queries.*;

@Component
public class TransactionTempDao {

    @Autowired
    Session session;
    private Date date = new Date();


    /* ===== CREATE ===== */
    public boolean create(TransactionTemp transactionTemp){

        Timestamp timestamp = new Timestamp(date.getTime());

        Map<String,Object> fields = new HashMap<String,Object>(){{
            put(TransactionFields.ROOT_TX_ID.getValue(),transactionTemp.getRootTxnId());
            put(TransactionFields.BRANCH_ID.getValue(),transactionTemp.getBranchId());
            put(TransactionFields.INIT_DATE.getValue(),timestamp);
            put(TransactionFields.PAYMENT_CONTENT.getValue(),transactionTemp.getPaymentContent());
        }};
        return session.execute(TX_TMP_INSERT,fields).wasApplied();
    }

    public boolean create0(){
//        ResultSet resultSet = session.execute(TX_TMP_INSERT_ONE);
        return session.execute(TX_TMP_INSERT_ONE).wasApplied();
    }

    /* ===== READ ===== */
    public List<TransactionTemp> fetchAll(){
        ResultSet resultSet = session.execute(TX_TMP_FETCH_ALL);
        return resultSet2TransactionTemps(resultSet);
    }

    public List<TransactionTemp> fetchAllByBranchId(String branchId){
        ResultSet resultSet = session.execute(TX_TMP_FETCH_BY_BRANCHID,branchId);
        return resultSet2TransactionTemps(resultSet);
    }

    /* ===== DELETE ===== */
    public boolean deleteByRootTxnId(String rootTxnId){
        if (session.execute(TX_TMP_FETCH_BY_ROOT_TX_ID,rootTxnId).all().size()>0){
            return session.execute(TX_TMP_DELETE_BY_ROOT_TX_ID,rootTxnId).wasApplied();
        } else {
            throw new RootTxnIdNotFoundException("root_txn_id does not exist");
        }
    }

    public boolean deleteAll(){
        return session.execute(TX_TMP_DELETE_ALL).wasApplied();
    }



    private List<TransactionTemp> resultSet2TransactionTemps(ResultSet resultSet) {
        if (resultSet!=null){
            List<Row> all = resultSet.all();
            return all.stream().map(row ->TransactionTemp.builder()
                    .rootTxnId(row.getString(TransactionFields.ROOT_TX_ID.getValue()))
                    .branchId(row.getString(TransactionFields.BRANCH_ID.getValue()))
                    .initDate( new Timestamp(
                            row.getTimestamp(TransactionFields.INIT_DATE.getValue()).getTime()
                            )
                    )
                    .paymentContent(row.getString(TransactionFields.PAYMENT_CONTENT.getValue()))
                    .build()
            ).collect(Collectors.toList());
        }
        return null;
    }





}
