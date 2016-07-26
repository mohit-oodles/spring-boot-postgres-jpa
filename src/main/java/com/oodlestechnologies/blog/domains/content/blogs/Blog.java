package com.oodlestechnologies.blog.domains.content.blogs;

import javax.persistence.*;




@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long blogID;

    private String blog;
    private String blogSubject;
    private String blogCategory;
    private String createdOn;
    private long personId;


    public void setBlogCategory(String blogCategory) {
        this.blogCategory = blogCategory;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getBlogSubject() {
        return blogSubject;
    }

    public void setBlogSubject(String blogSubject) {
        this.blogSubject = blogSubject;
    }

    public String getBlogCategory() {
        return blogCategory;
    }

    public long getBlogID() {
        return blogID;
    }

    public void setBlogID(long blogID) {
        this.blogID = blogID;
    }

    public String getBlog() {
        return blog;
    }


    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;



}
