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
package com.aviator.jsonplaceholderendpoints.boundary.impl;

import com.aviator.jsonplaceholderendpoints.boundary.PhotoService;
import com.aviator.jsonplaceholderendpoints.entity.Photo;
import com.aviator.jsonplaceholderendpoints.entity.Post;
import com.aviator.jsonplaceholderendpoints.util.Constants;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aviator
 */
@Stateless
public class PhotoServiceImpl extends AbstractBeanImpl<Photo, Long> implements PhotoService {

    @PersistenceContext(
            unitName = Constants.ENTITY_MANAGER_NAME
    )
    EntityManager em;

    public PhotoServiceImpl() {
        super(Photo.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Photo> getAlbumPhotos(Long albumId) {
        Query q = getEntityManager().createNamedQuery(Photo.PHOTO_GETALBUMPHOTOS, Post.class);
        q.setParameter("albumId", albumId);
        return q.getResultList();
    }

}
