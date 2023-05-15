package oss.itemservice.domain;

import lombok.Data;

@Data
public class Item {

      private Long id; // 회원 아이디
      private String itemName; // 상품 이름
      private Integer priace; // 가격
      private Integer quantity; // 수량

    public Item() {
    }

    public Item(String itemName, Integer priace, Integer quantity) {
        this.itemName = itemName;
        this.priace = priace;
        this.quantity = quantity;
    }
}
