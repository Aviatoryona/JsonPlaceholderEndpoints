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

import com.aviator.jsonplaceholderendpoints.boundary.PostService;
import com.aviator.jsonplaceholderendpoints.control.rest.PostRESTFacadeI;
import com.aviator.jsonplaceholderendpoints.entity.Comment;
import com.aviator.jsonplaceholderendpoints.entity.Post;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

/**
 *
 * @author Aviator
 */
@Stateless
public class PostRESTFacadeImpl implements PostRESTFacadeI {

    @EJB
    private PostService postService;

    @Override
    public Response find(Long id) {
        Post post = postService.find(id);
        if (post == null) {
            Error error = new Error();
            ErrorInfo errorInfo = new ErrorInfo();
            errorInfo.setBriefSummary("User not found");
            errorInfo.setStatusCode(400);
            errorInfo.setDescriptionURL("http://localhost:8081/TrainingApp/swagger-ui/#/Post/retrievePost");
            error.setErrorInfo(errorInfo);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
        return Response.ok().entity(post).build();
    }

    @Override
    public Response create(Post post) {
        Post createdPost = postService.create(post);
        if (createdPost == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().entity(createdPost).build();
    }

    @Override
    public long count() {
        return postService.count();
    }

    @Override
    public List<Post> findRange(int[] range) {
        return postService.findRange(range);
    }

    @Override
    public List<Post> findAll() {
        return postService.findAll();
    }

    @Override
    public boolean remove(Long id) {
        return postService.remove(id);
    }

    @Override
    public Post edit(Post entity) {
        return postService.edit(entity);
    }

    @Override
    public List<Post> getPostsByUserId(Long id) {
        return postService.getPostsByUserId(id);
    }

    @Override
    public List<Comment> getPostsComments(Long postId) {
        return postService.getPostsComments(postId);
    }

}
