package com.example.demo2.demo2.src.test.java.com.example.demo2;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
  Random random; // null

  @Autowired
  JdbcTemplate jdbcTemplate;

  @GetMapping("/board")
  public String board(Model model) {
    String sql = "select id, title, content, writer from board";
    List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
    model.addAttribute("list", list);
    return "board"; // templates/board.html
  }

  @GetMapping("/board/add")
  public String boardAdd() {
    // 방명록 작성 - 로그 남기기
    return "board/add"; // templates/board/add.html
  }

  @PostMapping("/board/add")
  public String boardAddPost(
      String title, String content,
      String writer) {
    String sql = "insert into board values ( (select max(id)+1 from board) , ?, ?, ?)";
    // sequence board_seq.nextval
    jdbcTemplate.update(sql, title, content, writer);

    return "board/add";
  }

  @PostMapping("/login")
  @ResponseBody
  public String loginPost(String id, String pw) {
    String sql = "select id, pw, name, join_date from join" + "  where id = ? and pw = ?";
    Map<String, Object> result;
    try {
      result = jdbcTemplate.queryForMap(sql, id, pw);
    } catch (EmptyResultDataAccessException e) {
      return "ID와 PW를 확인해주세요.";
    }
    System.out.println(result);

    return id + ", " + pw;
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/join")
  @ResponseBody
  public String joinPost(String id, String pw, String name, String date) {
    String sql = "insert into join values (?, ?, ?, ?)";
    jdbcTemplate.update(sql, id, pw, name, date);

    return id + ", " + pw + ", " + name + ", " + date;
  }

  @GetMapping("/join")
  public String join() {
    return "join";
  }

}
