package hello.itemservice.domain.item;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * FAST : 빠른배송
 * NORMAL : 보통배송
 * SLOW : 느리배송
 */

@Data
@AllArgsConstructor
public class DeliveryCode {

    private String code;
    private String displayName;


}
