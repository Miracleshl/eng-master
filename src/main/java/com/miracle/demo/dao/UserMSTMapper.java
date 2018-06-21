package com.miracle.demo.dao;

import com.miracle.demo.domain.UserMST;
import com.miracle.demo.domain.UserMSTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMSTMapper {
    long countByExample(UserMSTExample example);

    int deleteByExample(UserMSTExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserMST record);

    int insertSelective(UserMST record);

    List<UserMST> selectByExample(UserMSTExample example);

    UserMST selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserMST record, @Param("example") UserMSTExample example);

    int updateByExample(@Param("record") UserMST record, @Param("example") UserMSTExample example);

    int updateByPrimaryKeySelective(UserMST record);

    int updateByPrimaryKey(UserMST record);

    int selectByUserNameAndPassWord(UserMST userMST);

}