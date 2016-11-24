package com.dadaabs.mhealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dadaabs.mhealth.models.GeneralHealthModel;
import com.dadaabs.mhealth.models.HygeneTipsModel;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateHygieneTips extends AppCompatActivity {
    EditText title,updateDetails,organization;
    DatabaseReference db;
    DatabaseOperations dbOperationsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_hygiene_tips);
        Firebase.setAndroidContext(this);
        db = FirebaseDatabase.getInstance().getReference();
        dbOperationsHelper = new DatabaseOperations(db);

        title = (EditText) findViewById(R.id.txtUpdateHead);
        updateDetails = (EditText) findViewById(R.id.txtUpdateDetails);
        organization = (EditText) findViewById(R.id.txtorganization);


        Button btnNewsUpdate = (Button) findViewById(R.id.btn_add_update);

        btnNewsUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * GET DATA
                 */
                String hygienetitle = title.getText().toString();
                String hygieneBody = updateDetails.getText().toString();
                String hygieneorganization = organization.getText().toString();

                /**
                 * SET DATA
                 */
                HygeneTipsModel dbModel = new HygeneTipsModel();
                dbModel.setTitle(hygienetitle);
                dbModel.setTitleBody(hygieneBody);
                dbModel.setOraganization(hygieneorganization);
                /*** SIMPLE VALIDATION ***/
                if(hygienetitle != null && hygieneBody.length() > 0){

                    if(dbOperationsHelper.saveHygeneTips(dbModel)){
                        /** IF NEWS SAVED, CLEAR EDIT TEXT */
                        title.setText("");
                        updateDetails.setText("");
                        organization.setText("");

                    }else{
                        Toast.makeText(UpdateHygieneTips.this, "MUST NOT BE EMPTY", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
