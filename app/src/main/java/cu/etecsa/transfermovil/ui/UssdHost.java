package cu.etecsa.transfermovil.ui;

/** Activity contract used by clean screens that initiate an existing USSD route. */
public interface UssdHost {
    void actionCallUSSD(String codeService);
}
