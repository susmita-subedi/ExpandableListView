package com.android.susmita.citirewards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
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
    private static int lastExpandedPosition = 0;
    private StatementResponse respObj = null;
    //    private TextView monthIndicator;
    private int lastSelectedMonth = 0;
/*    private ImageView groupIndicator;*/
    private ImageView arrowUp;
    private ImageView arrowDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("main", "create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        fillData();
//        showGroupIndicator();
        /*expandableListView.setSelectedGroup(lastExpandedPosition);
        expandableListView.setSelectedChild(lastExpandedPosition,lastSelectedMonth,true );*/
//        setDefault();
        expandableListAdapter = new MyExpandableAdapter(this, respObj);
        /*DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);*/
//        int width = metrics.widthPixels;
        expandableListView.setAdapter(expandableListAdapter);
//        expandableListView.setIndicatorBounds(width - GetPixelFromDips(50), width - GetPixelFromDips(5));
        collapseUnselectedGroup();
        showToastOfSelectedItem();
//        expandableListView.animate();


//        expandableListView.setChildIndicatorBounds(width - GetPixelFromDips(50), width - GetPixelFromDips(5));


        expandableListView.expandGroup(lastExpandedPosition);
//        expandableListView.performItemClick(,lastExpandedPosition,1);


    }

    private void setDefault() {

        expandableListView.setSelectedGroup(lastExpandedPosition);
        Log.d("main", "group");
        /*expandableListView.setSelectedChild(lastExpandedPosition, lastSelectedMonth, true);
        Log.d("main", "month");*/

    }


    private void showGroupIndicator() {
//        expandableListView.setSelectedGroup(lastExpandedPosition);
        /*expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View clickedView, int groupPosition, long rowId) {
                groupIndicator = (ImageView) clickedView.findViewById(R.id.arrowdown);
                if (parent.isGroupExpanded(groupPosition)) {
                    parent.collapseGroup(groupPosition);
                    groupIndicator.setImageResource(R.drawable.arrow_down);
                } else {
                    parent.expandGroup(groupPosition);
                    groupIndicator.setImageResource(R.drawable.arrow_up);
                }
                return true;
            }
        });*/

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int i) {
////                groupIndicator = View.findViewById(R.id.group_indicator);
//                groupIndicator.setImageResource(R.drawable.arrow_down);

               arrowUp.setVisibility(View.VISIBLE);

                if (i != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                   arrowUp.setVisibility(View.VISIBLE);
                   arrowDown.setVisibility(View.GONE);
//                    arrowdown.setImageResource(R.drawable.arrow_up);
                }
                /*else {
                   arrowdown.setImageResource(R.drawable.arrow_up);
                }*/
              /* else
                {
                    arrowdown.setVisibility(View.VISIBLE);
                }*/
                lastExpandedPosition = i;
            }

        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {

                arrowDown.setVisibility(View.GONE);
                arrowUp.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("main", "start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("main", "stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("main", "destroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("main", "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("main", "pause");
    }


    private void showToastOfSelectedItem() {
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupIndex, int childIndex, long l) {
//                monthIndicator = (TextView)findViewById(R.id.childindicator);
//                if(i1 != selectedMonth){
//                    monthIndicator.setVisibility(View.GONE);
//
//                }
//                selectedMonth = i1;
//
//                monthIndicator.setVisibility(View.VISIBLE);
               /*if(lastSelectedMonth != null){
                    lastSelectedMonth.setBackgroundColor(view.getResources().getColor(R.color.colorTransparent));
                }
                lastSelectedMonth = view;
                view.setBackgroundColor(view.getResources().getColor(R.color.colorPrimary));
*/
                String year = respObj.getStatementResponse().get(groupIndex).getYear();
                String month = respObj.getStatementResponse().get(groupIndex).getStatementMonths().get(childIndex).getMonth();
//                Toast.makeText(MainActivity.this, month + " of " + year + " selected ", Toast.LENGTH_LONG).show();
//                if (groupIndex != lastExpandedPosition && childIndex !=lastSelectedMonth) {
//                    view.setBackgroundColor(view.getResources().getColor(R.color.colorTransparent));
//                }
//                view.setBackgroundColor(view.getResources().getColor(R.color.colorPrimary));
                lastExpandedPosition = groupIndex;
//                lastSelectedMonth = childIndex;
                String m = expandableListAdapter.getChild(groupIndex, childIndex).toString();
                String y = expandableListAdapter.getGroup(groupIndex).toString();
                Toast.makeText(MainActivity.this, m + " of " + y + " selected ddddd", Toast.LENGTH_LONG).show();
                return true;
            }

        });


    }


    private void collapseUnselectedGroup() {
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            ImageView arrowdown = (ImageView) expandableListView.findViewById(R.id.arrowdown);
            ImageView arrowup = (ImageView) expandableListView.findViewById(R.id.arrowup);

            @Override
            public void onGroupExpand(int groupPosition) {
//                arrowdown.setVisibility(View.GONE);
//                arrowup.setVisibility(View.VISIBLE);

                if (groupPosition != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }

                lastExpandedPosition = groupPosition;
            }
        });
    }

    public void fillData() {
        String jsonResp = "{\"statementResponse\":[{\"year\":\"2018\",\"statementMonths\":[{\"statementDate\":\"2018-02-02\",\"month\":\"January\"},{\"statementDate\":\"2018-02-02\",\"month\":\"February\"},{\"statementDate\":\"2018-02-02\",\"month\":\"August\"},{\"statementDate\":\"2018-02-02\",\"month\":\"December\"}]},{\"year\":\"2017\",\"statementMonths\":[{\"statementDate\":\"2018-02-02\",\"month\":\"January\"},{\"statementDate\":\"2018-02-02\",\"month\":\"February\"},{\"statementDate\":\"2018-02-02\",\"month\":\"August\"},{\"statementDate\":\"2018-02-02\",\"month\":\"December\"}]},{\"year\":\"2016\",\"statementMonths\":[{\"statementDate\":\"2018-02-02\",\"month\":\"January\"},{\"statementDate\":\"2018-02-02\",\"month\":\"February\"},{\"statementDate\":\"2018-02-02\",\"month\":\"August\"},{\"statementDate\":\"2018-02-02\",\"month\":\"December\"}]}]}";
        Gson gson = new Gson();
        try {
            respObj = gson.fromJson(jsonResp, StatementResponse.class);
            System.out.println("mapping is success");
        } catch (Exception e) {
            System.out.println("The error is" + e);
            Log.d("In main activity", "Parsing error");
        }

    }

    public int GetPixelFromDips(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }


}
