package com.example.demo.apiTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import com.example.common.AbstractTest;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.vo.BoardVo.ListRequest;
import com.example.demo.common.exception.BizException;
import com.example.demo.common.vo.CommonResponse;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BoardTest extends AbstractTest {

  // 참고: https://blog.neonkid.xyz/272

  @Autowired
  private BoardService boardService;

  @DisplayName("insertBoardTest")
  @Test
  @Transactional
  void insertBoardTest() throws BizException {
    // given
    String body = getBoardData();

    // when
    ResponseEntity<CommonResponse> result = callApi(body);

    // then
    assertEquals(HttpStatus.OK, result.getStatusCode());

    String boardId = Optional.ofNullable(boardService.getBoards(ListRequest.builder().langCode("ko").build()))
        .map(e -> e.get(0)).get().getId();

    assertEquals(boardId, boardService.getBoard(UUID.fromString(boardId)).getId());
  }
  
  @SuppressWarnings("unchecked")
  private ResponseEntity<CommonResponse> callApi(Object body) {
    RestClient restClient = RestClient.create();

    @SuppressWarnings("rawtypes")
    ResponseEntity result = restClient.post()
        .uri("http://localhost:" + port + "/" + "board")
        .header("Content-Type", "application/json")
        .body(body)
        .retrieve()
        .toEntity(String.class);
    return result;
  }

  private String getBoardData() {
    return "{\n" + //
        "  \"order\": 1,\n" + //
        "  \"titles\": [\n" + //
        "    {\n" + //
        "      \"langCode\": \"ko\",\n" + //
        "      \"title\": \"게시판1\",\n" + //
        "      \"defaultYn\": true\n" + //
        "\n" + //
        "    },\n" + //
        "    {\n" + //
        "      \"langCode\": \"en\",\n" + //
        "      \"title\": \"board1\",\n" + //
        "      \"defaultYn\": false\n" + //
        "    }\n" + //
        "  ]\n" + //
        "}";
  }

}
