package com.android.susmita.citirewards.dto;

import java.util.ArrayList;

/**
 * Created by susmita on 10/20/2017.
 */

public class Statements {
    private String year;
    private ArrayList<StatementMonths> statementMonths;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<StatementMonths> getStatementMonths() {
        return statementMonths;
    }

    public void setStatementMonths(ArrayList<StatementMonths> statementMonths) {
        this.statementMonths = statementMonths;
    }
}
