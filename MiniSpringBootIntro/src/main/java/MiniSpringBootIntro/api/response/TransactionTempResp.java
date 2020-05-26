package MiniSpringBootIntro.api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionTempResp {

    private String rootTxnId;
    private String branchId;
    private String initDate;
    private String paymentContent;
}
