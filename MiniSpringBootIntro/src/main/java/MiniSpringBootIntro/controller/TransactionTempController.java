package MiniSpringBootIntro.controller;

import MiniSpringBootIntro.api.request.TransactionTempReq;
import MiniSpringBootIntro.api.response.TransactionTempResp;
import MiniSpringBootIntro.exception.EmptyParamException;
import MiniSpringBootIntro.service.TransactionTempService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class TransactionTempController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionTempController.class);

    @Autowired
    TransactionTempService transactionTempService;
    private ObjectMapper mapper = new ObjectMapper();


    /* ===== CREATE ===== */
    @PostMapping("/Transaction")
    public String newTransaction(@RequestBody TransactionTempReq transactionTempReq){
        logger.info("POST req: newTransaction, branch:" + transactionTempReq.getBranchName().toUpperCase());
        if (transactionTempService.newTransaction(transactionTempReq)) return "New Transaction Added";
        return "Failed to add new transaction";

    }


    @PostMapping("/firstTransaction")
    public String firstTransaction(){
        logger.info("POST req: firstTransaction");
        if (transactionTempService.firstTransaction()) return "First Transaction Added";
        return "Failed to add new transaction";

    }

    /* ===== READ ===== */
    //Without using response model
    @GetMapping("/Transactions")
    public JsonNode fetchAll() throws IOException {
        logger.info("GET  req: fetchAll");
        String jsonStr = mapper.writeValueAsString(transactionTempService.fetchAll());
        return mapper.readTree(jsonStr);
    }

    //Using response model
    @GetMapping("/Transactions/{branchName}")
    public List<TransactionTempResp> fetchByBranchName(@PathVariable String branchName) {
        logger.info("GET  req: fetchByBranchName: " + branchName.toUpperCase());
        return transactionTempService.fetchByBranchName(branchName);
    }


    /* ===== DELETE ===== */
    @DeleteMapping("/Transactions/{rootTxnId}")
    public String deleteByRootTxnId(@PathVariable String rootTxnId){
        logger.info("DELETE req: deleteByRootTxnId: " + rootTxnId.toUpperCase());
        if (transactionTempService.deleteByRootTxnId(rootTxnId)) return "Transaction with Root_Txn_Id: " + rootTxnId + " has been deleted";
        return "Failed to delete transactions";    }

    @DeleteMapping("/Transactions")    // for "/Transactions" and "/Transactions/" Change StatusCode from 403 to 500
    public String delete(){
        logger.error("Client did not include rootTxnId");
        throw new EmptyParamException("Please provide a valid Root_Txn_Id");
    }

    @DeleteMapping("/cleanTransactions")
    public String deleteAll(){
        logger.info("DELETE req: deleteALL");
        if (transactionTempService.deleteAll()) return "All transactions have been deleted";
        return "Failed to delete transactions";    }



}
