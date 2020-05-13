package com.monkey.bootcloud.dao;

import com.monkey.bootcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Payment)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-13 10:25:39
 */
@Mapper
public interface PaymentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Payment queryById(Long id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param payment 实例对象
     * @return 对象列表
     */
    List<Payment> queryAll(Payment payment);

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 影响行数
     */
    int insert(Payment payment);

}