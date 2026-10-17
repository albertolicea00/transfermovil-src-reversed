package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;

/** @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.OSQajAAbpl */
public class StatisticsResponse extends BaseApiResult {
    public int dayAbort, dayConfirm, dayPend;
    public int devDayAbort, devDayConfim, devDayPend;
    public int devMesAbort, devMesConfirm, devMesPend;
    public int devYearAbort, devYearConfirm, devYearPend;
    public int mesAbort, mesConfirm, mesPend;
    public float statsDay, statsMonth, statsWeek, statsYear;
    public int yearAbort, yearConfirm, yearPend;
}
