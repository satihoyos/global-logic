package com.globallogic.evaluation.userapi.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by sati on 29-07-20.
 */
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date create;
    @Column(name = "modified_at")
    @Temporal(TemporalType.DATE)
    private Date  modified;
    @Column(name = "last_login_at")
    @Temporal(TemporalType.DATE)
    private Date  lastLogin;
    @Column(name = "is_active")
    private Boolean enabled;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="user_id")
    List<PhoneEntity>phones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<PhoneEntity> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneEntity> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", create=" + create +
                ", modified=" + modified +
                ", lastLogin=" + lastLogin +
                ", enabled=" + enabled +
                ", phones=" + phones +
                '}';
    }
}
