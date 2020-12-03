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

import com.aviator.jsonplaceholderendpoints.boundary.UserService;
import com.aviator.jsonplaceholderendpoints.control.rest.UserRESTFacadeI;
import com.aviator.jsonplaceholderendpoints.entity.Album;
import com.aviator.jsonplaceholderendpoints.entity.Post;
import com.aviator.jsonplaceholderendpoints.entity.ToDo;
import com.aviator.jsonplaceholderendpoints.entity.UserModel;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

/**
 *
 * @author Aviator
 */
@Stateless
public class UserRESTFacadeImpl implements UserRESTFacadeI {

    @EJB
    private UserService userService;

    @Override
    public long count() {
        return userService.count();
    }

    @Override
    public List<UserModel> findRange(int[] range) {
        return userService.findRange(range);
    }

    @Override
    public List<UserModel> findAll() {
        return userService.findAll();
    }

    @Override
    public Response find(Long id) {
        UserModel user = userService.find(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(user).build();
    }

    @Override
    public Response remove(Long id) {
        if (userService.remove(id)) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @Override
    public Response edit(UserModel entity) {
        UserModel model = userService.edit(entity);
        if (model == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().entity(model).build();
    }

    @Override
    public Response create(UserModel entity) {
        UserModel model = userService.create(entity);
        if (model == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().entity(model).build();
    }

    @Override
    public Response findUserByEmail(String email) {
        return userService.findUserByEmail(email);
    }

    @Override
    public Response findUserByUsername(String userName) {
        return userService.findUserByUsername(userName);
    }

    @Override
    public List<Post> getUserPosts(Long userId) {
        return userService.getUserPosts(userId);
    }

    @Override
    public List<Album> getUserAlbums(Long userId) {
        return userService.getUserAlbums(userId);
    }

    @Override
    public List<ToDo> getUserToDos(Long userId) {
        return userService.getUserToDos(userId);
    }

}
