package MiniSpringBootIntro.api.request;

import lombok.Getter;

@Getter
public class TransactionTempReq {

    private String branchName;
    private double amount;
    private String currency;
    private String sender;
    private String receiver;

}
