package com.dadaabs.mhealth.models;

/**
 * Created by crakama on 11/23/2016.
 */
public class GeneralHealthModel {

    public GeneralHealthModel() {

    }

    public GeneralHealthModel(String title, String titleBody) {
        this.title = title;
        this.titleBody = titleBody;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleBody() {
        return titleBody;
    }

    public void setTitleBody(String titleBody) {
        this.titleBody = titleBody;
    }

    private String title;
    private String titleBody;

    public String getOraganization() {
        return oraganization;
    }

    private String oraganization;

    public void setOraganization(String oraganization) {
        this.oraganization = oraganization;
    }
}

