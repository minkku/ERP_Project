package org.gagu.controller.vender;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gagu.dto.vender.RegisterVenderResponse;
import org.gagu.dto.vender.UpdateVender;
import org.gagu.dto.vender.VenderResponse;
import org.gagu.entity.vender.Vender;
import org.gagu.service.vender.VenderService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Log4j2
public class VenderController {
    private final VenderService venderService;
    @GetMapping("/venderList")
    public String getVenderList(Model model,
                                @RequestParam(value = "size", defaultValue = "10") int size,
                                @RequestParam(value = "page", defaultValue = "0")int page)
    {
        Page<VenderResponse> getVenderList = venderService.getVenderList(size, page);

        model.addAttribute("list", getVenderList);

        return "vender";
    }

    @PostMapping("/vender")
    public Vender register(@RequestBody RegisterVenderResponse response) {
        log.info("-------- POST VENDER DATA -----------");
        return venderService.registerVender(response);
    }

    @GetMapping("/updateVender")
    public ResponseEntity<Vender> getUpdateVender(@RequestParam("venderId") int venderId) {
        Vender result = venderService.getVender(venderId);
        log.info("-------------- get id controller ------------------");
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @PutMapping("/updating")
    public ResponseEntity<String> updateVender(@RequestParam("venderId") int venderId, @RequestBody UpdateVender request) {
        try {
            venderService.updateVender(venderId, request);
            return ResponseEntity.ok("Success to update : " + venderId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update : " + e.getMessage());
        }
    }

    @DeleteMapping("/deleting/{venderId}")
    public ResponseEntity<Integer> deleteList(@PathVariable int venderId) {
        venderService.deleteList(venderId);

        return new ResponseEntity<>(venderId, HttpStatus.OK);
    }
}