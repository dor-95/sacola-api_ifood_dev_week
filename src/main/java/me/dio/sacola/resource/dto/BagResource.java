package me.dio.sacola.resource.dto;

import lombok.RequiredArgsConstructor;
import me.dio.sacola.model.Bag;
import me.dio.sacola.model.Item;
import me.dio.sacola.service.BagService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ifood-devweek/bags")
@RequiredArgsConstructor
public class BagResource {

    private final BagService bagService;

    @PostMapping
    public Item includeItemInBag(@RequestBody ItemDto itemDto) {
        return bagService.includeItemInBag(itemDto);
    }

    @GetMapping("/{id}")
    public Bag seeBag(@PathVariable("id") Long id) {
        return bagService.seeBag(id);
    }

    @PatchMapping("/closeBag/{sacolaId}")
    public Bag closeBag(@PathVariable("sacolaId") Long sacolaId,
                        @RequestParam("formPayment") int formPayment) {
        return bagService.closeBag(sacolaId, formPayment);
    }

}
