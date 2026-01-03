package az.edu.itbrains.Aptekk.controller;

import az.edu.itbrains.Aptekk.dtos.response.AboutResponseDto;
import az.edu.itbrains.Aptekk.dtos.response.FeaturesResponseDto;
import az.edu.itbrains.Aptekk.dtos.response.TeamResponseDto;
import az.edu.itbrains.Aptekk.services.AboutService;
import az.edu.itbrains.Aptekk.services.FeaturesService;
import az.edu.itbrains.Aptekk.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AboutController {
    private final AboutService aboutService;
    private final TeamService teamService;
    private final FeaturesService featuresService;

    @GetMapping("/about") // localhost:8080/about
    public String about(Model model) {
        // About məlumatları
        AboutResponseDto aboutResponseDto = aboutService.getAboutsList();
        model.addAttribute("about", aboutResponseDto);

        // İlk section-dan video götür (əgər varsa)
        if (aboutResponseDto != null &&
                aboutResponseDto.getSections() != null &&
                !aboutResponseDto.getSections().isEmpty()) {

            // İlk section-un videoUrl-ni götür
            String firstVideoUrl = aboutResponseDto.getSections().get(0).getVideoUrl();

            if (firstVideoUrl != null && !firstVideoUrl.isEmpty()) {
                String videoId = extractYouTubeVideoId(firstVideoUrl);
                model.addAttribute("videoId", videoId);

                boolean isYouTube = firstVideoUrl.contains("youtube.com") ||
                        firstVideoUrl.contains("youtu.be");
                model.addAttribute("isYouTube", isYouTube);
                model.addAttribute("mainVideoUrl", firstVideoUrl);
            }
        }

        // Team məlumatları
        List<TeamResponseDto> teamResponseDtoList = teamService.getTeamsList();
        model.addAttribute("teams", teamResponseDtoList);

        // Features məlumatları
        List<FeaturesResponseDto> featuresResponseDtoList = featuresService.getFeaturesList();
        model.addAttribute("features", featuresResponseDtoList);

        return "about";
    }

    /**
     * YouTube URL-dən video ID çıxarır
     */
    private String extractYouTubeVideoId(String url) {
        if (url == null || url.isEmpty()) {
            return null;
        }

        try {
            // YouTube Shorts: youtube.com/shorts/VIDEO_ID
            if (url.contains("shorts/")) {
                int start = url.indexOf("shorts/") + 7;
                int end = url.indexOf("?", start);
                if (end == -1) {
                    return url.substring(start);
                }
                return url.substring(start, end);
            }

            // Normal YouTube: youtube.com/watch?v=VIDEO_ID
            if (url.contains("watch?v=")) {
                int start = url.indexOf("watch?v=") + 8;
                int end = url.indexOf("&", start);
                if (end == -1) {
                    return url.substring(start);
                }
                return url.substring(start, end);
            }

            // Qısa YouTube: youtu.be/VIDEO_ID
            if (url.contains("youtu.be/")) {
                int start = url.indexOf("youtu.be/") + 9;
                int end = url.indexOf("?", start);
                if (end == -1) {
                    return url.substring(start);
                }
                return url.substring(start, end);
            }
        } catch (Exception e) {
            System.err.println("Error extracting YouTube video ID: " + e.getMessage());
        }

        return null;
    }
}