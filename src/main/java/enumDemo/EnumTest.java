package enumDemo;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2019/10/23
 * Time: 14:19
 */
public enum EnumTest {
    FREE("free","卖家包邮"),

    POST("post","平邮"),

    EXPRESS("express","快递"),

    EMS("ems","EMS"),

    VIRTUAL("virtual","虚拟发货"),

    TWENTY_FIVE("25","次日必达"),

    TWENTY_SIX("26","预约配送");

    private String code;
    private String value;

    private  EnumTest(String code,String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 根据code获取去value
     * @param code
     * @return
     */
    public static String getValueByCode(String code){
        for(EnumTest platformFree:EnumTest.values()){
            if(code.equals(platformFree.getCode())){
                return platformFree.getValue();
            }
        }
        return  null;
    }

    public static void main(String[] args) {
        System.out.println(getValueByCode("post"));
    }
}
