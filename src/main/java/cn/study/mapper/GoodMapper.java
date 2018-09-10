package cn.study.mapper;

import cn.study.pojo.Classify;
import cn.study.pojo.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author asus
 * @Title: GoodMapper
 * @ProjectName mymall
 * @Description: TODO
 * @date 2018/9/3 16:49
 */
public interface GoodMapper {
    /**
     * get goods list
     * @return list of all goods
     */
    List<Good> getAllGoods();

    /**
     * get a good by id
     * @param id good id
     * @return good
     */
    Good queryGoodById(Integer id);

    /**
     *  get all groups
     * @return 查询所有类型
     */
    List<Classify> queryAllGroups();

    /**
     * 修改
     * @param good 商品
     */
    void updateGood(Good good);

    /**
     * delete
     * @param id id
     */
    void deleteGood(Integer id);

    /**
     * 添加商品
     * @param good good对象
     */
    void addGood(Good good);

    /**
     * get good by sale status
     * @param isSale sale status
     * @return list
     */
    List<Good> getAllGoodsBySale(int isSale);

    /**
     * 更新上架状态
     * @param id goodd
     * @param sale isSale
     */
    void updateSale(@Param("id") int id,@Param("sale") int sale);

}
