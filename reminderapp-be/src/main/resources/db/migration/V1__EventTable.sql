CREATE TABLE event (
    id UUID NOT NULL PRIMARY KEY,
    eventName VARCHAR(200) NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    details VARCHAR(300)
)