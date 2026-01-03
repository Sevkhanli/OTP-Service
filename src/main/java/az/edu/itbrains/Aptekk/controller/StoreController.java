package az.edu.itbrains.Aptekk.controller;

import az.edu.itbrains.Aptekk.dtos.response.CureStoreDto;
import az.edu.itbrains.Aptekk.services.CureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StoreController {
    private final CureService cureService;

    @GetMapping("/store") // localhost:8080/store
    public String store(Model model) {
        List<CureStoreDto> cureStoreDtoList = cureService.getCuresForStore();
        model.addAttribute("cures", cureStoreDtoList);
        return "store";

    }
}


