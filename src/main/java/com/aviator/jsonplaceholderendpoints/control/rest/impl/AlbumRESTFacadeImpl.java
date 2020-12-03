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
package com.aviator.jsonplaceholderendpoints.control.rest.impl;

import com.aviator.jsonplaceholderendpoints.boundary.AlbumService;
import com.aviator.jsonplaceholderendpoints.control.rest.AlbumRESTFacadeI;
import com.aviator.jsonplaceholderendpoints.entity.Album;
import com.aviator.jsonplaceholderendpoints.entity.Photo;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Aviator
 */
public class AlbumRESTFacadeImpl implements AlbumRESTFacadeI {

    @EJB
    AlbumService albumService;

    @Override
    public long count() {
        return albumService.count();
    }

    @Override
    public List<Album> findRange(int[] range) {
        return albumService.findRange(range);
    }

    @Override
    public List<Album> findAll() {
        return albumService.findAll();
    }

    @Override
    public Album find(long id) {
        return albumService.find(id);
    }

    @Override
    public boolean remove(Long id) {
        return albumService.remove(id);
    }

    @Override
    public Album edit(Album entity) {
        return albumService.edit(entity);
    }

    @Override
    public Album create(Album entity) {
        return albumService.create(entity);
    }

    @Override
    public List<Photo> getAlbumPhotos(Long albumId) {
        return albumService.getAlbumPhotos(albumId);
    }

    @Override
    public List<Album> getUserAlbums(Long userId) {
        return albumService.getUserAlbums(userId);
    }

}
