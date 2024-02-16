package com.example.t01_bucketlist.model;

public class MemberItem {
    String memberID;
    String member_name;
    String JoinDate;
    String Gid;

    public MemberItem(String memberID, String member_name, String joinDate, String gid) {
        this.memberID = memberID;
        this.member_name = member_name;
        JoinDate = joinDate;
        Gid = gid;
    }

    MemberItem() {
        memberID = "";
        member_name = "";
        JoinDate = "";
        Gid = "";
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getJoinDate() {
        return JoinDate;
    }

    public void setJoinDate(String joinDate) {
        JoinDate = joinDate;
    }

    public String getGid() {
        return Gid;
    }

    public void setGid(String gid) {
        Gid = gid;
    }
}
