package com.dadaabs.mhealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dadaabs.mhealth.models.GeneralHealthModel;
import com.dadaabs.mhealth.models.MotherCareModel;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateMotherCare extends AppCompatActivity {

    EditText title,updateDetails,organization;
    DatabaseReference db;
    DatabaseOperations dbOperationsHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mother_care);
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
                String caretitle = title.getText().toString();
                String careBody = updateDetails.getText().toString();
                String careorganization = organization.getText().toString();

                /**
                 * SET DATA
                 */
                MotherCareModel dbModel = new MotherCareModel();
                dbModel.setTitle(caretitle);
                dbModel.setTitleBody(careBody);
                dbModel.setOraganization(careorganization);
                /*** SIMPLE VALIDATION ***/
                if(caretitle != null && careBody.length() > 0){

                    if(dbOperationsHelper.saveMotherCare(dbModel)){
                        /** IF NEWS SAVED, CLEAR EDIT TEXT */
                        title.setText("");
                        updateDetails.setText("");
                        organization.setText("");

                    }else{
                        Toast.makeText(UpdateMotherCare.this, "MUST NOT BE EMPTY", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
