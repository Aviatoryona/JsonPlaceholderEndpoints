/*
 * Copyright (C) 2020 Aviator
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.aviator.jsonplaceholderendpoints.entity;

import static com.aviator.jsonplaceholderendpoints.entity.Comment.GETPOSTCOMMENTS;
import static com.aviator.jsonplaceholderendpoints.entity.Comment.GETUSERPOSTCOMMENTS;
import com.aviator.jsonplaceholderendpoints.util.FieldDescription;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Aviator
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@NamedQueries(
        {
            @NamedQuery(name = GETPOSTCOMMENTS, query = "SELECT c FROM Comment c WHERE c.postId= :postId"),
            @NamedQuery(name = GETUSERPOSTCOMMENTS, query = "SELECT c FROM Comment c, Post p,UserModel u WHERE (c.postId=p.id) AND (p.userId=u.id) AND u.id= :userId"),}
)

public class Comment implements Serializable {

    public static final String GETPOSTCOMMENTS = "comment.GETPOSTCOMMENTS";
    public static final String GETUSERPOSTCOMMENTS = "comment.GETUSERPOSTCOMMENTS";

    private static final long serialVersionUID = 1L;

    @Column(name = "COMMENT_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long postId;

    @Column
    private String name;

    @Column
    private String email;

    @Lob
    @Column
    private String body;

    /*
     *A post can have many comments
     */
    @FieldDescription(description = "Many comments can belong to a single post")
    @JoinColumn(name = "POST_ID")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Post post;

}
