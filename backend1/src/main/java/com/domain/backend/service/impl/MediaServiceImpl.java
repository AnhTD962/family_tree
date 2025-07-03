package com.domain.backend.service.impl;

import com.domain.backend.model.Media;
import com.domain.backend.repository.MediaRepository;
import com.domain.backend.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Override
    public Media addMedia(Media media) {
        return mediaRepository.save(media);
    }

    @Override
    public Optional<Media> getMediaById(String mediaId) {
        return mediaRepository.findById(mediaId);
    }

    @Override
    public List<Media> getMediaByMemberId(String memberId) {
        return mediaRepository.findByMemberId(memberId);
    }

    @Override
    public List<Media> getMediaByTreeId(String treeId) {
        return mediaRepository.findByTreeId(treeId);
    }

    @Override
    public void deleteMedia(String mediaId) {
        mediaRepository.deleteById(mediaId);
    }

    @Override
    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }
}
