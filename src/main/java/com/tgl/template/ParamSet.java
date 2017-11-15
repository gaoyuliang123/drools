package com.tgl.template;

import java.util.EnumSet;

public class ParamSet {

    private String field;
    private int lower;
    private int upper;
    private EnumSet<ItemCode> codeSet;

    public ParamSet() {
    }

    public ParamSet(String field, int lower, int upper, EnumSet<ItemCode> codeSet) {
        this.field = field;
        this.lower = lower;
        this.upper = upper;
        this.codeSet = codeSet;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getLower() {
        return lower;
    }

    public void setLower(int lower) {
        this.lower = lower;
    }

    public int getUpper() {
        return upper;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }

    public EnumSet<ItemCode> getCodeSet() {
        return codeSet;
    }

    public void setCodeSet(EnumSet<ItemCode> codeSet) {
        this.codeSet = codeSet;
    }

    public String getCodes() {
        StringBuffer sb = new StringBuffer();
        String conn = " ";
        if (!this.codeSet.isEmpty()) {
            for(ItemCode itemCode : codeSet) {
                sb.append(conn).append("ItemCode.").append(itemCode);
                conn = " ||";
            }
        }
        return sb.toString();
    }
}
