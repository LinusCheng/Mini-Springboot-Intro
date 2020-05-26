package MiniSpringBootIntro.constance;

public class Queries {

    public static final String TX_TMP_FETCH_ALL =
        "SELECT * FROM transaction_tmp;";

    public static final String TX_TMP_FETCH_BY_BRANCHID =
            "SELECT * FROM transaction_tmp WHERE branch_id = ? ALLOW FILTERING;";

    public static final String TX_TMP_FETCH_BY_ROOT_TX_ID =
            "SELECT * FROM transaction_tmp WHERE root_txn_id = ?;";

    public static final String TX_TMP_INSERT_ONE =
        "INSERT INTO transaction_tmp (root_txn_id, branch_id, init_date, payment_content) VALUES (" +
        "'3E94R5-005312-7J2T4A-68H7F8',"+
        "'100586772',"+
        "'2020-05-20T11:18:31-0500',"+
        "'5b6636f91f89bbf9da235eaa53c001c3fab2c976f4cae1a8c772540e4431d91ba36c6242f9a07a94680a6c7789c8d50e282be8e52378956dd761bb05bdf52b8a85d438aaf985f70b5bcd3a6e6b92f4c877a562c98420cef7e6ce802a73514746'"+
        ");";

    public static final String TX_TMP_INSERT =
        "INSERT INTO transaction_tmp (root_txn_id, branch_id, init_date, payment_content) VALUES (?,?,?,?);";

    // Not able to do this in Cassandra
    public static final String TX_TMP_DELETE_BY_BRANCHID =
        "DELETE FROM transaction_tmp WHERE branch_id = ?;";

    public static final String TX_TMP_DELETE_BY_ROOT_TX_ID =
            "DELETE FROM transaction_tmp WHERE root_txn_id = ?;";

    public static final String TX_TMP_DELETE_ALL =
            "TRUNCATE transaction_tmp;";


}
