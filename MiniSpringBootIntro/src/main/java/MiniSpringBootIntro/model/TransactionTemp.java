package MiniSpringBootIntro.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
//import java.util.Date;


@Data
@Builder
public class TransactionTemp {

    private String rootTxnId;
    private String branchId;
    private Timestamp initDate;
    private String paymentContent;

}
