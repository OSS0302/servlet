package oss.itemservice.web.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import oss.itemservice.repository.ItemRepository;

@Controller
@RequestMapping("/basic/items")
public class BasicItemController {
    private  final ItemRepository itemRepository;

    @Autowired
    public BasicItemController(ItemRepository itemRepository){
        this.itemRepository =itemRepository;
    }
}
