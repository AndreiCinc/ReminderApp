package event.ReminderApp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
class EventTest {

    private Event event;

    @BeforeEach
    void setEvent() {
        event = new Event(
                UUID.fromString("b17759ed-ca4d-412a-b575-5c39dafb5355"),
                "robert",
                new Date(2020-2-2),
                new Date(2020-2-2),
                "Bam, first test");
    }

    @Test
    void getName() {
    }

    @Test
    void getStartDate() {
    }

    @Test
    void getEndDate() {
    }

    @Test
    void getDetails() {
    }
}