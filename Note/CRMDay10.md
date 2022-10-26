# 查询市场活动

当市场活动主页面加载完成之后,显示所有数据的第一页;

用户在市场活动主页面填写查询条件,点击"查询"按钮,显示所有符合条件的数据的第一页，保持每页显示条数不变

实现翻页功能.

  *在市场活动主页面,显示市场活动列表和记录的总条数

  *默认每页显示条数:10

## 一个表可以被连接多次，通过起别名来连接

分页查询sql语句

~~~sql
<select id="selectActivityByConditionForPage" parameterType="map" resultMap="BaseResultMap">
        select a.id, u1.name as owner,a.name,a.start_date,a.end_date,a.cost,a.description,a.create_time,u2.name as create_by
            ,a.edit_time,u3.name as edit_by
        from tbl_activity a
        join tbl_user u1 on a.owner=u1.id
        join tbl_user u2 on a.create_by=u2.id
        left join tbl_user u3 on a.edit_by=u3.id
        <where>
          <if test="name!=null and name!=''">
            and a.name like '%' #{name} '%'
          </if>
          <if test="owner!=null and owner!=''">
            and u1.name like '%' #{owner} '%'
          </if>
          <if test="startDate!=null and startDate!=''">
            and a.start_date &gt;= #{startDate}
          </if>
          <if test="endDate!=null and endDate!=''">
            and a.end_date &lt;= #{endDate}
          </if>
        </where>
        order by a.create_time desc
        limit #{beginNO},#{pageSize}
  </select>
~~~