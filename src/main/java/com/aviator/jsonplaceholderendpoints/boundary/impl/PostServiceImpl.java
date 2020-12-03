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

import com.aviator.jsonplaceholderendpoints.boundary.PostService;
import com.aviator.jsonplaceholderendpoints.entity.Comment;
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
public class PostServiceImpl extends AbstractBeanImpl<Post, Long> implements PostService {

    @PersistenceContext(name = Constants.ENTITY_MANAGER_NAME)
    private EntityManager entityManager;

    public PostServiceImpl() {
        super(Post.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Post> getPostsByUserId(Long id) {
        Query q = getEntityManager().createNamedQuery(Post.FINDPOSTSBYUSERID, Post.class);
        q.setParameter("userId", id);
        return q.getResultList();
    }

    @Override
    public List<Comment> getPostsComments(Long postId) {
        Query q = getEntityManager().createNamedQuery(Post.FINDPOSTSCOMMENTS, Comment.class);
        q.setParameter("postId", postId);
        return q.getResultList();
    }

}
