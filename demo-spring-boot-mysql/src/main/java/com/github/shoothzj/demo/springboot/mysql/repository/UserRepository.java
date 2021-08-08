package com.github.shoothzj.demo.springboot.mysql.repository;

import com.github.shoothzj.demo.springboot.mysql.domain.User;
import com.github.shoothzj.demo.springboot.mysql.module.JoinView;
import com.github.shoothzj.demo.springboot.mysql.module.JoinViewReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * real sql:
     *
     * @param password
     * @param overtime
     * @return
     */
    @Query("select new com.github.shoothzj.demo.springboot.mysql.module.JoinView(u.username, u.password, s.salary, s.overtime) from User u join Salary s ON u.username = s.username where u.password = :password AND s.overtime > :overtime")
    List<JoinView> joinView(@Param("password") String password, @Param("overtime") long overtime);


    /**
     * real sql:
     *
     * @param req
     * @return
     */
    @Query("select new com.github.shoothzj.demo.springboot.mysql.module.JoinView(u.username, u.password, s.salary, s.overtime) from User u join Salary s ON u.username = s.username where u.password = :#{#req.password} AND s.overtime > :#{#req.overtime}")
    List<JoinView> joinView(@Param("req") JoinViewReq req);

    /**
     * real sql:
     *
     * @param req
     * @return
     */
    @Query("select new com.github.shoothzj.demo.springboot.mysql.module.JoinView(u.username, u.password, s.salary, s.overtime) from User u join Salary s ON u.username = s.username where (u.password = :#{#req.password} OR :#{#req.password} is null ) AND s.overtime > :#{#req.overtime}")
    List<JoinView> joinViewNullAll(@Param("req") JoinViewReq req);

}
