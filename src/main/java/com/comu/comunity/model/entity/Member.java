package com.comu.comunity.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "email", nullable = false, unique = true)
    private String email;


    /* 게시글과의 연관관계 설정 예시
    @OneToMany(mappedBy = "member", cascade = CascadeType.All, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();
     */

    /* 댓글과의 연관관계 설정 예시
    @OneToMany(mappedBy = "member", cascade = CascadeType.All, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
     */

    public void updateProfile(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    // 팔로우 (내가 추가한 사람들)
    @OneToMany(mappedBy = "fromMember")
    private List<Friend> followings = new ArrayList<>();

    // 팔로워(나를 추가한 사람들)
    @OneToMany(mappedBy = "toMember")
    private List<Friend> followers = new ArrayList<>();


}
