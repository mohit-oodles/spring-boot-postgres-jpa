package com.oodlestechnologies.blog.domains.Many2Many;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Created by oodles on 27/7/16.
 */
public class Guest {

    long guestId;
    String guestName;
    String guestAddress;


    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestAddress() {
        return guestAddress;
    }

    public void setGuestAddress(String guestAddress) {
        this.guestAddress = guestAddress;
    }

}
