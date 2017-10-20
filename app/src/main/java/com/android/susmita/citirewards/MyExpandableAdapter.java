package com.android.susmita.citirewards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.android.susmita.citirewards.dto.StatementMonths;
import com.android.susmita.citirewards.dto.StatementResponse;
import com.android.susmita.citirewards.dto.Statements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static com.android.susmita.citirewards.R.layout.years;

/**
 * Created by susmita on 10/19/2017.
 */

public class MyExpandableAdapter extends BaseExpandableListAdapter {
    Context context;
    List<String> yearsList;
    Map<String, List<String>> statementMonthsMap;

    public MyExpandableAdapter(Context context, StatementResponse statementResponse) {
        this.context = context;
        yearsList = new ArrayList<>();
        statementMonthsMap = new HashMap<>();
        List<StatementMonths> statementMonthsList;
        ArrayList<String> monthsList;

        ArrayList<Statements> statementList = statementResponse.getStatementResponse();
        for (Statements statement : statementList){
            yearsList.add(statement.getYear());
            statementMonthsList = statement.getStatementMonths();
            monthsList = new ArrayList<>();
            for(StatementMonths statementMonths : statementMonthsList){
                monthsList.add(statementMonths.getMonth());
            }
            statementMonthsMap.put(statement.getYear(),monthsList);
        }
    }

    @Override
    public int getGroupCount() {
        return yearsList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return statementMonthsMap.get(yearsList.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return yearsList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return statementMonthsMap.get(yearsList.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String year = (String) getGroup(i);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.years, null);
        }
        TextView txtYears = (TextView)view.findViewById(R.id.tv_years);
        txtYears.setText(year);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String topic = (String) getChild(i, i1);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.statement_months, null);
        }
        TextView txtMonths = (TextView)view.findViewById(R.id.tvmonths);
        txtMonths.setText(topic);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }


}
