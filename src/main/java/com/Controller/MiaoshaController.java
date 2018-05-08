package com.Controller;

import com.Result.CodeMsg;
import com.Service.GoodsService;
import com.Service.MiaoshaService;
import com.Service.OrderService;
import com.Vo.GoodsVo;

import com.domain.MiaoshaOrder;
import com.domain.OrderInfo;
import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoshaService miaoshaService;

    @RequestMapping("/doMiaosha")
    public String doMiaosha(Model model, @RequestParam("goodsId")Long goodsId,
                            @SessionAttribute User user) {
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        //判断库存
        int stock = goods.getStockCount();
        if(stock <= 0) {
            model.addAttribute("errmsg", CodeMsg.MIAOSHA_OVER.getMsg());
            return "miaoshaFail";
        }
        //判断是否已经秒杀到
        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdAndGoodsId(user.getTelephone(), goodsId);
        if(order != null) {
            model.addAttribute("errmsg", CodeMsg.MIAOSHA_REPEAT.getMsg());
            return "miaoshaFail";
        }
        //减库存 下订单 写入秒杀订单
        OrderInfo orderInfo = miaoshaService.miaoshao(user.getTelephone(), goods);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("goods", goods);
        return "orderDetail";
    }
}
