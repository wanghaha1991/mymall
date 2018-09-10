package cn.study.mapper;

import cn.study.pojo.Classify;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/6 9:06
 */
public interface ClassifyMapper {

    /**
     * 获得所有的类别
     * @return list
     */
    List<Classify> getAllClassifies();

    /**
     * 回显
     * @param id id
     * @return classify
     */
    Classify queryClassifyByid(int id);

    /**
     * 获取所有一级目录的类别
     * @return list classify
     */
    List<Classify> getRoot(int parentId);

    /**
     * 查找子节点
     * @param parentId 父类别
     * @return list
     */
    List<Classify> getChildren(int parentId);

    /**
     *  修改
     * @param classify 实例
     */
    void updateClassify(Classify classify);

    /**
     * 添加类别
     * @param classify instance
     */
    void addClassify(Classify classify);
}
