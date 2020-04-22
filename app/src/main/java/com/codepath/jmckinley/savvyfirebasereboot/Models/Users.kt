package com.codepath.jmckinley.savvyfirebasereboot.Models

class Users {

    private var uid: String = ""
    private var coverImage: String = ""
    private var facebook: String = ""
    private var profileImage: String = ""
    private var search: String = ""
    private var status: String = ""
    private var username: String = ""
    private var website: String = ""

    // TODO: ADD these to constructor
    // TODO: Create Getters/Setters

    /*  private var school: String = ""
        private var bio: String = ""
        private var firstName: String = ""
        private var lastName: String = ""
        private var isCompany: Boolean = ""
        private var major: String = ""
        private var resume: String = ""
    **/


    constructor()

    constructor(uid: String, coverImage: String, facebook: String, profileImage: String,
                search: String, status: String, username: String, website: String) {
        this.uid = uid
        this.coverImage = coverImage
        this.facebook = facebook
        this.profileImage = profileImage
        this.search = search
        this.status = status
        this.username = username
        this.website = website
    }

    fun getUID(): String? {
        return uid
    }

    fun setUID(uid: String) {
        this.uid = uid
    }

    fun getCoverImage(): String? {
        return coverImage
    }

    fun setCoverImage(coverImage: String) {
        this.coverImage = coverImage
    }

    fun getFacebook(): String? {
        return facebook
}
    fun setFacebook(facebook: String) {
        this.facebook = facebook
    }

    fun getProfileImage(): String? {
        return profileImage
    }
    fun setProfileImage(profileImage: String) {
        this.profileImage = profileImage
    }

    fun getSearch(): String? {
        return search
    }
    fun setSearch(search: String) {
        this.search = search
    }

    fun getWebsite(): String? {
        return website
    }
    fun setWebsite(website: String) {
        this.website = website
    }

    fun getUsername(): String? {
        return username
    }
    fun setUsername(username: String) {
        // TODO: change to firstname + lastname
        this.username = username
    }

    fun getStatus(): String? {
        return status
    }
    fun setStatus(status: String) {
        this.status = status
    }




}