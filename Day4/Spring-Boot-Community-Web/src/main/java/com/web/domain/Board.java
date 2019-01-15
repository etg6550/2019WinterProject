package com.web.domain;

import com.web.domain.enums.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.FetchType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Board implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String title;

    @Column
    private String subTitle;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updateDate;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Board(String title, String subTitle, String content, BoardType boardType, LocalDateTime createdDate, LocalDateTime updatedDate, User user) {

        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.boardType = boardType;
        this.createdDate = createdDate;
        this.updateDate = updatedDate;
        this.user = user;

    }

}
