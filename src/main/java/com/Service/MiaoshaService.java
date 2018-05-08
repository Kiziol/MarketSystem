package com.Service;

import com.Vo.GoodsVo;
import com.domain.Goods;
import com.domain.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MiaoshaService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Transactional
    public OrderInfo miaoshao(Long telephone, GoodsVo goods) {
        goodsService.reduceStock(goods);
        return orderService.createOrder(telephone, goods);
    }
}
