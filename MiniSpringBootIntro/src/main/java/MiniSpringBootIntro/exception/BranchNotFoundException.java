package MiniSpringBootIntro.exception;

public class BranchNotFoundException extends RuntimeException{

    public BranchNotFoundException(String e) {
        super(e);
    }

}
