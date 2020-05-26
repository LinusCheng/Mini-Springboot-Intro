package MiniSpringBootIntro.service;

import MiniSpringBootIntro.api.request.TransactionTempReq;
import MiniSpringBootIntro.api.response.TransactionTempResp;
import MiniSpringBootIntro.constance.BranchIdMap;
import MiniSpringBootIntro.dao.TransactionTempDao;
import MiniSpringBootIntro.exception.BranchNotFoundException;
import MiniSpringBootIntro.model.TransactionTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
public class TransactionTempService {

    @Autowired
    TransactionTempDao transactionTempDao;
    private Random random = new Random();
    private final String digitSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* ===== CREATE ===== */
    public Boolean newTransaction(TransactionTempReq transactionTempReq){

        if (!BranchIdMap.branchExists(transactionTempReq.getBranchName())){
            throw new BranchNotFoundException("Invalid Branch Name: " + transactionTempReq.getBranchName());
        }

        TransactionTemp transactionTemp = TransactionTemp.builder()
                .rootTxnId(rootTxnIdGenerator())
                .branchId(BranchIdMap.getBranchId(transactionTempReq.getBranchName()))
                .paymentContent(dummyPaymentContentEncoder(transactionTempReq))
                .build();

        return transactionTempDao.create(transactionTemp);
    }

    public Boolean firstTransaction(){
        return transactionTempDao.create0();
    }


    /* ===== READ ===== */
    public List<TransactionTemp> fetchAll(){
        return transactionTempDao.fetchAll();
    }

    public List<TransactionTempResp> fetchByBranchName(String branchName) {

        if (BranchIdMap.branchExists(branchName)){
            List<TransactionTemp> transactionTemps = transactionTempDao.fetchAllByBranchId(BranchIdMap.getBranchId(branchName));
            if (transactionTemps.size()>0){
                return transactionTemps.stream().map(a->TransactionTempResp.builder()
                        .rootTxnId(a.getRootTxnId())
                        .branchId(a.getBranchId())
                        .initDate(a.getInitDate().toString() + " TimeZone: " + TimeZone.getDefault().getID())
                        .paymentContent(a.getPaymentContent())
                        .build()
                ).collect(Collectors.toList());
            }
            return null;
        } else {
            throw new BranchNotFoundException("Invalid Branch Name: " + branchName);
        }
    }


    /* ===== DELETE ===== */
    public boolean deleteByRootTxnId(String rootTxnId){
        return transactionTempDao.deleteByRootTxnId(rootTxnId);
    }

    public boolean deleteAll(){
        return transactionTempDao.deleteAll();
    }



    private String rootTxnIdGenerator(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<27;i++){
            if (i==6 || i==13 || i==20){
                sb.append("-");
            }
            else {
                sb.append(digitSet.charAt(random.nextInt(digitSet.length())));
            }
        }
        return sb.toString();
    }

    private String dummyPaymentContentEncoder(TransactionTempReq transactionTempReq){
        return "5b6636f91f89bbf9da235eaa53c001c3fab2c976f4cae1a8c772540e4431d91ba36c6242f9a07a94680a6c7789c8d50e282be8e52378956dd761bb05bdf52b8a85d438aaf985f70b5bcd3a6e6b92f4c877a562c98420cef7e6ce802a73514746";
    }

}
