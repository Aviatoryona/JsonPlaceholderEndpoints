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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@EqualsAndHashCode
@ToString
@NamedQueries(
        {
            @NamedQuery(name = Album.GETUSER_ALBUMS, query = "SELECT a FROM Album a WHERE a.userId= :userId"),
            @NamedQuery(name = Album.GETALBUMPHOTOS, query = "SELECT ph FROM Photo ph WHERE ph.albumId= :albumId"),}
)
public class Album implements Serializable {

    public static final String GETUSER_ALBUMS = "album.getUserAlbums";
    public static final String GETALBUMPHOTOS = "album.getAlbumPhotos";

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private long userId;

    @Column(unique = true)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    UserModel userModel;

    @FieldDescription(description = "An album can have many photos")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "album")
    List<Photo> posts;
}
