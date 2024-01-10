package com.bruno.desafiotodolist;

import com.bruno.desafiotodolist.models.TodoModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioTodolistApplicationTests {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateTodoSuccess() {
        var todo = new TodoModel("Todo test", "Desc todo", true, 1);

        webTestClient
                .post()
                .uri("/todos/new")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$[0].nome").isEqualTo(todo.getNome())
                .jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
                .jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
                .jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());

    }

    @Test
    void testCreateTodoFailure() {
        webTestClient
                .post()
                .uri("/todos/new")
                .bodyValue(
                        new TodoModel("", "", false, 0)
                ).exchange()
                .expectStatus().isBadRequest();
    }

}
