USE assertivaDB;

CREATE TABLE IF NOT EXISTS clientes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    cpf VARCHAR(14) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    celulares VARCHAR(100),
    emails VARCHAR(100),
    PRIMARY KEY (id)
    );

INSERT INTO clientes (cpf, nome, celulares, emails)
VALUES ('077.218.631-05', 'Mia Travesck', '55289999999,11999999999', 'miatravesck@gmail.com,miatravesck@assertiva.com.br'),
       ('354.846.825-03', 'Liam Garcia', '48289666666', 'liamgarcia@gmail.com'),
       ('178.517.276-40', 'Julia Brown', '77123456789', 'juliabrown@hotmail.com'),
       ('188.946.471-09', 'Jackie Smith', '55368888888', 'jackiesmith@gmail.com'),
       ('404.758.773-59', 'Ethan Lee', '11987654321', 'ethanlee@gmail.com'),
       ('545.643.270-92', 'Cloud Cilou', '55289999999,11999999999', 'cloudcilou@gmail.com,cloudcilou@assertiva.com.br'),
       ('225.013.481-31', 'Avery Johnson', '77234567890', 'averyjohnson@hotmail.com'),
       ('067.428.509-67', 'Mia Schevsk', '55289999999,48999999999', 'miaschevsk@gmail.com, miaschevsk@hotmail.com'),
       ('146.247.455-52', 'Oliver Green', '1187654321,55771122334', 'olivergreen@hotmail.com, olivergreen@gmail.com'),
       ('275.611.764-45', 'Caroline Scott', '55357777888,55889999666', 'carolinescott@gmail.com, carolinescott@hotmail.com'),
       ('310.346.780-28', 'Sophie Davis', '2877777777,55114433221', 'sophiedavis@gmail.com, sophiedavis@hotmail.com'),
       ('290.708.169-80', 'John Smith', '55447777666', 'johnsmith@hotmail.com'),
       ('441.003.428-07', 'Oliver Scott', '48289111111,55888877665', 'oliverscott@gmail.com, oliverscott@hotmail.com'),
       ('072.902.651-63', 'Emma Johnson', '77111111111', 'emmajohnson@gmail.com'),
       ('249.189.207-97', 'Dim Travesck', '55348888888,55289999999', 'dimtravesck@gmail.com, dimtravesck@assertiva.com.br'),
       ('332.167.653-26', 'Dam Brown', '28966666677', 'dambrown@gmail.com');