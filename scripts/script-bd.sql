CREATE TABLE tb_regiao (
                           id BIGSERIAL PRIMARY KEY,
                           nome VARCHAR(100),
                           cidade VARCHAR(100),
                           nivel_risco VARCHAR(50)
);

CREATE TABLE tb_usuario (
                            id BIGSERIAL PRIMARY KEY,
                            nome VARCHAR(100),
                            email VARCHAR(150),
                            senha VARCHAR(255)
);