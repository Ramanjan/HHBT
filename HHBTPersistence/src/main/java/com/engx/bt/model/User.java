package com.engx.bt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class User {

    /**
     * empId.
     */
    @Id
    @Column(name = "empId")
    private Integer empId;

    /**
     * firstName.
     */
    @Column(name = "firstName")
    private String firstName;

    /**
     * lastName.
     */
    @Column(name = "lastName")
    private String lastName;

    /**
     * emailId.
     */
    @Column(name = "emailId")
    private String emailId;

    /**
     * password.
     */
    @Column(name = "password")
    private String password;

    /**
     * salt.
     */
    @Column(name = "salt")
    private String salt;

    /**
     * resetPassword.
     */
    @Column(name = "mobileNumber")
    private Integer mobileNumber;

    /**
     * createdAt.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    private Date createdAt;

    /**
     * updatedAt.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedAt")
    private Date updatedAt;

    /**
     * @return the createdAt
     */
    public final Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the emailId
     */
    public final String getEmailId() {
        return emailId;
    }

    /**
     * @return the empId
     */
    public final Integer getEmpId() {
        return empId;
    }

    /**
     * @return the firstName
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * @return the mobileNumber
     */
    public final Integer getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @return the password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * @return the salt
     */
    public final String getSalt() {
        return salt;
    }

    /**
     * @return the updatedAt
     */
    public final Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param createdAt
     *            the createdAt to set
     */
    public final void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @param emailId
     *            the emailId to set
     */
    public final void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    /**
     * @param empId
     *            the empId to set
     */
    public final void setEmpId(final Integer empId) {
        this.empId = empId;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param mobileNumber
     *            the mobileNumber to set
     */
    public final void setMobileNumber(final Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @param password
     *            the password to set
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @param salt
     *            the salt to set
     */
    public final void setSalt(final String salt) {
        this.salt = salt;
    }

    /**
     * @param updatedAt
     *            the updatedAt to set
     */
    public final void setUpdatedAt(final Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}