package javaBasics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: xinghaifang
 * Date: 2019/12/16
 * Time: 11:56
 */
public class IndexConstantTableName {
    public static Map<String,String> ehrEmrTableList = new HashMap<>();
    public static final int BOTH = 0;
    public static final int ONLY_EMPI = 1;
    public static final int ONLY_INDEX = 2;
    //静态代码块,自动执行;
    static {
        //儿童保健 Child
        ehrEmrTableList.put("cdhCheckup", "child");
        ehrEmrTableList.put("cdhScreeningrecord", "child");
        ehrEmrTableList.put("cdhNutritionaldiseases", "child");
        ehrEmrTableList.put("cdhDeadregister", "child");
        ehrEmrTableList.put("cdhBirthmedicine", "child");

        // 疾病控制control
        ehrEmrTableList.put("dcVaccination", "control");
        ehrEmrTableList.put("dcAidsprevention", "control");
        ehrEmrTableList.put("dcSchistosomiasis", "control");
        ehrEmrTableList.put("dcChronicfilariasis", "control");
        ehrEmrTableList.put("dcTbrecord", "control");
        ehrEmrTableList.put("dcRiskbehavioral", "control");
        ehrEmrTableList.put("dcInfectiousdiseases", "control");
        ehrEmrTableList.put("dcPesticidepoisoning", "control");
        ehrEmrTableList.put("dcDeathrecord", "control");
        ehrEmrTableList.put("dcDamagedetection", "control");
        ehrEmrTableList.put("dcOccupationaldisease", "control");
        ehrEmrTableList.put("dcOccupationalhealth", "control");


        // 疾病管理manage
        ehrEmrTableList.put("mdcTumourrecord", "manage");
        ehrEmrTableList.put("mdcHypertensionmedicine", "manage");
        ehrEmrTableList.put("psychosisrecord", "manage");
        ehrEmrTableList.put("psychosismedicine", "manage");
        ehrEmrTableList.put("mdcHypertesiorecord", "manage");
        ehrEmrTableList.put("mdcOldpeoplevisit", "manage");
        ehrEmrTableList.put("mdcOldpeoplerecord", "manage");
        ehrEmrTableList.put("mdcOldpeoplemedicine", "manage");
        ehrEmrTableList.put("dmHepatitisb", "manage");
        ehrEmrTableList.put("mdcDiabetesvisit", "manage");
        ehrEmrTableList.put("mdcDiabetesmedicine", "manage");
        ehrEmrTableList.put("mdcTumourvisit", "manage");
        ehrEmrTableList.put("mdcHypertensionvisit", "manage");
        ehrEmrTableList.put("mdcDiabetesrecord", "manage");
        ehrEmrTableList.put("psychosisvisit", "manage");


        // 医疗服务medserv
        ehrEmrTableList.put("opApplyInfo", "medserv");
        ehrEmrTableList.put("inhOuthos", "medserv");
        ehrEmrTableList.put("lisReportInfo", "medserv");
        ehrEmrTableList.put("mrmFrontpage", "medserv");
        ehrEmrTableList.put("optBloodtransfusionr", "medserv");
        ehrEmrTableList.put("lisReportAuti", "medserv");
        ehrEmrTableList.put("inhSettle", "medserv");
        ehrEmrTableList.put("emrOuthrecord", "medserv");
        ehrEmrTableList.put("emrInhrecord", "medserv");
        ehrEmrTableList.put("inhSettleDetail", "medserv");
        ehrEmrTableList.put("medDispense", "medserv");
        ehrEmrTableList.put("mrmFee", "medserv");
        ehrEmrTableList.put("cliRegister", "medserv");
        ehrEmrTableList.put("mrmOperation", "medserv");
        ehrEmrTableList.put("risReportInfo", "medserv");
        ehrEmrTableList.put("mrmDiagnosis", "medserv");
        ehrEmrTableList.put("opRecordInfo", "medserv");
        ehrEmrTableList.put("inhDiag", "medserv");
        ehrEmrTableList.put("cliRecipe", "medserv");
        ehrEmrTableList.put("inhInhos", "medserv");
        ehrEmrTableList.put("risRegInfo", "medserv");
        ehrEmrTableList.put("inhOrders", "medserv");
        ehrEmrTableList.put("lisReportBacteria", "medserv");
        ehrEmrTableList.put("cliSeerecord", "medserv");
        ehrEmrTableList.put("cliFeeDetail", "medserv");
        ehrEmrTableList.put("mpiBabyinfo", "medserv");
        ehrEmrTableList.put("cliDiagnose", "medserv");
        ehrEmrTableList.put("lisReportDetail", "medserv");
        ehrEmrTableList.put("optDeathrecords", "medserv");
        ehrEmrTableList.put("cliFeeInvoice", "medserv");
        ehrEmrTableList.put("iptSummary", "medserv");
        ehrEmrTableList.put("iptSalvagelogging", "medserv");
        ehrEmrTableList.put("iptAnesthesiarecords", "medserv");
        ehrEmrTableList.put("iptConsultationrecord", "medserv");
        ehrEmrTableList.put("iptAfteranesthesiair", "medserv");
        ehrEmrTableList.put("iptRecordfirstduration", "medserv");
        ehrEmrTableList.put("iptChinafirstpagemedica", "medserv");
        ehrEmrTableList.put("iptCheckingrecordsd", "medserv");
        ehrEmrTableList.put("iptPreoperativesummary", "medserv");
        ehrEmrTableList.put("iptExaminationrecord", "medserv");
        ehrEmrTableList.put("iptPreoperativediscussion", "medserv");
        ehrEmrTableList.put("iptHospitalsignsre", "medserv");
        ehrEmrTableList.put("iptDailycourser", "medserv");
        ehrEmrTableList.put("iptRecordfirsttdao", "medserv");
        ehrEmrTableList.put("mpiPatientinfo", "medserv");


        // 健康档案person
        ehrEmrTableList.put("ehrHealthrecord", "person");
        ehrEmrTableList.put("ehrJwsss", "person");
        ehrEmrTableList.put("ehrJwgms", "person");
        ehrEmrTableList.put("ehrCjqk", "person");
        ehrEmrTableList.put("ehrJwjbs", "person");
        ehrEmrTableList.put("ehrJwsxs", "person");
        ehrEmrTableList.put("ehrHjblys", "person");
        ehrEmrTableList.put("ehrJwwss", "person");
        ehrEmrTableList.put("ehrJzjbs", "person");


        // 妇女保健  woman
        ehrEmrTableList.put("cdhDefectregister", "woman");
        ehrEmrTableList.put("mhcCommonscreening", "woman");
        ehrEmrTableList.put("mhcPregnantscreenresult", "woman");
        ehrEmrTableList.put("pmcPremaritalrecord", "woman");
        ehrEmrTableList.put("mhcBirthcontrol", "woman");
        ehrEmrTableList.put("mhcHighriskvisitreason", "woman");
        ehrEmrTableList.put("mhcMaternalreport", "woman");
    }
}
