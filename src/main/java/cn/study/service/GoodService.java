package cn.study.service;

import cn.study.pojo.Classify;
import cn.study.pojo.Good;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/3 17:02
 */
public interface GoodService {
    /**
     * 返回商品集合
     * @return list
     */
    List<Good> getList();

    /**
     * 回显
     * @param id goodId
     * @return good
     */
    Good getGoodById(int id);

    /**
     * 查询所有商品类别
     * @return list
     */
    List<Classify> getAllGroups();

    /**
     * 修改商品信息
     * @param good 商品
     */
    void updateGood(Good good);
    /**
     * delete good by id
     * @param id id
     */
    void delGood(Integer id);

    /**
     * 添加商品
     * @param good instance
     */
    void addGood(Good good);
    /**
     * 根据上架状态查询
     * @return  list
     * @param isSale sale status
     */
    List<Good> getGoodsBySale(int isSale);

    /**
     * 更新 上架状态
     * @param id good id
     * @param sale isSale
     */
    void updateSale(int id,int sale);
}
