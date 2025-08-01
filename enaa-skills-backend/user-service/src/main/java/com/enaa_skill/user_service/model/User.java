package com.enaa_skill.user_service.model;


import jakarta.persistence.*;


@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("USER") //par default user
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;

    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // --- Getters and Setters ---


    public Long getId() {
        return id; }

    public void setId(Long id) {
        this.id = id; }

    public String getUsername() {
        return username; }


    public void setUsername(String username) {
        this.username = username; }

    public String getEmail() {
        return email; }
    public void setEmail(String email) {
        this.email = email; }



    public String getPassword() {
        return password; }
    public void setPassword(String password) {
        this.password = password; }
}

