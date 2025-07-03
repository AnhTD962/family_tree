package com.domain.backend.service;

import com.domain.backend.model.Media;

import java.util.List;
import java.util.Optional;

public interface MediaService {
    Media addMedia(Media media);

    Optional<Media> getMediaById(String mediaId);

    List<Media> getMediaByMemberId(String memberId);

    List<Media> getMediaByTreeId(String treeId);

    void deleteMedia(String mediaId);

    List<Media> getAllMedia();
}
