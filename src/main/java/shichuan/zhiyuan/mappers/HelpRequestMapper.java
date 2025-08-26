package shichuan.zhiyuan.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import shichuan.zhiyuan.entity.query.HelpRequest;

import java.util.List;

@Mapper
public interface HelpRequestMapper {
    // 插入
    Integer insert(HelpRequest helpRequest);

    // 查询所有
    List<HelpRequest> selectAll();

    // 根据ID查询
    HelpRequest selectById(@Param("id") Integer id);


}
