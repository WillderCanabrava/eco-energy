CREATE TABLE consumo (
    id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    dispositivo VARCHAR2(100) NOT NULL,
    kwh NUMBER(10, 2) NOT NULL,
    data_hora TIMESTAMP NOT NULL,
    usuario_id NUMBER NOT NULL
);
