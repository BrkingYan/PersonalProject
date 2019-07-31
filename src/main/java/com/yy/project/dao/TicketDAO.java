package com.yy.project.dao;


import com.yy.project.model.Ticket;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by nowcoder on 2018/08/04 下午3:44
 */
@Mapper
public interface TicketDAO {

  String table_name = " ticket ";
  String insert_field = " user_id, ticket, expired_at ";
  String select_field = " id, " + insert_field;

  // add ticket
  @Insert({"insert into", table_name, "(", insert_field,
      ") values (#{userId},#{ticket},#{expiredAt})"})
  int addTicket(Ticket ticket);

  // select ticket by id
  @Select({"select", select_field, "from", table_name, "where user_id=#{uid}"})
  Ticket selectByUserId(int uid);

  // select ticket by name
  @Select({"select", select_field, "from", table_name, "where ticket=#{t}"})
  Ticket selectByTicket(String t);

  // delete ticket by id
  @Delete({"delete from", table_name, " where id=#{tid}"})
  void deleteTicketById(int tid);

  // delete ticket by name
  @Delete({"delete from", table_name, " where ticket=#{t}"})
  void deleteTicket(String t);

}
