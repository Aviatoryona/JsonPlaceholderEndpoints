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

import com.aviator.jsonplaceholderendpoints.boundary.PhotoService;
import com.aviator.jsonplaceholderendpoints.control.rest.PhotoRESTFacadeI;
import com.aviator.jsonplaceholderendpoints.entity.Photo;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Aviator
 */
public class PhotoRESTFacadeImpl implements PhotoRESTFacadeI {

    @EJB
    PhotoService photoService;

    @Override
    public long count() {
        return photoService.count();
    }

    @Override
    public List<Photo> findRange(int[] range) {
        return photoService.findRange(range);
    }

    @Override
    public List<Photo> findAll() {
        return photoService.findAll();
    }

    @Override
    public Photo find(Long id) {
        return photoService.find(id);
    }

    @Override
    public boolean remove(Long id) {
        return photoService.remove(id);
    }

    @Override
    public Photo edit(Photo entity) {
        return photoService.edit(entity);
    }

    @Override
    public Photo create(Photo entity) {
        return photoService.create(entity);
    }

    @Override
    public List<Photo> getAlbumPhotos(Long albumId) {
        return photoService.getAlbumPhotos(albumId);
    }

}
