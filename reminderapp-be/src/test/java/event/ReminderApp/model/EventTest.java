package event.ReminderApp.model;

import org.joda.time.DateTime;
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