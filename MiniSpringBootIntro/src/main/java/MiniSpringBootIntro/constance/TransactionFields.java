package MiniSpringBootIntro.constance;

import lombok.Getter;

@Getter
public enum TransactionFields {
    ROOT_TX_ID("root_txn_id"),
    BRANCH_ID("branch_id"),
    INIT_DATE("init_date"),
    PAYMENT_CONTENT("payment_content");

    private final String value;
    TransactionFields(String val) {value = val;}

}
