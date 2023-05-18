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
    //@PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item, Model model){

        itemRepository.save(item);
        //model.addAttribute("item",item); // 자동으로 추가 생략가능 하나
        // @ModelAttribute에서 @ModelAttribute에서 이름 안 사용하면 클래스 Item의   첫글 자만 소문자로 변경되어  item 이름으로 자동으로 만들어준다.

        return "basic/item";
    }@PostMapping("/add")
    public String addItemV4(Item item){ // @ModelAttribute 도 생략가능하다

        itemRepository.save(item);


        return "basic/item";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model){
        Item item = itemRepository.findById(itemId); //아이템을 아이템 아이디를 통해서 찾는다.
        model.addAttribute("item",item); //모델에 넣어준다.

        return "basic/editForm"; //basic/items 경로로 반환한다.
    }

    //테스트하기위한 데이터 넣기
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA",10000,10));
        itemRepository.save(new Item("itemB",20000,10));
    }
}
