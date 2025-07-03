package com.domain.backend.controller;

import com.domain.backend.model.Media;
import com.domain.backend.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping
    public ResponseEntity<Media> addMedia(@RequestBody Media media) {
        Media created = mediaService.addMedia(media);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{mediaId}")
    public ResponseEntity<Media> getMedia(@PathVariable String mediaId) {
        return mediaService.getMediaById(mediaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Media>> getMediaByMember(@PathVariable String memberId) {
        return ResponseEntity.ok(mediaService.getMediaByMemberId(memberId));
    }

    @GetMapping("/tree/{treeId}")
    public ResponseEntity<List<Media>> getMediaByTree(@PathVariable String treeId) {
        return ResponseEntity.ok(mediaService.getMediaByTreeId(treeId));
    }

    @DeleteMapping("/{mediaId}")
    public ResponseEntity<Void> deleteMedia(@PathVariable String mediaId) {
        mediaService.deleteMedia(mediaId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Media>> getAllMedia() {
        return ResponseEntity.ok(mediaService.getAllMedia());
    }
}
