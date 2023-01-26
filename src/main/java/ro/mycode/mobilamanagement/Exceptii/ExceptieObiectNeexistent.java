package ro.mycode.mobilamanagement.Exceptii;

public class ExceptieObiectNeexistent extends RuntimeException{

    public ExceptieObiectNeexistent() {
        super("Acest obiect nu exista in baza de date!!");
    }
}
