package com.example.hcicoolexample;

import java.util.ArrayList;

public class MyDoes {
    String itemType;
    String position;
    String company;
    String location;
    String date;
    String status;
    String tags;
    String notes;

    public MyDoes(){

    }

    public MyDoes(String itemType, String position, String company, String location, String date, String status, String tags, String notes){
        this.itemType = itemType;
        this.position = position;
        this.company = company;
        this.location = location;
        this.date = date;
        this.status = status;
        this.tags = tags;
        this.notes = notes;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCompany(String company) { this.company = company; }

    public void setLocation(String location) { this.location = location; }

    public void setDate(String date) { this.date = date; }

    public void setStatus(String status) { this.status = status; }

    public void setTags(String tags) { this.tags = tags; }

    public void setNotes(String notes) { this.notes = notes; }

    public String getItemType() {
        return itemType;
    }

    public String getPosition() {
        return position;
    }

    public String getCompany() { return company; }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getTags() {
        return tags;
    }

    public String getNotes() {
        return notes;
    }

    public ArrayList<String> getInfo() {
        ArrayList<String> info = new ArrayList<String>();
        info.add(itemType);
        info.add(position);
        info.add(company);
        info.add(location);
        info.add(date);
        info.add(status);
        info.add(tags);
        info.add(notes);
        return info;
    }
}
