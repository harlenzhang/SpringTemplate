package com.tqmall.combo.mapper;

import com.tqmall.combo.model.Cart;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartMapper {

    int deleteByPrimaryKey(Integer recId);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer recId);

    int updateByPrimaryKeySelective(Cart record);

    List<Cart> getCartByParam(@Param("goodsId") Integer goodsId,
                              @Param("uid") Integer uid,
                              @Param("deviceId") String deviceId,
                              @Param("buyNow") byte buyNow,
                              @Param("activityId") Integer activityId,
                              @Param("activityGroupId") Integer activityGroupId,
                              @Param("userType") byte userType,
                              @Param("cityId") Integer cityId);

    List<Cart> getKaCartByParam(@Param("goodsId") Integer goodsId,
                                @Param("uid") Integer uid,
                                @Param("deviceId") String deviceId,
                                @Param("buyNow") byte buyNow,
                                @Param("activityId") Integer activityId,
                                @Param("activityGroupId") Integer activityGroupId,
                                @Param("userType") byte userType,
                                @Param("warehouseId") Integer warehouseId);



    List<Cart> queryCartGoods(@Param("cityId") Integer cityId,
                              @Param("uid") Integer uid,
                              @Param("deviceId") String deviceId,
                              @Param("userType") byte userType,
                              @Param("buyNow") byte buyNow);

    List<Cart> queryCartGoodsSortByCreateTime(@Param("cityId") Integer cityId,
                                              @Param("uid") Integer uid,
                                              @Param("deviceId") String deviceId,
                                              @Param("userType") byte userType,
                                              @Param("buyNow") byte buyNow);

    List<Cart> queryKaCartGoods(@Param("uid") Integer uid, @Param("warehouseId") Integer warehouseId, @Param("userType") byte userType);

    @Update("update db_cart set goods_number = goods_number+#{goodsNumber}, gmt_modified = now() where rec_id = #{recId} and buy_now <> 1")
    @Transactional
    int updateCartGoodsNumWhenExist(@Param("recId") Integer recId, @Param("goodsNumber") Integer goodsNumber);

    @Transactional
    int batchDeleteCartGoods(String[] recIds);

    List<Cart> queryCartById(List<Integer> cartIdList);

    @Update("update db_cart set user_id=#{uid} where session_id=#{sessionId}")
    @Transactional
    int syncCart(@Param("sessionId") String sessionId, @Param("uid") Integer uid);

    List<Cart> batchQueryCartByIds(List<String> recIds);

    List<Cart> selectByRecIds(@Param("recIds") List<Integer> recIds);

    @Update("update db_cart set goods_number = #{goodsNumber}, gmt_modified = now() where rec_id = #{recId} and buy_now <> 1")
    @Transactional
    int updateCartGoodsNum(@Param("recId") Integer recId, @Param("goodsNumber") Integer goodsNumber);

    @Transactional
    Integer deleteBuyNowHistory(@Param("uid") int uid, @Param("deviceId") String deviceId);

    Integer deleteBuyNow(@Param("uid") Integer uid, @Param("actIds") List<Integer> actIds, @Param("buynow") Integer buynow);

    List<Integer> getBuynowRecIds(@Param("uid") int uid, @Param("cityId") int cityId);

    List<Cart> selectByRecIdsAndBuynow(@Param("recIds") List<Integer> recIds);

    @Transactional
    int batchDeleteCartGood(@Param("recIds") List<Integer> recIds);
}