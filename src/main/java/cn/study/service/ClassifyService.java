package cn.study.service;

import cn.study.pojo.Classify;

import java.util.List;

/**
 * @author asus
 * @Title: ClassifyService
 * @ProjectName mymall
 * @Description: TODO
 * @date 2018/9/6 9:22
 */
public interface ClassifyService {
    /**
     * 查询所有
     * @return list
     */
    List<Classify> getAll();

    /**
     * 回显
     * @param id classify id
     * @return classify instance
     */
    Classify getClassifyById(int id);

    /**
     * 获取根类别
     * @param parentId 0
     * @return list
     */
    List<Classify> getRoot(int parentId);
    /**
     * 获取子类别
     * @param parentId 0
     * @return list
     */
    List<Classify> getChildren(int parentId);

    /**
     * 修改类别描述
     * @param classify 修改
     */
    void updateClassify(Classify classify);

    /**
     * 新增类别
     * @param classify 对象
     */
    void addClassify(Classify classify);
}
