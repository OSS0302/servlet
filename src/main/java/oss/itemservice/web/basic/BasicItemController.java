package oss.itemservice.web.basic;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import oss.itemservice.domain.Item;
import oss.itemservice.repository.ItemRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {
    private  final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model ){
        List<Item> items = itemRepository.findAll(); // 상품 전체 조회 리스트
        model.addAttribute("items",items);// 이름: items 데이터 items를 모델 실어서 보낸다.
        return "basic/items";
    }
    //상품 상세
    @GetMapping("/{itemId}")
        public String item(@PathVariable long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/item";
    }
    // 상품 등록 폼 만들기
    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }
    //@PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam Integer quantity,
                       Model model){
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);

        model.addAttribute("item",item);
        return "basic/item";
    }

    // model.attribute 사용하기
    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item")Item item, Model model){
       // @ModelAttribute가  1.아래와같이 동작하며 아이템 인스턴스 생성후 상품이름과 가격 수량 등를 자동 만들어준다.
        //model.addAttribute("item",item); 자동으로 뷰에 넣어준다. 그래서 만들 필요가 없다.
//        Item item = new Item();
//        item.setItemName(itemName);
//        item.setPrice(price);
//        item.setQuantity(quantity);

        itemRepository.save(item);


        return "basic/item";
    }

    //테스트하기위한 데이터 넣기
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA",10000,10));
        itemRepository.save(new Item("itemB",20000,10));
    }
}
