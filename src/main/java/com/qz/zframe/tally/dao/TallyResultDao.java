package com.qz.zframe.tally.dao;

import com.qz.zframe.tally.entity.TallyResult;
import com.qz.zframe.tally.entity.TallyResultChoose;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TallyResultDao {

    /**
     * 查所有结果选项基本信息
     * @param resultCode
     * @param resultName
     * @param firstIndex
     * @param lastIndex
     * @return
     */
    List<TallyResult> findAllTallyResult(@Param("resultCode") String resultCode, @Param("resultName") String resultName,
                                         @Param("firstIndex") int firstIndex, @Param("lastIndex")int lastIndex);

    /**
     * 查所有结果选项基本信息 分页用的记录总条数
     * @param resultCode
     * @param resultName
     * @return
     */
    int countTallyResult(@Param("resultCode")String resultCode,@Param("resultName") String resultName);

    /**
     * 新增结果基本信息表
     * @param tallyResult
     */
    void addTallyResult(TallyResult tallyResult);

    /**
     * 结果选项配置流水号
     * @return
     */
   int findserialNum();


    /**
     * 新增结果选项表
     * @param tallyResultChooseList
     */
    void addTallyResultChoose(List<TallyResultChoose> tallyResultChooseList);

    /**
     * 更新结果基本信息表
     * @param tallyResult
     */
    void updateTallyResult(TallyResult tallyResult);

    /**
     * 更新结果基本信息表
     * @param tallyResultChoose
     */
    void updateTallyResultChoose(TallyResultChoose tallyResultChoose);

    /**
     * 删除结果选项
     * @param resultIds
     */
    void deleteTallyResult(@Param("resultIds") String[] resultIds);

    /**
     * 根据id查选项基础信息表
     * @param resultId
     * @return
     */
    TallyResult findTallyResultByResultId(@Param("resultId") String resultId);

    /**
     *
     * 根据结果id查下面的选项
     * @param resultId
     * @return
     */
    List<TallyResultChoose> findTallyResultChooseByResultId(@Param("resultId") String resultId);

    /**
     * 根据编号查询结果选项分组选项
     * @param resultCode
     * @return
     */
    TallyResult findTallyResultByResultCode(@Param("resultCode") String resultCode);

    /**
     * 根据编号查询结果选项分组选项(不包括自己)
     * @param resultCode
     * @param resultId
     * @return
     */
    TallyResult findTallyResultByResultCodeNotId(@Param("resultCode") String resultCode, @Param("resultId") String resultId);

    /**
     * 根据结果选项分组id删除结果选项
     * @param resultId
     * @return
     */
    int deletetallyResultChooseList(@Param("resultId") String resultId);

    /**
     * 假删除
     * @param resultIds
     */
    int updateTallyResultIsDelete(@Param("resultIds") String[] resultIds);
}
