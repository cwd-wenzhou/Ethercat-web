CREATE TABLE SlaveInfo
(

    name varchar(255),
    VenderID varchar(1024),
    ProductCode varchar(1024),
    position int primary key ,
    pdo_entries varchar(1024),
    pdos varchar(255),
    syncs varchar(255)
);

insert into SlaveInfo
values ('Beckhoff_EL3102','0x00000002', '0x0c1e3052',1,
        '{0x3101, 1,  8}, // channel 1 status
        {0x3101, 2, 16}, // channel 1 value
        {0x3102, 1,  8}, // channel 2 status
        {0x3102, 2, 16}, // channel 2 value
        {0x6401, 1, 16}, // channel 1 value (alt.)
        {0x6401, 2, 16}  // channel 2 value (alt.)',
        '{0x1A00, 2, el3102_pdo_entries},
        {0x1A01, 2, el3102_pdo_entries + 2}',
        '{2, EC_DIR_OUTPUT},
        {3, EC_DIR_INPUT, 2, el3102_pdos},
        {0xff}'
);

insert into SlaveInfo
values ('Beckhoff_EL4102', '0x00000002', '0x10063052',2,
        '{0x3001, 1, 16}, // channel 1 value
        {0x3002, 1, 16}, // channel 2 value',
        '{0x1600, 1, el4102_pdo_entries},
        {0x1601, 1, el4102_pdo_entries + 1}',
        '{2, EC_DIR_OUTPUT, 2, el4102_pdos},
        {3, EC_DIR_INPUT},
        {0xff}'
);

insert into SlaveInfo
  values ('Beckhoff_EL2004', '0x00000002', '0x07d43052',3,
          '{0x3001, 1, 1}, // Value 1
          {0x3001, 2, 1}, // Value 2
          {0x3001, 3, 1}, // Value 3
          {0x3001, 4, 1}  // Value 4',
          '{0x1600, 1, &el2004_channels[0]},
          {0x1601, 1, &el2004_channels[1]},
          {0x1602, 1, &el2004_channels[2]},
          {0x1603, 1, &el2004_channels[3]}',
          '{0, EC_DIR_OUTPUT, 4, el2004_pdos},
          {1, EC_DIR_INPUT},
          {0xff}'
);