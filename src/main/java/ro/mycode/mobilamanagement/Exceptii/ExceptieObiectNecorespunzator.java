package ro.mycode.mobilamanagement.Exceptii;

public class ExceptieObiectNecorespunzator extends RuntimeException{

    public ExceptieObiectNecorespunzator() {
        super("Niciun obiect nu corespunde cerintelor tale!!");
    }
}
