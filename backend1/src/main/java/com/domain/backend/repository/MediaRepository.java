package com.domain.backend.repository;

import com.domain.backend.model.Media;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MediaRepository extends MongoRepository<Media, String> {
    List<Media> findByMemberId(String memberId);

    List<Media> findByTreeId(String treeId);
}
