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

import com.aviator.jsonplaceholderendpoints.entity.Photo;
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

/**
 *
 * @author Aviator
 */
@Path("/photos")
@Tag(name = "Photos")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface PhotoRESTFacadeI {

    @GET
    @Path(value = "/count")
    @Produces({MediaType.TEXT_PLAIN})
    public long count();

    public List<Photo> findRange(int[] range);

    @GET
    public List<Photo> findAll();

    @GET
    @Path(value = "/{id}")
    public Photo find(@PathParam(value = "id") Long id);

    @DELETE
    @Path(value = "/{id}")
    public boolean remove(@PathParam(value = "id") Long id);

    @PUT
    public Photo edit(Photo entity);

    @POST
    public Photo create(Photo entity);

    @GET
    @Path(value = "/{albumId}/photos")
    List<Photo> getAlbumPhotos(@PathParam(value = "albumId") Long albumId);

}
