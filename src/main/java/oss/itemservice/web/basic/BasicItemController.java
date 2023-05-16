package oss.itemservice.web.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import oss.itemservice.repository.ItemRepository;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {
    private  final ItemRepository itemRepository;

//    @Autowired
//    public BasicItemController(ItemRepository itemRepository){
//        this.itemRepository =itemRepository;
//    }
}
