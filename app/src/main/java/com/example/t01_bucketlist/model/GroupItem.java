package com.example.t01_bucketlist.model;

import java.util.ArrayList;
import java.util.List;

public class GroupItem {
    String Gid;
    String gname;
    String category;
    String place;
    String description;
    String CDate;
    String TDate;

    List<MemberItem> memberItemList;

    public GroupItem(String gid, String gname, String category, String place, String description, String CDate, String TDate, List<MemberItem> memberItemList) {
        Gid = gid;
        this.gname = gname;
        this.category = category;
        this.place = place;
        this.description = description;
        this.CDate = CDate;
        this.TDate = TDate;
        this.memberItemList = memberItemList;
    }


    GroupItem() {
        Gid = "";
        gname = "";
        category = "";
        place = "";
        description = "";
        CDate = "";
        TDate = "";
        memberItemList = new ArrayList<>();
    }

    public String getGid() {
        return Gid;
    }

    public void setGid(String gid) {
        Gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCDate() {
        return CDate;
    }

    public void setCDate(String CDate) {
        this.CDate = CDate;
    }

    public String getTDate() {
        return TDate;
    }

    public void setTDate(String TDate) {
        this.TDate = TDate;
    }

    public List<MemberItem> getMemberItemList() {
        return memberItemList;
    }

    public void setMemberItemList(List<MemberItem> memberItemList) {
        this.memberItemList = memberItemList;
    }
}
