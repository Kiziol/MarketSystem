package com.Service;

import com.Dao.GoodsDao;
import com.Vo.GoodsVo;
import com.domain.Goods;
import com.domain.MiaoshaGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsDao goodsDao;

    public List<GoodsVo> getGoodsListVo() {
        return goodsDao.getGoodsListVo();
    }

    public GoodsVo getGoodsVoByGoodsId(Long goodsId) {
        return goodsDao.getGoodsVoByGoodsId(goodsId);
    }

    public void reduceStock(GoodsVo goodsVo) {
        MiaoshaGoods mg = new MiaoshaGoods();
        mg.setGoodsId(goodsVo.getId());
        mg.setStockCount(goodsVo.getStockCount() - 1);
        goodsDao.reduceStock(mg);
    }
}
