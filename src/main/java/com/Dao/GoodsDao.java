package com.Dao;

import com.Vo.GoodsVo;
import com.domain.MiaoshaGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsDao {

    /**
     * 查询秒杀商品的信息
     * @return GoodsVo实体类的List
     */
    @Select("select g.*, mg.stock_count, mg.miaosha_price, mg.start_date, mg.end_date " +
            "from miaosha_goods mg left join goods g on mg.goods_id = g.id")
    public List<GoodsVo> getGoodsListVo();

    @Select("select g.*, mg.stock_count, mg.miaosha_price, mg.start_date, mg.end_date " +
            "from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id=#{goodsId}")
    public GoodsVo getGoodsVoByGoodsId(@Param("goodsId")Long goodsId);

    @Update("update miaosha_goods set stock_count=stock_count - 1 where goods_id=#{goodsId}")
    public void reduceStock(MiaoshaGoods g);
}
