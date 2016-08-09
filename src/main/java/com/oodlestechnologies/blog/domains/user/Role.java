package com.oodlestechnologies.blog.domains.user;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by oodles on 2/8/16.
 */

@Entity
public class Role {

    public Role(){
    }

    public Role(String rN ,String rAL){
            this.role = rN;
        this.roleAccessLevel = rAL;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String role;
    String roleAccessLevel;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleAccessLevel() {
        return roleAccessLevel;
    }

    public void setRoleAccessLevel(String roleAccessLevel) {
        this.roleAccessLevel = roleAccessLevel;
    }

    @ManyToMany
    Collection<UserT> userTs;

    public Collection<UserT> getUserTs() {
        return userTs;
    }

    public void setUserTs(Collection<UserT> userTs) {
        this.userTs = userTs;
    }



}
