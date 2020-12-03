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

import com.aviator.jsonplaceholderendpoints.util.FieldDescription;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Aviator
 */
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@NamedQueries(
        {
            @NamedQuery(name = UserModel.FINDBYEMAIL, query = "SELECT u FROM UserModel u WHERE u.email= :email"),
            @NamedQuery(name = UserModel.FINDBYUSERNAME, query = "SELECT u FROM UserModel u WHERE u.username= :username"),
            @NamedQuery(name = UserModel.GETUSERPOSTS, query = "SELECT p FROM Post p WHERE p.userId= :userId"),
            @NamedQuery(name = UserModel.GETUSERALBUMS, query = "SELECT a FROM Album a WHERE a.userId= :userId"),
            @NamedQuery(name = UserModel.GETUSERTODO, query = "SELECT t FROM ToDo t WHERE t.userId= :userId"),}
)
@Entity
public class UserModel implements Serializable {

    public static final String FINDBYEMAIL = "user.findByEmail";
    public static final String FINDBYUSERNAME = "user.findByUserName";
    public static final String GETUSERPOSTS = "user.getUserPosts";
    public static final String GETUSERALBUMS = "user.getUserAlbums";
    public static final String GETUSERTODO = "user.getUserTodo";

    private static final long serialVersionUID = 1L;

    @Column(name = "USER_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column
    private String phone;
    @Column
    private String website;

    @Embedded
    private Address address;

    @Embedded
    private Company company;

    @FieldDescription(description = "A user can have many posts")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userModel")
    List<Post> posts;

    @FieldDescription(description = "A user can have many albums")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userModel")
    List<Album> albums;

    @FieldDescription(description = "A user can have many Todos")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userModel")
    List<ToDo> toDos;

}
