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

import com.aviator.jsonplaceholderendpoints.entity.Album;
import com.aviator.jsonplaceholderendpoints.entity.Post;
import com.aviator.jsonplaceholderendpoints.entity.ToDo;
import com.aviator.jsonplaceholderendpoints.entity.UserModel;
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
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;

/**
 *
 * @author Aviator
 */
@Path("/users")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Tag(name = "User")
public interface UserRESTFacadeI {

    /**
     *
     * @return
     */
    @GET
    @Path("/count")
    @Produces({MediaType.TEXT_PLAIN})
    @Operation(
            summary = "Get number of users",
            responses = {
                @ApiResponse(
                        description = "Users",
                        content
                        = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserModel.class))),
                @ApiResponse(responseCode = "400", description = "Not found")
            })
    public long count();

    /**
     *
     * @param range
     * @return
     */
    @GET
    @Path("/find")
    @Operation(
            summary = "Get users between n to nth",
            responses = {
                @ApiResponse(
                        description = "Users",
                        content
                        = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserModel.class))),
                @ApiResponse(responseCode = "400", description = "Not found")
            })
    public List<UserModel> findRange(int[] range);

    /**
     *
     * @return
     */
    @GET
    @Operation(
            summary = "Get all users",
            responses = {
                @ApiResponse(
                        description = "Users",
                        content
                        = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserModel.class))),
                @ApiResponse(responseCode = "400", description = "Not found")
            })
    public List<UserModel> findAll();

    /**
     *
     * @param primaryKey
     * @return
     */
    @GET
    @Path("/{id}")
    @Operation(
            summary = "Get user by  id",
            responses = {
                @ApiResponse(
                        description = "The User",
                        content
                        = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserModel.class))),
                @ApiResponse(responseCode = "400", description = "User not found")
            })
    public Response find(@PathParam(value = "id") Long primaryKey);

    /**
     *
     * @param id Long
     * @return
     */
    @DELETE
    @Operation(
            summary = "Delete user",
            responses = {
                @ApiResponse(
                        description = "Users",
                        content
                        = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserModel.class))),
                @ApiResponse(responseCode = "400", description = "Not found")
            })

    @Path(value = "/{id}")
    public Response remove(@PathParam(value = "id") Long id);

    /**
     *
     * @param entity
     * @return
     */
    @PUT
    @Operation(
            summary = "Edit user",
            responses = {
                @ApiResponse(
                        description = "Users",
                        content
                        = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserModel.class))),
                @ApiResponse(responseCode = "400", description = "Not found")
            })
    public Response edit(UserModel entity);

    /**
     *
     * @param entity
     * @return
     */
    @POST
    @Operation(
            summary = "Create user",
            responses = {
                @ApiResponse(
                        description = "The User",
                        content
                        = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserModel.class))),
                @ApiResponse(responseCode = "400", description = "Error")
            })
    public Response create(UserModel entity);

    @GET
    @Path("/email/{email}")
    @Operation(
            description = "Find User By Email",
            responses = {
                @ApiResponse(
                        description = "findUserByEmail",
                        content
                        = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserModel.class))),
                @ApiResponse(responseCode = "400", description = "Error")
            }
    )
    Response findUserByEmail(@PathParam(value = "email") String email);

    @GET
    @Path("/username/{username}")
    @Operation(
            description = "Find User By Email",
            responses = {
                @ApiResponse(
                        description = "findUserByUsername",
                        content
                        = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserModel.class))),
                @ApiResponse(responseCode = "400", description = "Error")
            }
    )
    Response findUserByUsername(@PathParam(value = "username") String userName);

    @GET
    @Path(value = "/post/{userId}")
    List<Post> getUserPosts(@PathParam(value = "userId") Long userId);

    @GET
    @Path(value = "/album/{userId}")
    List<Album> getUserAlbums(@PathParam(value = "userId") Long userId);

    @GET
    @Path(value = "/todo/{userId}")
    List<ToDo> getUserToDos(@PathParam(value = "userId") Long userId);

}
