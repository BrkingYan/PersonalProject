package com.yy.project.dao;


import com.yy.project.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by nowcoder on 2018/08/04 下午3:41
 */
@Mapper
public interface UserDAO {

  String table_name = " user ";
  String insert_field = " name, email, password ";
  String select_field = " id, " + insert_field;

  // add user
  @Insert({"insert into", table_name, "(", insert_field,
      ") values (#{name},#{email},#{password})"})
  int addUser(User user);

  // select user by id
  @Select({"select", select_field, "from", table_name, "where id=#{id}"})
  User selectById(int id);

  // select user by name
  @Select({"select", select_field, "from", table_name, "where name=#{name}"})
  User selectByName(String name);

  // select user by email
  @Select({"select", select_field, "from", table_name, "where email=#{email}"})
  User selectByEmail(String email);

  // update user
  @Update({"update", table_name, "set password=#{password} where id=#{id}"})
  void updatePassword(User user);
}
