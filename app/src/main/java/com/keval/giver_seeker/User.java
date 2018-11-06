package com.keval.giver_seeker;

public class User {
    public String mobile,username,orgName,orgRegno,indOrOrg;

    public User(){

    }

    public User(String mobile, String username,String orgName,String orgRegno,String indOrOrg) {
        this.mobile = mobile;
        this.username = username;
        this.orgName = orgName;
        this.orgRegno = orgRegno;
        this.indOrOrg = indOrOrg;
    }
}