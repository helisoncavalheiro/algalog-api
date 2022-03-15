CREATE TABLE entrega(

  id BIGINT AUTO_INCREMENT NOT NULL,
  cliente_id BIGINT NOT NULL,
  taxa DECIMAL(10,2) NOT NULL,
  status VARCHAR(20) NOT NULL,
  data_pedido DATETIME,
  data_finalizacao DATETIME,

  destinatario_nome VARCHAR(60) NOT NULL,
  destinatario_logradouro VARCHAR(60) NOT NULL,
  destinatario_numero VARCHAR(30) NOT NULL,
  destinatario_complemento VARCHAR(60) NOT NULL,
  destinatario_bairro VARCHAR(60) NOT NULL,

  PRIMARY KEY (id)
);

ALTER TABLE entrega ADD CONSTRAINT fk_entrega_cliente 
FOREIGN KEY (cliente_id) REFERENCES cliente (id);