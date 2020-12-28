package com.mongodb_rest_api.springbootmongodb;

public class Review {
    private String userName;
    private int rating;
    private boolean approved;

    protected Review(){}
    public Review(String userName,int rating,boolean approved){
        this.approved=approved;
        this.rating=rating;
        this.userName=userName;
    }

    public String getUserName() {
        return userName;
    }

    public int getRating() {
        return rating;
    }

    public boolean isApproved() {
        return approved;
    }
}
