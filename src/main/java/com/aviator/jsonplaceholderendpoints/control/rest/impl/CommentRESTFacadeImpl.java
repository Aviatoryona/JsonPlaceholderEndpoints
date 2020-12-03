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

import com.aviator.jsonplaceholderendpoints.boundary.CommentService;
import com.aviator.jsonplaceholderendpoints.control.rest.CommentRESTFacadeI;
import com.aviator.jsonplaceholderendpoints.entity.Comment;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Response;

/**
 *
 * @author Aviator
 */
public class CommentRESTFacadeImpl implements CommentRESTFacadeI {

    @EJB
    CommentService commentService;

    @Override
    public Response find(long id) {
        Comment comment = commentService.find(id);
        if (comment == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().entity(comment).build();
    }

    @Override
    public Response create(Comment comment) {
        Comment c = commentService.create(comment);
        if (c == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().entity(c).build();
    }

    @Override
    public long count() {
        return commentService.count();
    }

    @Override
    public List<Comment> findRange(int[] range) {
        return commentService.findRange(range);
    }

    @Override
    public List<Comment> findAll() {
        return commentService.findAll();
    }

    @Override
    public boolean remove(Long id) {
        return commentService.remove(id);
    }

    @Override
    public Comment edit(Comment entity) {
        return commentService.edit(entity);
    }

    @Override
    public List<Comment> getPostComments(Long postId) {
        return commentService.getPostComments(postId);
    }

    @Override
    public List<Comment> getUserPostComments(Long userId) {
        return commentService.getUserPostComments(userId);
    }

}
