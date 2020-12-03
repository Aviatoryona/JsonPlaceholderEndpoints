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
package com.aviator.jsonplaceholderendpoints.control.rest;

import com.aviator.jsonplaceholderendpoints.entity.Comment;
import com.aviator.jsonplaceholderendpoints.entity.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;

/**
 *
 * @author Aviator
 */
@Path("/posts")
@Tag(name = "Post")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public interface PostRESTFacadeI {

    @GET
    @Path("/{id}")
    @Operation(
            summary = "Get post by  id",
            responses = {
                @ApiResponse(
                        description = "The Post",
                        content
                        = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Post.class))),
                @ApiResponse(responseCode = "400", description = "Post not found", content
                        = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Error.class)))
            })
    public Response find(@PathParam(value = "id") Long id);

    @GET
    @Path(value = "/count")
    @Produces({MediaType.TEXT_PLAIN})
    public long count();

    public List<Post> findRange(int[] range);

    @GET
    public List<Post> findAll();

    @DELETE
    @Path(value = "/{id}")
    public boolean remove(@PathParam(value = "id") Long id);

    @PUT
    public Post edit(Post entity);

    @POST
    public Response create(Post entity);

    @GET
    public List<Post> getPostsByUserId(@QueryParam(value = "userId") Long userId);

    @GET
    List<Comment> getPostsComments(@QueryParam(value = "postId") Long postId);

}
