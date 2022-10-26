package xyz.liyouxiu.crm.workbench.mapper;

import xyz.liyouxiu.crm.workbench.domian.Activity;
import xyz.liyouxiu.crm.workbench.domian.Clue;

import java.util.List;
import java.util.Map;

public interface ClueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Wed Oct 26 10:47:46 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Wed Oct 26 10:47:46 CST 2022
     */
//    int insert(Clue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Wed Oct 26 10:47:46 CST 2022
     */
    int insertSelective(Clue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Wed Oct 26 10:47:46 CST 2022
     */
    Clue selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Wed Oct 26 10:47:46 CST 2022
     */
    int updateByPrimaryKeySelective(Clue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Wed Oct 26 10:47:46 CST 2022
     */
    int updateByPrimaryKey(Clue record);

    /**
     * 保存创建的线索
     * @param Clue
     * @return
     */
    int insertClue(Clue Clue);

    /**
     * 根据条件查询线索的总条数
     * @param map
     * @return
     */
    List<Clue> selectClueByConditionForPage(Map<String, Object> map);
}