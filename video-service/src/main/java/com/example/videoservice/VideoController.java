package com.example.videoservice;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
public class VideoController {
    public record Video(String id, String title, String description, String duration) {}

    @GetMapping
    public List<Video> listVideos() {
        return List.of(
            new Video("1", "Ocean Escape", "A relaxing blue-ocean demo clip.", "10 sec"),
            new Video("2", "Forest Morning", "A green nature demo clip.", "10 sec"),
            new Video("3", "Sunset Sky", "A warm sunset demo clip.", "10 sec")
        );
    }
}
