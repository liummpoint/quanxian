package com.manage.commom.enums;

/**
 * Created by Administrator on 2017/3/4.
 */
public interface CommonEnum {
    /**
     * 暂时不需要
     */
    enum ShanXinBankCode {

        BANKCODE_ABC("ABC","ABC"),
        BANKCODE_BCOM("BCOM","BCOM"),
        BANKCODE_BOC("BOC","BOC"),
        BANKCODE_SHB("SHB","BOS"),
        BANKCODE_CCB("CCB","CCB"),
        BANKCODE_CEB("CEB","CEBB"),
        BANKCODE_CIB("CIB","CIB"),
        BANKCODE_CMB("CMB","CMB"),
        BANKCODE_CMBC("CMBC","CMBC"),
        BANKCODE_CITIC("CITIC","ECITIC"),
        BANKCODE_GDB("GDB","GDB"),
        BANKCODE_HXB("HXB","HXB"),
        BANKCODE_ICBC("ICBC","ICBC"),
        BANKCODE_PAB("PAB","PAB"),
        BANKCODE_PSBC("PSBC","PSBC"),
        BANKCODE_SPDB("SPDB","SPDB");

        private String code;
        private String comment;

        ShanXinBankCode(String code, String comment) {
            this.code = code;
            this.comment = comment;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }

}
