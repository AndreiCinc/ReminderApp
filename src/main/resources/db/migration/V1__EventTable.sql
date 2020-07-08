CREATE TABLE event (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    startDate Date NOT NULL,
    endDate Date NOT NULL,
    details VARCHAR(300)
)