package ro.mycode.mobilamanagement.Exceptii;

public class ExceptieObiectExistent extends RuntimeException{

    public ExceptieObiectExistent() {
        super("Acest obiect exte deja in baza de date!!");
    }
}
