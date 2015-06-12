package com.anmi.webapp.entity;

        import javax.persistence.*;
        import java.util.HashSet;
        import java.util.Set;

@Entity
@Table(name="accounts",
        indexes = {@Index(name = "uk_accounts_email", columnList = "email", unique = true)})
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private byte[] picture;

    @Column(name = "first_name")
    private java.lang.String firstName;


    @Column(name = "last_name")
    private java.lang.String lastName;

    @Column(name = "user_name", nullable= false, unique = true)
    private java.lang.String userName;

    //@Enumerated(EnumType.ORDINAL)
    @Column(name = "account_type")
    private String accountType;

    private Boolean admin;

   // @Column(nullable = false)
    private java.lang.String email;

  //  @Column(nullable = false)
    private java.lang.String password;

    @Column //(columnDefinition = "default = 'default.jpg'")
    private java.lang.String imgPath;

    private boolean enabled;

   // @OneToMany(fetch = FetchType.EAGER)
   // @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "user_id"))

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "accounts_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(name = "fk_accounts_account_roles_role_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            inverseForeignKey = @ForeignKey(name = "fk_accounts_account_roles_role_id"))
    private Set<Role> userRole = new HashSet<Role>(0);




    public enum AccountType {
        ADMIN,USER,MAINTENACE;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<Role> userRole) {
        this.userRole = userRole;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getAccountType() {
        return accountType;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public void setAccountType(String string) {
        this.accountType = string;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public java.lang.String getImgPath() {
        return imgPath;
    }

    public void setImgPath(java.lang.String imgPath) {
        this.imgPath = imgPath;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
