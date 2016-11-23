package com.dadaabs.mhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.dadaabs.mhealth.models.MainModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_mainscreen;
    LinearLayoutManager nwlinearLayoutManager;
    GeneralNavAdapter generalNavAdapter;
    private List<MainModel> mainModelList = new ArrayList<>();

    public static final String TOWNS = "MainModel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cv);
        Button btnnew = (Button)findViewById(R.id.btn);
        btnnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,UpdateGeneralHealth.class);
                startActivity(i);
            }
        });
//        homeNavigation();
//        homeNavigationData();
    }

//    public void homeNavigation() {
//        nwlinearLayoutManager = new LinearLayoutManager(this);
//        generalNavAdapter = new GeneralNavAdapter(mainModelList);
//        rv_mainscreen =(RecyclerView) findViewById(R.id.rv_reportOptions);
//        rv_mainscreen.setLayoutManager(nwlinearLayoutManager);
//        rv_mainscreen.setAdapter(reportAdapter);
//        rv_mainscreen.addOnItemTouchListener(new ReportItemClickListener(getApplicationContext(),
//                new ReportItemClickListener.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, int i) {
//                        switch (i) {
//                            case 0:
//                                openReportIncidentActivity();
//                                break;
//                            case 1:
//                                // Toast.makeText(view.getContext(), "POSITION" + i, Toast.LENGTH_LONG).show();
//                                openJoinChatActivity();
//
//                                break;
//                            case 2:
//                                // Toast.makeText(view.getContext(), "POSITION" + i, Toast.LENGTH_LONG).show();
//                                openAffectedAreasActivity();
//                                break;
//                        }
//                    }
//                }));
//    }
//
//    private void homeNavigationData() {
//        MainModel model = new MainModel("General Health", R.drawable.faqbold);
//        reportModelList.add(model);
//
//        model = new MainModel("Mother Care",R.drawable.helpinghand);
//        reportModelList.add(model);
//
//        model = new MainModel("Hygiene ",R.drawable.about);
//        reportModelList.add(model);
//
//    }

}
