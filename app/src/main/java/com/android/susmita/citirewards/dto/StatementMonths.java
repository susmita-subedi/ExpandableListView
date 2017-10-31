package com.android.susmita.citirewards.dto;

/**
 * Created by susmita on 10/20/2017.
 */

public class StatementMonths {
    private String statementDate;
    private String month;
    private boolean selected;

    public String getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(String statementDate) {
        this.statementDate = statementDate;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public boolean getIsSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
