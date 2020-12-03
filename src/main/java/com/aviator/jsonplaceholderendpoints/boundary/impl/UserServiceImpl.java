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

import com.aviator.jsonplaceholderendpoints.boundary.UserService;
import com.aviator.jsonplaceholderendpoints.entity.Album;
import com.aviator.jsonplaceholderendpoints.entity.Post;
import com.aviator.jsonplaceholderendpoints.entity.ToDo;
import com.aviator.jsonplaceholderendpoints.entity.UserModel;
import com.aviator.jsonplaceholderendpoints.util.Constants;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

/**
 *
 * @author Aviator
 */
@Stateless
public class UserServiceImpl extends AbstractBeanImpl<UserModel, Long> implements UserService {

    @PersistenceContext(
            name = Constants.ENTITY_MANAGER_NAME
    )
    EntityManager entityManager;

    public UserServiceImpl() {
        super(UserModel.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Response findUserByEmail(String email) {
        try {
            Query q = getEntityManager().createNamedQuery(UserModel.FINDBYEMAIL, UserModel.class);
            q.setParameter("email", email);
            UserModel u = (UserModel) q.getSingleResult();
            return Response.ok().entity(u).build();
        } catch (ClassCastException e) {

        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @Override
    public Response findUserByUsername(String userName) {
        try {
            Query q = getEntityManager().createNamedQuery(UserModel.FINDBYUSERNAME, UserModel.class);
            q.setParameter("username", userName);
            UserModel u = (UserModel) q.getSingleResult();
            return Response.ok().entity(u).build();
        } catch (ClassCastException e) {

        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @Override
    public List<Post> getUserPosts(Long userId) {
        Query q = getEntityManager().createNamedQuery(UserModel.GETUSERPOSTS, Post.class);
        q.setParameter("userId", userId);
        return q.getResultList();
    }

    @Override
    public List<Album> getUserAlbums(Long userId) {
        Query q = getEntityManager().createNamedQuery(UserModel.GETUSERALBUMS, Album.class);
        q.setParameter("userId", userId);
        return q.getResultList();
    }

    @Override
    public List<ToDo> getUserToDos(Long userId) {
        Query q = getEntityManager().createNamedQuery(UserModel.GETUSERTODO, ToDo.class);
        q.setParameter("userId", userId);
        return q.getResultList();
    }

}
