package com.dadaabs.mhealth;

import com.dadaabs.mhealth.models.GeneralHealthModel;
import com.dadaabs.mhealth.models.HygeneTipsModel;
import com.dadaabs.mhealth.models.MotherCareModel;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by crakama on 11/23/2016.
 */

public class DatabaseOperations {
    DatabaseReference dbref;
    Boolean savedhealthupdate, savemothercare, savehygenetips;

    /** * DATABASE  REFERENCE ***/

    public DatabaseOperations(DatabaseReference db){
        this.dbref = db;
    }


    /*** Send General Health Info to firebase  ***/
    public Boolean saveGeneralHealth(GeneralHealthModel generalHealthModel){
        if(generalHealthModel == null){
            savedhealthupdate = false;
        }else{
            try {
                dbref.child("GeneralHealthModel").push().setValue(generalHealthModel);
                savedhealthupdate = true;
            } catch (DatabaseException e) {

                e.printStackTrace();
                savedhealthupdate = false;
            }
        }
        return savedhealthupdate;
    }

    /*** Send Mother Care Info to firebase  ***/
    public Boolean saveMotherCare(MotherCareModel motherCareModel){
        if(motherCareModel == null){
            savemothercare = false;
        }else{
            try {
                dbref.child("MotherCareModel").push().setValue(motherCareModel);
                savemothercare = true;
            } catch (DatabaseException e) {

                e.printStackTrace();
                savemothercare = false;
            }
        }
        return savemothercare;
    }


    /*** Send Hygiene  Info to firebase  ***/
    public Boolean saveHygeneTips(HygeneTipsModel hygeneTipsModel){
        if(hygeneTipsModel == null){
            savehygenetips = false;
        }else{
            try {
                dbref.child("HygeneTipsModel").push().setValue(hygeneTipsModel);
                savehygenetips = true;
            } catch (DatabaseException e) {

                e.printStackTrace();
                savehygenetips = false;
            }
        }
        return savehygenetips;
    }
}
