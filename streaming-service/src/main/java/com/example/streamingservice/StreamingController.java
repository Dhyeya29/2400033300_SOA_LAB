package com.example.streamingservice;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stream")
public class StreamingController {
    @GetMapping(value = "/{id}", produces = "video/mp4")
    public ResponseEntity<Resource> streamVideo(@PathVariable String id) {
        String fileName = switch (id) {
            case "1" -> "ocean.mp4";
            case "2" -> "forest.mp4";
            case "3" -> "sunset.mp4";
            default -> null;
        };
        if (fileName == null) return ResponseEntity.notFound().build();
        Resource video = new ClassPathResource("videos/" + fileName);
        if (!video.exists()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().contentType(MediaType.valueOf("video/mp4")).body(video);
    }
}
