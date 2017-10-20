package com.android.susmita.citirewards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.android.susmita.citirewards.dto.StatementResponse;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> yearsList;
    private Map<String, List<String>> statementMonthsMap;
    private int lastExpandedPosition = -1;
    private StatementResponse respObj = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        fillData();
        expandableListAdapter = new MyExpandableAdapter(this, respObj);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(groupPosition -> {
            if (groupPosition != lastExpandedPosition) {
                expandableListView.collapseGroup(lastExpandedPosition);
            }
            lastExpandedPosition = groupPosition;
        });
        expandableListView.setOnChildClickListener((expandableListView1, view, i, i1, l) -> {
            String year = respObj.getStatementResponse().get(i).getYear();
            String month = respObj.getStatementResponse().get(i).getStatementMonths().get(i1).getMonth();
//            statementMonthsMap.get(yearsList.get(i)).get(i1);
            Toast.makeText(MainActivity.this,month + " of "+ year+" selected " , Toast.LENGTH_LONG).show();
            return false;
        });
    }

    public void fillData() {
        String jsonResp = "{\"statementResponse\":[{\"year\":\"2018\",\"statementMonths\":[{\"statementDate\":\"2018-02-02\",\"month\":\"January\"},{\"statementDate\":\"2018-02-02\",\"month\":\"February\"},{\"statementDate\":\"2018-02-02\",\"month\":\"August\"},{\"statementDate\":\"2018-02-02\",\"month\":\"December\"}]},{\"year\":\"2017\",\"statementMonths\":[{\"statementDate\":\"2018-02-02\",\"month\":\"January\"},{\"statementDate\":\"2018-02-02\",\"month\":\"February\"},{\"statementDate\":\"2018-02-02\",\"month\":\"August\"},{\"statementDate\":\"2018-02-02\",\"month\":\"December\"}]},{\"year\":\"2016\",\"statementMonths\":[{\"statementDate\":\"2018-02-02\",\"month\":\"January\"},{\"statementDate\":\"2018-02-02\",\"month\":\"February\"},{\"statementDate\":\"2018-02-02\",\"month\":\"August\"},{\"statementDate\":\"2018-02-02\",\"month\":\"December\"}]}]}";
        Gson gson = new Gson();
        try {
            respObj = gson.fromJson(jsonResp, StatementResponse.class);
            System.out.println("mapping is success");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
