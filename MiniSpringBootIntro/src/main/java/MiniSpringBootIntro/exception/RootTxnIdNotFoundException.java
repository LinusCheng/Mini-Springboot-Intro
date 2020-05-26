package MiniSpringBootIntro.exception;

public class RootTxnIdNotFoundException extends RuntimeException{

    public RootTxnIdNotFoundException(String e) {
        super(e);
    }

}
