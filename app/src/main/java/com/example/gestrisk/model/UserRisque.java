package com.example.gestrisk.model;

public class UserRisque {
    private User user = null;
    private Risque risque = null;

    public UserRisque(User user, Risque risque) {
        super();
        this.user = user;
        this.risque = risque;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Risque getRisque() {
        return risque;
    }

    public void setRisque(Risque risque) {
        this.risque = risque;
    }

    @Override
    public String toString() {
        return "UserRisque{" +
                "user=" + user +
                ", risque=" + risque +
                '}';
    }
}
