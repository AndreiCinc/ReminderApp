CREATE TABLE event (
    id UUID NOT NULL PRIMARY KEY,
    eventName VARCHAR(200) NOT NULL,
    startDate timestamp  NOT NULL,
    endDate timestamp  NOT NULL,
    reminderDate timestamp NOT NULL,
    details VARCHAR(300)
)