package com.augusto.dojooverflow.Repositories;

import org.springframework.stereotype.Repository;

import com.augusto.dojooverflow.Models.Tag;

@Repository
public interface TagRepository extends BaseRepository<Tag> {
    Tag findBySubject(String subject);
}
